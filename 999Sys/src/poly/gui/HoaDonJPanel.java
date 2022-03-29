/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import poly.dao.CTHoaDonDao;
import poly.dao.DanhMucDao;
import poly.dao.HoaDonDao;
import poly.dao.KhachHangDao;
import poly.dao.LoaiKhachHangDao;
import poly.dao.SanPhamDao;
import poly.entity.CTHoaDon;
import poly.entity.DanhMuc;
import poly.entity.HoaDon;
import poly.entity.KhachHang;
import poly.entity.LoaiKhachHang;
import poly.entity.SanPham;
import poly.helper.Auth;
import poly.helper.ButtonColumn;
import poly.helper.CustomDatePicker;
import poly.helper.ImageColumn;
import poly.helper.Messeger;
import poly.helper.XDate;
import poly.helper.XValidate;

/**
 *
 * @author XUÂN THÀNH
 */
public class HoaDonJPanel extends javax.swing.JPanel {

    Locale localeVN = new Locale("vi", "VN");
    NumberFormat df = NumberFormat.getCurrencyInstance(localeVN);
    int slNhap;
    int slGoc;
    int maxMaHD;

    DefaultTableModel dtmSanPham;
    DefaultTableModel dtmKhachHang;
    DefaultTableModel dtmHoaDon;
    DefaultComboBoxModel<DanhMuc> CBBModelDM;
    DefaultComboBoxModel<LoaiKhachHang> CBBModelLKH;

    DanhMucDao daoDM;
    SanPhamDao daoSP;
    KhachHangDao daoKH;
    LoaiKhachHangDao daoLKH;
    HoaDonDao DAOHD;
    CTHoaDonDao DAOCTHD;

    boolean isSanPhamSelected = true;
    JTabbedPane pnlTabs;

    public HoaDonJPanel(JTabbedPane pnlTabs) {
        initComponents();
        this.daoDM = new DanhMucDao();
        this.daoSP = new SanPhamDao();
        this.daoKH = new KhachHangDao();
        this.daoLKH = new LoaiKhachHangDao();
        this.DAOHD = new HoaDonDao();
        this.DAOCTHD = new CTHoaDonDao();

        this.dtmHoaDon = new DefaultTableModel();
        this.dtmKhachHang = new DefaultTableModel();
        this.dtmSanPham = new DefaultTableModel();
        this.CBBModelDM = new DefaultComboBoxModel<>();
        this.CBBModelLKH = new DefaultComboBoxModel<>();

        this.dtmHoaDon = (DefaultTableModel) tblHoaDon.getModel();
        this.dtmKhachHang = (DefaultTableModel) tblKhachHang.getModel();
        this.dtmSanPham = (DefaultTableModel) tblSanPham.getModel();
        //Add button vào bảng
        addButtonToTable();
        tblSanPham.getColumn("Ảnh SP").setCellRenderer(new ImageColumn());

        //truyền vào pnlTabs từ MainFm
        this.pnlTabs = pnlTabs;
        // lấy mã hóa đơn cuối cùng
        this.maxMaHD = this.DAOHD.getMaxMaHD();
        this.CBBModelDM = (DefaultComboBoxModel) cbbDanhMucSP.getModel();
        this.CBBModelLKH = (DefaultComboBoxModel) cbbLoaKH.getModel();

        loadDataToCBBDM();
        loadDataToCBBLKH();

        dpkNgaySinh.setSettings(CustomDatePicker.customsDatePicker(dpkNgaySinh, new javax.swing.ImageIcon(getClass().getResource("/poly/icons/calendar.png"))));
        dpkNgaySinh.setDateToToday();
    }

    private void addButtonToTable() {
        //Bảng Hóa Đơn
        //Viết mã sử lỹ cho sự kiện xóa ở đây
        Action delete = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                JTable table = (JTable) e.getSource();
                int modelRow = Integer.valueOf(e.getActionCommand());
                int masphd = Integer.parseInt((((DefaultTableModel) table.getModel()).getValueAt(modelRow, 8)) + "");
                slGoc = Integer.valueOf(((DefaultTableModel) table.getModel()).getValueAt(modelRow, 2) + "");
                for (int i = 0; i < tblSanPham.getRowCount(); i++) {
                    int masp = Integer.parseInt(tblSanPham.getValueAt(i, 0) + "");
                    int sl = Integer.parseInt(tblSanPham.getValueAt(i, 4) + "");
                    if (masp == masphd) {
                        tblSanPham.setValueAt(slGoc + sl, i, 4);

                        SanPham sp = new SanPham();
                        sp.setMaSP(masp);
                        sp.setSoLuong(slGoc + sl);
                        try {
                            daoSP.updateSP(sp);
                            DAOCTHD.deleteOnerecord(Integer.parseInt(lblHoaDon.getToolTipText()), masp);

                        } catch (Exception ex) {
                            Logger.getLogger(HoaDonJPanel.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        ((DefaultTableModel) table.getModel()).removeRow(modelRow);
                        tongTien();
                    }
                }

            }

        };
        //Viết mã sử lỹ cho sự kiện Giảm ở đây
        Action giam = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                JTable table = (JTable) e.getSource();
                int modelRow = Integer.valueOf(e.getActionCommand());
                slGoc = (int) table.getValueAt(modelRow, 2);
                int masphd = Integer.parseInt((((DefaultTableModel) table.getModel()).getValueAt(modelRow, 8)) + "");
                double gia = Double.parseDouble(table.getValueAt(modelRow, 5) + "");
                if (!nhapSl()) {
                    int soLuongCTHD = slGoc - slNhap;
                    if (slGoc - slNhap == 0) {
                        JOptionPane.showMessageDialog(null, "Bấm 'Xóa' Để loại bỏ sản phẩm này");
                    } else {
                        for (int i = 0; i < tblSanPham.getRowCount(); i++) {
                            int masp = Integer.parseInt(tblSanPham.getValueAt(i, 0) + "");
                            int slsp = Integer.parseInt(tblSanPham.getValueAt(i, 4) + "");
                            if (masp == masphd) {
                                int soLuongSP = slsp + slNhap;
                                tblSanPham.setValueAt(soLuongSP, i, 4);

                                suaCTHD(masp, soLuongSP, soLuongCTHD);
                                ((DefaultTableModel) table.getModel()).setValueAt(slGoc - slNhap, modelRow, 2);
                                ((DefaultTableModel) table.getModel()).setValueAt(String.format("%.0f", (slGoc - slNhap) * gia), modelRow, 7);
                                tongTien();
                            }
                        }
                    }

                }

            }

        };
        //Viết mã sử lỹ cho sự kiện Tăng ở đây
        Action tang = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                JTable table = (JTable) e.getSource();
                int modelRow = Integer.valueOf(e.getActionCommand());
                int sl = (int) table.getValueAt(modelRow, 2);
                int masphd = Integer.parseInt((((DefaultTableModel) table.getModel()).getValueAt(modelRow, 8)) + "");
                double gia = Double.parseDouble(table.getValueAt(modelRow, 5) + "");
                for (int i = 0; i < tblSanPham.getRowCount(); i++) {
                    int masp = Integer.parseInt(tblSanPham.getValueAt(i, 0) + "");
                    slGoc = Integer.parseInt(tblSanPham.getValueAt(i, 4) + "");

                    if (masp == masphd) {
                        if (slGoc == 0) {
                            JOptionPane.showMessageDialog(null, "Hết hàng rồi");
                            return;
                        } else if (!nhapSl()) {
                            int soLuongSP = slGoc - slNhap;
                            int soLuongCTHD = sl + slNhap;
                            tblSanPham.setValueAt(soLuongSP, i, 4);

                            suaCTHD(masp, soLuongSP, soLuongCTHD);
                            ((DefaultTableModel) table.getModel()).setValueAt(soLuongCTHD, modelRow, 2);
                            ((DefaultTableModel) table.getModel()).setValueAt(String.format("%.0f", soLuongCTHD * gia), modelRow, 7);
                            tongTien();
                        }

                    }
                }

            }
        };

        //khởi tạo buttonColum để tạo button có sự kiện xóa vào bảng sản phẩm ở cột 12 đặt tên là xóa
        ButtonColumn btnDeleteHoaDon = new ButtonColumn(tblHoaDon, delete, 0, "Xóa", new javax.swing.ImageIcon(getClass().getResource("/poly/icons/cancel-40.png")));
        btnDeleteHoaDon.setMnemonic(KeyEvent.VK_D);
        //khởi tạo buttonColum để tạo button có sự kiện Giảm số lượng vào bảng sản phẩm ở cột 3 đặt tên là Giảm
        ButtonColumn btnTangHoaDon = new ButtonColumn(tblHoaDon, giam, 3, "Giảm", new javax.swing.ImageIcon(getClass().getResource("/poly/icons/giam-40.png")));
        btnTangHoaDon.setMnemonic(KeyEvent.VK_D);
        //khởi tạo buttonColum để tạo button có sự kiện Tăng số lượng vào bảng sản phẩm ở cột 4 đặt tên là Tăng
        ButtonColumn btnGiamHoaDon = new ButtonColumn(tblHoaDon, tang, 4, "Tăng", new javax.swing.ImageIcon(getClass().getResource("/poly/icons/tang-40.png")));
        btnGiamHoaDon.setMnemonic(KeyEvent.VK_D);
        //Bảng Sản Phẩm
        //Viết mã sử lỹ cho sự kiện thêm sản phẩm vào hóa đơn ở đây
        Action ThemSPVaoHD = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                JTable table = (JTable) e.getSource();
                int modelRow = Integer.valueOf(e.getActionCommand());
                slGoc = Integer.parseInt((((DefaultTableModel) table.getModel()).getValueAt(modelRow, 4)) + "");
                int maSP = Integer.parseInt((((DefaultTableModel) table.getModel()).getValueAt(modelRow, 0)) + "");
                if (!nhapSl()) {
                    boolean c = true;
                    for (int i = 0; i < tblHoaDon.getRowCount(); i++) {
                        int masphd = Integer.parseInt(tblHoaDon.getValueAt(i, 8) + "");
                        int sl = Integer.parseInt(tblHoaDon.getValueAt(i, 2) + "");
                        double dg = Double.parseDouble(tblHoaDon.getValueAt(i, 5) + "");
                        if (maSP == masphd) {
                            int soLuongSP = slGoc - slNhap;
                            int soLuongCTHD = slNhap + sl;
                            tblHoaDon.setValueAt(soLuongCTHD, i, 2);
                            tblHoaDon.setValueAt(soLuongCTHD * dg, i, 7);
                            ((DefaultTableModel) table.getModel()).setValueAt(slGoc - slNhap, modelRow, 4);
                            tongTien();
                            suaCTHD(maSP, soLuongSP, soLuongCTHD);
                            return;
                        }
                    }

                    double thanhTien = Double.parseDouble(((DefaultTableModel) table.getModel()).getValueAt(modelRow, 3) + "") * slNhap;

                    Object[] data = new Object[]{
                        null,
                        ((DefaultTableModel) table.getModel()).getValueAt(modelRow, 2),
                        slNhap,
                        null,
                        null,
                        (((DefaultTableModel) table.getModel()).getValueAt(modelRow, 3)),
                        null,
                        String.format("%.0f", thanhTien),
                        ((DefaultTableModel) table.getModel()).getValueAt(modelRow, 0)
                    };
                    dtmHoaDon.addRow(data);
                    ((DefaultTableModel) table.getModel()).setValueAt(slGoc - slNhap, modelRow, 4);
                    SanPham sp = new SanPham();
                    sp.setMaSP(maSP);
                    sp.setSoLuong(slGoc - slNhap);
                    try {
                        daoSP.updateSP(sp);
                    } catch (Exception ex) {
                        Logger.getLogger(HoaDonJPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    tongTien();
                    if (lblHoaDon.getText().equalsIgnoreCase("Hóa đơn trống")) {
                        taoHoaDon();
                    }
                    taoHDCT(maSP, slNhap);
                }

            }

        };
        //khởi tạo buttonColum để tạo button có sự kiện 'thêm sản phẩm vào bảng hóa đơn' ở cột 4 đặt tên là Thêm vào hóa đơn
        ButtonColumn btnThemSPVaoHD = new ButtonColumn(tblSanPham, ThemSPVaoHD, 5, "thêm sản phẩm vào bảng hóa đơn", new javax.swing.ImageIcon(getClass().getResource("/poly/icons/add-to-basket-64.png")));
        btnThemSPVaoHD.setMnemonic(KeyEvent.VK_D);

        //Bảng Khách hàng
        //Viết mã sử lỹ cho sự kiện thêm Khách hàng vào hóa đơn ở đây
        Action ThemKHVaoHD = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                JTable table = (JTable) e.getSource();
                int modelRow = Integer.valueOf(e.getActionCommand());
                String maKH = String.valueOf(((DefaultTableModel) table.getModel()).getValueAt(modelRow, 0));
                String tenKH = String.valueOf(((DefaultTableModel) table.getModel()).getValueAt(modelRow, 2));
                lblTenKH.setText(tenKH);
                lblTenKH.setToolTipText(maKH);
                pnlTabs.setTitleAt(pnlTabs.getSelectedIndex(), tenKH);
                tongTien();
                if (!lblHoaDon.getText().equalsIgnoreCase("Hóa đơn trống")) {
                    try {
                        HoaDon hd = new HoaDon();
                        hd.setMaHD(Integer.parseInt(lblHoaDon.getToolTipText()));
                        hd.setMaKH(maKH);
                        hd.setMaNV(Auth.user.getMaNV());
                        hd.setMaTT(1);
                        DAOHD.update(hd);
                    } catch (Exception ex) {
                        Logger.getLogger(HoaDonJPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        };
        //khởi tạo buttonColum để tạo button có sự kiện 'thêm khách hàng vào bảng hóa đơn' ở cột 9 đặt tên là Thêm vào hóa đơn
        ButtonColumn btnThemKHVaoHD = new ButtonColumn(tblKhachHang, ThemKHVaoHD, 9, "thêm khách hàng vào hóa đơn", new javax.swing.ImageIcon(getClass().getResource("/poly/icons/add-user-70.png")));
        btnThemKHVaoHD.setMnemonic(KeyEvent.VK_D);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnlMain = new javax.swing.JPanel();
        pnlHeader = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        btnQuetMa = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        btnTimKiem = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        btnSanPham = new javax.swing.JButton();
        btnKhachHang = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        pnlThanhToan = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        lblTenKH = new javax.swing.JLabel();
        lblHoaDon = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtTongTien = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblGiamGia = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblSoLuong = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblThanhTien = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnThanhToam = new javax.swing.JButton();
        btnHoaDonMoi = new javax.swing.JButton();
        btnMaKhuyenMai = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        pnlCenter = new javax.swing.JPanel();
        pnlCard_KhachHang_SanPham = new javax.swing.JPanel();
        pnlSanPham = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        cbbDanhMucSP = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        pnlKhachHang = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();
        jPanel17 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        lblMaKH = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        lblLoaiKH = new javax.swing.JLabel();
        cbbLoaKH = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtTenKH = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        lblDiaChi = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtNgayThamGia = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        rdoNu = new javax.swing.JRadioButton();
        rdoNam = new javax.swing.JRadioButton();
        dpkNgaySinh = new com.github.lgooddatepicker.components.DatePicker();
        jPanel18 = new javax.swing.JPanel();
        btnMoiKH = new javax.swing.JButton();
        btnLuuKH = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 102), 10));
        setLayout(new java.awt.BorderLayout());

        pnlMain.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 153, 51)));
        pnlMain.setLayout(new java.awt.BorderLayout());

        pnlHeader.setBackground(new java.awt.Color(0, 0, 0));
        pnlHeader.setPreferredSize(new java.awt.Dimension(1068, 50));
        pnlHeader.setLayout(new java.awt.BorderLayout());

        jPanel6.setBackground(new java.awt.Color(0, 0, 0));
        jPanel6.setPreferredSize(new java.awt.Dimension(456, 50));
        jPanel6.setLayout(new java.awt.BorderLayout());

        jPanel8.setBackground(new java.awt.Color(255, 204, 102));
        jPanel8.setLayout(new java.awt.BorderLayout());

        jPanel9.setBackground(new java.awt.Color(0, 153, 51));
        jPanel9.setPreferredSize(new java.awt.Dimension(260, 51));
        jPanel9.setLayout(new java.awt.BorderLayout());

        btnQuetMa.setBackground(new java.awt.Color(153, 0, 153));
        btnQuetMa.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnQuetMa.setForeground(new java.awt.Color(255, 255, 255));
        btnQuetMa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poly/icons/qr.png"))); // NOI18N
        btnQuetMa.setText("    Quét mã");
        btnQuetMa.setBorder(null);
        btnQuetMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuetMaActionPerformed(evt);
            }
        });
        jPanel9.add(btnQuetMa, java.awt.BorderLayout.CENTER);

        jPanel13.setBackground(new java.awt.Color(0, 153, 51));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel9.add(jPanel13, java.awt.BorderLayout.LINE_START);

        jPanel8.add(jPanel9, java.awt.BorderLayout.LINE_END);

        jPanel10.setBackground(new java.awt.Color(0, 153, 51));
        jPanel10.setLayout(new java.awt.BorderLayout());

        btnTimKiem.setBackground(new java.awt.Color(255, 255, 255));
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poly/icons/search.jpg"))); // NOI18N
        btnTimKiem.setBorder(null);
        btnTimKiem.setPreferredSize(new java.awt.Dimension(55, 15));
        jPanel10.add(btnTimKiem, java.awt.BorderLayout.LINE_END);

        txtTimKiem.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtTimKiem.setForeground(new java.awt.Color(255, 0, 0));
        txtTimKiem.setText("Tìm Kiếm Sản Phẩm");
        txtTimKiem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtTimKiem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTimKiemFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTimKiemFocusLost(evt);
            }
        });
        txtTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTimKiemMouseClicked(evt);
            }
        });
        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });
        jPanel10.add(txtTimKiem, java.awt.BorderLayout.CENTER);

        jPanel5.setBackground(new java.awt.Color(0, 153, 51));
        jPanel5.setLayout(new java.awt.GridLayout(1, 0));

        btnSanPham.setBackground(new java.awt.Color(153, 255, 153));
        btnSanPham.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnSanPham.setText("Sản phẩm");
        btnSanPham.setBorder(null);
        btnSanPham.setHideActionText(true);
        btnSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSanPhamActionPerformed(evt);
            }
        });
        jPanel5.add(btnSanPham);

        btnKhachHang.setBackground(new java.awt.Color(255, 204, 102));
        btnKhachHang.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnKhachHang.setText("Khách hàng");
        btnKhachHang.setBorder(null);
        btnKhachHang.setHideActionText(true);
        btnKhachHang.setPreferredSize(new java.awt.Dimension(120, 23));
        btnKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhachHangActionPerformed(evt);
            }
        });
        jPanel5.add(btnKhachHang);

        jPanel12.setBackground(new java.awt.Color(0, 153, 51));
        jPanel12.setPreferredSize(new java.awt.Dimension(20, 50));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel12);

        jPanel10.add(jPanel5, java.awt.BorderLayout.LINE_START);

        jPanel8.add(jPanel10, java.awt.BorderLayout.CENTER);

        jPanel6.add(jPanel8, java.awt.BorderLayout.CENTER);

        pnlHeader.add(jPanel6, java.awt.BorderLayout.CENTER);

        pnlMain.add(pnlHeader, java.awt.BorderLayout.PAGE_START);

        pnlThanhToan.setBackground(new java.awt.Color(255, 255, 255));
        pnlThanhToan.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 0, 0, 0, new java.awt.Color(0, 153, 51)));
        pnlThanhToan.setForeground(new java.awt.Color(204, 255, 204));
        pnlThanhToan.setPreferredSize(new java.awt.Dimension(650, 500));
        pnlThanhToan.setLayout(new java.awt.BorderLayout());

        jPanel14.setLayout(new java.awt.GridLayout(1, 0));

        lblTenKH.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTenKH.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poly/icons/login32.png"))); // NOI18N
        lblTenKH.setText("Khách lẻ");
        lblTenKH.setPreferredSize(new java.awt.Dimension(34, 50));
        jPanel14.add(lblTenKH);

        lblHoaDon.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblHoaDon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHoaDon.setText("Hóa đơn trống");
        jPanel14.add(lblHoaDon);

        pnlThanhToan.add(jPanel14, java.awt.BorderLayout.NORTH);

        jPanel1.setPreferredSize(new java.awt.Dimension(452, 450));
        jPanel1.setLayout(new java.awt.BorderLayout());

        txtTongTien.setEditable(false);
        txtTongTien.setBackground(new java.awt.Color(0, 0, 0));
        txtTongTien.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        txtTongTien.setForeground(new java.awt.Color(0, 255, 51));
        txtTongTien.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTongTien.setText("0");
        txtTongTien.setToolTipText("Tổng Tiền Hàng");
        jPanel1.add(txtTongTien, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setPreferredSize(new java.awt.Dimension(80, 0));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel16, java.awt.BorderLayout.EAST);

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setPreferredSize(new java.awt.Dimension(20, 0));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel15, java.awt.BorderLayout.WEST);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jPanel4.setLayout(new java.awt.GridLayout(3, 3, 0, 5));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Giảm giá");
        jPanel4.add(jLabel1);

        lblGiamGia.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblGiamGia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblGiamGia.setText("0");
        jPanel4.add(lblGiamGia);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setText("Số lượng");
        jPanel4.add(jLabel4);

        lblSoLuong.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblSoLuong.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSoLuong.setText(" 0");
        jPanel4.add(lblSoLuong);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setText("Thành Tiền");
        jLabel3.setToolTipText("Tổng tiền hàng phải trả");
        jPanel4.add(jLabel3);

        lblThanhTien.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblThanhTien.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblThanhTien.setText("0");
        jPanel4.add(lblThanhTien);

        jPanel2.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(450, 50));
        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        btnThanhToam.setBackground(new java.awt.Color(102, 255, 102));
        btnThanhToam.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnThanhToam.setText("Thanh Toán");
        btnThanhToam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToamActionPerformed(evt);
            }
        });
        jPanel3.add(btnThanhToam);

        btnHoaDonMoi.setBackground(new java.awt.Color(255, 255, 102));
        btnHoaDonMoi.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnHoaDonMoi.setText("Hóa Đơn Mới");
        btnHoaDonMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoaDonMoiActionPerformed(evt);
            }
        });
        jPanel3.add(btnHoaDonMoi);

        btnMaKhuyenMai.setBackground(new java.awt.Color(255, 51, 51));
        btnMaKhuyenMai.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnMaKhuyenMai.setText("Mã Khuyến Mại");
        btnMaKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaKhuyenMaiActionPerformed(evt);
            }
        });
        jPanel3.add(btnMaKhuyenMai);

        jPanel2.add(jPanel3, java.awt.BorderLayout.PAGE_END);

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jPanel7.setBackground(new java.awt.Color(0, 153, 51));
        jPanel7.setLayout(new java.awt.BorderLayout());

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Xóa", "Tên SP", "Số Lượng", "Giảm", "Tăng", "Đơn Giá", "Giá Sau KM", "Thành Tiền", "Mã SP"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, true, true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDon.setRowHeight(40);
        jScrollPane1.setViewportView(tblHoaDon);
        if (tblHoaDon.getColumnModel().getColumnCount() > 0) {
            tblHoaDon.getColumnModel().getColumn(0).setMinWidth(40);
            tblHoaDon.getColumnModel().getColumn(0).setPreferredWidth(40);
            tblHoaDon.getColumnModel().getColumn(0).setMaxWidth(40);
            tblHoaDon.getColumnModel().getColumn(3).setMinWidth(40);
            tblHoaDon.getColumnModel().getColumn(3).setPreferredWidth(40);
            tblHoaDon.getColumnModel().getColumn(3).setMaxWidth(40);
            tblHoaDon.getColumnModel().getColumn(4).setMinWidth(40);
            tblHoaDon.getColumnModel().getColumn(4).setPreferredWidth(40);
            tblHoaDon.getColumnModel().getColumn(4).setMaxWidth(40);
            tblHoaDon.getColumnModel().getColumn(6).setMinWidth(0);
            tblHoaDon.getColumnModel().getColumn(6).setPreferredWidth(0);
            tblHoaDon.getColumnModel().getColumn(6).setMaxWidth(0);
            tblHoaDon.getColumnModel().getColumn(8).setMinWidth(0);
            tblHoaDon.getColumnModel().getColumn(8).setPreferredWidth(0);
            tblHoaDon.getColumnModel().getColumn(8).setMaxWidth(0);
        }

        jPanel7.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel7, java.awt.BorderLayout.CENTER);

        pnlThanhToan.add(jPanel1, java.awt.BorderLayout.CENTER);

        pnlMain.add(pnlThanhToan, java.awt.BorderLayout.LINE_END);

        pnlCenter.setBackground(new java.awt.Color(153, 153, 153));
        pnlCenter.setLayout(new java.awt.BorderLayout());

        pnlCard_KhachHang_SanPham.setBackground(new java.awt.Color(0, 0, 0));
        pnlCard_KhachHang_SanPham.setLayout(new java.awt.CardLayout());

        pnlSanPham.setBackground(new java.awt.Color(0, 153, 51));

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Mã Vạch", "Tên SP", "Đơn Giá", "Số Lượng", "Thêm Vào Hóa Đơn", "Ảnh SP"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPham.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        tblSanPham.setRowHeight(80);
        jScrollPane2.setViewportView(tblSanPham);
        if (tblSanPham.getColumnModel().getColumnCount() > 0) {
            tblSanPham.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblSanPham.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblSanPham.getColumnModel().getColumn(3).setPreferredWidth(70);
            tblSanPham.getColumnModel().getColumn(4).setPreferredWidth(70);
            tblSanPham.getColumnModel().getColumn(5).setMinWidth(70);
            tblSanPham.getColumnModel().getColumn(5).setPreferredWidth(70);
            tblSanPham.getColumnModel().getColumn(6).setMinWidth(48);
            tblSanPham.getColumnModel().getColumn(6).setPreferredWidth(70);
        }

        cbbDanhMucSP.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cbbDanhMucSP.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbDanhMucSPItemStateChanged(evt);
            }
        });

        jLabel2.setText("Danh Mục");
        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlSanPhamLayout = new javax.swing.GroupLayout(pnlSanPham);
        pnlSanPham.setLayout(pnlSanPhamLayout);
        pnlSanPhamLayout.setHorizontalGroup(
            pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 805, Short.MAX_VALUE)
            .addGroup(pnlSanPhamLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cbbDanhMucSP, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlSanPhamLayout.setVerticalGroup(
            pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSanPhamLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbbDanhMucSP)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE))
        );

        pnlCard_KhachHang_SanPham.add(pnlSanPham, "SanPham");

        pnlKhachHang.setBackground(new java.awt.Color(0, 153, 51));
        pnlKhachHang.setLayout(new java.awt.BorderLayout());

        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Khách Hàng", "Mã Loại Khách Hàng", "Tên Khách hàng", "Địa Chỉ", "Giới Tính", "Email", "SDT", "Ngày Sinh", "Ngày Tham Gia", "Thêm vào hóa đơn"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKhachHang.setRowHeight(72);
        jScrollPane3.setViewportView(tblKhachHang);
        if (tblKhachHang.getColumnModel().getColumnCount() > 0) {
            tblKhachHang.getColumnModel().getColumn(9).setPreferredWidth(72);
        }

        pnlKhachHang.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        jPanel17.setLayout(new java.awt.BorderLayout());

        jPanel19.setLayout(new java.awt.BorderLayout());

        jPanel11.setBackground(new java.awt.Color(0, 153, 51));

        lblMaKH.setText("Mã KH");
        lblMaKH.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        lblMaKH.setForeground(new java.awt.Color(255, 255, 255));
        lblMaKH.setPreferredSize(new java.awt.Dimension(60, 20));

        txtMaKH.setPreferredSize(new java.awt.Dimension(180, 18));

        lblLoaiKH.setText("Loại khách hàng");
        lblLoaiKH.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        lblLoaiKH.setForeground(new java.awt.Color(255, 255, 255));
        lblLoaiKH.setPreferredSize(new java.awt.Dimension(60, 0));

        cbbLoaKH.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbLoaKHItemStateChanged(evt);
            }
        });

        jLabel6.setText("Tên KH");
        jLabel6.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setPreferredSize(new java.awt.Dimension(60, 20));

        jLabel13.setText("SDT");
        jLabel13.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setPreferredSize(new java.awt.Dimension(60, 0));

        txtSDT.setPreferredSize(new java.awt.Dimension(180, 18));

        lblDiaChi.setText("Địa chỉ");
        lblDiaChi.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        lblDiaChi.setForeground(new java.awt.Color(255, 255, 255));
        lblDiaChi.setPreferredSize(new java.awt.Dimension(60, 20));

        lblEmail.setText("Email");
        lblEmail.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(255, 255, 255));
        lblEmail.setPreferredSize(new java.awt.Dimension(60, 0));

        jLabel15.setText("Ngày tham gia");
        jLabel15.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setPreferredSize(new java.awt.Dimension(60, 20));

        txtNgayThamGia.setEditable(false);
        txtNgayThamGia.setPreferredSize(new java.awt.Dimension(180, 18));

        jLabel14.setText("Ngày sinh");
        jLabel14.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setPreferredSize(new java.awt.Dimension(60, 0));

        jLabel9.setText("Giới tính");
        jLabel9.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setPreferredSize(new java.awt.Dimension(60, 20));

        buttonGroup1.add(rdoNu);
        rdoNu.setForeground(new java.awt.Color(255, 255, 255));
        rdoNu.setText("Nữ");

        buttonGroup1.add(rdoNam);
        rdoNam.setForeground(new java.awt.Color(255, 255, 255));
        rdoNam.setSelected(true);
        rdoNam.setText("Nam");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(lblMaKH, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(lblLoaiKH, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSDT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbLoaKH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(txtNgayThamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(dpkNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(rdoNu, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rdoNam, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(lblMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(lblDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLoaiKH, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbLoaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(txtNgayThamGia, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(dpkNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdoNu, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdoNam, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        jPanel19.add(jPanel11, java.awt.BorderLayout.PAGE_START);

        jPanel17.add(jPanel19, java.awt.BorderLayout.CENTER);

        jPanel18.setBackground(new java.awt.Color(0, 153, 51));
        jPanel18.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 1, 70, 100, new java.awt.Color(0, 153, 51)));
        jPanel18.setMinimumSize(new java.awt.Dimension(69, 42));
        jPanel18.setLayout(new java.awt.GridLayout(2, 1, 10, 10));

        btnMoiKH.setText("Mới");
        btnMoiKH.setBackground(new java.awt.Color(255, 204, 153));
        btnMoiKH.setPreferredSize(new java.awt.Dimension(140, 21));
        btnMoiKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiKHActionPerformed(evt);
            }
        });
        jPanel18.add(btnMoiKH);

        btnLuuKH.setText("Lưu");
        btnLuuKH.setBackground(new java.awt.Color(255, 204, 153));
        btnLuuKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuKHActionPerformed(evt);
            }
        });
        jPanel18.add(btnLuuKH);

        jPanel17.add(jPanel18, java.awt.BorderLayout.EAST);

        pnlKhachHang.add(jPanel17, java.awt.BorderLayout.PAGE_START);

        pnlCard_KhachHang_SanPham.add(pnlKhachHang, "KhachHang");

        pnlCenter.add(pnlCard_KhachHang_SanPham, java.awt.BorderLayout.CENTER);

        pnlMain.add(pnlCenter, java.awt.BorderLayout.CENTER);

        add(pnlMain, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnQuetMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuetMaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQuetMaActionPerformed

    private void btnHoaDonMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoaDonMoiActionPerformed
        if (!lblHoaDon.getText().equalsIgnoreCase("Hóa đơn trống")) {
            HoaDonJPanel hdpnl = new HoaDonJPanel(pnlTabs);
            pnlTabs.addTab("Khách lẻ 0" + MainFrm.hoaDonIndex, hdpnl);
            MainFrm.hoaDonIndex++;
            pnlTabs.setSelectedComponent(hdpnl);
        }
    }//GEN-LAST:event_btnHoaDonMoiActionPerformed

    private void btnKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhachHangActionPerformed
        CardLayout layout = (CardLayout) pnlCard_KhachHang_SanPham.getLayout();

        layout.show(pnlCard_KhachHang_SanPham, "KhachHang");
        this.isSanPhamSelected = false;
        changeBackgroud_SP_KH();
    }//GEN-LAST:event_btnKhachHangActionPerformed

    private void btnSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSanPhamActionPerformed
        CardLayout layout = (CardLayout) pnlCard_KhachHang_SanPham.getLayout();

        layout.show(pnlCard_KhachHang_SanPham, "SanPham");
        this.isSanPhamSelected = true;
        changeBackgroud_SP_KH();
    }//GEN-LAST:event_btnSanPhamActionPerformed

    private void cbbLoaKHItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbLoaKHItemStateChanged
        LoaiKhachHang lkh = (LoaiKhachHang) cbbLoaKH.getSelectedItem();
        KhachHang kh = new KhachHang();
        kh.setMaLoaiKH(lkh.getMaLoaiKH());
        loadDataToTableKhachHang(kh);
    }//GEN-LAST:event_cbbLoaKHItemStateChanged

    private void cbbDanhMucSPItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbDanhMucSPItemStateChanged
        DanhMuc dm = (DanhMuc) cbbDanhMucSP.getSelectedItem();
        SanPham sp = new SanPham();
        sp.setMaDanhMuc(dm.getMaDM());
        loadDataToTableSanPham(sp);
    }//GEN-LAST:event_cbbDanhMucSPItemStateChanged

    private void btnMaKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaKhuyenMaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMaKhuyenMaiActionPerformed

    private void btnThanhToamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToamActionPerformed
        if (lblHoaDon.getToolTipText() == null) {
            JOptionPane.showMessageDialog(this, "Không có sản phẩm để thanh toán");
            return;
        } else {
            HoaDon hd = new HoaDon();
            hd.setMaHD(Integer.parseInt(lblHoaDon.getToolTipText()));
            hd.setMaKH(lblTenKH.getToolTipText());
            hd.setMaNV(Auth.user.getMaNV());
            hd.setMaTT(2);
            hd.setThanhTien(Double.parseDouble(lblThanhTien.getToolTipText()));
            new ThanhToanJDialog(null, true, pnlTabs, hd).setVisible(true);
        }

    }//GEN-LAST:event_btnThanhToamActionPerformed

    private void btnMoiKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiKHActionPerformed
        clearFormKH();
    }//GEN-LAST:event_btnMoiKHActionPerformed

    private void btnLuuKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuKHActionPerformed
        if (themKH()) return;
    }//GEN-LAST:event_btnLuuKHActionPerformed

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void txtTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimKiemMouseClicked
    }//GEN-LAST:event_txtTimKiemMouseClicked

    private void txtTimKiemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimKiemFocusGained
        if (txtTimKiem.getText().equalsIgnoreCase("Tìm Kiếm Khách Hàng") || txtTimKiem.getText().equalsIgnoreCase("Tìm Kiếm Sản Phẩm") ){
            txtTimKiem.setText("");
            txtTimKiem.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtTimKiemFocusGained

    private void txtTimKiemFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimKiemFocusLost
        if (txtTimKiem.getText().trim().isEmpty()) {
            txtTimKiem.setForeground(new Color(255, 0, 0));
            changeBackgroud_SP_KH();
        }
    }//GEN-LAST:event_txtTimKiemFocusLost
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHoaDonMoi;
    private javax.swing.JButton btnKhachHang;
    private javax.swing.JButton btnLuuKH;
    private javax.swing.JButton btnMaKhuyenMai;
    private javax.swing.JButton btnMoiKH;
    private javax.swing.JButton btnQuetMa;
    private javax.swing.JButton btnSanPham;
    private javax.swing.JButton btnThanhToam;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbDanhMucSP;
    private javax.swing.JComboBox<String> cbbLoaKH;
    private com.github.lgooddatepicker.components.DatePicker dpkNgaySinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblGiamGia;
    private javax.swing.JLabel lblHoaDon;
    private javax.swing.JLabel lblLoaiKH;
    private javax.swing.JLabel lblMaKH;
    private javax.swing.JLabel lblSoLuong;
    private javax.swing.JLabel lblTenKH;
    private javax.swing.JLabel lblThanhTien;
    private javax.swing.JPanel pnlCard_KhachHang_SanPham;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlKhachHang;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlSanPham;
    private javax.swing.JPanel pnlThanhToan;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtNgayThamGia;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables

    private void changeBackgroud_SP_KH() {
        if (isSanPhamSelected == true) {
            btnSanPham.setBackground(new Color(153, 255, 153));
            btnKhachHang.setBackground(new Color(255, 204, 102));
            txtTimKiem.setText("Tìm Kiếm Sản Phẩm");
        } else {
            btnSanPham.setBackground(new Color(255, 204, 102));
            btnKhachHang.setBackground(new Color(153, 255, 153));
            txtTimKiem.setText("Tìm Kiếm Khách Hàng");
        }
    }

    private void tongTien() {
        double tongTien = 0;
        double giamGia = 0;
        int soLuong = 0;

        for (int i = 0; i < tblHoaDon.getRowCount(); i++) {
            int sl = Integer.parseInt(tblHoaDon.getValueAt(i, 2) + "");
            double thanhTienColum = Double.parseDouble(tblHoaDon.getValueAt(i, 7) + "");
            double giaChuaGiam = sl * Double.parseDouble(tblHoaDon.getValueAt(i, 5) + "");

            tongTien += thanhTienColum;
            giamGia += (giaChuaGiam - thanhTienColum);
            soLuong += sl;
        }

        lblGiamGia.setText(df.format(giamGia));
        lblSoLuong.setText(soLuong + "");
        lblThanhTien.setText(df.format(tongTien));
        lblThanhTien.setToolTipText(tongTien + "");
        txtTongTien.setText(df.format(tongTien));
        pnlTabs.setTitleAt(pnlTabs.getSelectedIndex(), lblTenKH.getText() + ": " + df.format(tongTien));
    }

    private boolean nhapSl() {
        try {
            slNhap = Integer.parseInt(JOptionPane.showInputDialog("Nhập số lượng"));
            if (slNhap > slGoc) {
                JOptionPane.showMessageDialog(null, "Số lượng vượt quá số lượng hiện tại");
                return true;
            } else if (slNhap <= 0) {
                JOptionPane.showMessageDialog(null, "Số lượng phải nhập ít nhất là 1");
                return true;
            }
            return false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Số lượng sai!");
            return true;
        }
    }

//    private boolean checkSL() {
//        if (slNhap > slGoc) {
//            JOptionPane.showMessageDialog(null, "Số lượng vượt quá số lượng tồn kho");
//            return true;
//        } else if (slNhap <= 0) {
//            JOptionPane.showMessageDialog(null, "Số lượng phải nhập ít nhất là 1");
//            return true;
//        }
//        return false;
//    }
    private void loadDataToCBBDM() {
        this.CBBModelDM.removeAllElements();
        List<DanhMuc> list = new ArrayList<>();
        try {
            list = this.daoDM.selectAll();
            for (DanhMuc danhMuc : list) {
                this.CBBModelDM.addElement(danhMuc);
            }
        } catch (Exception ex) {
            Logger.getLogger(HoaDonJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadDataToCBBLKH() {
        this.CBBModelLKH.removeAllElements();
        List<LoaiKhachHang> list = new ArrayList<>();
        try {
            list = this.daoLKH.selectAll();
            for (LoaiKhachHang loaiKhachHang : list) {
                this.CBBModelLKH.addElement(loaiKhachHang);
            }
        } catch (Exception ex) {
            Logger.getLogger(HoaDonJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadDataToTableSanPham(SanPham sp) {
        this.dtmSanPham.setRowCount(0);
        List<SanPham> list = new ArrayList<>();
        try {
            list = this.daoSP.selectWhere(sp);
            for (SanPham sp1 : list) {
                JLabel ImgLabel = new JLabel();
                ImageIcon icon = new ImageIcon(".\\AnhSP\\quanJeanNamDen.jpg");
                Image img = icon.getImage().getScaledInstance(48, 64, Image.SCALE_SMOOTH);
                ImgLabel.setIcon(new ImageIcon(img));
                this.dtmSanPham.addRow(new Object[]{
                    sp1.getMaSP(),
                    sp1.getMaVach(),
                    sp1.getTenSanPham(),
                    sp1.getGiaBan(),
                    sp1.getSoLuong(),
                    null,
                    ImgLabel
                });
            }
        } catch (Exception ex) {
            Logger.getLogger(HoaDonJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadDataToTableKhachHang(KhachHang kh) {
        this.dtmKhachHang.setRowCount(0);
        List<KhachHang> list = new ArrayList<>();
        try {
            list = this.daoKH.selectWhere(kh);
            for (KhachHang kh1 : list) {
                String gt = kh1.isGioiTinh() ? "Nam" : "Nữ";
                this.dtmKhachHang.addRow(new Object[]{
                    kh1.getMaKH(),
                    kh1.getMaLoaiKH(),
                    kh1.getHoTen(),
                    kh1.getDiaChi(),
                    gt,
                    kh1.getEmail(),
                    kh1.getSDT(),
                    XDate.toString(kh1.getNgaySinh(), "dd/MM/yyyy"),
                    XDate.toString(kh1.getNgayTao(), "dd/MM/yyyy")
                });
            }
        } catch (Exception ex) {
            Logger.getLogger(HoaDonJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void reloadTableSP() {
        DanhMuc dm = (DanhMuc) cbbDanhMucSP.getSelectedItem();
        SanPham sp = new SanPham();
        sp.setMaDanhMuc(dm.getMaDM());
        loadDataToTableSanPham(sp);

    }

    public void loadDataToHoaDon() {
        this.dtmHoaDon.setRowCount(0);
        ArrayList<CTHoaDon> list = MainFrm.listCTHD;
        KhachHang kh = MainFrm.k;
        for (CTHoaDon c : list) {
            try {
                SanPham s = this.daoSP.selectById(c.getMaSP());
                dtmHoaDon.addRow(new Object[]{
                    null,
                    s.getTenSanPham(),
                    c.getSoLuong(),
                    null,
                    null,
                    s.getGiaBan(),
                    0,
                    c.getSoLuong() * s.getGiaBan(),
                    c.getMaSP()
                });
                if (kh != null) {
                    lblTenKH.setText(kh.getHoTen());
                    lblTenKH.setToolTipText(kh.getMaKH());
                }

                tongTien();
            } catch (Exception ex) {
                Logger.getLogger(HoaDonJPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void taoHoaDon() {
        this.maxMaHD = this.DAOHD.getMaxMaHD();
        HoaDon hd = new HoaDon();
        hd.setMaHD(maxMaHD + 1);
        hd.setMaNV(Auth.user.getMaNV());
        hd.setMaTT(1);
        if (!lblTenKH.getText().equalsIgnoreCase("Khách lẻ")) {
            hd.setMaKH(lblTenKH.getToolTipText());
        }
        try {
            this.DAOHD.insert(hd);
            lblHoaDon.setText("Mã Hóa Đơn: " + (maxMaHD + 1));
            lblHoaDon.setToolTipText(String.valueOf(maxMaHD + 1));
        } catch (Exception ex) {
            Logger.getLogger(HoaDonJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void taoHDCT(int maSP, int soLuong) {
        CTHoaDon cthd = new CTHoaDon();
        cthd.setMaHD(Integer.parseInt(lblHoaDon.getToolTipText()));
        cthd.setMaSP(maSP);
        cthd.setSoLuong(soLuong);
        try {
            this.DAOCTHD.insert(cthd);
        } catch (Exception ex) {
            Logger.getLogger(HoaDonJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void suaCTHD(int masp, int soLuongSP, int soLuongCTHD) throws NumberFormatException {
        SanPham sp = new SanPham();
        sp.setMaSP(masp);
        sp.setSoLuong(soLuongSP);
        CTHoaDon cthd = new CTHoaDon();
        cthd.setMaHD(Integer.parseInt(lblHoaDon.getToolTipText()));
        cthd.setMaSP(masp);
        cthd.setSoLuong(soLuongCTHD);
        cthd.setTrangThai(true);
        try {
            daoSP.updateSP(sp);
            DAOCTHD.update(cthd);

        } catch (Exception ex) {
            Logger.getLogger(HoaDonJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setLabelHoaDon(HoaDon hd) {
        this.lblHoaDon.setText("Mã Hóa Đơn: " + hd.getMaHD());
        this.lblHoaDon.setToolTipText(hd.getMaHD() + "");
    }

    public JLabel getLblHoaDon() {
        return lblHoaDon;
    }

    private void clearFormKH() {
        this.txtDiaChi.setText("");
        this.txtEmail.setText("");
        this.txtMaKH.setText("");
        this.dpkNgaySinh.setText("15/01/2022");
        this.txtNgayThamGia.setText("");
        this.txtSDT.setText("");
        this.txtTimKiem.setText("");
        this.txtTongTien.setText("");
    }

    public KhachHang getFormKH() {
        KhachHang kh = new KhachHang();
        kh.setMaKH(txtMaKH.getText());
        kh.setHoTen(txtTenKH.getText());
        kh.setDiaChi(txtDiaChi.getText());
        kh.setEmail(txtEmail.getText());
        kh.setGioiTinh(rdoNam.isSelected());
        LoaiKhachHang d = (LoaiKhachHang) cbbLoaKH.getSelectedItem();
        kh.setMaLoaiKH(d.getMaLoaiKH());
        kh.setSDT(txtSDT.getText());

        Date ngaysinh = XDate.toDate(dpkNgaySinh.getText(), "dd/MM/yyyy");
        kh.setNgaySinh(ngaysinh);
        kh.setNgayTao(XDate.toDate(XDate.toString(new Date(), "dd/MM/yyyy"), "MM/dd/YYYY"));
        return kh;
    }

    private boolean CheckFormKH() {
        StringBuilder sp = new StringBuilder();
        if (XValidate.isEmpty(txtMaKH)) {
            sp.append("Không để trống Mã Khách Hàng!\n");
        }
        if (XValidate.isEmpty(txtTenKH)) {
            sp.append("Không để trống Họ Tên Khách Hàng!\n");
        }
        if (XValidate.isEmpty(txtDiaChi)) {
            sp.append("Không để trống Địa Chỉ Khách Hàng!\n");
        }
        if (XValidate.isEmpty(txtSDT)) {
            sp.append("Không để trống Số Điện Thoại Khách Hàng!\n");
        } else if (XValidate.isNotNumber(txtSDT)) {
            sp.append("Số Điện Thoại Không hợp lệ!\n");
        }
        if (XValidate.isEmpty(txtEmail)) {
            sp.append("Không để trống Email Khách Hàng!\n");
        } else if (XValidate.isNotEmail(txtEmail)) {
            sp.append("Email không hợp lệ!\n");
        }
        if (sp.length() > 0) {
            Messeger.showErrorDialog(this, sp.toString(), "Lỗi");
            return true;
        }
        return false;
    }
    
    
    private boolean themKH() {
        if (CheckFormKH()) {
            return true;
        }
        try {
            if (this.daoKH.selectById(getFormKH().getMaKH()) != null) {
                Messeger.alert(this, "Đã tồn tại mã khách hàng này");
                return true;
            }
        }catch (Exception ex) {
            Logger.getLogger(HoaDonJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            KhachHang kh = getFormKH();
            this.daoKH.insert(kh);
            Messeger.alert(this, "Đã thêm thành công");
            loadDataToTableKhachHang(kh);
        } catch (Exception ex) {
            Messeger.showErrorDialog(this, "Lỗi truy vấn", "Hệ thống ORANGE");
            Logger.getLogger(HoaDonJPanel.class.getName()).log(Level.SEVERE, null, ex);
            return true;
        }
        return false;
    }
}
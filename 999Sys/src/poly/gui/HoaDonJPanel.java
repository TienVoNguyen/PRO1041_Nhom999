/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import poly.dao.CTHoaDonDao;
import poly.dao.DanhMucDao;
import poly.dao.HoaDonDao;
import poly.dao.SanPhamDao;
import poly.entity.DanhMuc;
import poly.entity.LoaiKhachHang;
import poly.helper.ButtonColumn;

/**
 *
 * @author XUÂN THÀNH
 */
public class HoaDonJPanel extends javax.swing.JPanel {

    Locale localeVN = new Locale("vi", "VN");
    NumberFormat df = NumberFormat.getCurrencyInstance(localeVN);
    int slNhap;
    int slGoc;
    
    DefaultTableModel dtmSanPham;
    DefaultTableModel dtmKhachHang;
    DefaultTableModel dtmHoaDon;
    DefaultComboBoxModel<DanhMuc> CBBModelDM;
    DefaultComboBoxModel<LoaiKhachHang> CBBModelLKH;
    
    DanhMucDao daoDM;
    SanPhamDao daoSP;
    //khách hàng DAO?
    //Loại KH DAO?
    HoaDonDao DAOHD;
    CTHoaDonDao DAOCTHD;
    
    boolean isSanPhamSelected = true;
    JTabbedPane pnlTabs;

    public HoaDonJPanel(JTabbedPane pnlTabs) {
        initComponents();
        
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

        //truyền vào pnlTabs từ MainFm
        this.pnlTabs = pnlTabs;
        
        this.CBBModelDM = (DefaultComboBoxModel)cbbDanhMucSP.getModel();
        this.CBBModelLKH = (DefaultComboBoxModel)cbbLoaKH.getModel();
        
        loadDataToCBBDM();
        loadDataToCBBLKH();
        loadDataToTableSanPham();
        
    }

    private void addButtonToTable() {
        //Bảng Hóa Đơn
        //Viết mã sử lỹ cho sự kiện xóa ở đây
        Action delete = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                JTable table = (JTable) e.getSource();
                int modelRow = Integer.valueOf(e.getActionCommand());
                ((DefaultTableModel) table.getModel()).removeRow(modelRow);
                tongTien();
            }

        };
        //Viết mã sử lỹ cho sự kiện Giảm ở đây
        Action giam = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                JTable table = (JTable) e.getSource();
                int modelRow = Integer.valueOf(e.getActionCommand());
                int sl = (int) table.getValueAt(modelRow, 2) - 1;
                double gia = Double.parseDouble(table.getValueAt(modelRow, 6) + "");
                if (sl == 0) {
                    return;
                }
                ((DefaultTableModel) table.getModel()).setValueAt(sl, modelRow, 2);
                ((DefaultTableModel) table.getModel()).setValueAt(String.format("%.0f", sl * gia), modelRow, 7);
                tongTien();
            }
        };
        //Viết mã sử lỹ cho sự kiện Tăng ở đây
        Action tang = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                JTable table = (JTable) e.getSource();
                int modelRow = Integer.valueOf(e.getActionCommand());
                int sl = (int) table.getValueAt(modelRow, 2) + 1;
                 double gia = Double.parseDouble(table.getValueAt(modelRow, 6) + "");
                ((DefaultTableModel) table.getModel()).setValueAt(sl, modelRow, 2);
                ((DefaultTableModel) table.getModel()).setValueAt(String.format("%.0f", sl * gia), modelRow, 7);
                tongTien();

            }
        };

        //khởi tạo buttonColum để tạo button có sự kiện xóa vào bảng sản phẩm ở cột 12 đặt tên là xóa
        ButtonColumn btnDeleteHoaDon = new ButtonColumn(tblHoaDon, delete, 0, "Xóa");
        btnDeleteHoaDon.setMnemonic(KeyEvent.VK_D);
        //khởi tạo buttonColum để tạo button có sự kiện Giảm số lượng vào bảng sản phẩm ở cột 3 đặt tên là Giảm
        ButtonColumn btnTangHoaDon = new ButtonColumn(tblHoaDon, giam, 3, "Giảm");
        btnTangHoaDon.setMnemonic(KeyEvent.VK_D);
        //khởi tạo buttonColum để tạo button có sự kiện Tăng số lượng vào bảng sản phẩm ở cột 4 đặt tên là Tăng
        ButtonColumn btnGiamHoaDon = new ButtonColumn(tblHoaDon, tang, 4, "Tăng");
        btnGiamHoaDon.setMnemonic(KeyEvent.VK_D);
        //Bảng Sản Phẩm
        //Viết mã sử lỹ cho sự kiện thêm sản phẩm vào hóa đơn ở đây
        Action ThemSPVaoHD = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                JTable table = (JTable) e.getSource();
                int modelRow = Integer.valueOf(e.getActionCommand());
                slGoc = Integer.parseInt((((DefaultTableModel) table.getModel()).getValueAt(modelRow, 2)) + "");
                
                boolean a = nhapSl();
                boolean b = checkSL();
                if (!a && !b) {
                    double thanhTien = Double.parseDouble(((DefaultTableModel) table.getModel()).getValueAt(modelRow, 3) + "") * slNhap;

                    Object[] data = new Object[]{
                        null,
                        ((DefaultTableModel) table.getModel()).getValueAt(modelRow, 0),
                        slNhap,
                        null,
                        null,
                        (((DefaultTableModel) table.getModel()).getValueAt(modelRow, 1)),
                        (((DefaultTableModel) table.getModel()).getValueAt(modelRow, 3)),
                        String.format("%.0f", thanhTien),
                        ((DefaultTableModel) table.getModel()).getValueAt(modelRow, 5)
                    };
                    addDataToHoaDon(data);
                    ((DefaultTableModel) table.getModel()).setValueAt(slGoc-slNhap, modelRow, 2);
                    tongTien();
                }

            }

        };
        //khởi tạo buttonColum để tạo button có sự kiện 'thêm sản phẩm vào bảng hóa đơn' ở cột 4 đặt tên là Thêm vào hóa đơn
        ButtonColumn btnThemSPVaoHD = new ButtonColumn(tblSanPham, ThemSPVaoHD, 5, "Thêm vào hóa đơn");
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
            }

        };
        //khởi tạo buttonColum để tạo button có sự kiện 'thêm khách hàng vào bảng hóa đơn' ở cột 9 đặt tên là Thêm vào hóa đơn
        ButtonColumn btnThemKHVaoHD = new ButtonColumn(tblKhachHang, ThemKHVaoHD, 9, "Thêm vào hóa đơn");
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
        lblTenKH = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtTongTien = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
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
        btnXoa = new javax.swing.JButton();
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
        jPanel11 = new javax.swing.JPanel();
        lblMaKH = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        lblLoaiKH = new javax.swing.JLabel();
        cbbLoaKH = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        TenKH = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtMaKH2 = new javax.swing.JTextField();
        lblDiaChi = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtMaKH1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtMaKH3 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jRadioButton2 = new javax.swing.JRadioButton();
        rdoNam = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

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
        txtTimKiem.setText("Tìm Kiếm");
        txtTimKiem.setBorder(null);
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
        pnlThanhToan.setForeground(new java.awt.Color(204, 255, 204));
        pnlThanhToan.setPreferredSize(new java.awt.Dimension(650, 479));
        pnlThanhToan.setLayout(new java.awt.BorderLayout());

        lblTenKH.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTenKH.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poly/icons/login32.png"))); // NOI18N
        lblTenKH.setText("Khách lẻ");
        lblTenKH.setPreferredSize(new java.awt.Dimension(34, 50));
        pnlThanhToan.add(lblTenKH, java.awt.BorderLayout.PAGE_START);

        jPanel1.setLayout(new java.awt.BorderLayout());

        txtTongTien.setEditable(false);
        txtTongTien.setBackground(new java.awt.Color(0, 0, 0));
        txtTongTien.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        txtTongTien.setForeground(new java.awt.Color(0, 255, 51));
        txtTongTien.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTongTien.setText("0");
        jPanel1.add(txtTongTien, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jPanel4.setLayout(new java.awt.GridLayout(3, 3));

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
        jPanel4.add(jLabel3);

        lblThanhTien.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblThanhTien.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblThanhTien.setText("0");
        jPanel4.add(lblThanhTien);

        jPanel2.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(450, 50));
        jPanel3.setLayout(new java.awt.GridLayout(0, 3));

        btnThanhToam.setBackground(new java.awt.Color(102, 255, 102));
        btnThanhToam.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnThanhToam.setText("Thanh Toán");
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

        btnXoa.setBackground(new java.awt.Color(255, 51, 51));
        btnXoa.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        jPanel3.add(btnXoa);

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
            tblHoaDon.getColumnModel().getColumn(0).setMinWidth(60);
            tblHoaDon.getColumnModel().getColumn(0).setPreferredWidth(60);
            tblHoaDon.getColumnModel().getColumn(0).setMaxWidth(60);
            tblHoaDon.getColumnModel().getColumn(3).setMinWidth(60);
            tblHoaDon.getColumnModel().getColumn(3).setPreferredWidth(60);
            tblHoaDon.getColumnModel().getColumn(3).setMaxWidth(60);
            tblHoaDon.getColumnModel().getColumn(4).setMinWidth(60);
            tblHoaDon.getColumnModel().getColumn(4).setPreferredWidth(60);
            tblHoaDon.getColumnModel().getColumn(4).setMaxWidth(60);
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

        tblSanPham.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Mã Vạch", "Tên SP", "Đơn Giá", "Số Lượng", "Thêm Vào Hóa Đơn"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPham.setRowHeight(40);
        jScrollPane2.setViewportView(tblSanPham);
        if (tblSanPham.getColumnModel().getColumnCount() > 0) {
            tblSanPham.getColumnModel().getColumn(5).setMinWidth(120);
            tblSanPham.getColumnModel().getColumn(5).setPreferredWidth(120);
            tblSanPham.getColumnModel().getColumn(5).setMaxWidth(120);
        }

        cbbDanhMucSP.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Danh Mục");

        javax.swing.GroupLayout pnlSanPhamLayout = new javax.swing.GroupLayout(pnlSanPham);
        pnlSanPham.setLayout(pnlSanPhamLayout);
        pnlSanPhamLayout.setHorizontalGroup(
            pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE))
        );

        pnlCard_KhachHang_SanPham.add(pnlSanPham, "SanPham");

        pnlKhachHang.setBackground(new java.awt.Color(0, 153, 51));

        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Khách Hàng", "Loại Khách Hàng", "Tên Khách hàng", "Địa Chỉ", "Giới Tính", "Email", "SDT", "Ngày Sinh", "Ngày Tham Gia", "Thêm vào hóa đơn"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKhachHang.setRowHeight(40);
        jScrollPane3.setViewportView(tblKhachHang);
        if (tblKhachHang.getColumnModel().getColumnCount() > 0) {
            tblKhachHang.getColumnModel().getColumn(9).setMinWidth(120);
            tblKhachHang.getColumnModel().getColumn(9).setPreferredWidth(120);
            tblKhachHang.getColumnModel().getColumn(9).setMaxWidth(120);
        }

        jPanel11.setBackground(new java.awt.Color(0, 153, 51));

        lblMaKH.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        lblMaKH.setForeground(new java.awt.Color(255, 255, 255));
        lblMaKH.setText("Mã KH");
        lblMaKH.setPreferredSize(new java.awt.Dimension(60, 20));

        txtMaKH.setPreferredSize(new java.awt.Dimension(180, 18));

        lblLoaiKH.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        lblLoaiKH.setForeground(new java.awt.Color(255, 255, 255));
        lblLoaiKH.setText("Loại khách hàng");
        lblLoaiKH.setPreferredSize(new java.awt.Dimension(60, 0));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Tên KH");
        jLabel6.setPreferredSize(new java.awt.Dimension(60, 20));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("SDT");
        jLabel13.setPreferredSize(new java.awt.Dimension(60, 0));

        txtMaKH2.setPreferredSize(new java.awt.Dimension(180, 18));

        lblDiaChi.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        lblDiaChi.setForeground(new java.awt.Color(255, 255, 255));
        lblDiaChi.setText("Địa chỉ");
        lblDiaChi.setPreferredSize(new java.awt.Dimension(60, 20));

        lblEmail.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(255, 255, 255));
        lblEmail.setText("Email");
        lblEmail.setPreferredSize(new java.awt.Dimension(60, 0));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Ngày tham gia");
        jLabel15.setPreferredSize(new java.awt.Dimension(60, 20));

        txtMaKH1.setPreferredSize(new java.awt.Dimension(180, 18));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Ngày sinh");
        jLabel14.setPreferredSize(new java.awt.Dimension(60, 0));

        txtMaKH3.setPreferredSize(new java.awt.Dimension(180, 18));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Giới tính");
        jLabel9.setPreferredSize(new java.awt.Dimension(60, 20));

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton2.setText("Nữ");

        buttonGroup1.add(rdoNam);
        rdoNam.setForeground(new java.awt.Color(255, 255, 255));
        rdoNam.setText("Nam");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(lblMaKH, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(lblLoaiKH, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                        .addComponent(TenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaKH2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbLoaKH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(txtMaKH1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtMaKH3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rdoNam, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(98, Short.MAX_VALUE))
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
                            .addComponent(TenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaKH2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaKH1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaKH3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdoNam, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        jButton1.setBackground(new java.awt.Color(255, 204, 153));
        jButton1.setText("Lưu");

        jButton2.setBackground(new java.awt.Color(255, 204, 153));
        jButton2.setText("Mới");

        javax.swing.GroupLayout pnlKhachHangLayout = new javax.swing.GroupLayout(pnlKhachHang);
        pnlKhachHang.setLayout(pnlKhachHangLayout);
        pnlKhachHangLayout.setHorizontalGroup(
            pnlKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKhachHangLayout.createSequentialGroup()
                .addGroup(pnlKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
                    .addGroup(pnlKhachHangLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlKhachHangLayout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(jButton1)
                        .addGap(37, 37, 37)
                        .addComponent(jButton2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlKhachHangLayout.setVerticalGroup(
            pnlKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlKhachHangLayout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))
        );

        pnlCard_KhachHang_SanPham.add(pnlKhachHang, "KhachHang");

        pnlCenter.add(pnlCard_KhachHang_SanPham, java.awt.BorderLayout.CENTER);

        pnlMain.add(pnlCenter, java.awt.BorderLayout.CENTER);

        add(pnlMain, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnQuetMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuetMaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQuetMaActionPerformed

    private void btnHoaDonMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoaDonMoiActionPerformed
        HoaDonJPanel hdpnl = new HoaDonJPanel(pnlTabs);

        pnlTabs.addTab("Khách lẻ 0" + MainFrm.hoaDonIndex, hdpnl);
        MainFrm.hoaDonIndex++;

        pnlTabs.setSelectedComponent(hdpnl);
    }//GEN-LAST:event_btnHoaDonMoiActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if (pnlTabs.getTabCount() == 1) {
            JOptionPane.showMessageDialog(this, "chiu");
            return;
        }
        pnlTabs.remove(pnlTabs.getSelectedComponent());
    }//GEN-LAST:event_btnXoaActionPerformed

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TenKH;
    private javax.swing.JButton btnHoaDonMoi;
    private javax.swing.JButton btnKhachHang;
    private javax.swing.JButton btnQuetMa;
    private javax.swing.JButton btnSanPham;
    private javax.swing.JButton btnThanhToam;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbDanhMucSP;
    private javax.swing.JComboBox<String> cbbLoaKH;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblGiamGia;
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
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtMaKH1;
    private javax.swing.JTextField txtMaKH2;
    private javax.swing.JTextField txtMaKH3;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables

    private void changeBackgroud_SP_KH() {
        if (isSanPhamSelected == true) {
            btnSanPham.setBackground(new Color(153, 255, 153));
            btnKhachHang.setBackground(new Color(255, 204, 102));
        } else {
            btnSanPham.setBackground(new Color(255, 204, 102));
            btnKhachHang.setBackground(new Color(153, 255, 153));
        }
    }

    private void addDataToHoaDon(Object[] data) {
        this.dtmHoaDon.addRow(data);
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
        txtTongTien.setText(df.format(tongTien));
        pnlTabs.setTitleAt(pnlTabs.getSelectedIndex(), lblTenKH.getText() + ": " + df.format(tongTien));
    }

    private boolean nhapSl() {
        try {
            slNhap = Integer.parseInt(JOptionPane.showInputDialog("Nhập số lượng"));
            return false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Số lượng sai!");
            return true;
        }
    }

    private boolean checkSL() {
        if (slNhap > slGoc) {
            JOptionPane.showMessageDialog(null, "Số lượng vượt quá số lượng tồn kho");
            return true;
        } else if (slNhap <= 0) {
            JOptionPane.showMessageDialog(null, "Số lượng phải nhập ít nhất là 1");
            return true;
        }
        return false;
    }

    private void loadDataToCBBDM() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void loadDataToCBBLKH() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.newgui;

import java.awt.CardLayout;
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import poly.dao.HoaDonDao;
import poly.dao.TTHoaDonDao;
import poly.entity.TTHoaDon;
import poly.helper.Messeger;
import poly.helper.XDate;
import poly.helper.XInternal;

/**
 *
 * @author NTV
 */
public class LichSuGDFrm extends javax.swing.JInternalFrame {

    private CardLayout cardGoc;
    private HoaDonDao hDDao;
    private TTHoaDonDao tTHDDao;
    private DefaultTableModel HoaDonCHModelTB;
    private DefaultTableModel hoaDonGiaoHangModelTB;
    private DefaultTableModel cTSPmodelTB;
    private DefaultComboBoxModel cbbTrangThaiModel;
    private DefaultComboBoxModel cbbTimKiemMaNV;
    private DefaultComboBoxModel cbbTimKiemMaKH;
    private Locale localeVN = new Locale("vi", "VN");
    private NumberFormat df = NumberFormat.getCurrencyInstance(localeVN);
    private int row = -1;

    /**
     * Creates new form LichSuGDFrm
     */
    public LichSuGDFrm() {
        initComponents();
        init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jpnFormHD = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jpnFormTXT = new javax.swing.JPanel();
        jpnCBBTT = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cbbTrangThai = new javax.swing.JComboBox<>();
        jpnTxtHoaDon = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        jpnTxtMaNV = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        jpnTxtMaKH = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        jpnTxtNgayMua = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtNgayMua = new javax.swing.JTextField();
        jpnTxtGiamGia = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtGiamGia = new javax.swing.JTextField();
        jpnTxtNgayGH = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtNgayGH = new javax.swing.JTextField();
        jpnTxtTienShip = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtTienShip = new javax.swing.JTextField();
        jpnTxtThanhTien = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtThanhTien = new javax.swing.JTextField();
        jpnTxtGhiCHu = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtGhiChu = new javax.swing.JTextField();
        jpnButton = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jpnTitle = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jpnTable = new javax.swing.JPanel();
        jpnTBHD = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        cbbLoaiThanhToan = new javax.swing.JComboBox<>();
        cbbMaNV = new javax.swing.JComboBox<>();
        cbbMaKH = new javax.swing.JComboBox<>();
        jpnCardTableHD = new javax.swing.JPanel();
        jpnGiaoHang = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblThanhToanGiaoHang = new javax.swing.JTable();
        jpnCuaHang = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblThanhToanCuaHang = new javax.swing.JTable();
        jpnTBCTHD = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCTSP = new javax.swing.JTable();
        jpnTiTleCTHD = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();

        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBackground(new java.awt.Color(255, 102, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1227, 688));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jpnFormHD.setBackground(new java.awt.Color(102, 255, 0));
        jpnFormHD.setMinimumSize(new java.awt.Dimension(203, 120));
        jpnFormHD.setPreferredSize(new java.awt.Dimension(500, 200));
        jpnFormHD.setLayout(new java.awt.BorderLayout());

        jPanel11.setBackground(new java.awt.Color(255, 102, 0));
        jPanel11.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 3, 0, 0, new java.awt.Color(0, 0, 0)));
        jPanel11.setPreferredSize(new java.awt.Dimension(327, 40));
        jPanel11.setLayout(new java.awt.BorderLayout());

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("FORM HÓA ĐƠN");
        jPanel11.add(jLabel10, java.awt.BorderLayout.CENTER);

        jpnFormHD.add(jPanel11, java.awt.BorderLayout.PAGE_START);

        jpnFormTXT.setBackground(new java.awt.Color(255, 102, 255));
        jpnFormTXT.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 102, 255)));
        jpnFormTXT.setMinimumSize(new java.awt.Dimension(203, 100));
        jpnFormTXT.setPreferredSize(new java.awt.Dimension(200, 300));
        jpnFormTXT.setLayout(new java.awt.GridLayout(10, 1, 5, 5));

        jpnCBBTT.setLayout(new java.awt.BorderLayout());

        jLabel3.setText("  Trạng Thái :");
        jLabel3.setPreferredSize(new java.awt.Dimension(130, 14));
        jpnCBBTT.add(jLabel3, java.awt.BorderLayout.LINE_START);

        jpnCBBTT.add(cbbTrangThai, java.awt.BorderLayout.CENTER);

        jpnFormTXT.add(jpnCBBTT);

        jpnTxtHoaDon.setLayout(new java.awt.BorderLayout());

        jLabel2.setText("  Mã Hóa Đơn :");
        jLabel2.setPreferredSize(new java.awt.Dimension(130, 14));
        jpnTxtHoaDon.add(jLabel2, java.awt.BorderLayout.LINE_START);
        jpnTxtHoaDon.add(txtMaHD, java.awt.BorderLayout.CENTER);

        jpnFormTXT.add(jpnTxtHoaDon);

        jpnTxtMaNV.setLayout(new java.awt.BorderLayout());

        jLabel5.setText("  Mã Nhân Viên :");
        jLabel5.setPreferredSize(new java.awt.Dimension(130, 14));
        jpnTxtMaNV.add(jLabel5, java.awt.BorderLayout.LINE_START);
        jpnTxtMaNV.add(txtMaNV, java.awt.BorderLayout.CENTER);

        jpnFormTXT.add(jpnTxtMaNV);

        jpnTxtMaKH.setLayout(new java.awt.BorderLayout());

        jLabel7.setText("  Mã Khách Hàng :");
        jLabel7.setPreferredSize(new java.awt.Dimension(130, 14));
        jpnTxtMaKH.add(jLabel7, java.awt.BorderLayout.LINE_START);
        jpnTxtMaKH.add(txtMaKH, java.awt.BorderLayout.CENTER);

        jpnFormTXT.add(jpnTxtMaKH);

        jpnTxtNgayMua.setLayout(new java.awt.BorderLayout());

        jLabel9.setText("  Ngày Mua :");
        jLabel9.setPreferredSize(new java.awt.Dimension(130, 14));
        jpnTxtNgayMua.add(jLabel9, java.awt.BorderLayout.LINE_START);
        jpnTxtNgayMua.add(txtNgayMua, java.awt.BorderLayout.CENTER);

        jpnFormTXT.add(jpnTxtNgayMua);

        jpnTxtGiamGia.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("  Giảm Giá :");
        jLabel1.setPreferredSize(new java.awt.Dimension(130, 14));
        jpnTxtGiamGia.add(jLabel1, java.awt.BorderLayout.LINE_START);
        jpnTxtGiamGia.add(txtGiamGia, java.awt.BorderLayout.CENTER);

        jpnFormTXT.add(jpnTxtGiamGia);

        jpnTxtNgayGH.setLayout(new java.awt.BorderLayout());

        jLabel4.setText("  Ngày Giao Hàng :");
        jLabel4.setPreferredSize(new java.awt.Dimension(130, 14));
        jpnTxtNgayGH.add(jLabel4, java.awt.BorderLayout.LINE_START);
        jpnTxtNgayGH.add(txtNgayGH, java.awt.BorderLayout.CENTER);

        jpnFormTXT.add(jpnTxtNgayGH);

        jpnTxtTienShip.setLayout(new java.awt.BorderLayout());

        jLabel6.setText("  Tiền Ship :");
        jLabel6.setPreferredSize(new java.awt.Dimension(130, 14));
        jpnTxtTienShip.add(jLabel6, java.awt.BorderLayout.LINE_START);
        jpnTxtTienShip.add(txtTienShip, java.awt.BorderLayout.CENTER);

        jpnFormTXT.add(jpnTxtTienShip);

        jpnTxtThanhTien.setLayout(new java.awt.BorderLayout());

        jLabel8.setText("  Thành Tiền :");
        jLabel8.setPreferredSize(new java.awt.Dimension(130, 14));
        jpnTxtThanhTien.add(jLabel8, java.awt.BorderLayout.LINE_START);
        jpnTxtThanhTien.add(txtThanhTien, java.awt.BorderLayout.CENTER);

        jpnFormTXT.add(jpnTxtThanhTien);

        jpnTxtGhiCHu.setLayout(new java.awt.BorderLayout());

        jLabel13.setText("  Ghi Chú :");
        jLabel13.setPreferredSize(new java.awt.Dimension(130, 14));
        jpnTxtGhiCHu.add(jLabel13, java.awt.BorderLayout.LINE_START);
        jpnTxtGhiCHu.add(txtGhiChu, java.awt.BorderLayout.CENTER);

        jpnFormTXT.add(jpnTxtGhiCHu);

        jpnFormHD.add(jpnFormTXT, java.awt.BorderLayout.CENTER);

        jpnButton.setBackground(new java.awt.Color(255, 102, 255));
        jpnButton.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 3, 0, 0, new java.awt.Color(0, 0, 0)));
        jpnButton.setPreferredSize(new java.awt.Dimension(774, 80));
        jpnButton.setLayout(new java.awt.GridBagLayout());
        jpnFormHD.add(jpnButton, java.awt.BorderLayout.SOUTH);

        jPanel12.setBackground(new java.awt.Color(0, 0, 0));
        jPanel12.setPreferredSize(new java.awt.Dimension(3, 405));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        jpnFormHD.add(jPanel12, java.awt.BorderLayout.WEST);

        jPanel1.add(jpnFormHD, java.awt.BorderLayout.EAST);

        jpnTitle.setBackground(new java.awt.Color(255, 102, 255));
        jpnTitle.setPreferredSize(new java.awt.Dimension(780, 60));
        jpnTitle.setLayout(new java.awt.BorderLayout());

        jLabel11.setBackground(new java.awt.Color(255, 102, 255));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("LỊCH SỬ GIAO DỊCH");
        jLabel11.setPreferredSize(new java.awt.Dimension(207, 30));
        jpnTitle.add(jLabel11, java.awt.BorderLayout.CENTER);

        jPanel1.add(jpnTitle, java.awt.BorderLayout.PAGE_START);

        jpnTable.setBackground(new java.awt.Color(255, 102, 255));
        jpnTable.setLayout(new java.awt.BorderLayout());

        jpnTBHD.setBackground(new java.awt.Color(51, 255, 0));
        jpnTBHD.setPreferredSize(new java.awt.Dimension(774, 150));
        jpnTBHD.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(255, 102, 0));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 102, 0)));
        jPanel3.setForeground(new java.awt.Color(255, 102, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(280, 40));
        jPanel3.setLayout(new java.awt.GridLayout(1, 3, 5, 5));

        cbbLoaiThanhToan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbbLoaiThanhToan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cửa Hàng", "Giao Hàng" }));
        cbbLoaiThanhToan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbLoaiThanhToanItemStateChanged(evt);
            }
        });
        jPanel3.add(cbbLoaiThanhToan);

        cbbMaNV.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbbMaNV.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbMaNVItemStateChanged(evt);
            }
        });
        jPanel3.add(cbbMaNV);

        cbbMaKH.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbbMaKH.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbMaKHItemStateChanged(evt);
            }
        });
        jPanel3.add(cbbMaKH);

        jpnTBHD.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jpnCardTableHD.setBackground(new java.awt.Color(255, 102, 255));
        jpnCardTableHD.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 5, 0, 5, new java.awt.Color(255, 102, 255)));
        jpnCardTableHD.setPreferredSize(new java.awt.Dimension(621, 294));
        jpnCardTableHD.setLayout(new java.awt.CardLayout());

        jpnGiaoHang.setBackground(new java.awt.Color(51, 51, 255));
        jpnGiaoHang.setLayout(new java.awt.BorderLayout());

        tblThanhToanGiaoHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Hóa Đơn", "Mã Nhân Viên", "Tên NV", "Mã Khách Hàng", "Họ Tên", "SDT", "Địa Chỉ", "Ngày Mua", "Ngày Giao", "Giảm Gía", "Tiền Ship", "Thành Tiền", "Trạng Thái", "Ghi Chú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblThanhToanGiaoHang.setRowHeight(24);
        tblThanhToanGiaoHang.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblThanhToanGiaoHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThanhToanGiaoHangMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblThanhToanGiaoHang);

        jpnGiaoHang.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        jpnCardTableHD.add(jpnGiaoHang, "CardGiaoHang");

        jpnCuaHang.setLayout(new java.awt.BorderLayout());

        tblThanhToanCuaHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Hóa Đơn", "Mã Nhân Viên", "Tên NV", "Mã Khách Hàng", "Ngày Mua", "Giảm Giá", "Thành Tiền", "Trạng Thái", "Ghi Chú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblThanhToanCuaHang.setPreferredSize(new java.awt.Dimension(300, 294));
        tblThanhToanCuaHang.setRowHeight(24);
        tblThanhToanCuaHang.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblThanhToanCuaHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThanhToanCuaHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblThanhToanCuaHang);

        jpnCuaHang.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jpnCardTableHD.add(jpnCuaHang, "cardTTCuaHang");

        jpnTBHD.add(jpnCardTableHD, java.awt.BorderLayout.CENTER);

        jpnTable.add(jpnTBHD, java.awt.BorderLayout.CENTER);

        jpnTBCTHD.setBackground(new java.awt.Color(255, 102, 255));
        jpnTBCTHD.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 5, 5, 5, new java.awt.Color(255, 102, 255)));
        jpnTBCTHD.setPreferredSize(new java.awt.Dimension(780, 294));
        jpnTBCTHD.setLayout(new java.awt.BorderLayout());

        tblCTSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã SP", "Tên SP", "Mã Vạch ", "Giá Bán", "Số Lượng", "Tên Danh Mục", "Đơn Vị Tính", "Size", "Màu Sắc", "Chất Liệu", "Ngày Nhập"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCTSP.setRowHeight(24);
        tblCTSP.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(tblCTSP);

        jpnTBCTHD.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jpnTiTleCTHD.setBackground(new java.awt.Color(255, 102, 255));
        jpnTiTleCTHD.setPreferredSize(new java.awt.Dimension(621, 30));
        jpnTiTleCTHD.setLayout(new java.awt.BorderLayout());

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Chi Tiết Hóa Đơn");
        jpnTiTleCTHD.add(jLabel12, java.awt.BorderLayout.CENTER);

        jpnTBCTHD.add(jpnTiTleCTHD, java.awt.BorderLayout.PAGE_START);

        jpnTable.add(jpnTBCTHD, java.awt.BorderLayout.PAGE_END);

        jPanel1.add(jpnTable, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbbLoaiThanhToanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbLoaiThanhToanItemStateChanged
        if (cbbLoaiThanhToan.getSelectedIndex() == 0) {
            cardGoc.show(this.jpnCardTableHD, "cardTTCuaHang");
        } else {
            cardGoc.show(this.jpnCardTableHD, "CardGiaoHang");
        }
    }//GEN-LAST:event_cbbLoaiThanhToanItemStateChanged

    private void tblThanhToanGiaoHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThanhToanGiaoHangMouseClicked
        row = tblThanhToanGiaoHang.getSelectedRow();
        if (row == -1) {
            return;
        }
        this.cbbTrangThaiModel.setSelectedItem(tblThanhToanGiaoHang.getValueAt(row, 12).toString());
        this.txtMaHD.setText(tblThanhToanGiaoHang.getValueAt(row, 0).toString());
        this.txtMaNV.setText(tblThanhToanGiaoHang.getValueAt(row, 1).toString());
        this.txtMaKH.setText(tblThanhToanGiaoHang.getValueAt(row, 3).toString());
        this.txtNgayMua.setText(XDate.toString((Date) tblThanhToanGiaoHang.getValueAt(row, 7), "dd/MM/yyyy"));
        this.txtNgayGH.setText(XDate.toString((Date) tblThanhToanGiaoHang.getValueAt(row, 8), "dd/MM/yyyy"));
        this.txtGiamGia.setText(tblThanhToanGiaoHang.getValueAt(row, 9).toString());
        this.txtTienShip.setText(tblThanhToanGiaoHang.getValueAt(row, 10).toString());
        this.txtThanhTien.setText(tblThanhToanGiaoHang.getValueAt(row, 11).toString());
        this.txtGhiChu.setText(tblThanhToanGiaoHang.getValueAt(row, 13).toString());
        int maHD = Integer.parseInt(tblThanhToanGiaoHang.getValueAt(row, 0).toString());
        this.fillToTableCTSP(maHD);
    }//GEN-LAST:event_tblThanhToanGiaoHangMouseClicked

    private void tblThanhToanCuaHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThanhToanCuaHangMouseClicked
        row = tblThanhToanCuaHang.getSelectedRow();
        if (row == -1) {
            return;
        }
        this.cbbTrangThaiModel.setSelectedItem(tblThanhToanCuaHang.getValueAt(row, 7).toString());
        this.txtMaHD.setText(tblThanhToanCuaHang.getValueAt(row, 0).toString());
        this.txtMaNV.setText(tblThanhToanCuaHang.getValueAt(row, 1).toString());
        if (tblThanhToanCuaHang.getValueAt(row, 3) == null) {
            this.txtMaKH.setText("");
        } else {
            this.txtMaKH.setText(tblThanhToanCuaHang.getValueAt(row, 3).toString());
        }
        this.txtNgayMua.setText(XDate.toString((Date) tblThanhToanCuaHang.getValueAt(row, 4), "dd/MM/yyyy"));
        this.txtGiamGia.setText(tblThanhToanCuaHang.getValueAt(row, 5).toString());
        this.txtThanhTien.setText(tblThanhToanCuaHang.getValueAt(row, 6).toString());
        int maHD = Integer.parseInt(tblThanhToanCuaHang.getValueAt(row, 0).toString());
        this.fillToTableCTSP(maHD);
    }//GEN-LAST:event_tblThanhToanCuaHangMouseClicked

    private void cbbMaNVItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbMaNVItemStateChanged
        String maNV, maKH;
        maNV = (cbbMaNV.getSelectedItem().toString().equalsIgnoreCase("Mã Nhân Viên") ? "%%" : "%" + cbbMaNV.getSelectedItem().toString() + "%");
        cbbMaKH.setSelectedItem("Mã Khách Hàng");
        maKH = "%%";
        Object[] listKey = {maNV, maKH};
        this.fillToTableHDCuaHang(listKey);
        this.fillToTableHDGiaoHang(listKey);
        this.setTableSP();

    }//GEN-LAST:event_cbbMaNVItemStateChanged

    private void cbbMaKHItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbMaKHItemStateChanged
        String maNV, maKH;
        maKH = String.valueOf(cbbMaKH.getSelectedItem().toString().equalsIgnoreCase("Mã Khách Hàng") ? "%%" : "%" + cbbMaKH.getSelectedItem().toString() + "%");
        cbbMaNV.setSelectedIndex(0);
        maNV = "%%";
        Object[] listKey = {maNV, maKH};
        this.fillToTableHDCuaHang(listKey);
        this.fillToTableHDGiaoHang(listKey);
        this.setTableSP();
    }//GEN-LAST:event_cbbMaKHItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbbLoaiThanhToan;
    private javax.swing.JComboBox<String> cbbMaKH;
    private javax.swing.JComboBox<String> cbbMaNV;
    private javax.swing.JComboBox<String> cbbTrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel jpnButton;
    private javax.swing.JPanel jpnCBBTT;
    private javax.swing.JPanel jpnCardTableHD;
    private javax.swing.JPanel jpnCuaHang;
    private javax.swing.JPanel jpnFormHD;
    private javax.swing.JPanel jpnFormTXT;
    private javax.swing.JPanel jpnGiaoHang;
    private javax.swing.JPanel jpnTBCTHD;
    private javax.swing.JPanel jpnTBHD;
    private javax.swing.JPanel jpnTable;
    private javax.swing.JPanel jpnTiTleCTHD;
    private javax.swing.JPanel jpnTitle;
    private javax.swing.JPanel jpnTxtGhiCHu;
    private javax.swing.JPanel jpnTxtGiamGia;
    private javax.swing.JPanel jpnTxtHoaDon;
    private javax.swing.JPanel jpnTxtMaKH;
    private javax.swing.JPanel jpnTxtMaNV;
    private javax.swing.JPanel jpnTxtNgayGH;
    private javax.swing.JPanel jpnTxtNgayMua;
    private javax.swing.JPanel jpnTxtThanhTien;
    private javax.swing.JPanel jpnTxtTienShip;
    private javax.swing.JTable tblCTSP;
    private javax.swing.JTable tblThanhToanCuaHang;
    private javax.swing.JTable tblThanhToanGiaoHang;
    private javax.swing.JTextField txtGhiChu;
    private javax.swing.JTextField txtGiamGia;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtNgayGH;
    private javax.swing.JTextField txtNgayMua;
    private javax.swing.JTextField txtThanhTien;
    private javax.swing.JTextField txtTienShip;
    // End of variables declaration//GEN-END:variables

    private void init() {
        XInternal.uncorated(this);
        cbbTrangThaiModel = (DefaultComboBoxModel) cbbTrangThai.getModel();
        cbbTimKiemMaNV = (DefaultComboBoxModel) cbbMaNV.getModel();
        cbbTimKiemMaKH = (DefaultComboBoxModel) cbbMaKH.getModel();
        hDDao = new HoaDonDao();
        tTHDDao = new TTHoaDonDao();
        cardGoc = (CardLayout) this.jpnCardTableHD.getLayout();
        cardGoc.show(jpnCardTableHD, "cardTTCuaHang");
        Object[] keyObj = {"%%", "%%"};
        this.fillToTableHDCuaHang(keyObj);
        this.fillToTableHDGiaoHang(keyObj);
        this.fillToCBBTrangThai();
        this.fillToCBBTimKiem();
    }

    private void fillToTableHDCuaHang(Object[] keyObj) {
        try {
            HoaDonCHModelTB = (DefaultTableModel) tblThanhToanCuaHang.getModel();
            HoaDonCHModelTB.setRowCount(0);
            List<Object[]> listHD = hDDao.getListHD(keyObj);
            for (Object[] hd : listHD) {
                HoaDonCHModelTB.addRow(hd);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void fillToTableHDGiaoHang(Object[] listKey) {
        try {
            hoaDonGiaoHangModelTB = (DefaultTableModel) tblThanhToanGiaoHang.getModel();
            hoaDonGiaoHangModelTB.setRowCount(0);
            List<Object[]> listGiaoHang = hDDao.getListGIAOHANG(listKey);
            for (Object[] giaoHang : listGiaoHang) {
                hoaDonGiaoHangModelTB.addRow(giaoHang);
            }

        } catch (Exception ex) {
            Messeger.showErrorDialog(this, "Lỗi", "Error!");
            ex.printStackTrace();
        }
    }

    private void fillToTableCTSP(int maHD) {
        try {
            cTSPmodelTB = (DefaultTableModel) tblCTSP.getModel();
            cTSPmodelTB.setRowCount(0);
            List<Object[]> listCTSP = hDDao.getListCTSPByMaHD(maHD);
            for (Object[] o : listCTSP) {
                cTSPmodelTB.addRow(o);
            }
        } catch (Exception ex) {
            Messeger.showErrorDialog(this, "Lỗi load CTSP", "ERROR!");
            ex.printStackTrace();
        }
    }

    private void fillToCBBTrangThai() {
        try {
            cbbTrangThaiModel.removeAllElements();
            List<TTHoaDon> listTTHoaDon = tTHDDao.selectAll();
            for (TTHoaDon tTHD : listTTHoaDon) {
                cbbTrangThaiModel.addElement(tTHD);
            }
        } catch (Exception ex) {
            Messeger.showErrorDialog(this, "Lỗi truy vấn trạng thái hóa đơn!", "Error!");
            ex.printStackTrace();
        }
    }

    private void fillToCBBTimKiem() {
        try {
            cbbTimKiemMaNV.removeAllElements();
            cbbTimKiemMaKH.removeAllElements();
            cbbTimKiemMaNV.addElement("Mã Nhân Viên");
            List<String> listCBBNhanVien = hDDao.getCbbMaNV();
            for (String nv : listCBBNhanVien) {
                cbbTimKiemMaNV.addElement(nv);
            }
            cbbTimKiemMaKH.addElement("Mã Khách Hàng");
            List<String> listCBBKhangHang = hDDao.getCbbMaKH();
            for (String kh : listCBBKhangHang) {
                cbbTimKiemMaKH.addElement(kh);
            }
        } catch (Exception ex) {
            Messeger.showErrorDialog(this, "Lỗi truy vấn tìm kiếm hóa đơn!", "Error!");
            ex.printStackTrace();
        }
    }

    private void setTableSP() {
        if (cbbTrangThai.getSelectedIndex() == 0) {
            if (tblThanhToanCuaHang.getRowCount() == 0) {
                cTSPmodelTB.setRowCount(0);
            }
        } else if (tblThanhToanGiaoHang.getRowCount() == 0) {
            cTSPmodelTB.setRowCount(0);
        }
    }
}

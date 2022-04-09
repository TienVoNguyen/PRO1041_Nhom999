/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.gui;

import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import poly.dao.NhanVienDao;
import poly.dao.VaiTroDao;
import poly.entity.NhanVien;
import poly.entity.VaiTro;
import poly.helper.Auth;
import poly.helper.CustomDatePicker;
import poly.helper.ImageHelper;
import poly.helper.Messeger;
import poly.helper.XDate;
import poly.helper.XValidate;

/**
 *
 * @author maihuong
 */
public class QuanLyTaiKhoan extends javax.swing.JDialog {

    private JFileChooser fileChooser;
    NhanVienDao dao_nv;
    VaiTroDao dao_vt;
    DefaultTableModel modelTable_nv;
    DefaultTableModel modelTable_vt;

    public QuanLyTaiKhoan(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jpncenter = new javax.swing.JPanel();
        jpnTaiKhoan = new javax.swing.JPanel();
        jpntableTK = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblnhanvien = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jpnSearch = new javax.swing.JPanel();
        btnTimKiem = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        jpnForm = new javax.swing.JPanel();
        jpnButton = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        btnThemMoi = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnFirst = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        lbanh = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        jPanel21 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JTextField();
        jPanel25 = new javax.swing.JPanel();
        jPanel51 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jPanel52 = new javax.swing.JPanel();
        radioql = new javax.swing.JRadioButton();
        radionv = new javax.swing.JRadioButton();
        jPanel23 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtngaysinh = new com.github.lgooddatepicker.components.DatePicker();
        jPanel24 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtSĐT = new javax.swing.JTextField();
        jPanel26 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jPanel27 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jPanel28 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jPanel29 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtngaytao = new com.github.lgooddatepicker.components.DatePicker();
        jpnVaiTro = new javax.swing.JPanel();
        jpnTableVaiTro = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblvt = new javax.swing.JTable();
        jpnFormVaiTro = new javax.swing.JPanel();
        jPanel48 = new javax.swing.JPanel();
        jPanel49 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        txtMaVT = new javax.swing.JTextField();
        jPanel50 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        txtTenVT = new javax.swing.JTextField();
        jpnbuttonVaiTro = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(1483, 666));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(255, 204, 204));
        jPanel3.setPreferredSize(new java.awt.Dimension(1227, 45));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jLabel1.setBackground(new java.awt.Color(255, 204, 204));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ TÀI KHOẢN");
        jPanel3.add(jLabel1, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jpncenter.setPreferredSize(new java.awt.Dimension(85, 650));
        jpncenter.setLayout(new java.awt.BorderLayout());

        jpnTaiKhoan.setLayout(new java.awt.BorderLayout());

        jpntableTK.setLayout(new java.awt.BorderLayout());

        tblnhanvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã NV", "Họ Tên", "Mật Khẩu", "Ngày Sinh", "Số ĐT", "Giới Tính", "Địa Chỉ", "Email", "Ngày Tạo", "Vai Trò", "Ảnh NV"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblnhanvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblnhanvienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblnhanvien);

        jpntableTK.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel6.setPreferredSize(new java.awt.Dimension(820, 70));
        jPanel6.setLayout(new java.awt.BorderLayout());

        jPanel8.setBackground(new java.awt.Color(255, 51, 102));
        jPanel8.setPreferredSize(new java.awt.Dimension(820, 30));
        jPanel8.setLayout(new java.awt.BorderLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Quản lý tài khoản");
        jPanel8.add(jLabel2, java.awt.BorderLayout.CENTER);

        jPanel7.setBackground(new java.awt.Color(0, 153, 153));
        jPanel7.setPreferredSize(new java.awt.Dimension(820, 40));
        jPanel7.setLayout(new java.awt.BorderLayout());

        jLabel15.setText("Loại Tài Khoản  ");
        jPanel7.add(jLabel15, java.awt.BorderLayout.LINE_START);

        jpnSearch.setLayout(new java.awt.BorderLayout());

        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poly/icons/search.jpg"))); // NOI18N
        btnTimKiem.setText("Tìm Kiếm");
        jpnSearch.add(btnTimKiem, java.awt.BorderLayout.EAST);
        jpnSearch.add(txtTimKiem, java.awt.BorderLayout.CENTER);

        jPanel7.add(jpnSearch, java.awt.BorderLayout.CENTER);

        jPanel8.add(jPanel7, java.awt.BorderLayout.PAGE_START);

        jPanel6.add(jPanel8, java.awt.BorderLayout.CENTER);

        jpntableTK.add(jPanel6, java.awt.BorderLayout.PAGE_START);

        jpnTaiKhoan.add(jpntableTK, java.awt.BorderLayout.CENTER);

        jpnForm.setPreferredSize(new java.awt.Dimension(820, 400));
        jpnForm.setLayout(new java.awt.BorderLayout());

        jpnButton.setBackground(new java.awt.Color(255, 255, 51));
        jpnButton.setPreferredSize(new java.awt.Dimension(820, 50));
        jpnButton.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        jPanel12.setLayout(new java.awt.GridLayout(1, 4, 5, 0));

        btnThemMoi.setText("Mới");
        btnThemMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMoiActionPerformed(evt);
            }
        });
        jPanel12.add(btnThemMoi);

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jPanel12.add(btnThem);

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        jPanel12.add(btnSua);

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        jPanel12.add(btnXoa);

        jpnButton.add(jPanel12);

        jPanel2.setLayout(new java.awt.GridLayout(1, 4, 5, 0));

        btnFirst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poly/icons/firtsicon.png"))); // NOI18N
        jPanel2.add(btnFirst);

        btnPrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poly/icons/preicon.png"))); // NOI18N
        jPanel2.add(btnPrev);

        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poly/icons/nexticon.png"))); // NOI18N
        jPanel2.add(btnNext);

        btnLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poly/icons/lasticon.png"))); // NOI18N
        jPanel2.add(btnLast);

        jpnButton.add(jPanel2);

        jpnForm.add(jpnButton, java.awt.BorderLayout.PAGE_END);

        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));
        jPanel5.setPreferredSize(new java.awt.Dimension(200, 300));
        jPanel5.setLayout(new java.awt.GridLayout(1, 0));

        lbanh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbanh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbanhMouseClicked(evt);
            }
        });
        jPanel5.add(lbanh);

        jPanel4.add(jPanel5, java.awt.BorderLayout.LINE_START);

        jPanel9.setBackground(new java.awt.Color(51, 51, 255));
        jPanel9.setPreferredSize(new java.awt.Dimension(95, 650));
        jPanel9.setLayout(new java.awt.GridLayout(5, 2, 5, 5));

        jPanel22.setLayout(new java.awt.BorderLayout());

        jLabel6.setText("  Mã NV :");
        jLabel6.setPreferredSize(new java.awt.Dimension(95, 15));
        jPanel22.add(jLabel6, java.awt.BorderLayout.LINE_START);
        jPanel22.add(txtMaNV, java.awt.BorderLayout.CENTER);

        jPanel9.add(jPanel22);

        jPanel21.setLayout(new java.awt.BorderLayout());

        jLabel5.setText("  Họ Tên :");
        jLabel5.setPreferredSize(new java.awt.Dimension(95, 15));
        jPanel21.add(jLabel5, java.awt.BorderLayout.LINE_START);
        jPanel21.add(txtHoTen, java.awt.BorderLayout.CENTER);

        jPanel9.add(jPanel21);

        jPanel10.setLayout(new java.awt.BorderLayout());

        jLabel4.setText("  Mật khẩu :");
        jLabel4.setPreferredSize(new java.awt.Dimension(95, 15));
        jPanel10.add(jLabel4, java.awt.BorderLayout.LINE_START);
        jPanel10.add(txtMatKhau, java.awt.BorderLayout.CENTER);

        jPanel9.add(jPanel10);

        jPanel25.setLayout(new java.awt.BorderLayout());

        jPanel51.setLayout(new java.awt.BorderLayout());

        jLabel27.setText("  Trạng Thái");
        jLabel27.setPreferredSize(new java.awt.Dimension(100, 16));
        jPanel51.add(jLabel27, java.awt.BorderLayout.LINE_START);

        jPanel52.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 5));

        buttonGroup2.add(radioql);
        radioql.setSelected(true);
        radioql.setText("Quản lý");
        radioql.setPreferredSize(new java.awt.Dimension(85, 55));
        jPanel52.add(radioql);

        buttonGroup2.add(radionv);
        radionv.setText("Nhân viên");
        radionv.setPreferredSize(new java.awt.Dimension(85, 55));
        jPanel52.add(radionv);

        jPanel51.add(jPanel52, java.awt.BorderLayout.CENTER);

        jPanel25.add(jPanel51, java.awt.BorderLayout.CENTER);

        jPanel9.add(jPanel25);

        jPanel23.setLayout(new java.awt.BorderLayout());

        jLabel7.setText("  Ngày sinh :");
        jLabel7.setPreferredSize(new java.awt.Dimension(95, 15));
        jPanel23.add(jLabel7, java.awt.BorderLayout.LINE_START);
        jPanel23.add(txtngaysinh, java.awt.BorderLayout.CENTER);

        jPanel9.add(jPanel23);

        jPanel24.setLayout(new java.awt.BorderLayout());

        jLabel8.setText(" Số Điện Thoại :");
        jLabel8.setPreferredSize(new java.awt.Dimension(95, 15));
        jPanel24.add(jLabel8, java.awt.BorderLayout.LINE_START);
        jPanel24.add(txtSĐT, java.awt.BorderLayout.CENTER);

        jPanel9.add(jPanel24);

        jPanel26.setLayout(new java.awt.BorderLayout());

        jLabel10.setText("  Giới Tính :");
        jLabel10.setPreferredSize(new java.awt.Dimension(95, 15));
        jPanel26.add(jLabel10, java.awt.BorderLayout.LINE_START);

        buttonGroup1.add(rdoNam);
        rdoNam.setSelected(true);
        rdoNam.setText("Nam");
        rdoNam.setPreferredSize(new java.awt.Dimension(85, 55));
        jPanel11.add(rdoNam);

        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nữ");
        rdoNu.setPreferredSize(new java.awt.Dimension(85, 55));
        jPanel11.add(rdoNu);

        jPanel26.add(jPanel11, java.awt.BorderLayout.CENTER);

        jPanel9.add(jPanel26);

        jPanel27.setLayout(new java.awt.BorderLayout());

        jLabel11.setText("  Địa chỉ :");
        jLabel11.setPreferredSize(new java.awt.Dimension(95, 15));
        jPanel27.add(jLabel11, java.awt.BorderLayout.LINE_START);
        jPanel27.add(txtDiaChi, java.awt.BorderLayout.CENTER);

        jPanel9.add(jPanel27);

        jPanel28.setLayout(new java.awt.BorderLayout());

        jLabel12.setText("  Email :");
        jLabel12.setPreferredSize(new java.awt.Dimension(95, 15));
        jPanel28.add(jLabel12, java.awt.BorderLayout.LINE_START);
        jPanel28.add(txtEmail, java.awt.BorderLayout.CENTER);

        jPanel9.add(jPanel28);

        jPanel29.setLayout(new java.awt.BorderLayout());

        jLabel13.setText(" Ngày Tạo :");
        jLabel13.setPreferredSize(new java.awt.Dimension(95, 15));
        jPanel29.add(jLabel13, java.awt.BorderLayout.LINE_START);
        jPanel29.add(txtngaytao, java.awt.BorderLayout.CENTER);

        jPanel9.add(jPanel29);

        jPanel4.add(jPanel9, java.awt.BorderLayout.CENTER);

        jpnForm.add(jPanel4, java.awt.BorderLayout.CENTER);

        jpnTaiKhoan.add(jpnForm, java.awt.BorderLayout.PAGE_END);

        jpncenter.add(jpnTaiKhoan, java.awt.BorderLayout.CENTER);

        jpnVaiTro.setBackground(new java.awt.Color(102, 102, 255));
        jpnVaiTro.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        jpnVaiTro.setPreferredSize(new java.awt.Dimension(400, 646));
        jpnVaiTro.setLayout(new java.awt.BorderLayout());

        jpnTableVaiTro.setPreferredSize(new java.awt.Dimension(345, 300));
        jpnTableVaiTro.setLayout(new java.awt.BorderLayout());

        jPanel15.setPreferredSize(new java.awt.Dimension(345, 70));
        jPanel15.setLayout(new java.awt.BorderLayout());

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Vai Trò");
        jPanel15.add(jLabel14, java.awt.BorderLayout.CENTER);

        jpnTableVaiTro.add(jPanel15, java.awt.BorderLayout.PAGE_START);

        jPanel16.setLayout(new java.awt.BorderLayout());

        tblvt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Vai Trò", "Tên Vai Trò"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblvt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblvtMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblvt);

        jPanel16.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jpnTableVaiTro.add(jPanel16, java.awt.BorderLayout.CENTER);

        jpnVaiTro.add(jpnTableVaiTro, java.awt.BorderLayout.PAGE_START);

        jpnFormVaiTro.setLayout(new java.awt.BorderLayout());

        jPanel48.setPreferredSize(new java.awt.Dimension(345, 200));
        jPanel48.setLayout(new java.awt.GridLayout(3, 1, 5, 5));

        jPanel49.setLayout(new java.awt.BorderLayout());

        jLabel25.setText("  Mã Vai Trò :");
        jLabel25.setPreferredSize(new java.awt.Dimension(100, 16));
        jPanel49.add(jLabel25, java.awt.BorderLayout.LINE_START);
        jPanel49.add(txtMaVT, java.awt.BorderLayout.CENTER);

        jPanel48.add(jPanel49);

        jPanel50.setLayout(new java.awt.BorderLayout());

        jLabel26.setText("  Tên Vai Trò :");
        jLabel26.setMaximumSize(new java.awt.Dimension(60, 16));
        jLabel26.setPreferredSize(new java.awt.Dimension(100, 16));
        jPanel50.add(jLabel26, java.awt.BorderLayout.LINE_START);
        jPanel50.add(txtTenVT, java.awt.BorderLayout.CENTER);

        jPanel48.add(jPanel50);

        jpnFormVaiTro.add(jPanel48, java.awt.BorderLayout.PAGE_START);

        jpnbuttonVaiTro.setLayout(new java.awt.BorderLayout());

        jPanel32.setPreferredSize(new java.awt.Dimension(345, 50));
        jPanel32.setLayout(new java.awt.GridLayout(1, 4, 5, 5));
        jpnbuttonVaiTro.add(jPanel32, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jpnbuttonVaiTro.add(jPanel13, java.awt.BorderLayout.PAGE_END);

        jpnFormVaiTro.add(jpnbuttonVaiTro, java.awt.BorderLayout.CENTER);

        jpnVaiTro.add(jpnFormVaiTro, java.awt.BorderLayout.CENTER);

        jpncenter.add(jpnVaiTro, java.awt.BorderLayout.LINE_END);

        jPanel1.add(jpncenter, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1587, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 828, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMoiActionPerformed
        ResetText();
    }//GEN-LAST:event_btnThemMoiActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        try {
            ArrayList<NhanVien> nv = dao_nv.selectAll();
            for (int i = 0; i < nv.size(); i++) {
            NhanVien get = nv.get(i);
            if (get.getMaNV().equals(txtMaNV.getText())) {
                Messeger.alert(this, "Đã Có Mã NV Trong Hệ Thống , Vui Lòng Chọn Mã Khác");
                return;
            }
        }
        } catch (Exception ex) {
            Logger.getLogger(QuanLyTaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (Validate()) {
            return;
        }
        
        try {
            boolean gioitinh = true;
            int vaitro = 101;
            if (rdoNu.isSelected()) {
                gioitinh = false;
            }
            if (radionv.isSelected()) {
                vaitro = 102;
            }
            if (!Messeger.confirm(this, "Bạn Có Muốn Thêm Không")) {
                return;
            }
            dao_nv.insert(new NhanVien(txtMaNV.getText(), txtMatKhau.getText(), txtHoTen.getText(),
                    txtngaysinh.getText(),
                    gioitinh,
                    txtEmail.getText(),
                    txtSĐT.getText(),
                    txtDiaChi.getText(),
                    lbanh.getToolTipText(),
                    vaitro,
                    txtngaytao.getText(),
                    true));
            LoadDataToTable_TaiKhoan();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (Auth.user.getMaNV().equals(txtMaNV.getText())) {
            Messeger.showErrorDialog(this, "Tài Khoản Đang Đăng Nhập Không Thể Tự Chỉnh Sửa", "Lỗi");
            return;
        }
        if (Validate()) {
            return;
        }
        try {
            boolean gioitinh = true;
            int vaitro = 101;
            if (rdoNu.isSelected()) {
                gioitinh = false;
            }
            if (radionv.isSelected()) {
                vaitro = 102;
            }
            if (!Messeger.confirm(this, "Bạn Có Muốn Sửa Không")) {
                return;
            }
            dao_nv.update(new NhanVien(txtMaNV.getText(), txtMatKhau.getText(), txtHoTen.getText(),
                    txtngaysinh.getText(),
                    gioitinh,
                    txtEmail.getText(),
                    txtSĐT.getText(),
                    txtDiaChi.getText(),
                    lbanh.getToolTipText(),
                    vaitro,
                    txtngaytao.getText(),
                    true));
            LoadDataToTable_TaiKhoan();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
       if (Auth.user.getMaNV().equals(txtMaNV.getText())) {
            Messeger.showErrorDialog(this, "Tài Khoản Đang Đăng Nhập Không Thể Tự Chỉnh Sửa", "Lỗi");
            return;
        }
        try {
            if (!Messeger.confirm(this, "Bạn Có Muốn Xóa Không")) {
                return;
            }
            dao_nv.delete(txtMaNV.getText());
            LoadDataToTable_TaiKhoan();
        } catch (Exception ex) {
            Logger.getLogger(QuanLyTaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tblnhanvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblnhanvienMouseClicked
        int viTri = tblnhanvien.getSelectedRow();
        if (viTri == -1) {
            return;
        }
        txtMaNV.setText(tblnhanvien.getValueAt(viTri, 0).toString());
        txtHoTen.setText(tblnhanvien.getValueAt(viTri, 1).toString());
        txtMatKhau.setText(tblnhanvien.getValueAt(viTri, 2).toString());
        txtngaysinh.setText(tblnhanvien.getValueAt(viTri, 3).toString());
        txtSĐT.setText(tblnhanvien.getValueAt(viTri, 4).toString());
        if (tblnhanvien.getValueAt(viTri, 5).toString().equalsIgnoreCase("Nam")) {
            rdoNam.setSelected(true);
        } else {
            rdoNu.setSelected(true);
        }
        txtDiaChi.setText(tblnhanvien.getValueAt(viTri, 6).toString());
        txtEmail.setText(tblnhanvien.getValueAt(viTri, 7).toString());
        txtngaytao.setText(tblnhanvien.getValueAt(viTri, 8).toString());
        if (tblnhanvien.getValueAt(viTri, 9).toString().equals("Trưởng Phòng")) {
            radioql.setSelected(true);
        } else {
            radionv.setSelected(true);
        }
        lbanh.setToolTipText(tblnhanvien.getValueAt(viTri, 10).toString());
        lbanh.setIcon(ImageHelper.read(String.valueOf(tblnhanvien.getValueAt(viTri, 10))));
    }//GEN-LAST:event_tblnhanvienMouseClicked

    private void tblvtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblvtMouseClicked
        int vitri = tblvt.getSelectedRow();
        if (vitri == -1) {
            return;
        }
        txtMaVT.setText(tblvt.getValueAt(vitri, 0).toString());
        txtTenVT.setText(tblvt.getValueAt(vitri, 1).toString());
        if (tblvt.getValueAt(vitri, 1).toString().equals("Trưởng Phòng")) {
            radioql.setSelected(true);
        } else {
            radionv.setSelected(true);
        }
    }//GEN-LAST:event_tblvtMouseClicked

    private void lbanhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbanhMouseClicked
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            ImageHelper.save(file); // lưu hình ảnh vào thư mục logos
            ImageIcon icon = ImageHelper.read(file.getName());//đọc hình từ thư mục logos
            lbanh.setIcon(icon);
            lbanh.setToolTipText(file.getName());//giữ tên hình trong tooltop
        }
    }//GEN-LAST:event_lbanhMouseClicked

    private void ResetText() {
        lbanh.setText("");
        txtMaNV.setText("");
        txtHoTen.setText("");
        txtMatKhau.setText("");
        txtngaysinh.setDateToToday();
        txtSĐT.setText("");
        rdoNam.setSelected(true);
        txtDiaChi.setText("");
        txtEmail.setText("");
        txtngaytao.setDateToToday();
        txtMaVT.setText("");
        txtTenVT.setText("");
        radioql.setEnabled(true);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuanLyTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                QuanLyTaiKhoan dialog = new QuanLyTaiKhoan(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemMoi;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jpnButton;
    private javax.swing.JPanel jpnForm;
    private javax.swing.JPanel jpnFormVaiTro;
    private javax.swing.JPanel jpnSearch;
    private javax.swing.JPanel jpnTableVaiTro;
    private javax.swing.JPanel jpnTaiKhoan;
    private javax.swing.JPanel jpnVaiTro;
    private javax.swing.JPanel jpnbuttonVaiTro;
    private javax.swing.JPanel jpncenter;
    private javax.swing.JPanel jpntableTK;
    private javax.swing.JLabel lbanh;
    private javax.swing.JRadioButton radionv;
    private javax.swing.JRadioButton radioql;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblnhanvien;
    private javax.swing.JTable tblvt;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtMaVT;
    private javax.swing.JTextField txtMatKhau;
    private javax.swing.JTextField txtSĐT;
    private javax.swing.JTextField txtTenVT;
    private javax.swing.JTextField txtTimKiem;
    private com.github.lgooddatepicker.components.DatePicker txtngaysinh;
    private com.github.lgooddatepicker.components.DatePicker txtngaytao;
    // End of variables declaration//GEN-END:variables

    private void init() {
        setLocationRelativeTo(null);
        ResetText();
        dao_nv = new NhanVienDao();
        modelTable_nv = (DefaultTableModel) tblnhanvien.getModel();
        modelTable_vt = (DefaultTableModel) tblvt.getModel();
        dao_vt = new VaiTroDao();
        LoadDataToTable_VaiTro();
        LoadDataToTable_TaiKhoan();
        txtngaysinh.setSettings(CustomDatePicker.customsDatePicker(txtngaysinh, new javax.swing.ImageIcon(getClass().getResource("/poly/icons/calendar.png"))));
        txtngaytao.setSettings(CustomDatePicker.customsDatePicker(txtngaytao, new javax.swing.ImageIcon(getClass().getResource("/poly/icons/calendar.png"))));
        this.fileChooser = new JFileChooser();

    }

    private void LoadDataToTable_VaiTro() {
        modelTable_vt.setRowCount(0);
        try {
            ArrayList<VaiTro> vt = dao_vt.selectAll();
            for (int i = 0; i < vt.size(); i++) {
                VaiTro get = vt.get(i);
                Object[] rowData = new Object[]{
                    get.getMaVaiTro(),
                    get.getTenVaiTro()
                };
                modelTable_vt.addRow(rowData);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void LoadDataToTable_TaiKhoan() {
        modelTable_nv.setRowCount(0);
        try {
            ArrayList<NhanVien> list = dao_nv.selectAll();
            for (int i = 0; i < list.size(); i++) {
                NhanVien get = list.get(i);
                if (get.isTrangThai()) {
                String gt = "Nam";
                if (!get.isGioiTinh()) {
                    gt = "Nữ";
                }
                String vaitro = "Quản Lý";
                if (get.getVaiTro() == 102) {
                    vaitro = "Nhân Viên";
                }
                String ngaysinh = XDate.toString(XDate.toDate(get.getNgSinh(), "yyyy-MM-dd"), "dd/MM/yyyy");
                String ngaydk = XDate.toString(XDate.toDate(get.getNgayTao(), "yyyy-MM-dd"), "dd/MM/yyyy");
                Object[] rowData = new Object[]{
                    get.getMaNV(),
                    get.getHoTen(),
                    get.getPassWord(),
                    ngaysinh,
                    get.getSDT(),
                    gt,
                    get.getDiaChi(),
                    get.getEmail(),
                    ngaydk,
                    vaitro,
                    get.getHinhAnh()
                };
                modelTable_nv.addRow(rowData);
            }}
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private boolean Validate() {
        StringBuilder x = new StringBuilder();
        if (lbanh.getToolTipText() == null) {
            x.append("Vui Lòng Chọn Ảnh");
        }else if (XValidate.isEmpty(txtMaNV)) {
             x.append("Vui Lòng Nhập Mã NV");
        }else if (XValidate.isEmpty(txtHoTen)) {
             x.append("Vui Lòng Nhập Họ Tên");
        }else if (XValidate.isEmpty(txtMatKhau)) {
            x.append("Vui Lòng Nhập Mật Khẩu");
        }else if (XValidate.isEmpty(txtSĐT)) {
            x.append("Vui Lòng Nhập Số Điện Thoại");
        }else if (XValidate.isNotNumber(txtSĐT)) {
            x.append("Sai Định Dạng Số Điện Thoại");
        }else if (XValidate.isEmpty(txtDiaChi)) {
            x.append("Vui Lòng Nhập Địa Chỉ");
        }else if (XValidate.isEmpty(txtEmail)) {
            x.append("Vui Lòng Nhập Email");
        }else if(XValidate.isNotEmail(txtEmail)){
         x.append("Sai Định Dạng Email");
        }
        if (x.toString().length() > 0) {
            Messeger.alert(this, x.toString());
            return true;
        }
        return false;

    }
}

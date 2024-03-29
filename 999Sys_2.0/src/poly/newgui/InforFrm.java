/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.newgui;

import java.awt.CardLayout;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import poly.dao.NhanVienDao;
import poly.dao.VaiTroDao;
import poly.entity.NhanVien;
import poly.helper.Auth;
import poly.helper.CustomDatePicker;
import poly.helper.CustomTabbedPaneUI;
import poly.helper.ImageHelper;
import poly.helper.Messeger;
import poly.helper.XDate;
import poly.helper.XInternal;
import poly.helper.XValidate;

/**
 *
 * @author XUÂN THÀNH
 */
public class InforFrm extends javax.swing.JInternalFrame {

    private JFileChooser fileChooser;
    private NhanVienDao dao_nv;
    CardLayout card_DoiMK;
    NewMainFrm main;

    public InforFrm(NewMainFrm main) {
        initComponents();
        this.main = main;
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnlTabs = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        lbanh = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        jPanel21 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
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
        jpnButton = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        btnThemMoi = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        pnlCardDoiMK = new javax.swing.JPanel();
        pnlXacNhanMKCu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtXacNhanMK = new javax.swing.JPasswordField();
        btnXacNhan = new javax.swing.JButton();
        pnlDoiMK = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNhapMKMoi = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        txtNhapLaiMKM = new javax.swing.JPasswordField();
        jPanel19 = new javax.swing.JPanel();
        btnXacNhanDMK = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();

        pnlTabs.setBackground(new java.awt.Color(0, 102, 102));
        pnlTabs.setForeground(new java.awt.Color(255, 255, 255));
        pnlTabs.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        pnlTabs.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        pnlTabs.setOpaque(true);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(50, 1, 100, 1, new java.awt.Color(0, 102, 102)));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 10, 0, 10, new java.awt.Color(0, 102, 102)));
        jPanel5.setPreferredSize(new java.awt.Dimension(300, 300));
        jPanel5.setLayout(new java.awt.GridLayout(0, 1));

        lbanh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbanh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbanhMouseClicked(evt);
            }
        });
        jPanel5.add(lbanh);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 248, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel1);

        jPanel4.add(jPanel5, java.awt.BorderLayout.LINE_START);

        jPanel9.setBackground(new java.awt.Color(0, 100, 100));
        jPanel9.setBorder(javax.swing.BorderFactory.createMatteBorder(30, 30, 30, 30, new java.awt.Color(0, 102, 102)));
        jPanel9.setPreferredSize(new java.awt.Dimension(95, 650));
        jPanel9.setLayout(new java.awt.GridLayout(4, 2, 20, 40));

        jPanel22.setBackground(new java.awt.Color(255, 153, 102));
        jPanel22.setLayout(new java.awt.BorderLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setText("  Mã NV :");
        jLabel6.setPreferredSize(new java.awt.Dimension(135, 50));
        jPanel22.add(jLabel6, java.awt.BorderLayout.LINE_START);

        txtMaNV.setEditable(false);
        txtMaNV.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jPanel22.add(txtMaNV, java.awt.BorderLayout.CENTER);

        jPanel9.add(jPanel22);

        jPanel21.setBackground(new java.awt.Color(255, 153, 102));
        jPanel21.setLayout(new java.awt.BorderLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setText("  Họ Tên :");
        jLabel5.setPreferredSize(new java.awt.Dimension(135, 50));
        jPanel21.add(jLabel5, java.awt.BorderLayout.LINE_START);

        txtHoTen.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jPanel21.add(txtHoTen, java.awt.BorderLayout.CENTER);

        jPanel9.add(jPanel21);

        jPanel23.setBackground(new java.awt.Color(255, 153, 102));
        jPanel23.setLayout(new java.awt.BorderLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setText("  Ngày sinh :");
        jLabel7.setPreferredSize(new java.awt.Dimension(135, 50));
        jPanel23.add(jLabel7, java.awt.BorderLayout.LINE_START);

        txtngaysinh.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jPanel23.add(txtngaysinh, java.awt.BorderLayout.CENTER);

        jPanel9.add(jPanel23);

        jPanel24.setBackground(new java.awt.Color(255, 153, 102));
        jPanel24.setLayout(new java.awt.BorderLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel8.setText(" Số Điện Thoại :");
        jLabel8.setPreferredSize(new java.awt.Dimension(135, 50));
        jPanel24.add(jLabel8, java.awt.BorderLayout.LINE_START);

        txtSĐT.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jPanel24.add(txtSĐT, java.awt.BorderLayout.CENTER);

        jPanel9.add(jPanel24);

        jPanel26.setBackground(new java.awt.Color(255, 153, 102));
        jPanel26.setLayout(new java.awt.BorderLayout());

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel10.setText("  Giới Tính :");
        jLabel10.setPreferredSize(new java.awt.Dimension(135, 50));
        jPanel26.add(jLabel10, java.awt.BorderLayout.LINE_START);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 25, 0, 0, new java.awt.Color(255, 255, 255)));

        buttonGroup1.add(rdoNam);
        rdoNam.setSelected(true);
        rdoNam.setText("Nam");
        rdoNam.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        rdoNam.setPreferredSize(new java.awt.Dimension(85, 55));
        jPanel11.add(rdoNam);

        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nữ");
        rdoNu.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        rdoNu.setPreferredSize(new java.awt.Dimension(85, 55));
        jPanel11.add(rdoNu);

        jPanel26.add(jPanel11, java.awt.BorderLayout.CENTER);

        jPanel9.add(jPanel26);

        jPanel27.setBackground(new java.awt.Color(255, 153, 102));
        jPanel27.setLayout(new java.awt.BorderLayout());

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel11.setText("  Địa chỉ :");
        jLabel11.setPreferredSize(new java.awt.Dimension(135, 50));
        jPanel27.add(jLabel11, java.awt.BorderLayout.LINE_START);

        txtDiaChi.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jPanel27.add(txtDiaChi, java.awt.BorderLayout.CENTER);

        jPanel9.add(jPanel27);

        jPanel28.setBackground(new java.awt.Color(255, 153, 102));
        jPanel28.setLayout(new java.awt.BorderLayout());

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel12.setText("  Email :");
        jLabel12.setPreferredSize(new java.awt.Dimension(135, 50));
        jPanel28.add(jLabel12, java.awt.BorderLayout.LINE_START);

        txtEmail.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jPanel28.add(txtEmail, java.awt.BorderLayout.CENTER);

        jPanel9.add(jPanel28);

        jPanel29.setBackground(new java.awt.Color(255, 153, 102));
        jPanel29.setLayout(new java.awt.BorderLayout());

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel13.setText(" Ngày Tạo :");
        jLabel13.setPreferredSize(new java.awt.Dimension(135, 50));
        jPanel29.add(jLabel13, java.awt.BorderLayout.LINE_START);

        txtngaytao.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jPanel29.add(txtngaytao, java.awt.BorderLayout.CENTER);

        jPanel9.add(jPanel29);

        jPanel4.add(jPanel9, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel4, java.awt.BorderLayout.CENTER);

        jpnButton.setBackground(new java.awt.Color(0, 102, 102));
        jpnButton.setPreferredSize(new java.awt.Dimension(820, 200));

        jPanel12.setBackground(new java.awt.Color(0, 102, 102));
        jPanel12.setLayout(new java.awt.GridLayout(1, 4, 30, 10));

        btnThemMoi.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnThemMoi.setText("Mới");
        btnThemMoi.setPreferredSize(new java.awt.Dimension(120, 60));
        btnThemMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMoiActionPerformed(evt);
            }
        });
        jPanel12.add(btnThemMoi);

        btnSua.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnSua.setText("Cập nhập");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        jPanel12.add(btnSua);

        jpnButton.add(jPanel12);

        jPanel2.add(jpnButton, java.awt.BorderLayout.PAGE_END);

        pnlTabs.addTab("Thông tin cá nhân", jPanel2);

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));
        jPanel3.setLayout(new java.awt.BorderLayout());

        pnlCardDoiMK.setLayout(new java.awt.CardLayout());

        pnlXacNhanMKCu.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 200));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Nhập Mật Khẩu Cũ :");
        jLabel1.setPreferredSize(new java.awt.Dimension(300, 80));
        pnlXacNhanMKCu.add(jLabel1);

        txtXacNhanMK.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        txtXacNhanMK.setPreferredSize(new java.awt.Dimension(500, 80));
        pnlXacNhanMKCu.add(txtXacNhanMK);

        btnXacNhan.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnXacNhan.setText("Xác Nhận");
        btnXacNhan.setPreferredSize(new java.awt.Dimension(200, 80));
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });
        pnlXacNhanMKCu.add(btnXacNhan);

        pnlCardDoiMK.add(pnlXacNhanMKCu, "xacNhanMKCu");

        pnlDoiMK.setLayout(new java.awt.BorderLayout());

        jPanel16.setPreferredSize(new java.awt.Dimension(200, 0));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlDoiMK.add(jPanel16, java.awt.BorderLayout.WEST);

        jPanel17.setPreferredSize(new java.awt.Dimension(200, 0));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlDoiMK.add(jPanel17, java.awt.BorderLayout.EAST);

        jPanel18.setLayout(new java.awt.GridLayout(0, 1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nhập Mật Khẩu Mới");
        jPanel18.add(jLabel2);

        txtNhapMKMoi.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        txtNhapMKMoi.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel18.add(txtNhapMKMoi);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Nhập Lại Mật Khẩu Mới");
        jPanel18.add(jLabel3);

        txtNhapLaiMKM.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        txtNhapLaiMKM.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel18.add(txtNhapLaiMKM);

        jPanel19.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 20));

        btnXacNhanDMK.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnXacNhanDMK.setText("Xác Nhận");
        btnXacNhanDMK.setPreferredSize(new java.awt.Dimension(200, 70));
        btnXacNhanDMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanDMKActionPerformed(evt);
            }
        });
        jPanel19.add(btnXacNhanDMK);

        jPanel18.add(jPanel19);

        pnlDoiMK.add(jPanel18, java.awt.BorderLayout.CENTER);

        pnlCardDoiMK.add(pnlDoiMK, "doiMK");

        jPanel3.add(pnlCardDoiMK, java.awt.BorderLayout.CENTER);

        jPanel7.setBackground(new java.awt.Color(0, 102, 102));
        jPanel7.setPreferredSize(new java.awt.Dimension(1238, 200));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1684, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel7, java.awt.BorderLayout.PAGE_START);

        jPanel8.setBackground(new java.awt.Color(0, 102, 102));
        jPanel8.setPreferredSize(new java.awt.Dimension(200, 362));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 457, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel8, java.awt.BorderLayout.LINE_END);

        jPanel10.setBackground(new java.awt.Color(0, 102, 102));
        jPanel10.setPreferredSize(new java.awt.Dimension(1238, 200));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1684, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel10, java.awt.BorderLayout.PAGE_END);

        jPanel13.setBackground(new java.awt.Color(0, 102, 102));
        jPanel13.setPreferredSize(new java.awt.Dimension(200, 362));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 457, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel13, java.awt.BorderLayout.LINE_START);

        pnlTabs.addTab("Đổi mật khẩu", jPanel3);

        getContentPane().add(pnlTabs, java.awt.BorderLayout.CENTER);
        pnlTabs.getAccessibleContext().setAccessibleName("Thông tin cá nhân");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbanhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbanhMouseClicked
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            ImageHelper.save(file); // lưu hình ảnh vào thư mục logos
            ImageIcon icon = ImageHelper.read(file.getName());//đọc hình từ thư mục logos
            lbanh.setIcon(icon);
            lbanh.setToolTipText(file.getName());//giữ tên hình trong tooltop
        }
    }//GEN-LAST:event_lbanhMouseClicked

    private void btnThemMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMoiActionPerformed
        ResetText();
    }//GEN-LAST:event_btnThemMoiActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed

        if (Validate()) {
            return;
        }
        if (Messeger.confirm(this, "Bạn Có Muốn Sửa Không")) {
            try {
                Auth.user.setDiaChi(txtDiaChi.getText());
                Auth.user.setEmail(txtEmail.getText());
                Auth.user.setGioiTinh(rdoNam.isSelected());
                Auth.user.setHinhAnh(lbanh.getToolTipText());
                Auth.user.setHoTen(txtHoTen.getText());
                Auth.user.setNgSinh(XDate.toString(XDate.toDate(txtngaysinh.getText(), "dd/mm/yyyy"), "yyyy/mm/dd"));
                Auth.user.setSDT(txtSĐT.getText());

                dao_nv.update(Auth.user);
                Messeger.alert(this, "Cập nhật thông tin thành công");
                this.main.setLblTenNV();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed
        if (Auth.user.getPassWord().equals(txtXacNhanMK.getText())) {
            card_DoiMK.show(pnlCardDoiMK, "doiMK");
        } else {
            Messeger.showErrorDialog(this, "Sai mật khẩu!", "Lỗi");
            return;
        }
    }//GEN-LAST:event_btnXacNhanActionPerformed

    private void btnXacNhanDMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanDMKActionPerformed

        String pass1 = txtNhapMKMoi.getText();
        String pass2 = txtNhapLaiMKM.getText();
        StringBuilder loi = new StringBuilder();
        if (checkMK(loi, pass1, pass2)) {
            return;
        }
        if (Messeger.confirm(this, "Xác Nhận đổi mật khẩu?")) {
            Auth.user.setPassWord(pass2);
            try {
                this.dao_nv.update(Auth.user);
                Messeger.alert(this, "Thành công!\nMời Bạn đăng nhập lại!");
                this.dispose();
                new LoginFrm(null, true).setVisible(true);
                this.main.phanQuyen();
            } catch (Exception ex) {
                Logger.getLogger(InforFrm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnXacNhanDMKActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThemMoi;
    private javax.swing.JButton btnXacNhan;
    private javax.swing.JButton btnXacNhanDMK;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jpnButton;
    private javax.swing.JLabel lbanh;
    private javax.swing.JPanel pnlCardDoiMK;
    private javax.swing.JPanel pnlDoiMK;
    private javax.swing.JTabbedPane pnlTabs;
    private javax.swing.JPanel pnlXacNhanMKCu;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JPasswordField txtNhapLaiMKM;
    private javax.swing.JPasswordField txtNhapMKMoi;
    private javax.swing.JTextField txtSĐT;
    private javax.swing.JPasswordField txtXacNhanMK;
    private com.github.lgooddatepicker.components.DatePicker txtngaysinh;
    private com.github.lgooddatepicker.components.DatePicker txtngaytao;
    // End of variables declaration//GEN-END:variables

    private void init() {
        XInternal.uncorated(this);
        ResetText();
        dao_nv = new NhanVienDao();
        txtngaysinh.setSettings(CustomDatePicker.customsDatePicker(txtngaysinh,
                new javax.swing.ImageIcon(getClass().getResource("/poly/icons/calendar.png"))));
        txtngaytao.setSettings(CustomDatePicker.customsDatePicker(txtngaytao,
                new javax.swing.ImageIcon(getClass().getResource("/poly/icons/calendar.png"))));
        this.card_DoiMK = (CardLayout) pnlCardDoiMK.getLayout();
        this.fileChooser = new JFileChooser();
        this.txtMaNV.setText(Auth.user.getMaNV());
        this.txtHoTen.setText(Auth.user.getHoTen());
        this.txtDiaChi.setText(Auth.user.getDiaChi());
        this.txtEmail.setText(Auth.user.getEmail());
        this.txtSĐT.setText(Auth.user.getSDT());
        this.rdoNam.setSelected(Auth.user.isGioiTinh());
        this.rdoNu.setSelected(!Auth.user.isGioiTinh());
        String ngaysinh = XDate.toString(XDate.toDate(Auth.user.getNgSinh(), "yyyy-MM-dd"), "dd/MM/yyyy");
        String ngaydk = XDate.toString(XDate.toDate(Auth.user.getNgayTao(), "yyyy-MM-dd"), "dd/MM/yyyy");
        this.txtngaysinh.setText(ngaysinh);
        this.txtngaytao.setText(ngaydk);
        this.pnlTabs.setUI(new CustomTabbedPaneUI());
    }

    private void ResetText() {
        lbanh.setText("");
        txtHoTen.setText("");
        txtngaysinh.setDateToToday();
        txtSĐT.setText("");
        rdoNam.setSelected(true);
        txtDiaChi.setText("");
        txtEmail.setText("");
        lbanh.setToolTipText(null);
        lbanh.setIcon(ImageHelper.read(String.valueOf("")));

    }

    private boolean Validate() {
        StringBuilder x = new StringBuilder();
        if (lbanh.getToolTipText() == null) {
            x.append("Vui Lòng Chọn Ảnh");
        } else if (XValidate.isEmpty(txtHoTen)) {
            x.append("Vui Lòng Nhập Họ Tên");
        } else if (XValidate.isEmpty(txtSĐT)) {
            x.append("Vui Lòng Nhập Số Điện Thoại");
        } else if (XValidate.isNotPhoneNumber(txtSĐT)) {
            x.append("Sai Định Dạng Số Điện Thoại");
        } else if (XValidate.isEmpty(txtDiaChi)) {
            x.append("Vui Lòng Nhập Địa Chỉ");
        } else if (XValidate.isEmpty(txtEmail)) {
            x.append("Vui Lòng Nhập Email");
        } else if (XValidate.isNotEmail(txtEmail)) {
            x.append("Sai Định Dạng Email");
        }
        if (x.toString().length() > 0) {
            Messeger.alert(this, x.toString());
            return true;
        }
        return false;

    }

    public boolean checkMK(StringBuilder loi, String pass1, String pass2) {
        if (XValidate.isEmpty(txtNhapMKMoi)) {
            loi.append("Bạn phải nhập mật khẩu mới!\n");
        } else if (pass1.length() < 8) {
            loi.append("Mật khẩu phải đủ ít nhất 8 ký tự!\n");
        }
        if (XValidate.isEmpty(txtNhapLaiMKM)) {
            loi.append("Bạn phải nhập lại mật khẩu mới!\n");
        } else if (!pass1.equals(pass2)) {
            loi.append("Mật khẩu nhập lại không đúng!\n");
        }
        if (loi.length() > 0) {
            Messeger.showErrorDialog(this, loi + "", "Lỗi");
            return true;
        }
        return false;
    }

}

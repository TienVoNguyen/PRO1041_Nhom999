/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.gui;

import java.awt.CardLayout;
import javax.swing.JFrame;

/**
 *
 * @author NTV
 */
public class MainFrm extends javax.swing.JFrame {

    /**
     * Creates new form MainFrm
     */
    public MainFrm() {
        initComponents();

        setLocationRelativeTo(null);
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);//hiển thị toàn màn hình
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpmMenu = new javax.swing.JPopupMenu();
        mniQLSanPham = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        pnlMain = new javax.swing.JPanel();
        pnlHeader = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        lblTenNV = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        btnQuetMa = new javax.swing.JButton();
        btnThemKhachHang = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        btnTimKiem = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        btnHoaDon = new javax.swing.JButton();
        btnSanPham = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btnMinimise = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        pnlThanhToan = new javax.swing.JPanel();
        lblTenKH = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
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
        btnTamDung = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        pnlFooter = new javax.swing.JPanel();
        btnKhoaManHinh = new javax.swing.JButton();
        btnMenu = new javax.swing.JButton();
        pnlCenter = new javax.swing.JPanel();
        pnlCard_HoaDon_SanPham = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel12 = new javax.swing.JPanel();

        jpmMenu.setPreferredSize(new java.awt.Dimension(200, 200));

        mniQLSanPham.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        mniQLSanPham.setText("Quản Lý Sản Phẩm");
        mniQLSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniQLSanPhamActionPerformed(evt);
            }
        });
        jpmMenu.add(mniQLSanPham);
        jpmMenu.add(jSeparator1);

        jMenuItem2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jMenuItem2.setText("Quản Lý Chung");
        jpmMenu.add(jMenuItem2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        pnlMain.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(51, 51, 51)));
        pnlMain.setLayout(new java.awt.BorderLayout());

        pnlHeader.setBackground(new java.awt.Color(0, 0, 0));
        pnlHeader.setPreferredSize(new java.awt.Dimension(1068, 50));
        pnlHeader.setLayout(new java.awt.BorderLayout());

        jPanel6.setBackground(new java.awt.Color(0, 0, 0));
        jPanel6.setPreferredSize(new java.awt.Dimension(456, 50));
        jPanel6.setLayout(new java.awt.BorderLayout());

        lblTenNV.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTenNV.setForeground(new java.awt.Color(255, 255, 255));
        lblTenNV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenNV.setText("Mai Xuân Thành");
        lblTenNV.setPreferredSize(new java.awt.Dimension(360, 17));
        jPanel6.add(lblTenNV, java.awt.BorderLayout.LINE_END);

        jPanel8.setBackground(new java.awt.Color(255, 204, 102));
        jPanel8.setLayout(new java.awt.BorderLayout());

        jPanel9.setBackground(new java.awt.Color(0, 0, 0));
        jPanel9.setPreferredSize(new java.awt.Dimension(260, 51));
        jPanel9.setLayout(new java.awt.GridLayout(0, 2));

        btnQuetMa.setBackground(new java.awt.Color(255, 255, 255));
        btnQuetMa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poly/icons/qr.png"))); // NOI18N
        btnQuetMa.setText("Quét mã");
        btnQuetMa.setBorder(null);
        btnQuetMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuetMaActionPerformed(evt);
            }
        });
        jPanel9.add(btnQuetMa);

        btnThemKhachHang.setBackground(new java.awt.Color(255, 255, 255));
        btnThemKhachHang.setText("Thêm khách hàng");
        btnThemKhachHang.setBorder(null);
        btnThemKhachHang.setHideActionText(true);
        btnThemKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemKhachHangActionPerformed(evt);
            }
        });
        jPanel9.add(btnThemKhachHang);

        jPanel8.add(jPanel9, java.awt.BorderLayout.LINE_END);

        jPanel10.setBackground(new java.awt.Color(0, 0, 0));
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

        jPanel8.add(jPanel10, java.awt.BorderLayout.CENTER);

        jPanel6.add(jPanel8, java.awt.BorderLayout.CENTER);

        pnlHeader.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));
        jPanel7.setPreferredSize(new java.awt.Dimension(250, 0));
        jPanel7.setLayout(new java.awt.GridLayout(1, 0));

        btnHoaDon.setBackground(new java.awt.Color(102, 102, 102));
        btnHoaDon.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnHoaDon.setText("Hóa Đơn");
        btnHoaDon.setBorder(null);
        btnHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoaDonActionPerformed(evt);
            }
        });
        jPanel7.add(btnHoaDon);

        btnSanPham.setBackground(new java.awt.Color(102, 102, 102));
        btnSanPham.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnSanPham.setText("Sản Phẩm");
        btnSanPham.setBorder(null);
        btnSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSanPhamActionPerformed(evt);
            }
        });
        jPanel7.add(btnSanPham);

        pnlHeader.add(jPanel7, java.awt.BorderLayout.WEST);

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));
        jPanel5.setPreferredSize(new java.awt.Dimension(90, 0));
        jPanel5.setLayout(new java.awt.GridLayout(0, 2));

        btnMinimise.setBackground(new java.awt.Color(0, 0, 0));
        btnMinimise.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnMinimise.setForeground(new java.awt.Color(255, 0, 0));
        btnMinimise.setText("--");
        btnMinimise.setBorder(null);
        btnMinimise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinimiseActionPerformed(evt);
            }
        });
        jPanel5.add(btnMinimise);

        btnClose.setBackground(new java.awt.Color(0, 0, 0));
        btnClose.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnClose.setForeground(new java.awt.Color(255, 0, 0));
        btnClose.setText("X");
        btnClose.setBorder(null);
        btnClose.setHideActionText(true);
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        jPanel5.add(btnClose);

        pnlHeader.add(jPanel5, java.awt.BorderLayout.EAST);

        pnlMain.add(pnlHeader, java.awt.BorderLayout.PAGE_START);

        pnlThanhToan.setBackground(new java.awt.Color(255, 255, 255));
        pnlThanhToan.setForeground(new java.awt.Color(204, 255, 204));
        pnlThanhToan.setPreferredSize(new java.awt.Dimension(450, 479));
        pnlThanhToan.setLayout(new java.awt.BorderLayout());

        lblTenKH.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTenKH.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poly/icons/login32.png"))); // NOI18N
        lblTenKH.setText("Khách lẻ");
        lblTenKH.setPreferredSize(new java.awt.Dimension(34, 50));
        pnlThanhToan.add(lblTenKH, java.awt.BorderLayout.PAGE_START);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jTextField1.setBackground(new java.awt.Color(0, 0, 0));
        jTextField1.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(0, 255, 51));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("10000");
        jPanel1.add(jTextField1, java.awt.BorderLayout.PAGE_START);

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
        lblSoLuong.setText("10");
        jPanel4.add(lblSoLuong);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setText("Thành Tiền");
        jPanel4.add(jLabel3);

        lblThanhTien.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblThanhTien.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblThanhTien.setText("100000");
        jPanel4.add(lblThanhTien);

        jPanel2.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(450, 50));
        jPanel3.setLayout(new java.awt.GridLayout(0, 3));

        btnThanhToam.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnThanhToam.setText("Thanh Toán");
        jPanel3.add(btnThanhToam);

        btnTamDung.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnTamDung.setText("Tạm Dừng");
        jPanel3.add(btnTamDung);

        btnXoa.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnXoa.setText("Xóa");
        jPanel3.add(btnXoa);

        jPanel2.add(jPanel3, java.awt.BorderLayout.PAGE_END);

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_END);

        pnlThanhToan.add(jPanel1, java.awt.BorderLayout.CENTER);

        pnlMain.add(pnlThanhToan, java.awt.BorderLayout.LINE_END);

        pnlFooter.setBackground(new java.awt.Color(0, 0, 0));
        pnlFooter.setPreferredSize(new java.awt.Dimension(1068, 50));
        pnlFooter.setLayout(new java.awt.BorderLayout());

        btnKhoaManHinh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poly/icons/password32.png"))); // NOI18N
        pnlFooter.add(btnKhoaManHinh, java.awt.BorderLayout.LINE_START);

        btnMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poly/icons/checklist.png"))); // NOI18N
        btnMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMenuMouseClicked(evt);
            }
        });
        pnlFooter.add(btnMenu, java.awt.BorderLayout.LINE_END);

        pnlMain.add(pnlFooter, java.awt.BorderLayout.PAGE_END);

        pnlCenter.setBackground(new java.awt.Color(153, 153, 153));
        pnlCenter.setLayout(new java.awt.BorderLayout());

        pnlCard_HoaDon_SanPham.setBackground(new java.awt.Color(0, 0, 0));
        pnlCard_HoaDon_SanPham.setLayout(new java.awt.CardLayout());

        jPanel14.setBackground(new java.awt.Color(153, 153, 153));

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblSanPham);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE))
        );

        pnlCard_HoaDon_SanPham.add(jPanel14, "SanPham");

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tblHoaDon);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE))
        );

        pnlCard_HoaDon_SanPham.add(jPanel13, "HoaDon");

        pnlCenter.add(pnlCard_HoaDon_SanPham, java.awt.BorderLayout.CENTER);

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(50, 50));

        jPanel12.setBackground(new java.awt.Color(153, 153, 153));
        jPanel12.setPreferredSize(new java.awt.Dimension(50, 50));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 716, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel12);

        pnlCenter.add(jScrollPane1, java.awt.BorderLayout.PAGE_END);

        pnlMain.add(pnlCenter, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlMain, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMinimiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimiseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMinimiseActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnQuetMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuetMaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQuetMaActionPerformed

    private void btnThemKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemKhachHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemKhachHangActionPerformed

    private void btnHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoaDonActionPerformed
        CardLayout layout = (CardLayout) pnlCard_HoaDon_SanPham.getLayout();

        layout.show(pnlCard_HoaDon_SanPham, "HoaDon");
    }//GEN-LAST:event_btnHoaDonActionPerformed

    private void btnSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSanPhamActionPerformed
        CardLayout layout = (CardLayout) pnlCard_HoaDon_SanPham.getLayout();

        
        layout.show(pnlCard_HoaDon_SanPham, "SanPham"); 
    }//GEN-LAST:event_btnSanPhamActionPerformed

    private void btnMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuMouseClicked
        jpmMenu.show(btnMenu, -160, -160);
        
    }//GEN-LAST:event_btnMenuMouseClicked

    private void mniQLSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniQLSanPhamActionPerformed
        new QL_SanPham(this, true).setVisible(true);
    }//GEN-LAST:event_mniQLSanPhamActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnHoaDon;
    private javax.swing.JButton btnKhoaManHinh;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnMinimise;
    private javax.swing.JButton btnQuetMa;
    private javax.swing.JButton btnSanPham;
    private javax.swing.JButton btnTamDung;
    private javax.swing.JButton btnThanhToam;
    private javax.swing.JButton btnThemKhachHang;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
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
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPopupMenu jpmMenu;
    private javax.swing.JLabel lblGiamGia;
    private javax.swing.JLabel lblSoLuong;
    private javax.swing.JLabel lblTenKH;
    private javax.swing.JLabel lblTenNV;
    private javax.swing.JLabel lblThanhTien;
    private javax.swing.JMenuItem mniQLSanPham;
    private javax.swing.JPanel pnlCard_HoaDon_SanPham;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlFooter;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlThanhToan;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}

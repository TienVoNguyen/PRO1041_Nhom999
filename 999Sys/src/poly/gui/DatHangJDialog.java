/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.gui;

import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTabbedPane;
import poly.dao.GiaoHangDao;
import poly.dao.HoaDonDao;
import poly.dao.KhachHangDao;
import poly.entity.GiaoHang;
import poly.entity.HoaDon;
import poly.entity.KhachHang;
import poly.helper.Messeger;
import poly.helper.XDate;

/**
 *
 * @author XUÂN THÀNH
 */
public class DatHangJDialog extends javax.swing.JDialog {

    Locale localeVN = new Locale("vi", "VN");
    NumberFormat df = NumberFormat.getCurrencyInstance(localeVN);
    HoaDon hd;
    KhachHang kh;
    JTabbedPane pnlTabs;
    HoaDonDao daoHD;
    KhachHangDao daoKH;
    GiaoHangDao daoGH;
    java.awt.Frame parent;

    public DatHangJDialog(java.awt.Frame parent, boolean modal, JTabbedPane pnlTabs, HoaDon hd) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.parent = parent;
        this.daoHD = new HoaDonDao();
        this.daoKH = new KhachHangDao();
        this.daoGH = new GiaoHangDao();
        this.pnlTabs = pnlTabs;
        this.hd = hd;
        if (hd.getMaKH() != null) {
            try {
                kh = this.daoKH.selectById(hd.getMaKH());
                this.txtPoint.setText(kh.getTichDiem() + "");
                this.txtTenKhachHang.setText(kh.getHoTen());
                this.txtSDT.setText(kh.getSDT());
                this.txtDiaChi.setText(kh.getDiaChi());
            } catch (Exception ex) {
                Logger.getLogger(ThanhToanJDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.txtTienHang.setText(df.format(hd.getThanhTien()));
        this.txtTienHang.setToolTipText(hd.getThanhTien() + "");
        this.txtTongTien.setText(df.format(hd.getThanhTien()));
        this.txtTongTien.setToolTipText(hd.getThanhTien() + "");
        this.txtGiamGia.setToolTipText(0 + "");
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
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        jPanel9 = new javax.swing.JPanel();
        txtTenKhachHang = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        txtTienHang = new javax.swing.JTextField();
        txtTienShip = new javax.swing.JTextField();
        txtTongTien = new javax.swing.JTextField();
        txtGiamGia = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        btnSuDung = new javax.swing.JButton();
        txtPoint = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        btnAPDung = new javax.swing.JButton();
        txtVoucher = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnHuy = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btnGiaoHang = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 15, 15, 15, new java.awt.Color(0, 153, 153)));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("XÁC NHẬN ĐƠN HÀNG");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setPreferredSize(new java.awt.Dimension(536, 100));
        jPanel1.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel7.setBackground(new java.awt.Color(0, 153, 153));
        jPanel7.setPreferredSize(new java.awt.Dimension(200, 100));
        jPanel7.setLayout(new java.awt.GridLayout(0, 1, 10, 10));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Tên Khách Hàng:");
        jLabel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 30, new java.awt.Color(0, 153, 153)));
        jPanel7.add(jLabel3);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Số điện thoại:");
        jLabel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 30, new java.awt.Color(0, 153, 153)));
        jPanel7.add(jLabel2);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Địa chỉ:");
        jLabel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 30, new java.awt.Color(0, 153, 153)));
        jPanel7.add(jLabel4);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Tiền hàng:");
        jLabel5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 30, new java.awt.Color(0, 153, 153)));
        jPanel7.add(jLabel5);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Tiền ship:");
        jLabel6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 30, new java.awt.Color(0, 153, 153)));
        jPanel7.add(jLabel6);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Tổng tiền:");
        jLabel7.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 30, new java.awt.Color(0, 153, 153)));
        jPanel7.add(jLabel7);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Giảm giá:");
        jLabel9.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 30, new java.awt.Color(0, 153, 153)));
        jLabel9.setPreferredSize(new java.awt.Dimension(168, 12));
        jPanel7.add(jLabel9);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Point:");
        jLabel10.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 30, new java.awt.Color(0, 153, 153)));
        jLabel10.setPreferredSize(new java.awt.Dimension(168, 12));
        jPanel7.add(jLabel10);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Voucher:");
        jLabel11.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 30, new java.awt.Color(0, 153, 153)));
        jLabel11.setPreferredSize(new java.awt.Dimension(168, 12));
        jPanel7.add(jLabel11);

        jPanel2.add(jPanel7, java.awt.BorderLayout.LINE_START);

        jPanel8.setBackground(new java.awt.Color(0, 153, 153));
        jPanel8.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 0, 10, 0, new java.awt.Color(0, 153, 153)));
        jPanel8.setPreferredSize(new java.awt.Dimension(100, 120));
        jPanel8.setLayout(new java.awt.BorderLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Ghi chú:");
        jLabel8.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel8.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 30, new java.awt.Color(0, 153, 153)));
        jLabel8.setPreferredSize(new java.awt.Dimension(200, 16));
        jLabel8.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPanel8.add(jLabel8, java.awt.BorderLayout.LINE_START);

        txtGhiChu.setColumns(20);
        txtGhiChu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtGhiChu.setRows(5);
        jScrollPane1.setViewportView(txtGhiChu);

        jPanel8.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel8, java.awt.BorderLayout.PAGE_END);

        jPanel9.setBackground(new java.awt.Color(0, 153, 153));
        jPanel9.setLayout(new java.awt.GridLayout(0, 1, 0, 10));

        txtTenKhachHang.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel9.add(txtTenKhachHang);

        txtSDT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel9.add(txtSDT);

        txtDiaChi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel9.add(txtDiaChi);

        txtTienHang.setEditable(false);
        txtTienHang.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel9.add(txtTienHang);

        txtTienShip.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtTienShip.setText("0");
        txtTienShip.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTienShipKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienShipKeyReleased(evt);
            }
        });
        jPanel9.add(txtTienShip);

        txtTongTien.setEditable(false);
        txtTongTien.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel9.add(txtTongTien);

        txtGiamGia.setEditable(false);
        txtGiamGia.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtGiamGia.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtGiamGia.setText("0");
        txtGiamGia.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(240, 240, 240)));
        txtGiamGia.setEnabled(false);
        jPanel9.add(txtGiamGia);

        jPanel13.setBackground(new java.awt.Color(0, 153, 153));
        jPanel13.setLayout(new java.awt.BorderLayout());

        btnSuDung.setBackground(new java.awt.Color(255, 102, 51));
        btnSuDung.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnSuDung.setForeground(new java.awt.Color(255, 255, 255));
        btnSuDung.setText("Sử Dụng");
        btnSuDung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuDungActionPerformed(evt);
            }
        });
        jPanel13.add(btnSuDung, java.awt.BorderLayout.LINE_END);

        txtPoint.setEditable(false);
        txtPoint.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPanel13.add(txtPoint, java.awt.BorderLayout.CENTER);

        jPanel9.add(jPanel13);

        jPanel14.setBackground(new java.awt.Color(0, 153, 153));
        jPanel14.setLayout(new java.awt.BorderLayout());

        btnAPDung.setBackground(new java.awt.Color(255, 102, 51));
        btnAPDung.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnAPDung.setForeground(new java.awt.Color(255, 255, 255));
        btnAPDung.setText("Áp Dụng");
        btnAPDung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAPDungActionPerformed(evt);
            }
        });
        jPanel14.add(btnAPDung, java.awt.BorderLayout.LINE_END);

        txtVoucher.setEditable(false);
        txtVoucher.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPanel14.add(txtVoucher, java.awt.BorderLayout.CENTER);

        jPanel9.add(jPanel14);

        jPanel2.add(jPanel9, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 10, 10, 10, new java.awt.Color(0, 153, 153)));
        jPanel3.setPreferredSize(new java.awt.Dimension(400, 80));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));
        jPanel4.setLayout(new java.awt.BorderLayout());

        btnHuy.setBackground(new java.awt.Color(255, 51, 51));
        btnHuy.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnHuy.setForeground(new java.awt.Color(255, 255, 0));
        btnHuy.setText("Hủy");
        btnHuy.setPreferredSize(new java.awt.Dimension(79, 25));
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });
        jPanel4.add(btnHuy, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel4, java.awt.BorderLayout.LINE_END);

        jPanel5.setBackground(new java.awt.Color(0, 153, 153));
        jPanel5.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        btnGiaoHang.setBackground(new java.awt.Color(102, 255, 102));
        btnGiaoHang.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnGiaoHang.setText("Giao Hàng");
        btnGiaoHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGiaoHangActionPerformed(evt);
            }
        });
        jPanel5.add(btnGiaoHang);

        jPanel3.add(jPanel5, java.awt.BorderLayout.LINE_START);

        jPanel6.setBackground(new java.awt.Color(0, 153, 153));
        jPanel6.setLayout(new java.awt.GridLayout(1, 0));
        jPanel3.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnGiaoHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGiaoHangActionPerformed
        if (datHang()) {
            return;
        }
        Messeger.alert(this, "Thành công, Đơn hàng đang vào trại thái chờ giao hàng!");
        
    }//GEN-LAST:event_btnGiaoHangActionPerformed

    private void txtTienShipKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienShipKeyPressed
        char c = evt.getKeyChar();

        if (c >= '0' && c <= '9') {
            txtTienShip.setEditable(true);
        } else if (evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
            txtTienShip.setEditable(true);

        } else {
            txtTienShip.setEditable(false);
        }
    }//GEN-LAST:event_txtTienShipKeyPressed

    private void txtTienShipKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienShipKeyReleased
        double tongTien, tienShip, tienHang;
        if (txtTienShip.getText().isEmpty()) {
            tienShip = 0;
        } else {
            tienShip = Double.parseDouble(txtTienShip.getText());
        }
        tienHang = Double.parseDouble(txtTienHang.getToolTipText());
        tongTien = tienHang + tienShip;
        this.txtTongTien.setText(df.format(tongTien));
        this.txtTongTien.setToolTipText(tongTien + "");

    }//GEN-LAST:event_txtTienShipKeyReleased

    private void btnSuDungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuDungActionPerformed
        int diemTL = Integer.parseInt(txtPoint.getText());
        double tongTien = Double.parseDouble(txtTongTien.getToolTipText());
        if (btnSuDung.getText().equalsIgnoreCase("Sử Dụng")) {
            if (Messeger.confirm(this, "Xác nhận sử dụng điểm tích lũy?")) {

                this.txtTongTien.setText(df.format(tongTien - diemTL));
                this.txtTongTien.setToolTipText(String.valueOf(tongTien - diemTL));
                this.txtGiamGia.setText(df.format(diemTL));
                this.txtGiamGia.setToolTipText(String.valueOf(diemTL));
                txtPoint.setText(0 + "");
                this.btnSuDung.setText("Hoàn Tác");
            }
        } else {
            double tienShip;
            if (txtTienShip.getText().isEmpty()) {
                tienShip = 0;
            } else {
                tienShip = Double.parseDouble(txtTienShip.getText());
            }
            this.btnSuDung.setText("Sử Dụng");
            this.txtTongTien.setText(df.format(hd.getThanhTien() + tienShip));
            this.txtTongTien.setToolTipText(String.valueOf(hd.getThanhTien() + tienShip));
            this.txtGiamGia.setText(df.format(0));
            this.txtGiamGia.setToolTipText(String.valueOf(0));
            txtPoint.setText(kh.getTichDiem() + "");
        }
    }//GEN-LAST:event_btnSuDungActionPerformed

    private void btnAPDungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAPDungActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAPDungActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(DatHangJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(DatHangJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(DatHangJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(DatHangJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                DatHangJDialog dialog = new DatHangJDialog(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAPDung;
    private javax.swing.JButton btnGiaoHang;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnSuDung;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
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
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtGiamGia;
    private javax.swing.JTextField txtPoint;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenKhachHang;
    private javax.swing.JTextField txtTienHang;
    private javax.swing.JTextField txtTienShip;
    private javax.swing.JTextField txtTongTien;
    private javax.swing.JTextField txtVoucher;
    // End of variables declaration//GEN-END:variables

    public GiaoHang getFrom() {
        GiaoHang gh = new GiaoHang();
        gh.setMaHoaDon(this.hd.getMaHD());
        gh.setTenKhachHang(txtTenKhachHang.getText());
        gh.setSoDienThoai(txtSDT.getText());
        gh.setDiaChi(txtDiaChi.getText());
        gh.setTienShip(Double.parseDouble(txtTienShip.getText()));
        gh.setGhiChu(txtGhiChu.getText());
        gh.setNgayGiaoHang(new Date());
        gh.setMaTrangThai(6);
        return gh;
    }

    private boolean datHang() throws HeadlessException {
        if (Messeger.confirm(this, "Xác Nhận Yêu Cầu Đặt Hàng Cho Hóa đơn-MAHD: " + hd.getMaHD())) {
            try {
                hd.setGiamGia(Double.parseDouble(txtGiamGia.getToolTipText()));
                hd.setNgayMua(XDate.toString(new Date(), "MM/dd/yyyy hh:mm:ss"));
                hd.setThanhTien(Double.parseDouble(txtTongTien.getToolTipText()));
                hd.setMaTT(6);
                this.daoHD.update(hd);
                this.daoGH.insert(this.getFrom());
                MainFrm main = (MainFrm) this.parent;
                main.setLblSoLuongDonHang();
                if (hd.getMaKH() != null) {
                    try {
                        kh.setTichDiem(Integer.parseInt(txtPoint.getText()));
                        int diemTLSauThanhToan = (int) (Double.parseDouble(txtTongTien.getToolTipText()) * 0.01);
                        kh.setTichDiem(kh.getTichDiem() + diemTLSauThanhToan);
                        this.daoKH.update(kh);
                    } catch (Exception ex) {
                        Logger.getLogger(ThanhToanJDialog.class.getName()).log(Level.SEVERE, null, ex);
                        Messeger.showErrorDialog(this, "Lỗi truy vấn", "Lỗi");
                        return true;
                    }
                }
                this.dispose();
                this.pnlTabs.remove(pnlTabs.getSelectedComponent());
                if (pnlTabs.getTabCount() < 1) {
                    HoaDonJPanel hdpnl = new HoaDonJPanel(parent,pnlTabs);
                    pnlTabs.addTab("Khách lẻ", hdpnl);
                    pnlTabs.setSelectedComponent(hdpnl);
                }
            } catch (Exception ex) {
                Logger.getLogger(ThanhToanJDialog.class.getName()).log(Level.SEVERE, null, ex);
                Messeger.showErrorDialog(this, "Lỗi truy vấn", "lỗi");
                return true;
            }
        } else {
            return true;
        }
        return false;
    }
}

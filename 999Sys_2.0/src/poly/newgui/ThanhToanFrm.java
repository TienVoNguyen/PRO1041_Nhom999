/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.newgui;

import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import poly.dao.CTHoaDonDao;
import poly.dao.HoaDonDao;
import poly.dao.KhachHangDao;
import poly.entity.CTHoaDon;
import poly.entity.HoaDon;
import poly.entity.KhachHang;
import poly.helper.Messeger;
import poly.helper.XDate;
import poly.helper.XHoaDon;

/**
 *
 * @author XUÂN THÀNH
 */
public class ThanhToanFrm extends javax.swing.JDialog {

    /**
     * Creates new form ThanhToanFrm
     */
    Locale localeVN = new Locale("vi", "VN");
    NumberFormat df = NumberFormat.getCurrencyInstance(localeVN);
    HoaDon hd;
    KhachHang kh;
    JTabbedPane pnlTabs;
    HoaDonDao daoHD;
    KhachHangDao daoKH;
    NewMainFrm parent;
    ArrayList<CTHoaDon> listCTHD;
    CTHoaDonDao DAOCTHD;
    
    public ThanhToanFrm(JFrame parent, boolean modal, JTabbedPane pnlTabs, HoaDon hd, ArrayList<CTHoaDon> listCTHD) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(this);
        this.parent = (NewMainFrm) parent;
        this.daoHD = new HoaDonDao();
        this.daoKH = new KhachHangDao();
        this.pnlTabs = pnlTabs;
        this.hd = hd;
        this.listCTHD = listCTHD;
        this.DAOCTHD = new CTHoaDonDao();
        if (hd.getMaKH() != null) {
            try {
                kh = this.daoKH.selectById(hd.getMaKH());
                txtPoint.setText(kh.getTichDiem() + "");
            } catch (Exception ex) {
                Logger.getLogger(ThanhToanFrm.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            btnSuDung.setEnabled(false);
        }
        this.txtTongTien.setText(df.format(hd.getThanhTien()));
        this.txtTongTien.setToolTipText(String.valueOf(hd.getThanhTien()));
        this.txtGiamGia.setToolTipText(0+"");
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
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnHuy = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btnThanhToan = new javax.swing.JButton();
        btnThanhToanIn = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txtTongTien = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtGiamGia = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtApDungVou = new javax.swing.JButton();
        txtVouCher = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btnSuDung = new javax.swing.JButton();
        txtPoint = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtTienKhach = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        lblTienThua = new javax.swing.JLabel();
        txtTienThua = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 10, 10, 10, new java.awt.Color(255, 153, 51)));
        jPanel1.setPreferredSize(new java.awt.Dimension(620, 525));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(255, 153, 51));
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 50));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(255, 153, 51));
        jPanel4.setLayout(new java.awt.BorderLayout());

        btnHuy.setBackground(new java.awt.Color(255, 51, 51));
        btnHuy.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnHuy.setForeground(new java.awt.Color(255, 255, 0));
        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });
        jPanel4.add(btnHuy, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel4, java.awt.BorderLayout.LINE_END);

        jPanel5.setBackground(new java.awt.Color(255, 153, 51));
        jPanel5.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        btnThanhToan.setBackground(new java.awt.Color(102, 255, 102));
        btnThanhToan.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnThanhToan.setText("Thanh Toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });
        jPanel5.add(btnThanhToan);

        btnThanhToanIn.setBackground(new java.awt.Color(51, 204, 0));
        btnThanhToanIn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnThanhToanIn.setText("Thanh Toán + In");
        btnThanhToanIn.setToolTipText("Thanh toán và in ra file pdf");
        btnThanhToanIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanInActionPerformed(evt);
            }
        });
        jPanel5.add(btnThanhToanIn);

        jPanel2.add(jPanel5, java.awt.BorderLayout.LINE_START);

        jPanel6.setBackground(new java.awt.Color(255, 153, 51));
        jPanel6.setLayout(new java.awt.GridLayout(1, 0));
        jPanel2.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jPanel3.setBackground(new java.awt.Color(153, 255, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 0, 5, 0, new java.awt.Color(255, 153, 51)));
        jPanel3.setPreferredSize(new java.awt.Dimension(366, 535));
        jPanel3.setLayout(new java.awt.BorderLayout());

        txtTongTien.setEditable(false);
        txtTongTien.setBackground(new java.awt.Color(0, 0, 0));
        txtTongTien.setFont(new java.awt.Font("Arial", 1, 78)); // NOI18N
        txtTongTien.setForeground(new java.awt.Color(0, 255, 51));
        txtTongTien.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTongTien.setText("0");
        txtTongTien.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.add(txtTongTien, java.awt.BorderLayout.CENTER);

        jPanel7.setBackground(new java.awt.Color(0, 153, 153));
        jPanel7.setLayout(new java.awt.GridLayout(2, 1));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Thanh Toán Hóa Đơn");
        jPanel7.add(jLabel1);

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 153));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ORANGE SHOP");
        jPanel7.add(jLabel2);

        jPanel3.add(jPanel7, java.awt.BorderLayout.PAGE_START);

        jPanel8.setBackground(new java.awt.Color(0, 153, 153));
        jPanel8.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 153, 153)));
        jPanel8.setMinimumSize(new java.awt.Dimension(181, 194));
        jPanel8.setPreferredSize(new java.awt.Dimension(296, 244));
        jPanel8.setLayout(new java.awt.GridLayout(0, 1, 0, 10));

        jPanel10.setBackground(new java.awt.Color(0, 153, 153));
        jPanel10.setLayout(new java.awt.BorderLayout());

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Giảm giá:");
        jLabel6.setPreferredSize(new java.awt.Dimension(168, 12));
        jPanel10.add(jLabel6, java.awt.BorderLayout.LINE_START);

        txtGiamGia.setEditable(false);
        txtGiamGia.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtGiamGia.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtGiamGia.setText("0");
        txtGiamGia.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(240, 240, 240)));
        txtGiamGia.setEnabled(false);
        jPanel10.add(txtGiamGia, java.awt.BorderLayout.CENTER);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setText("₫");
        jLabel3.setOpaque(true);
        jPanel10.add(jLabel3, java.awt.BorderLayout.LINE_END);

        jPanel8.add(jPanel10);

        jPanel14.setBackground(new java.awt.Color(0, 153, 153));
        jPanel14.setLayout(new java.awt.BorderLayout());

        jLabel8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Voucher:");
        jLabel8.setPreferredSize(new java.awt.Dimension(168, 12));
        jPanel14.add(jLabel8, java.awt.BorderLayout.LINE_START);

        txtApDungVou.setBackground(new java.awt.Color(255, 102, 51));
        txtApDungVou.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtApDungVou.setForeground(new java.awt.Color(255, 255, 255));
        txtApDungVou.setText("Áp Dụng");
        txtApDungVou.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApDungVouActionPerformed(evt);
            }
        });
        jPanel14.add(txtApDungVou, java.awt.BorderLayout.LINE_END);

        txtVouCher.setEditable(false);
        txtVouCher.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPanel14.add(txtVouCher, java.awt.BorderLayout.CENTER);

        jPanel8.add(jPanel14);

        jPanel13.setBackground(new java.awt.Color(0, 153, 153));
        jPanel13.setLayout(new java.awt.BorderLayout());

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Point:");
        jLabel5.setPreferredSize(new java.awt.Dimension(168, 12));
        jPanel13.add(jLabel5, java.awt.BorderLayout.LINE_START);

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

        jPanel8.add(jPanel13);

        jPanel12.setBackground(new java.awt.Color(0, 153, 153));
        jPanel12.setLayout(new java.awt.BorderLayout());

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tiền Khách Trả:");
        jLabel4.setPreferredSize(new java.awt.Dimension(168, 12));
        jPanel12.add(jLabel4, java.awt.BorderLayout.LINE_START);

        txtTienKhach.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtTienKhach.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTienKhach.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        txtTienKhach.setPreferredSize(new java.awt.Dimension(10, 22));
        txtTienKhach.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTienKhachKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienKhachKeyReleased(evt);
            }
        });
        jPanel12.add(txtTienKhach, java.awt.BorderLayout.CENTER);

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setText("₫");
        jLabel7.setOpaque(true);
        jPanel12.add(jLabel7, java.awt.BorderLayout.LINE_END);

        jPanel8.add(jPanel12);

        jPanel9.setBackground(new java.awt.Color(0, 153, 153));
        jPanel9.setLayout(new java.awt.BorderLayout());

        lblTienThua.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblTienThua.setForeground(new java.awt.Color(255, 255, 255));
        lblTienThua.setText("Trả Lại Khách:");
        lblTienThua.setPreferredSize(new java.awt.Dimension(168, 12));
        jPanel9.add(lblTienThua, java.awt.BorderLayout.LINE_START);

        txtTienThua.setEditable(false);
        txtTienThua.setBackground(new java.awt.Color(255, 255, 255));
        txtTienThua.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtTienThua.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTienThua.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtTienThua.setEnabled(false);
        txtTienThua.setOpaque(false);
        jPanel9.add(txtTienThua, java.awt.BorderLayout.CENTER);

        jPanel8.add(jPanel9);

        jPanel3.add(jPanel8, java.awt.BorderLayout.PAGE_END);

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        if (thanhToan()) {
            return;
        }
        Messeger.alert(this, "Thành công");

    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnHuyActionPerformed

    private void txtTienKhachKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKhachKeyPressed
        char c = evt.getKeyChar();
        if (c >= '0' && c <= '9') {
            txtTienKhach.setEditable(true);
        } else {
            if (evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                txtTienKhach.setEditable(true);
            } else {
                txtTienKhach.setEditable(false);
            }
        }
    }//GEN-LAST:event_txtTienKhachKeyPressed

    private void txtTienKhachKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKhachKeyReleased
        double TienThua;
        if (txtTienKhach.getText().isEmpty()) {
            TienThua = 0;
        } else {
            TienThua = Double.parseDouble(txtTienKhach.getText()) - Double.parseDouble(txtTongTien.getToolTipText());
        }

        if (TienThua < 0) {
            lblTienThua.setText("Khách Còn Thiếu:");
            this.txtTienThua.setText(df.format(TienThua * -1));

        } else {
            lblTienThua.setText("Trả Lại Khách:");
            this.txtTienThua.setText(df.format(TienThua));
        }
    }//GEN-LAST:event_txtTienKhachKeyReleased

    private void btnThanhToanInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanInActionPerformed
        if (thanhToan()) {
            return;
        }
        XHoaDon.XuatHoaDon(hd.getMaHD());
    }//GEN-LAST:event_btnThanhToanInActionPerformed

    private void btnSuDungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuDungActionPerformed
        int diemTL = Integer.parseInt(txtPoint.getText());
        double tongTien = Double.parseDouble(txtTongTien.getToolTipText());
        if (btnSuDung.getText().equalsIgnoreCase("Sử Dụng")) {
            if (Messeger.confirm(this, "Xác nhận sử dụng điểm tích lũy?")) {

                this.txtTongTien.setText(df.format(tongTien - diemTL));
                this.txtTongTien.setToolTipText(String.valueOf(tongTien - diemTL));
                this.txtGiamGia.setText(df.format(diemTL));
                this.txtGiamGia.setToolTipText(String.valueOf(diemTL));
                txtPoint.setText(0+"");
                this.btnSuDung.setText("Hoàn Tác");
            }
        } else {
            this.btnSuDung.setText("Sử Dụng");
            this.txtTongTien.setText(df.format(hd.getThanhTien()));
            this.txtTongTien.setToolTipText(String.valueOf(hd.getThanhTien()));
            this.txtGiamGia.setText(df.format(0));
            this.txtGiamGia.setToolTipText(String.valueOf(0));
            txtPoint.setText(kh.getTichDiem() + "");
        }
    }//GEN-LAST:event_btnSuDungActionPerformed

    private void txtApDungVouActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApDungVouActionPerformed
        Messeger.alert(parent, "Đang update");
    }//GEN-LAST:event_txtApDungVouActionPerformed

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
            java.util.logging.Logger.getLogger(ThanhToanFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThanhToanFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThanhToanFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThanhToanFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ThanhToanFrm dialog = new ThanhToanFrm(new javax.swing.JFrame(), true, new JTabbedPane(), new HoaDon(), new ArrayList<>());
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
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnSuDung;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThanhToanIn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
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
    private javax.swing.JLabel lblTienThua;
    private javax.swing.JButton txtApDungVou;
    private javax.swing.JTextField txtGiamGia;
    private javax.swing.JTextField txtPoint;
    private javax.swing.JTextField txtTienKhach;
    private javax.swing.JTextField txtTienThua;
    private javax.swing.JTextField txtTongTien;
    private javax.swing.JTextField txtVouCher;
    // End of variables declaration//GEN-END:variables

    private boolean thanhToan() throws HeadlessException {
        if (Messeger.confirm(this, "Xác Nhận Thanh Toán Hóa đơn-MAHD: " + hd.getMaHD())) {
            try {
                hd.setGiamGia(Double.parseDouble(txtGiamGia.getToolTipText()));
                hd.setNgayMua(XDate.toString(new Date(), "MM/dd/yyyy hh:mm:ss"));
                hd.setThanhTien(Double.parseDouble(txtTongTien.getToolTipText()));
                this.daoHD.update(hd);
                for (CTHoaDon c : listCTHD) {
                    this.DAOCTHD.update(c);
                }
                if (hd.getMaKH() != null) {
                    try {
                        kh.setTichDiem(Integer.parseInt(txtPoint.getText()));
                        int diemTLSauThanhToan = (int) (Double.parseDouble(txtTongTien.getToolTipText()) * 0.01);
                        kh.setTichDiem(kh.getTichDiem() + diemTLSauThanhToan);
                        kh.setDiemEXP(kh.getDiemEXP() + diemTLSauThanhToan);
                        this.daoKH.update(kh);
                    } catch (Exception ex) {
                        Logger.getLogger(ThanhToanFrm.class.getName()).log(Level.SEVERE, null, ex);
                        Messeger.showErrorDialog(this, "Lỗi truy vấn", "Lỗi");
                        return true;
                    }
                }
                Messeger.alert(null, "Thành công");
                this.dispose();
                this.pnlTabs.remove(pnlTabs.getSelectedComponent());
                if (pnlTabs.getTabCount() < 1) {
                    HoaDonFrm hdpnl = new HoaDonFrm(parent, pnlTabs);
                    pnlTabs.addTab("Khách lẻ", hdpnl);
                    pnlTabs.setSelectedComponent(hdpnl);
                }
            } catch (Exception ex) {
                Logger.getLogger(ThanhToanFrm.class.getName()).log(Level.SEVERE, null, ex);
                Messeger.showErrorDialog(this, "Lỗi truy vấn", "lỗi");
                return true;
            }
        } else {
            return true;
        }
        return false;
    }

}

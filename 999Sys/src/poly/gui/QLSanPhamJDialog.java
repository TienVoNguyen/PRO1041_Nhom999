/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author XUÂN THÀNH
 */
public class QLSanPhamJDialog extends javax.swing.JDialog {

    JButton button = new JButton();
    DefaultTableModel model;

    /**
     * Creates new form QL_SanPham
     */
    public QLSanPhamJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        //full màn hình
        setSize(parent.getWidth(), parent.getHeight());
        setLocationRelativeTo(null);

        model = (DefaultTableModel) tblSanPham.getModel();
        //Add button vào bảng
        addButtonToTable();
        
        model.addRow(new Object[]{
            1,2,3,4,5,6,7,8,9,10,11
        });
        model.addRow(new Object[]{
            1,2,3,4,5,6,7,8,9,10,11
        });
    }

    private void addButtonToTable() {
        // Add button vào trong bảng
        this.button.setSize(50, 50);
        tblSanPham.getColumn("tool").setCellRenderer(new ButtonRenderer());
        tblSanPham.getColumn("tool").setCellEditor(new ButtonEditor(new JCheckBox()));
        //Add sự kiện cho button
        button.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        if (tblSanPham.getSelectedRow() == -1)return;
                        System.out.println(tblSanPham.getSelectedRow());
                        model.removeRow(tblSanPham.getSelectedRow());
                        if (tblSanPham.getSelectedRow() == -1)return;
                        tblSanPham.setRowSelectionInterval(0, 0);
                    }
                }
        );
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
        btnExit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        btnChonAnh = new javax.swing.JButton();
        btnXoaAnh = new javax.swing.JButton();
        lblAnh = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        btnLuu = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        cbbTimDanhMuc = new javax.swing.JComboBox<>();
        cbbTimMau = new javax.swing.JComboBox<>();
        cbbTimSize = new javax.swing.JComboBox<>();
        cbbTimChatLieu = new javax.swing.JComboBox<>();
        btnTimKiem = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtMaSanPham = new javax.swing.JTextField();
        jPanel35 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        cbbDanhMuc = new javax.swing.JComboBox<>();
        btnThemDanhMuc = new javax.swing.JButton();
        jPanel37 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtMaVach = new javax.swing.JTextField();
        jPanel33 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        cbbDonViTinh = new javax.swing.JComboBox<>();
        btnThemDVT = new javax.swing.JButton();
        jPanel34 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtTenSP = new javax.swing.JTextField();
        jPanel31 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        cbbSize = new javax.swing.JComboBox<>();
        btnThemSize = new javax.swing.JButton();
        jPanel32 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtGiaBan = new javax.swing.JSpinner();
        jPanel27 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cbbMau = new javax.swing.JComboBox<>();
        btnThemMau = new javax.swing.JButton();
        jPanel30 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtGiaNhap = new javax.swing.JSpinner();
        jPanel28 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        cbbChatLieu = new javax.swing.JComboBox<>();
        btnThemChatLieu = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JSpinner();
        jPanel29 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtNgayNhap = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(6, 6, 6, 6, new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 102)));
        jPanel2.setPreferredSize(new java.awt.Dimension(978, 40));
        jPanel2.setLayout(new java.awt.BorderLayout());

        btnExit.setBackground(new java.awt.Color(0, 0, 0));
        btnExit.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 0, 0));
        btnExit.setText("X");
        btnExit.setBorder(null);
        btnExit.setPreferredSize(new java.awt.Dimension(40, 40));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel2.add(btnExit, java.awt.BorderLayout.LINE_END);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("QUẢN LÝ SẢN PHẨM");
        jPanel2.add(jLabel1, java.awt.BorderLayout.CENTER);

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setPreferredSize(new java.awt.Dimension(10, 40));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel4, java.awt.BorderLayout.LINE_START);

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));
        jPanel5.setPreferredSize(new java.awt.Dimension(1011, 400));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel7.setPreferredSize(new java.awt.Dimension(300, 348));
        jPanel7.setLayout(new java.awt.BorderLayout());

        jPanel10.setBackground(new java.awt.Color(0, 0, 0));
        jPanel10.setPreferredSize(new java.awt.Dimension(300, 50));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel7.add(jPanel10, java.awt.BorderLayout.PAGE_END);

        jPanel11.setLayout(new java.awt.BorderLayout());

        jPanel12.setBackground(new java.awt.Color(0, 0, 0));
        jPanel12.setPreferredSize(new java.awt.Dimension(300, 50));
        jPanel12.setLayout(new java.awt.GridLayout(1, 0));

        btnChonAnh.setBackground(new java.awt.Color(0, 0, 0));
        btnChonAnh.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnChonAnh.setForeground(new java.awt.Color(255, 255, 255));
        btnChonAnh.setText("Chọn ảnh");
        btnChonAnh.setBorder(null);
        btnChonAnh.setOpaque(false);
        jPanel12.add(btnChonAnh);

        btnXoaAnh.setBackground(new java.awt.Color(0, 0, 0));
        btnXoaAnh.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnXoaAnh.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaAnh.setText("Xóa ảnh");
        btnXoaAnh.setBorder(null);
        btnXoaAnh.setOpaque(false);
        jPanel12.add(btnXoaAnh);

        jPanel11.add(jPanel12, java.awt.BorderLayout.PAGE_END);

        lblAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poly/icons/book.png"))); // NOI18N
        jPanel11.add(lblAnh, java.awt.BorderLayout.CENTER);

        jPanel7.add(jPanel11, java.awt.BorderLayout.CENTER);

        jPanel5.add(jPanel7, java.awt.BorderLayout.LINE_END);

        jPanel8.setPreferredSize(new java.awt.Dimension(1065, 40));
        jPanel8.setLayout(new java.awt.BorderLayout());

        jPanel15.setBackground(new java.awt.Color(0, 0, 0));
        jPanel15.setLayout(new java.awt.GridLayout(1, 0, 10, 10));

        btnLuu.setBackground(new java.awt.Color(102, 102, 255));
        btnLuu.setText("Lưu");
        jPanel15.add(btnLuu);

        btnMoi.setBackground(new java.awt.Color(102, 102, 255));
        btnMoi.setText("Mới");
        jPanel15.add(btnMoi);

        jPanel8.add(jPanel15, java.awt.BorderLayout.WEST);

        jPanel16.setBackground(new java.awt.Color(0, 0, 0));
        jPanel16.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        txtTimKiem.setPreferredSize(new java.awt.Dimension(158, 30));
        jPanel16.add(txtTimKiem);

        cbbTimDanhMuc.setPreferredSize(new java.awt.Dimension(154, 30));
        jPanel16.add(cbbTimDanhMuc);

        cbbTimMau.setPreferredSize(new java.awt.Dimension(74, 30));
        jPanel16.add(cbbTimMau);

        cbbTimSize.setPreferredSize(new java.awt.Dimension(74, 30));
        jPanel16.add(cbbTimSize);

        cbbTimChatLieu.setPreferredSize(new java.awt.Dimension(74, 30));
        jPanel16.add(cbbTimChatLieu);

        btnTimKiem.setText("Tìm");
        btnTimKiem.setPreferredSize(new java.awt.Dimension(73, 30));
        jPanel16.add(btnTimKiem);

        jPanel8.add(jPanel16, java.awt.BorderLayout.CENTER);

        jPanel5.add(jPanel8, java.awt.BorderLayout.PAGE_END);

        jPanel9.setBackground(new java.awt.Color(0, 0, 0));
        jPanel9.setLayout(new java.awt.BorderLayout());

        jPanel14.setBackground(new java.awt.Color(0, 0, 0));
        jPanel14.setLayout(new java.awt.GridLayout(6, 2, 10, 10));

        jPanel36.setBackground(new java.awt.Color(0, 0, 0));
        jPanel36.setLayout(new java.awt.BorderLayout());

        jLabel13.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Mã sản phẩm");
        jLabel13.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel13.setPreferredSize(new java.awt.Dimension(150, 12));
        jPanel36.add(jLabel13, java.awt.BorderLayout.LINE_START);

        txtMaSanPham.setEditable(false);
        txtMaSanPham.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPanel36.add(txtMaSanPham, java.awt.BorderLayout.CENTER);

        jPanel14.add(jPanel36);

        jPanel35.setBackground(new java.awt.Color(0, 0, 0));
        jPanel35.setLayout(new java.awt.BorderLayout());

        jLabel12.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Danh mục");
        jLabel12.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel12.setPreferredSize(new java.awt.Dimension(150, 12));
        jPanel35.add(jLabel12, java.awt.BorderLayout.LINE_START);

        jPanel35.add(cbbDanhMuc, java.awt.BorderLayout.CENTER);

        btnThemDanhMuc.setText("Thêm Danh mục mới");
        btnThemDanhMuc.setPreferredSize(new java.awt.Dimension(143, 21));
        jPanel35.add(btnThemDanhMuc, java.awt.BorderLayout.LINE_END);

        jPanel14.add(jPanel35);

        jPanel37.setBackground(new java.awt.Color(0, 0, 0));
        jPanel37.setLayout(new java.awt.BorderLayout());

        jLabel14.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Mã vạch");
        jLabel14.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel14.setPreferredSize(new java.awt.Dimension(150, 12));
        jPanel37.add(jLabel14, java.awt.BorderLayout.LINE_START);

        txtMaVach.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPanel37.add(txtMaVach, java.awt.BorderLayout.CENTER);

        jPanel14.add(jPanel37);

        jPanel33.setBackground(new java.awt.Color(0, 0, 0));
        jPanel33.setLayout(new java.awt.BorderLayout());

        jLabel10.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Đơn vị tính");
        jLabel10.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel10.setPreferredSize(new java.awt.Dimension(150, 12));
        jPanel33.add(jLabel10, java.awt.BorderLayout.LINE_START);

        jPanel33.add(cbbDonViTinh, java.awt.BorderLayout.CENTER);

        btnThemDVT.setText("Thêm ĐVT mới");
        btnThemDVT.setPreferredSize(new java.awt.Dimension(143, 21));
        jPanel33.add(btnThemDVT, java.awt.BorderLayout.LINE_END);

        jPanel14.add(jPanel33);

        jPanel34.setBackground(new java.awt.Color(0, 0, 0));
        jPanel34.setLayout(new java.awt.BorderLayout());

        jLabel11.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Tên sản phẩm");
        jLabel11.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel11.setPreferredSize(new java.awt.Dimension(150, 12));
        jPanel34.add(jLabel11, java.awt.BorderLayout.LINE_START);

        txtTenSP.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPanel34.add(txtTenSP, java.awt.BorderLayout.CENTER);

        jPanel14.add(jPanel34);

        jPanel31.setBackground(new java.awt.Color(0, 0, 0));
        jPanel31.setLayout(new java.awt.BorderLayout());

        jLabel8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Size");
        jLabel8.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel8.setPreferredSize(new java.awt.Dimension(150, 12));
        jPanel31.add(jLabel8, java.awt.BorderLayout.LINE_START);

        jPanel31.add(cbbSize, java.awt.BorderLayout.CENTER);

        btnThemSize.setText("Thêm size mới");
        btnThemSize.setPreferredSize(new java.awt.Dimension(143, 21));
        jPanel31.add(btnThemSize, java.awt.BorderLayout.LINE_END);

        jPanel14.add(jPanel31);

        jPanel32.setBackground(new java.awt.Color(0, 0, 0));
        jPanel32.setLayout(new java.awt.BorderLayout());

        jLabel9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Giá bán");
        jLabel9.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel9.setPreferredSize(new java.awt.Dimension(150, 12));
        jPanel32.add(jLabel9, java.awt.BorderLayout.LINE_START);

        txtGiaBan.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPanel32.add(txtGiaBan, java.awt.BorderLayout.CENTER);

        jPanel14.add(jPanel32);

        jPanel27.setBackground(new java.awt.Color(0, 0, 0));
        jPanel27.setLayout(new java.awt.BorderLayout());

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Màu");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel4.setPreferredSize(new java.awt.Dimension(150, 12));
        jPanel27.add(jLabel4, java.awt.BorderLayout.LINE_START);

        jPanel27.add(cbbMau, java.awt.BorderLayout.CENTER);

        btnThemMau.setText("Thêm màu mới");
        btnThemMau.setPreferredSize(new java.awt.Dimension(143, 21));
        jPanel27.add(btnThemMau, java.awt.BorderLayout.LINE_END);

        jPanel14.add(jPanel27);

        jPanel30.setBackground(new java.awt.Color(0, 0, 0));
        jPanel30.setLayout(new java.awt.BorderLayout());

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Giá nhập");
        jLabel7.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel7.setPreferredSize(new java.awt.Dimension(150, 12));
        jPanel30.add(jLabel7, java.awt.BorderLayout.LINE_START);

        txtGiaNhap.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPanel30.add(txtGiaNhap, java.awt.BorderLayout.CENTER);

        jPanel14.add(jPanel30);

        jPanel28.setBackground(new java.awt.Color(0, 0, 0));
        jPanel28.setLayout(new java.awt.BorderLayout());

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Chất liệu");
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel5.setPreferredSize(new java.awt.Dimension(150, 12));
        jPanel28.add(jLabel5, java.awt.BorderLayout.LINE_START);

        jPanel28.add(cbbChatLieu, java.awt.BorderLayout.CENTER);

        btnThemChatLieu.setText("Thêm chất liệu mới");
        btnThemChatLieu.setPreferredSize(new java.awt.Dimension(143, 21));
        jPanel28.add(btnThemChatLieu, java.awt.BorderLayout.LINE_END);

        jPanel14.add(jPanel28);

        jPanel21.setBackground(new java.awt.Color(0, 0, 0));
        jPanel21.setLayout(new java.awt.BorderLayout());

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Số lượng");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel3.setPreferredSize(new java.awt.Dimension(150, 12));
        jPanel21.add(jLabel3, java.awt.BorderLayout.LINE_START);

        txtSoLuong.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPanel21.add(txtSoLuong, java.awt.BorderLayout.CENTER);

        jPanel14.add(jPanel21);

        jPanel29.setBackground(new java.awt.Color(0, 0, 0));
        jPanel29.setLayout(new java.awt.BorderLayout());

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Ngày nhập");
        jLabel6.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel6.setPreferredSize(new java.awt.Dimension(150, 12));
        jPanel29.add(jLabel6, java.awt.BorderLayout.LINE_START);

        txtNgayNhap.setEditable(false);
        txtNgayNhap.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPanel29.add(txtNgayNhap, java.awt.BorderLayout.CENTER);

        jPanel14.add(jPanel29);

        jPanel9.add(jPanel14, java.awt.BorderLayout.CENTER);

        jPanel5.add(jPanel9, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel5, java.awt.BorderLayout.PAGE_START);

        tblSanPham.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ma SP", "Ma Vach", "Ten SP", "Gia Ban", "Gia Nhap", "So Luong", "Danh Muc", "DVT", "Size", "Mau", "Chat Lieu", "Ngay Nhap", "tool"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPham.setGridColor(new java.awt.Color(0, 0, 0));
        tblSanPham.setRowHeight(40);
        jScrollPane1.setViewportView(tblSanPham);
        if (tblSanPham.getColumnModel().getColumnCount() > 0) {
            tblSanPham.getColumnModel().getColumn(12).setMinWidth(60);
            tblSanPham.getColumnModel().getColumn(12).setPreferredWidth(60);
            tblSanPham.getColumnModel().getColumn(12).setMaxWidth(60);
        }

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1243, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

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
            java.util.logging.Logger.getLogger(QLSanPhamJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLSanPhamJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLSanPhamJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLSanPhamJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                QLSanPhamJDialog dialog = new QLSanPhamJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnChonAnh;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnThemChatLieu;
    private javax.swing.JButton btnThemDVT;
    private javax.swing.JButton btnThemDanhMuc;
    private javax.swing.JButton btnThemMau;
    private javax.swing.JButton btnThemSize;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoaAnh;
    private javax.swing.JComboBox<String> cbbChatLieu;
    private javax.swing.JComboBox<String> cbbDanhMuc;
    private javax.swing.JComboBox<String> cbbDonViTinh;
    private javax.swing.JComboBox<String> cbbMau;
    private javax.swing.JComboBox<String> cbbSize;
    private javax.swing.JComboBox<String> cbbTimChatLieu;
    private javax.swing.JComboBox<String> cbbTimDanhMuc;
    private javax.swing.JComboBox<String> cbbTimMau;
    private javax.swing.JComboBox<String> cbbTimSize;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAnh;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JSpinner txtGiaBan;
    private javax.swing.JSpinner txtGiaNhap;
    private javax.swing.JTextField txtMaSanPham;
    private javax.swing.JTextField txtMaVach;
    private javax.swing.JTextField txtNgayNhap;
    private javax.swing.JSpinner txtSoLuong;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables

    class ButtonRenderer extends JButton implements TableCellRenderer {

        public ButtonRenderer() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "Xóa" : value.toString());
            return this;
        }
    }

    class ButtonEditor extends DefaultCellEditor {

        private String label;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
        }

        public Component getTableCellEditorComponent(JTable table, Object value,
                boolean isSelected, int row, int column) {
            label = (value == null) ? "Xóa" : value.toString();
            button.setText(label);
            return button;
        }

        public Object getCellEditorValue() {
            return new String(label);
        }
    }
}

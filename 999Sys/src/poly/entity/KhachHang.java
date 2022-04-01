/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.entity;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class KhachHang {
    private String maKH;
    private int maLoaiKH;
    private String hoTen;
    private Date ngaySinh,ngayTao;
    private boolean gioiTinh;
    private String email,SDT,diaChi;
    private boolean trangThai;
    private int tichDiem;
    public KhachHang() {
    }

    public KhachHang(String maKH, int maLoaiKH, String hoTen, Date ngaySinh, Date ngayTao, boolean gioiTinh, String email, String SDT, String diaChi, boolean trangThai, int tichDiem) {
        this.maKH = maKH;
        this.maLoaiKH = maLoaiKH;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.ngayTao = ngayTao;
        this.gioiTinh = gioiTinh;
        this.email = email;
        this.SDT = SDT;
        this.diaChi = diaChi;
        this.trangThai = trangThai;
        this.tichDiem = tichDiem;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public int getMaLoaiKH() {
        return maLoaiKH;
    }

    public void setMaLoaiKH(int maLoaiKH) {
        this.maLoaiKH = maLoaiKH;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public int getTichDiem() {
        return tichDiem;
    }

    public void setTichDiem(int tichDiem) {
        this.tichDiem = tichDiem;
    }
    

}

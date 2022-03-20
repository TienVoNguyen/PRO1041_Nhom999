/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.entity;

/**
 *
 * @author Admin
 */
public class loaiKhachHang {
 private String maLoaiKH,tenLoaiKH;
 private boolean trangThai;

    public loaiKhachHang() {
    }

    public loaiKhachHang(String maLoaiKH, String tenLoaiKH, boolean trangThai) {
        this.maLoaiKH = maLoaiKH;
        this.tenLoaiKH = tenLoaiKH;
        this.trangThai = trangThai;
    }

    public String getMaLoaiKH() {
        return maLoaiKH;
    }

    public void setMaLoaiKH(String maLoaiKH) {
        this.maLoaiKH = maLoaiKH;
    }

    public String getTenLoaiKH() {
        return tenLoaiKH;
    }

    public void setTenLoaiKH(String tenLoaiKH) {
        this.tenLoaiKH = tenLoaiKH;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
 
}

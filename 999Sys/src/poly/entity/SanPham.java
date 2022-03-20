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
public class SanPham {
    private int maSP;
    private String maDanhMuc,maVach,anhSanPham;
    private double giaNhap,giaBan;
    private double soLuong;
    private String ngayNhap;
    private boolean apDungKM;
    private int maDVT,maMau,maSize,maChatLieu;
    private boolean trangThai;

    public SanPham() {
    }

    public SanPham(int maSP, String maDanhMuc, String maVach, String anhSanPham, double giaNhap, double giaBan, double soLuong, String ngayNhap, boolean apDungKM, int maDVT, int maMau, int maSize, int maChatLieu, boolean trangThai) {
        this.maSP = maSP;
        this.maDanhMuc = maDanhMuc;
        this.maVach = maVach;
        this.anhSanPham = anhSanPham;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.ngayNhap = ngayNhap;
        this.apDungKM = apDungKM;
        this.maDVT = maDVT;
        this.maMau = maMau;
        this.maSize = maSize;
        this.maChatLieu = maChatLieu;
        this.trangThai = trangThai;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public String getMaDanhMuc() {
        return maDanhMuc;
    }

    public void setMaDanhMuc(String maDanhMuc) {
        this.maDanhMuc = maDanhMuc;
    }

    public String getMaVach() {
        return maVach;
    }

    public void setMaVach(String maVach) {
        this.maVach = maVach;
    }

    public String getAnhSanPham() {
        return anhSanPham;
    }

    public void setAnhSanPham(String anhSanPham) {
        this.anhSanPham = anhSanPham;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public double getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(double soLuong) {
        this.soLuong = soLuong;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public boolean isApDungKM() {
        return apDungKM;
    }

    public void setApDungKM(boolean apDungKM) {
        this.apDungKM = apDungKM;
    }

    public int getMaDVT() {
        return maDVT;
    }

    public void setMaDVT(int maDVT) {
        this.maDVT = maDVT;
    }

    public int getMaMau() {
        return maMau;
    }

    public void setMaMau(int maMau) {
        this.maMau = maMau;
    }

    public int getMaSize() {
        return maSize;
    }

    public void setMaSize(int maSize) {
        this.maSize = maSize;
    }

    public int getMaChatLieu() {
        return maChatLieu;
    }

    public void setMaChatLieu(int maChatLieu) {
        this.maChatLieu = maChatLieu;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    
}

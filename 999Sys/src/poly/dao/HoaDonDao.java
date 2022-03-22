/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import poly.entity.HoaDon;

/**
 *
 * @author Admin
 */
public class HoaDonDao extends BaseDao<HoaDon, String>{

    @Override
    public String getQuery(String action) {
        switch(action){
            case "INSERT":
                return "INSERT INTO HOADON (MANV, MAKH, NGAYMUA, GIAMGIA, NGAYGIAOHANG, TIENSHIP, THANHTIEN) VALUES (?,?,?,?,?,?,?)";
            case "UPDATE":
                return "UPDATE HOADON SET MANV =?, MAKH =?, NGAYMUA =?, GIAMGIA =?, NGAYGIAOHANG =?, TIENSHIP =?, THANHTIEN =?, TRANGTHAI =? WHERE MAHOADON = ?";
            case "DELETE":
                return "DELETE FROM HOADON WHERE MAHOADON =?";
            case "SELECTBYID":
                return "SELECT * FROM HOADON WHERE MAHOADON = ?";
            case "SELECTALL":
                return "SELECT * FROM HOADON";
        }
        return "";
    }

    @Override
    public Object[] getParams(String action, HoaDon obj) {
        switch(action){
            case "INSERT":
                return new Object[]{
                    obj.getMaHD(),
                    obj.getMaNV(),
                    obj.getMaKH(),
                    obj.getNgayMua(),
                    obj.getGiamGia(),
                    obj.getNgayGiaoHang(),
                    obj.getTienShip(),
                    obj.getThanhTien()
                };
            case "UPDATE":
                return new Object[]{
                    obj.getMaNV(),
                    obj.getMaKH(),
                    obj.getNgayMua(),
                    obj.getGiamGia(),
                    obj.getNgayGiaoHang(),
                    obj.getTienShip(),
                    obj.getThanhTien(),
                    obj.isTrangThai(),
                    obj.getMaHD()
                };
        }
        return null;
    }

    @Override
    public HoaDon createEntity(ResultSet rs) throws SQLException {
        HoaDon hD = new HoaDon();
        hD.setMaHD(rs.getInt("MAHOADON"));
        hD.setMaNV(rs.getString("MANV"));
        hD.setMaKH(rs.getString("MAKH"));
        hD.setNgayMua(rs.getString("NGAYMUA"));
        hD.setGiamGia(rs.getDouble("GIAMGIA"));
        hD.setNgayGiaoHang(rs.getString("NGAYGIAOHANG"));
        hD.setTienShip(rs.getDouble("TIENSHIP"));
        hD.setThanhTien(rs.getDouble("THANHTIEN"));
        hD.setTrangThai(rs.getBoolean("TRANGTHAI"));
        return hD;
    }
    
}

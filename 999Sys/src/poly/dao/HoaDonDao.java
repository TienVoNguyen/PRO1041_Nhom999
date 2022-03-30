/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import poly.entity.HoaDon;
import poly.helper.XJDBC;

/**
 *
 * @author Admin
 */
public class HoaDonDao extends BaseDao<HoaDon, String>{

    @Override
    public String getQuery(String action) {
        switch(action){
            case "INSERT":
                return "SET IDENTITY_INSERT [dbo].[HOADON] ON  INSERT INTO HOADON (MAHOADON, MANV, MAKH, MATT, NGAYMUA, GIAMGIA, NGAYGIAOHANG, TIENSHIP, THANHTIEN) VALUES (?,?,?,?,?,?,?,?,?)  SET IDENTITY_INSERT [dbo].[HOADON] OFF";
            case "UPDATE":
                return "UPDATE HOADON SET MANV =?, MAKH =?, MATT =?, NGAYMUA =?, GIAMGIA =?, NGAYGIAOHANG =?, TIENSHIP =?, THANHTIEN =?, TRANGTHAI =? WHERE MAHOADON = ?";
            case "DELETE":
                return "DELETE FROM HOADON WHERE MAHOADON =?";
            case "SELECTBYID":
                return "SELECT * FROM HOADON WHERE MAHOADON = ?";
            case "SELECTALL":
                return "SELECT * FROM HOADON";
            case "SELECTMAXMAHD":
                return "SELECT MAX(MAHOADON) AS 'MAXMAHD' FROM HOADON";
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
                    obj.getMaTT(),
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
                    obj.getMaTT(),
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
        hD.setMaTT(rs.getInt("MATT"));
        return hD;
    }
    
    public int getMaxMaHD(){
        return (int) XJDBC.value(this.getQuery("SELECTMAXMAHD"));
    }
    
}

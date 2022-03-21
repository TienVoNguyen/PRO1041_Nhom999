/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import poly.entity.CTHoaDon;

/**
 *
 * @author Admin
 */
public class CTHoaDonDao extends BaseDao<CTHoaDon, String>{

    @Override
    public String getQuery(String action) {
        switch(action){
            case "INSERT":
                return "INSERT INTO CT_HOADON(MAHD,MASP, SOLUONG, GHICHU) VALUES (?,?,?)";
            case "UPDATE":
                return "UPDATE CT_HOADON SET SOLUONG =?, GHICHU =?, TRANGTHAI =? WHERE MAHD = ? and MASP =?";
            case "DELETE":
                return "DELETE FROM CT_HOADON WHERE MAHD = ? and MASP =?";
            case "SELECTBYID":
                return "SELECT SOLUONG, GHICHU, TRANGTHAI FROM CT_HOADON WHERE MAHD = ? and MASP = ?";
            case "SELECTALL":
                return "SELECT CT_HOADON.* FROM   CT_HOADON";
        }
        return "";
    }

    @Override
    public Object[] getParams(String action, CTHoaDon obj) {
        switch(action){
            case "INSERT":
                return new Object[]{
                    obj.getMaHD(),
                    obj.getMaSP(),
                    obj.getSoLuong(),
                    obj.getGhiChu()
                };
            case "UPDATE":
                return new Object[]{
                    obj.getSoLuong(),
                    obj.getGhiChu(),
                    obj.isTrangThai(),
                    obj.getMaHD(),
                    obj.getMaSP()
                };
        }
        return null;
    }

    @Override
    public CTHoaDon createEntity(ResultSet rs) throws SQLException {
        CTHoaDon cTHD = new CTHoaDon();
        cTHD.setMaHD(rs.getInt("MAHD"));
        cTHD.setMaSP(rs.getInt("MASP"));
        cTHD.setSoLuong(rs.getInt("SOLUONG"));
        cTHD.setGhiChu(rs.getString("GHICHU"));
        cTHD.setTrangThai(rs.getBoolean("TRANGTHAI"));
        return cTHD;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import poly.entity.GiaoCa;

/**
 *
 * @author NTV
 */
public class GiaoCaDAO extends BaseDao<GiaoCa, Object> {

    @Override
    public String getQuery(String action) {
        switch (action) {
            case "INSERT":
                return "INSERT INTO GIAOCA (MANVGIAOCA) VALUES (?)";
            case "UPDATE":
                return "UPDATE GIAOCA SET "
                        + "MANVNHANCA = ?, GIOGIAOCA = ?, "
                        + "TIENPHATSINH = ?, DOANHTHUCA = ?, "
                        + "GHICHU = ? WHERE MAGIAOCA = ?";
            case "DELETE":
                return "UPDATE GIAOCA SET MATT = ? WHERE MAGIAOCA = ?";
            case "SELECTBYID":
                return "SELECT * FROM GIAOCA where MANVGIAOCA = ? AND MATT = 2";
            case "SELECTALL":
                return "SELECT * FROM GIAOCA";
        }
        return "";
    }

    @Override
    public Object[] getParams(String action, GiaoCa obj) {
        switch (action) {
            case "INSERT":
                return new Object[]{
                    obj.getMaNVGiaoCa()
                };
            case "UPDATE":
                return new Object[]{
                    obj.getMaNVNhan(),
                    obj.getGioGiaoCa(),
                    obj.getTienPhatSinh(),
                    obj.getDoanhThuCa(),
                    obj.getGhiChu(),
                    obj.getMaGiaoCa()
                };
        }
        return null;
    }

    @Override
    public GiaoCa createEntity(ResultSet rs) throws SQLException {
        GiaoCa gc = new GiaoCa();
        gc.setMaGiaoCa(rs.getInt("MAGIAOCA"));
        gc.setMaTT(rs.getInt("MATT"));
        gc.setMaNVGiaoCa(rs.getString("MANVGIAOCA"));
        gc.setGhiChu(rs.getString("GHICHU"));
        gc.setMaNVNhan(rs.getString("MANVNHANCA"));
        gc.setGioGiaoCa(rs.getString("GIOGIAOCA"));
        gc.setGioNhanCa(rs.getString("GIONHANCA"));
        gc.setTienCoSo(rs.getDouble("TIENCOSO"));
        gc.setTienPhatSinh(rs.getDouble("TIENPHATSINH"));
        gc.setDoanhThuCa(rs.getDouble("DOANHTHUCA"));
        gc.setTienDaThuHoi(rs.getDouble("TIENDATHUHOI"));
        return gc;
    }

}

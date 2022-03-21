/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import poly.entity.Size;


/**
 *
 * @author maihuong
 */
public class SizeDao extends BaseDao<Size, String> {

    @Override
    public String getQuery(String action) {
        switch (action) {
            case "INSERT":
                return "INSERT INTO SIZE (TENSIZE) VALUES (?)";
            case "UPDATE":
                return "UPDATE SIZE SET TENSIZE =?, TRANGTHAI =?, WHERE MASIZE = ?";
            case "DELETE":
                return "DELETE FROM SIZE WHERE SIZE = ?";
            case "SELECTBYID":
                return "SELECT * FROM   SIZE WHERE SIZE = ?";
            case "SELECTALL":
                return "SELECT * FROM   MAUSAC";

        }
        return "";
    }

    @Override
    public Object[] getParams(String action, Size obj) {
        switch (action) {
            case "INSERT":
                return new Object[]{
                    obj.getTenSize(),};
            case "UPDATE":
                return new Object[]{
                    obj.getTenSize(),
                    obj.isTrangThai(),
                    obj.getMaSize()
                };
        }
        return null;
    }

    @Override
    public Size createEntity(ResultSet rs) throws SQLException {
        Size s = new Size();
        s.setMaSize(rs.getString("MASIZE"));
        s.setTenSize(rs.getString("LOAISIZE"));
        s.setTrangThai(rs.getBoolean("TRANGTHAI"));
        return s;
    }

}

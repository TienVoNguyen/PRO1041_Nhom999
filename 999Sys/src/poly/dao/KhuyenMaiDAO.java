/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import poly.entity.KhuyenMai;

/**
 *
 * @author 98tae
 */
public class KhuyenMaiDAO extends BaseDao<KhuyenMai, String> {

    @Override
    public String getQuery(String action) {
        switch (action) {
            case "INSERT":
                return "INSERT INTO KHUYENMAI ( MASP, TENKM, HINHTHUCAD, GIAMTOIDA, NGAYBATDAU, NGAYKETTHUC, GIATRI) VALUES (?,?,?,?,?,?,?)";
            case "UPDATE":
                return "UPDATE KHUYENMAI SET MASP = ?, TENKM = ?, HINHTHUCAD = ?, GIAMTOIDA = ?, NGAYBATDAU = ?, NGAYKETTHUC = ?, GIATRI = ?, TRANGTHAI = ? WHERE MAKM = ?";
            case "DELETE":
                return "UPDATE KHUYENMAI SET TRANGTHAI = 0 WHERE MAKM = ?";
            case "SELECTBYID":
                return "SELECT MAKM, MASP, TENKM, HINHTHUCAD, GIAMTOIDA, NGAYBATDAU, NGAYKETTHUC, GIATRI TRANGTHAI FROM   KHUYENMAI WHERE (MAKM = ?)";
            case "SELECTALL":
                return "SELECT * FROM KHUYENMAI";
        }
        return "";
    }

    @Override
    public Object[] getParams(String action, KhuyenMai obj) {
            switch (action) {
            case "INSERT":
                return new Object[]{
                    obj.getMaSP(),
                    obj.getTenKM(),
                    obj.isHinhThucAD(),
                    obj.getGiamToiDa(),
                    obj.getNgayBD(),
                    obj.getNgayKT(),
                    obj.getGiaTri()
                };
            case "UPDATE":
                return new Object[]{
                    obj.getMaSP(),
                    obj.getTenKM(),
                    obj.isHinhThucAD(),
                    obj.getGiamToiDa(),
                    obj.getNgayBD(),
                    obj.getNgayKT(),
                    obj.getGiaTri(),
                    obj.isTrangThai(),
                    obj.getMaKM()
                };
        }
        return null;
    }

    @Override
    public KhuyenMai createEntity(ResultSet rs) throws SQLException {
        KhuyenMai km = new KhuyenMai();
        km.setMaKM(rs.getInt("MAKM"));
        km.setMaSP(rs.getInt("MASP"));
        km.setTenKM(rs.getString("TENKM"));
        km.setHinhThucAD(rs.getBoolean("HINHTHUCAD"));
        km.setGiaTri(rs.getDouble("GIATRI"));
        km.setGiamToiDa(rs.getDouble("GIAMTOIDA"));
        km.setNgayBD(rs.getString("NGAYBATDAU"));
        km.setNgayKT(rs.getString("NGAYKETTHUC"));
        km.setTrangThai(rs.getBoolean("TRANGTHAI"));
        return km;
    }

    
}

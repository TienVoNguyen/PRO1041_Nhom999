/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import poly.entity.SanPham;
import poly.helper.XJDBC;

/**
 *
 * @author 98tae
 */
public class SanPhamDao extends BaseDao<SanPham, Integer> {

    @Override
    public String getQuery(String action) {
        switch (action) {
            case "INSERT":
                return "INSERT INTO SANPHAM (MADM, MAVACH, ANHSANPHAM, GIANHAP, GIABAN, SOLUONG, NGAYNHAP, APDUNGKM, MADVT, MAMAU, MASIZE, MACHATLIEU) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            case "UPDATE":
                return "UPDATE SANPHAM SET MADM =?, MAVACH =?, ANHSANPHAM =?, GIANHAP =?, GIABAN =?, SOLUONG =?, NGAYNHAP =?, APDUNGKM =?, MADVT =?, MAMAU =?, MASIZE =?, MACHATLIEU =?, TRANGTHAI =? WHERE MASP = ?";
            case "DELETE":
                return "DELETE FROM SANPHAM WHERE MASP = ?";
            case "SELECTBYID":
                return "SELECT * FROM   SANPHAM WHERE (MASP = ?)";
            case "SELECTALL":
                return "SELECT * FROM SANPHAM";
            case "SELECTWHERE":
                return "SELECT * FROM   SANPHAM WHERE MADM =  ? and MASP like ? or TENSP like ?";
            case "UPDATEMASP":
                return "UPDATE SANPHAM SET SOLUONG =? WHERE MASP = ?";
        }
        return "";
    }

    @Override
    public Object[] getParams(String action, SanPham obj) {
        switch (action) {
            case "INSERT":
                return new Object[]{
                    obj.getMaDanhMuc(),
                    obj.getMaVach(),
                    obj.getAnhSanPham(),
                    obj.getGiaNhap(),
                    obj.getGiaBan(),
                    obj.getSoLuong(),
                    obj.getNgayNhap(),
                    obj.isApDungKM(),
                    obj.getMaDVT(),
                    obj.getMaMau(),
                    obj.getMaSize(),
                    obj.getMaChatLieu()
                };
            case "UPDATE":
                return new Object[]{
                    obj.getMaDanhMuc(),
                    obj.getMaVach(),
                    obj.getAnhSanPham(),
                    obj.getGiaNhap(),
                    obj.getGiaBan(),
                    obj.getSoLuong(),
                    obj.getNgayNhap(),
                    obj.isApDungKM(),
                    obj.getMaDVT(),
                    obj.getMaMau(),
                    obj.getMaSize(),
                    obj.getMaChatLieu(),
                    obj.isTrangThai(),
                    obj.getMaSP()
                };
            case "SELECTWHERE":
                return new Object[]{
                    obj.getMaDanhMuc(),
                    "%" + obj.getMaSP() + "%",
                    "%" + obj.getTenSanPham() + "%"
                };
            case "UPDATEMASP":
                return new Object[]{
                    obj.getSoLuong(),
                    obj.getMaSP()
                };
        }
        return null;
    }

    @Override
    public SanPham createEntity(ResultSet rs) throws SQLException {
        SanPham sp = new SanPham();
        sp.setMaSP(rs.getInt("MASP"));
        sp.setMaDanhMuc(rs.getInt("MADM"));
        sp.setMaVach(rs.getString("MAVACH"));
        sp.setTenSanPham(rs.getString("TENSP"));
        sp.setAnhSanPham(rs.getString("ANHSANPHAM"));
        sp.setGiaNhap(rs.getDouble("GIANHAP"));
        sp.setGiaBan(rs.getDouble("GIABAN"));
        sp.setSoLuong(rs.getInt("SOLUONG"));
        sp.setNgayNhap(rs.getDate("NGAYNHAP"));
        sp.setApDungKM(rs.getBoolean("APDUNGKM"));
        sp.setMaDVT(rs.getInt("MADVT"));
        sp.setMaMau(rs.getInt("MAMAU"));
        sp.setMaSize(rs.getString("MASIZE"));
        sp.setMaChatLieu(rs.getInt("MACHATLIEU"));
        sp.setTrangThai(rs.getBoolean("TRANGTHAI"));
        return sp;
    }

    public ArrayList<SanPham> selectWhere(SanPham sp) throws Exception {
        return selectByquery("SELECTWHERE", this.getParams("SELECTWHERE", sp));
    }

    public static ArrayList<String> ListSp_NoKhuyenMai(boolean boo) {
        String sql = "SELECT MASP FROM  SANPHAM\n"
                + "WHERE APDUNGKM = ?";
        ArrayList<String> list = new ArrayList<>();
        try {
            ResultSet rs = XJDBC.query(sql, boo);
            while (rs.next()) {
                list.add(rs.getString(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }}

    
    public boolean updateSP(SanPham e) throws Exception {
        return XJDBC.update(this.getQuery("UPDATEMASP"), this.getParams("UPDATEMASP", e)) > 0;
    }

}

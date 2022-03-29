/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import poly.entity.KhachHang;

/**
 *
 * @author Admin
 */
public class KhachHangDao extends BaseDao<KhachHang, String>{

    @Override
    public String getQuery(String action) {
         switch (action) {
            case "INSERT":
                return "INSERT INTO KHACHHANG (MAKH, MALOAIKH, HOTEN, NGAYSINH, GIOITINH, EMAIL, SDT, DIACHI, NGAYTAO) VALUES (?,?,?,?,?,?,?,?,?)";
            case "UPDATE":
                return "UPDATE KHACHHANG SET MALOAIKH =?, HOTEN =?, NGAYSINH =?, GIOITINH =?, EMAIL =?, SDT =?, DIACHI =?, NGAYTAO =?, TRANGTHAI =? WHERE MAKH=?";
            case "DELETE":
                return "DELETE FROM KHACHHANG WHERE MAKH = ?";
            case "SELECTBYID":
                return "SELECT * FROM KHACHHANG WHERE MAKH = ?";
            case "SELECTALL":
                return "SELECT * FROM KHACHHANG";
            case "SELECTWHERE":
                return "SELECT * FROM   KHACHHANG WHERE MALOAIKH = ? or HOTEN like ?";//
         }
        return "";
    }

    @Override
    public Object[] getParams(String action, KhachHang obj) {
         switch (action) {
            case "INSERT":
                return new Object[]{
                    obj.getMaKH(),
                    obj.getMaLoaiKH(),
                    obj.getHoTen(),
                    obj.getNgaySinh(),
                    obj.isGioiTinh(),
                    obj.getEmail(),
                    obj.getSDT(),
                    obj.getDiaChi(),
                    obj.getNgayTao()
                };
            case "UPDATE":
                return new Object[]{
                    obj.getMaLoaiKH(),
                    obj.getHoTen(),
                    obj.getNgaySinh(),
                    obj.isGioiTinh(),
                    obj.getEmail(),
                    obj.getSDT(),
                    obj.getDiaChi(),
                    obj.getNgayTao(),
                    obj.getMaKH()
                };
            case "SELECTWHERE":
                return new Object[]{
                    obj.getMaLoaiKH(),
//                    "%"+obj.getMaKH()+"%",
                    "%"+obj.getHoTen()+"%"
                };
        }
        return null;
    }

    @Override
    public KhachHang createEntity(ResultSet rs) throws SQLException {
        KhachHang kH = new KhachHang();
        kH.setMaKH(rs.getString("MAKH"));
        kH.setMaLoaiKH(rs.getInt("MALOAIKH"));
        kH.setHoTen(rs.getString("HOTEN"));
        kH.setNgaySinh(rs.getDate("NGAYSINH"));
        kH.setGioiTinh(rs.getBoolean("GIOITINH"));
        kH.setEmail(rs.getString("EMAIL"));
        kH.setSDT(rs.getString("SDT"));
        kH.setDiaChi(rs.getString("DIACHI"));
        kH.setNgayTao(rs.getDate("NGAYTAO"));
        kH.setTrangThai(rs.getBoolean("TRANGTHAI"));
        return kH;
    }
    
    public ArrayList<KhachHang> selectWhere(KhachHang kh) throws Exception{
        return selectByquery("SELECTWHERE", this.getParams("SELECTWHERE", kh));
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import poly.entity.GiaoHang;
import poly.helper.XDate;
import poly.helper.XJDBC;

/**
 *
 * @author XUÂN THÀNH
 */
public class GiaoHangDao extends BaseDao<GiaoHang, Integer>{

    @Override
    public String getQuery(String action) {
        switch(action){
            case "INSERT":
                return "INSERT INTO GIAOHANG (MAHOADON, TENKHACHHANG, SDT, DIACHI, NGAYGIAOHANG, TIENSHIPHANG, GHICHU, MATT) VALUES (?,?,?,?,?,?,?,?)";
            case "UPDATE":
                return "UPDATE GIAOHANG SET TENKHACHHANG = ?, SDT = ?, DIACHI = ?, NGAYGIAOHANG = ?, TIENSHIPHANG = ?, GHICHU = ?, MATT = ? WHERE  (MAGIAOHANG = ?)";
            case "DELETE":
                return "DELETE FROM GIAOHANG WHERE  (MAGIAOHANG = ?)";
            case "SELECTBYID":
                return "SELECT * FROM GIAOHANG WHERE  (MAGIAOHANG = ?)";
            case "SELECTALL":
                return "SELECT * FROM GIAOHANG";
            case "SELECT_COUNT_DANG_GIAO_HANG":
                return "SELECT COUNT(MAGIAOHANG) FROM GIAOHANG WHERE MATT = 6 or MATT = 5";
            case "SELECTBY_MATT":
                return "SELECT * FROM GIAOHANG WHERE  (MATT = ?)";
        }
        return "";
    }

    @Override
    public Object[] getParams(String action, GiaoHang obj) {
        switch(action){
            case "INSERT":
                return new Object[]{
                    obj.getMaHoaDon(),
                    obj.getTenKhachHang(),
                    obj.getSoDienThoai(),
                    obj.getDiaChi(),
                    obj.getNgayGiaoHang(),
                    obj.getTienShip(),
                    obj.getGhiChu(),
                    obj.getMaTrangThai()
                };
            case "UPDATE":
                return new Object[]{
                    obj.getTenKhachHang(),
                    obj.getSoDienThoai(),
                    obj.getDiaChi(),
                    obj.getNgayGiaoHang(),
                    obj.getTienShip(),
                    obj.getGhiChu(),
                    obj.getMaTrangThai(),
                    obj.getMaGiaoHang()
                };
        }
        return null;
    }

    @Override
    public GiaoHang createEntity(ResultSet rs) throws SQLException {
        GiaoHang gh = new GiaoHang();
        gh.setMaGiaoHang(rs.getInt("MAGIAOHANG"));
        gh.setMaHoaDon(rs.getInt("MAHOADON"));
        gh.setTenKhachHang(rs.getString("TENKHACHHANG"));
        gh.setSoDienThoai(rs.getString("SDT"));
        gh.setDiaChi(rs.getString("DIACHI"));
        gh.setNgayGiaoHang(rs.getTimestamp("NGAYGIAOHANG"));
        gh.setTienShip(rs.getDouble("TIENSHIPHANG"));
        gh.setGhiChu(rs.getString("GHICHU"));
        gh.setMaTrangThai(rs.getInt("MATT"));
        
        return gh;
    }
    
    public int getHDDangGiao(){
        return (int) XJDBC.value(this.getQuery("SELECT_COUNT_DANG_GIAO_HANG"));
    }
    
    public ArrayList<GiaoHang> selectListGiaoHangByTrangThai(int maTT) throws Exception{
        return this.selectByquery("SELECTBY_MATT", maTT);
    }
}

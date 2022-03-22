/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import poly.helper.XJDBC;

/**
 *
 * @author NTV
 */
public class DoanhThuDao {

    public List<Integer> selectYears() throws SQLException {
        String sql = "SELECT DISTINCT YEAR(NGAYMUA) as [YEAR] FROM HOADON ORDER BY [YEAR] DESC";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = XJDBC.query(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();

            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<Integer> selectYDays() throws SQLException {
        String sql = "SELECT DISTINCT DAY(NGAYMUA) as [DAY] FROM HOADON ORDER BY [DAY]";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = XJDBC.query(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();

            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<Integer> selectMonths() throws SQLException {
        String sql = "SELECT DISTINCT MONTH(NGAYMUA) as [MONTH] FROM HOADON ORDER BY [MONTH]";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = XJDBC.query(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();

            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public JFreeChart createChart(int month, int year) {
        String chartTitle = "Biểu đồ doanh thu tháng " + month + " năm " + year;
        String sql = "{Call SP_BTDT(?, ?)}";
        try {
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            ResultSet rs = XJDBC.query(sql, month, year);
            while (rs.next()) {
                dataset.addValue(rs.getDouble("THANHTIEN"), "DOANHTHU", rs.getString("NGAY"));
            }
            JFreeChart lineChart = ChartFactory.createLineChart(
                    chartTitle.toUpperCase(),
                    "NGÀY", "DOANH THU (VND)", dataset,
                    PlotOrientation.VERTICAL, false, false, false);
            rs.getStatement().getConnection().close();
            return lineChart;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<Object[]> getThongKeNgay(String day) {
        
        try {
            List<Object[]> lst = new ArrayList<>();
            String sql = "{Call SP_DTBYNGAYNOW(?)}";
            ResultSet rs = XJDBC.query(sql, day);
            
            while (rs.next()) {
                lst.add(new Object[]{
                    rs.getInt("SOHD"),
                    rs.getInt("HDTHAPNHAT"),
                    rs.getInt("HDCAONHAT"),
                    rs.getInt("TBHOADON"),
                    rs.getInt("SOTIENGIAM"),
                    rs.getInt("THANHTIEN"),
                });
                
            }
            rs.getStatement().getConnection().close();
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

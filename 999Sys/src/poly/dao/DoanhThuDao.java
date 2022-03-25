/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.dao;

import java.awt.BasicStroke;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import poly.helper.XDate;
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
        String sql = "{Call SP_CHARTMONTH(?, ?)}";
        try {
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            ResultSet rs = XJDBC.query(sql, month, year);
            while (rs.next()) {
                dataset.addValue(rs.getDouble("THANHTIEN"), "DOANHTHU", rs.getString("NGAY"));
            }
            JFreeChart lineChart = ChartFactory.createLineChart(
                    chartTitle.toUpperCase(),
                    "NGÀY", "DOANH THU (VND)", dataset,
                    PlotOrientation.VERTICAL, true, true, false);
            rs.getStatement().getConnection().close();
            CategoryPlot plot = lineChart.getCategoryPlot();
            plot.setRenderer(new BarRenderer());
            plot.setBackgroundPaint(Color.white);
            plot.setOutlineStroke(new BasicStroke(2.0f));
            plot.setRangeGridlinesVisible(true);
            plot.setRangeGridlinePaint(Color.BLACK);

            plot.setDomainGridlinesVisible(true);
            plot.setDomainGridlinePaint(Color.BLACK);

            lineChart.getLegend().setFrame(BlockBorder.NONE);
            return lineChart;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Object[]> getThongKeNgay(int month, int year) {

        try {
            List<Object[]> lst = new ArrayList<>();
            String sql = "{Call SP_DTBYNGAYINMONTH(?, ?)}";
            ResultSet rs = XJDBC.query(sql, month, year);

            while (rs.next()) {
                String da = XDate.toString(rs.getDate("NGAYMUA"), "dd/MM/yyyy");
                lst.add(new Object[]{
                    da,
                    rs.getInt("SOHD"),
                    rs.getInt("SOLUONG"),
                    rs.getInt("GIABAN"),
                    rs.getInt("GIAMGIA"),
                    rs.getInt("DOANHTHU")});

            }
            rs.getStatement().getConnection().close();
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Object> getThongKeToDay() throws Exception {

        List<Object> lst = new ArrayList<>();
        String sql = "SELECT * FROM FNDTTD(?)";
        ResultSet rs = XJDBC.query(sql, "2022-03-21");

        while (rs.next()) {
            lst.add(rs.getString("TONGTIEN"));
            lst.add(rs.getInt("THANHCONG"));
            lst.add(rs.getInt("BIHUY"));
        }
        rs.getStatement().getConnection().close();
        return lst;

    }

    public JFreeChart createChartMonths(int year) {
        String chartTitle = "Biểu đồ doanh thu " + " năm " + year;
        String sql = "{Call SP_CHARTYEAR(?)}";
        try {
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            ResultSet rs = XJDBC.query(sql, year);
            while (rs.next()) {
                dataset.addValue(rs.getDouble("THANHTIEN"), "DOANHTHU", rs.getString("THANG"));
            }
            JFreeChart lineChart = ChartFactory.createLineChart(
                    chartTitle.toUpperCase(),
                    "THÁNG", "DOANH THU (VND)", dataset,
                    PlotOrientation.VERTICAL, true, true, false);
            rs.getStatement().getConnection().close();
            CategoryPlot plot = lineChart.getCategoryPlot();
            plot.setRenderer(new BarRenderer());
            plot.setBackgroundPaint(Color.white);
            plot.setOutlineStroke(new BasicStroke(2.0f));
            plot.setRangeGridlinesVisible(true);
            plot.setRangeGridlinePaint(Color.BLACK);

            plot.setDomainGridlinesVisible(true);
            plot.setDomainGridlinePaint(Color.BLACK);

            lineChart.getLegend().setFrame(BlockBorder.NONE);
            return lineChart;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Object[]> getThongKeMonths(int year) {

        try {
            List<Object[]> lst = new ArrayList<>();
            String sql = "{Call SP_DTTHANG(?)}";
            ResultSet rs = XJDBC.query(sql, year);

            while (rs.next()) {
                lst.add(new Object[]{
                    rs.getString("THANG"),
                    rs.getInt("SOHD"),
                    rs.getInt("SOLUONG"),
                    rs.getInt("GIABAN"),
                    rs.getInt("GIAMGIA"),
                    rs.getInt("DOANHTHU")});

            }
            rs.getStatement().getConnection().close();
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public JFreeChart createChartYear() {
        String chartTitle = "Biểu đồ doanh thu các" + " năm ";
        String sql = "{Call SP_CHARTYEARS}";
        try {
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            ResultSet rs = XJDBC.query(sql);
            while (rs.next()) {
                dataset.addValue(rs.getDouble("THANHTIEN"), "DOANHTHU", rs.getString("NAM"));
            }
            JFreeChart lineChart = ChartFactory.createLineChart(
                    chartTitle.toUpperCase(),
                    "NĂM", "DOANH THU (VND)", dataset,
                    PlotOrientation.VERTICAL, true, true, false);
            rs.getStatement().getConnection().close();
            CategoryPlot plot = lineChart.getCategoryPlot();
            plot.setRenderer(new BarRenderer());
            plot.setBackgroundPaint(Color.white);
            plot.setOutlineStroke(new BasicStroke(2.0f));
            plot.setRangeGridlinesVisible(true);
            plot.setRangeGridlinePaint(Color.BLACK);

            plot.setDomainGridlinesVisible(true);
            plot.setDomainGridlinePaint(Color.BLACK);

            lineChart.getLegend().setFrame(BlockBorder.NONE);
            return lineChart;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Object[]> getThongKeYear() {

        try {
            List<Object[]> lst = new ArrayList<>();
            String sql = "{Call SP_DTNAM}";
            ResultSet rs = XJDBC.query(sql);

            while (rs.next()) {
                lst.add(new Object[]{
                    rs.getString("NAM"),
                    rs.getInt("SOHD"),
                    rs.getInt("SOLUONG"),
                    rs.getInt("GIABAN"),
                    rs.getInt("GIAMGIA"),
                    rs.getInt("DOANHTHU")});

            }
            rs.getStatement().getConnection().close();
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Object[]> getThongKeSP(int index) throws Exception {
        List<Object[]> lst = new ArrayList<>();
        switch (index) {
            case 0:
                String sql = "{Call SP_DTSP}";
                ResultSet rs = XJDBC.query(sql);

                while (rs.next()) {
                    lst.add(new Object[]{
                        rs.getString("MASP"),
                        rs.getString("TENSP"),
                        rs.getInt("CONLAI"),
                        rs.getInt("DABAN"),
                        rs.getInt("SOHD"),
                        rs.getInt("TBHOADON"),
                        rs.getInt("SOTIENGIAM"),
                        rs.getInt("THANHTIEN"),});

                }
                rs.getStatement().getConnection().close();
                return lst;
            case 1:
                String sql1 = "{Call SP_DTSP}";
                ResultSet rs1 = XJDBC.query(sql1);

                while (rs1.next()) {
                    lst.add(new Object[]{
                        rs1.getString("MASP"),
                        rs1.getString("TENSP"),
                        rs1.getInt("SOHD"),
                        rs1.getInt("HDTHAPNHAT"),
                        rs1.getInt("HDCAONHAT"),
                        rs1.getInt("TBHOADON"),
                        rs1.getInt("SOTIENGIAM"),
                        rs1.getInt("THANHTIEN"),});

                }
                rs1.getStatement().getConnection().close();
                return lst;
            case 2:
        }
        return null;
    }
}

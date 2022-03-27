/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import javax.swing.JTable;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author NTV
 */
public class XExcel {

    public static File xuatExcel(JTable jtable, String name) throws Exception {
        // create wordbook
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(name);
        // cell style 
        XSSFFont font = workbook.createFont();
        font.setFontName("Times New Roman");
        font.setBold(true);
        font.setFontHeightInPoints((short) 14);
        font.setColor(IndexedColors.WHITE.getIndex());
        XSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        style.setFillForegroundColor(IndexedColors.BLUE1.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setBorderBottom(BorderStyle.THIN);
        addDataToExcel(sheet, style, jtable, workbook, name);

        // luu file
        String path = System.getProperty("user.dir") + "\\FileExcel\\" + name + XDate.toString(new Date(), " ddMMyyyy hhmmssaa") + ".xlsx";
        File file = new File(path);
        file.getParentFile().mkdirs();

        FileOutputStream outFile;
        outFile = new FileOutputStream(file);
        workbook.write(outFile);
        return file;
    }

    public static void addDataToExcel(XSSFSheet sheet, XSSFCellStyle style, JTable jtable, XSSFWorkbook workbook, String name) {
        Cell cell;
        Row row;
        row = sheet.createRow(0);
        for (int i = 0; i < jtable.getColumnCount(); i++) {
            cell = row.createCell(i, CellType.STRING);
            cell.setCellStyle(style);
            cell.setCellValue(jtable.getColumnName(i));

        }
        for (int i = 0; i < jtable.getRowCount(); i++) {
            row = sheet.createRow(i + 1);
            for (int j = 0; j < jtable.getColumnCount(); j++) {
                cell = row.createCell(j, CellType.STRING);
                String mavach = jtable.getValueAt(i, j) == null ? "Chưa có" : jtable.getValueAt(i, j).toString();
                if (name.equals("SanPham")) {
                    cell.setCellStyle(cellStyle(workbook, i, jtable));
                }
                cell.setCellValue(mavach);
            }
        }
        for (int columnIndex = 0; columnIndex <= jtable.getRowCount(); columnIndex++) {
            sheet.autoSizeColumn(columnIndex);
        }
    }

    private static XSSFCellStyle cellStyle(XSSFWorkbook workbook, int row, JTable jtable) {
        XSSFFont font = workbook.createFont();
        font.setFontName("Times New Roman");
        font.setBold(true);
        font.setFontHeightInPoints((short) 12);
        XSSFCellStyle style = workbook.createCellStyle();
        style.setBorderBottom(BorderStyle.THIN);

        int sl = Integer.parseInt(jtable.getValueAt(row, 8).toString());
        if (sl < 51) {
            font.setColor(IndexedColors.YELLOW.getIndex());
            style.setFont(font);
            style.setFillForegroundColor(IndexedColors.RED.getIndex());
            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        } else if (sl < 101) {
            font.setColor(IndexedColors.RED.getIndex());
            style.setFont(font);
            style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return style;
    }
}

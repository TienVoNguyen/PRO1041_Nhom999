/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.JTable;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import poly.entity.SanPham;

/**
 *
 * @author NTV
 */
public class XExcel {

    public static List<SanPham> readExcel(String excelFilePath) throws Exception {
        List<SanPham> listSP = new ArrayList<>();

        // Get file
        InputStream inputStream = new FileInputStream(new File(excelFilePath));

        // Get workbook
        Workbook workbook = getWorkbook(inputStream, excelFilePath);

        // Get sheet
        Sheet sheet = workbook.getSheetAt(0);

        // Get all rows
        Iterator<Row> iterator = sheet.iterator();
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            if (nextRow.getRowNum() == 0) {
                // Ignore header
                continue;
            }

            // Get all cells
            Iterator<Cell> cellIterator = nextRow.cellIterator();

            // Read cells and set value for book object
            SanPham sp = new SanPham();
            while (cellIterator.hasNext()) {
                //Read cell
                Cell cell = cellIterator.next();
                Object cellValue = getCellValue(cell);
                if (cellValue == null || cellValue.toString().isEmpty()) {
                    continue;
                }
                // Set value for book object
                int columnIndex = cell.getColumnIndex();
                switch (columnIndex) {
                    case 0:
                        sp.setMaSP(new BigDecimal((double) cellValue).intValue());
                        break;
                    case 1:
                        sp.setTenSanPham((String) getCellValue(cell));
                        break;
//                    case 2:
//                        sp.set(new BigDecimal((double) cellValue).intValue());
//                        break;
//                    case 3:
//                        sp.setPrice((Double) getCellValue(cell));
//                        break;
//                    case 4:
//                        sp.setTotalMoney((Double) getCellValue(cell));
//                        break;
                    default:
                        break;
                }

            }
            listSP.add(sp);
        }

        workbook.close();
        inputStream.close();

        return listSP;
    }

    // Get Workbook
    private static Workbook getWorkbook(InputStream inputStream, String excelFilePath) throws Exception {
        Workbook workbook = null;
        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else if (excelFilePath.endsWith("xls")) {
            workbook = new HSSFWorkbook(inputStream);
        } else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }

        return workbook;
    }

    // Get cell value
    private static Object getCellValue(Cell cell) {
        CellType cellType = cell.getCellType();
        Object cellValue = null;
        switch (cellType) {
            case BOOLEAN:
                cellValue = cell.getBooleanCellValue();
                break;
            case FORMULA:
                Workbook workbook = cell.getSheet().getWorkbook();
                FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
                cellValue = evaluator.evaluate(cell).getNumberValue();
                break;
            case NUMERIC:
                cellValue = cell.getNumericCellValue();
                break;
            case STRING:
                cellValue = cell.getStringCellValue();
                break;
            case _NONE:
            case BLANK:
            case ERROR:
                break;
            default:
                break;
        }

        return cellValue;
    }

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
        String pattern = "^[0-9]{1,}$";
        for (int i = 0; i < jtable.getRowCount(); i++) {
            row = sheet.createRow(i + 1);
            for (int j = 0; j < jtable.getColumnCount(); j++) {

                if (jtable.getValueAt(i, j).toString().contains(",")) {
                    cell = row.createCell(j, CellType.NUMERIC);
                    String a = jtable.getValueAt(i, j).toString().replaceAll(",", "");
                    double b = Double.parseDouble(a);
                    short format = (short) BuiltinFormats.getBuiltinFormat("#,##0");
                    CellStyle cellStyleFormatNumber = null;
                    cellStyleFormatNumber = workbook.createCellStyle();
                    cellStyleFormatNumber.setDataFormat(format);
                    cell.setCellStyle(cellStyleFormatNumber);
                    cell.setCellValue(b);
                } else if (jtable.getValueAt(i, j).toString().matches(pattern)) {
                    cell = row.createCell(j, CellType.NUMERIC);
                    double b = Double.parseDouble(jtable.getValueAt(i, j).toString());
                    CellStyle cellStyleFormatNumber = null;
                    short format = (short) BuiltinFormats.getBuiltinFormat("#,##0");
                    cellStyleFormatNumber = workbook.createCellStyle();
                    cellStyleFormatNumber.setDataFormat(format);
                    cell.setCellStyle(cellStyleFormatNumber);
                    cell.setCellValue(b);

                } else {
                    cell = row.createCell(j, CellType.STRING);
                    String mavach = jtable.getValueAt(i, j) == null ? "Chưa có" : jtable.getValueAt(i, j).toString();
                    cell.setCellValue(mavach);
                }

                if (name.equals("SanPham")) {
                    cell.setCellStyle(cellStyle(workbook, i, jtable));
                }

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

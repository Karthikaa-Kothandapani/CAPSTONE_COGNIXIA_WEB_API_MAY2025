package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
public class ExcelUtil {

	@SuppressWarnings("deprecation")
	public static List<String> getColumnAsList(String filePath, String sheetName, int columnIndex) {
	    List<String> dataList = new ArrayList<>();
	    try (FileInputStream fis = new FileInputStream(filePath);
	         Workbook workbook = new XSSFWorkbook(fis)) {

	        Sheet sheet = workbook.getSheet(sheetName);
	        for (Row row : sheet) {
	            Cell cell = row.getCell(columnIndex);
	            if (cell != null) {
	                cell.setCellType(CellType.STRING);
	                dataList.add(cell.getStringCellValue().trim());
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return dataList;
	}

    }

package HelperMethods;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;

public class FetchExcelFileData {
    public String fetchUserRegisterDataExcel(int row, int column) {
        String excelFilePath = System.getProperty("user.dir") + "/src/test/java/TestData/Data.xlsx";
        XSSFSheet userRegisterDataExcel = null;
        try {
            FileInputStream excelFile = new FileInputStream(excelFilePath);
            XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
            userRegisterDataExcel = workbook.getSheet("User-Register-Data");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userRegisterDataExcel.getRow(row).getCell(column).getStringCellValue();
    }
}
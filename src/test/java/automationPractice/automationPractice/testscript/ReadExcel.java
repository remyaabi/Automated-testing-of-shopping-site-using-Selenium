package automationPractice.automationPractice.testscript;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.CellEditor;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.formula.functions.Rows;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.apache.poi.ss.usermodel.Cell;

import com.gargoylesoftware.htmlunit.javascript.host.Iterator;



public  class ReadExcel {
	FileInputStream fileInputStream;
	XSSFWorkbook workbook;
	 XSSFSheet  excelSheet;

	@SuppressWarnings("deprecation")
	public   Object[][]  excelReader(String path, String sheetName) throws IOException, EncryptedDocumentException, InvalidFormatException{
		 
		
			String filename = path;
			 fileInputStream=new FileInputStream(new File(filename));
			// workbook= (XSSFWorkbook) WorkbookFactory.create(fileInputStream);
			 workbook=new XSSFWorkbook(fileInputStream); 
		     excelSheet=workbook.getSheet(sheetName);
			int totalRows=excelSheet.getLastRowNum() + 1;
			int totalCols=excelSheet.getRow(0).getLastCellNum();
			int rowIndex=0;
		     Object[][] testdataValue= new Object[totalRows][totalCols];
		     java.util.Iterator<Row> rowIterator= excelSheet.iterator();
		DataFormatter formatter = new DataFormatter();
			 while(  rowIterator.hasNext()){
				 
				 Row row=rowIterator.next();
				 java.util.Iterator<org.apache.poi.ss.usermodel.Cell> cellIterator=row.cellIterator();
				 int colIndex=0;

				 while(cellIterator.hasNext()){
					 Cell cell= cellIterator.next();
					 if(cell.getCellType()==cell.CELL_TYPE_BLANK){
						 testdataValue[rowIndex][colIndex]="";
					 }
	                   else if(cell.getCellType()==cell.CELL_TYPE_NUMERIC){
	                    	testdataValue[rowIndex][colIndex]=formatter.formatCellValue(cell);//.getNumericCellValue();
	                    	System.out.println(testdataValue[rowIndex][colIndex] + ": testdataValue["+rowIndex+"]["+colIndex+"]");
	                    }else if(cell.getCellType()==cell.CELL_TYPE_BOOLEAN){
							testdataValue[rowIndex][colIndex]=Boolean.valueOf(cell.getBooleanCellValue());
	                    }else{
							testdataValue[rowIndex][colIndex]=String.valueOf(cell.getStringCellValue());
							System.out.println(testdataValue[rowIndex][colIndex] + ": testdataValue["+rowIndex+"]["+colIndex+"]");
						}
	                    colIndex++;
				 }
				 rowIndex++;
			 }
	     
		return testdataValue;
	}
	
}

	



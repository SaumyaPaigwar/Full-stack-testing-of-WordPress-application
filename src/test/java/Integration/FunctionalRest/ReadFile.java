package test.java.Integration.FunctionalRest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;






import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFile {

public List<List<Cell>> readingfile(String filepath,String filename,String sheetname){
		
	HSSFWorkbook workbook = null;
	
	List<List<Cell>> data=new ArrayList<List<Cell>>();
	File file=new File(filepath+filename);
	try 
	{
		FileInputStream fis=new FileInputStream(file);
	    workbook=new HSSFWorkbook(fis);	
	} catch (FileNotFoundException e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println("IO Catch");
		e.printStackTrace();
	}
	
	Sheet sheet=workbook.getSheet(sheetname);
	System.out.println("No of ROWS"+sheet.getLastRowNum());
	Iterator<Row> rowiterator = sheet.iterator();
	while(rowiterator.hasNext()){
	Row row = rowiterator.next();	
	List<Cell> listcell = new ArrayList<Cell>();
	Iterator<Cell> celliterator = row.iterator();
	while(celliterator.hasNext())
	{
		listcell.add(celliterator.next());
		
	}
	
	data.add(listcell);
	
	
	}
System.out.println(data +"----------" +data.size());
return data;	
}
}
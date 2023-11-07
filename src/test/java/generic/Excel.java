package generic;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {
	

	public static String getData(String path,String sheet,int r,int c)
	{
		String v="";
		try 
		{
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			v=wb.getSheet(sheet).getRow(r).getCell(c).toString();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return v;
	}
	
	public static int getRowCount(String path,String sheet)
	{
		int rowCount=0;
		
		try
		{
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			rowCount=wb.getSheet(sheet).getLastRowNum();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return rowCount;
	}
	
	//add a method to count columns
	public static int getCellCount(String path,String sheet ,int r )
	{
		int cellCount=0;
		
		try
		{
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			for(int i=0;i<=r;i++)
			{
			cellCount =wb.getSheet(sheet).getRow(0).getLastCellNum();
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return cellCount;
	}
	
	//method to write the data
	public static void setData(String path, String sheet, int r, int c, String s) {
		try 
		{
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			wb.getSheet(sheet).getRow(r).getCell(c).setCellValue(s);
			wb.write(new FileOutputStream(path));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}

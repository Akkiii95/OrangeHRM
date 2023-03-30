package excelReading;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelRead1 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		File myfile = new File("E:\\selenium\\excel new.xlsx");
		Sheet mySheet = WorkbookFactory.create(myfile).getSheet("New data");
		
		int rows = mySheet.getLastRowNum();
		int cols = mySheet.getRow(0).getLastCellNum()-1;

		for(int i=0; i<=rows; i++)
		{
			for (int j=0; j<= cols; j++)
			{
				CellType dataType = mySheet.getRow(i).getCell(j).getCellType();
				
				if (dataType==CellType.STRING)
				{
					String value = mySheet.getRow(i).getCell(j).getStringCellValue();
					System.out.print(" | "+value);
				}
				else if (dataType==CellType.NUMERIC)
				{
					double value = mySheet.getRow(i).getCell(j).getNumericCellValue();
					System.out.print(" | "+value);
				}
				else if (dataType==CellType.BOOLEAN) 
				{
					boolean value = mySheet.getRow(i).getCell(j).getBooleanCellValue();
					System.out.print(" | "+ value);
				}
			}
			System.out.println();
		}
	}

}

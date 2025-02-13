package Practice;

import Google_Youtube_Automation_GenericUtility.ExcelUtility;

public class ExcelDemo {
	
	public static void main(String[] args) throws Throwable {
		ExcelUtility elib=new ExcelUtility();
		String data = elib.readExcelData("test", 0, 0);
		
		System.out.println(data);
	}

}

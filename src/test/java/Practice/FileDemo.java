package Practice;

import Google_Youtube_Automation_GenericUtility.FileUtility;

public class FileDemo {
	
	public static void main(String[] args) throws Throwable {
		FileUtility flib=new FileUtility();
		String data = flib.getPropertyFileData("url");
		System.out.println(data);
	}

}

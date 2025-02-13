package Google_Youtube_Automation_GenericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	
	public int random() {
		Random ran=new Random();
		int random=ran.nextInt(1000);
		return random;
	}
	/**
	 * 
	 * @return
	 */
	public String getSystemDate() {
		Date dt=new Date();
		String date=dt.toString();
		return date;
		
	}
	/**
	 * 
	 * @return
	 */
	public String formateSystemDate() {
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		Date dt=new Date();
		String getDateAndTime=sdf.format(dt);
		getDateAndTime.replace(":","-");
		return getDateAndTime;
	}
	
	
	/**
	 * 
	 * @param data
	 * @return
	 */
	
	public String getPopupDigits(String data) {
		String digit="";
	    for(int i=0;i<data.length();i++) {
	    	char ch=data.charAt(i);
	    	if(Character.isDigit(ch))
	    		digit=digit+ch;
	    }
	    return digit;
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	//*OTP :176615

	public String getOtp(String str) {
		String s1="OTP :";
		String s=str.split(s1)[1];
		return s;
	}
	
	
	

}

package com.crm.SalesAndInventorySystemProject.WebDriverUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getRandomNumber() {
		Random random = new Random();
		int randomNumber = random.nextInt(5000);
		return randomNumber;
	}

	public String getSystemDateYYYYMMDD() {
		Date dateObj = new Date();
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		String date = sdf.format(dateObj);
		return date;
	}

	public String getRequiredDateYYYYMMDD(int days) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String reqDate = sdf.format(cal.getTime());
		return reqDate;
	}
	public StringBuffer getRandomAlphanumericCode()
	{
		int n=5;
		
		//chooses the random character from this string
		String AlphaNumericString="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
		//String AlphaNumericString="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz!@#$%^&*()";
		
		
		//create the StringBuffer of sizeof AlphanumericString
		StringBuffer sb=new StringBuffer(n);
		
		for(int i=0;i<n;i++)
		{
			//generate a random number between 0 to AlphaNumericString variable length
			int index=(int)(AlphaNumericString.length()*Math.random());
			
			//add character one by one in end of sb 
			sb.append(AlphaNumericString.charAt(index));
		}
		//System.out.println(sb);
		return sb;
			
	}

}

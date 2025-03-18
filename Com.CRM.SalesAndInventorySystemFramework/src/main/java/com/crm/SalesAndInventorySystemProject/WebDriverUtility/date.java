package com.crm.SalesAndInventorySystemProject.WebDriverUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class date
{
	public static void main(String[] args) {
		
		
			int days = 0;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DAY_OF_MONTH, days);
			String reqDate = sdf.format(cal.getTime());
			System.out.println(reqDate); ;
		}
	}



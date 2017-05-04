package com.oot.usedcar.util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private static final String DATEFORMAT1 = "dd/MM/yyyy";
	
	public static Date convertStringToDate(String dateStr){
		return convertStringToDate(dateStr,DATEFORMAT1);
	}
	public static Date convertStringToDate(String dateStr,String format){
		
		SimpleDateFormat s = new SimpleDateFormat(format);
		
		try {
	      Date date = s.parse(dateStr);
	      System.out.println(date);
	      return date;
	    } catch (ParseException e) {
	      e.printStackTrace();
	      return null;
	    }
		
	}
	
	public static Double convertStringToDouble(String doubleStr) {
		double d = 0.00;
		if (doubleStr!=""){		
			d = Double.parseDouble(doubleStr.replaceAll(",", ""));
		}
		return d;

	}
	
	public static int convertStringToInt(String IntStr) {
		int d = 0;
		if (IntStr!="") {
			d=Integer.parseInt(IntStr.replaceAll(",", ""));
		}
		return d;
	}
	
	public static BigDecimal convertStringToBigDecimal(String bigDecimalStr) {	
		BigDecimal d = new BigDecimal(0);
		if (bigDecimalStr!="") {
			d =new BigDecimal(bigDecimalStr.replaceAll(",", ""));
		}
		return d;
	}

}

package it.urial.rps.utils;

public class Utils {
	
	public static boolean isNumber(String text) {
		boolean result = false;
		try {
			Integer.parseInt(text);
			result = true;
		} catch(Exception e) {
			
		}
		
		return result;
	}
	
}

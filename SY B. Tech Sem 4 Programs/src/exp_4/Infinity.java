package exp_4;

import java.io.UnsupportedEncodingException;

public class Infinity {
	
	public static void main(String args[]) {
		
		String infinitySymbol = null;

		try {

		    infinitySymbol = new String(String.valueOf(Character.toString('\u221E')).getBytes("UTF-8"), "UTF-8");

		} catch (UnsupportedEncodingException ex) {

		    infinitySymbol = "?";

		} finally {

		    System.out.print("Symbol of infinity is : " + infinitySymbol);

		}
	}
}

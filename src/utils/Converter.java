package utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class Converter {

	/**
	 * Convert an Exception stacktrace to a String writable in DB
	 * 
	 * @param e
	 * @return the exception's stacktrace
	 */
	public static String StacktraceToString(Exception e) {
		String returned = null;

		StringWriter sw = new StringWriter ( );
		PrintWriter pw = new PrintWriter (sw);

		e.printStackTrace (pw);

		returned = sw.toString ( );

		try {
			pw.close ( );
			sw.close ( );
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace ( );
		}

		return returned;

	}

}

/**
 * 
 */
package constants;

/**
 * @author pascal
 *
 */
public final class Configuration {

	private static String	defaultDirectory;
	private static String	defaultFileName;
	private static String	defaultMessage;

	public static String getDefaultDirectory( ) {
		return defaultDirectory;
	}

	public static void setDefaultDirectory(String defaultDirectory) {
		Configuration.defaultDirectory = defaultDirectory;
	}

	public static String getDefaultFileName( ) {
		return defaultFileName;
	}

	public static void setDefaultFileName(String defaultFileName) {
		Configuration.defaultFileName = defaultFileName;
	}

	public static String getDefaultMessage( ) {
		return defaultMessage;
	}

	public static void setDefaultMessage(String defaultMessage) {
		Configuration.defaultMessage = defaultMessage;
	}
}

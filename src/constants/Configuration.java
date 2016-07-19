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
	private static String	defaultSummary;

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

	public static String getDefaultSummary( ) {
		return defaultSummary;
	}

	public static void setDefaultSummary(String defaultSummary) {
		Configuration.defaultSummary = defaultSummary;
	}
}

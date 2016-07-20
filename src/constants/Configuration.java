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
	private static Severity	severity;

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

	public static Severity getSeverity( ) {
		return severity;
	}

	public static void setSeverity(Severity severity) {
		Configuration.severity = severity;
	}
}

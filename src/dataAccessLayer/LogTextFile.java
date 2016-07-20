/**
 * 
 */
package dataAccessLayer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import businessLogicLayer.Log;
import constants.Configuration;

/**
 * FileAccessObject
 * 
 * @author pascal
 *
 */
public class LogTextFile {

	private String	summary;
	private String	name;
	private String	dir;

	public LogTextFile(String dir, String name, String summary) {
		setDir(dir);
		setName(name);
		setSummary(summary);
		createFile( );
	}

	/**
	 * Constructor use the default directory, filename and message you should
	 * have put in MRCXLogConfig.xml<br>
	 * <br>
	 * 
	 * This also need you to read the configuration file first with : <br>
	 * <code>ReadXMLFile.readDefaultConfiguration( )</code>
	 */
	public LogTextFile( ) {
		setDir(Configuration.getDefaultDirectory( ));
		setName(Configuration.getDefaultFileName( ));
		setSummary(Configuration.getDefaultSummary( ));
		createFile( );
	}

	/**
	 * Create a new text file <br>
	 * 
	 * <code>return true</code> if the file is created or if the file already
	 * exist <br>
	 * 
	 * <code> return false</code> if the file cannot be created
	 * 
	 * @return true if the file exist
	 */
	public boolean createFile( ) {
		File directory = new File(dir);
		File file = new File(dir + name);

		if(!directory.exists( )){
			directory.mkdirs( );
		}

		if(!file.exists( )){
			try(FileWriter fw = new FileWriter(dir + name)){

				if(null != getSummary( )){
					fw.write(getSummary( ));
					fw.write(System.lineSeparator( ));
					fw.write(System.lineSeparator( ));
				}

			}catch(IOException e){
				e.printStackTrace( );
				return false;
			}
		}

		return true;
	}

	/**
	 * write a Log object in the file
	 * 
	 * @param log
	 */
	public void writeLog(Log log) {
		try(FileWriter fw = new FileWriter(dir + name, true)){

			fw.write(log.toString( ));
			fw.write(System.lineSeparator( ));

		}catch(IOException e){
			e.printStackTrace( );
		}
	}

	/**
	 * This was implemented for tests
	 */
	public void writeSeparation( ) {
		try(FileWriter fw = new FileWriter(dir + name, true)){

			fw.write("----------------------------------------------------------------");
			fw.write(System.lineSeparator( ));

		}catch(IOException e){
			e.printStackTrace( );
		}
	}

	/**
	 * Write a message in the log file
	 * 
	 * @param message
	 */
	public void writeMessage(String message) {
		try(FileWriter fw = new FileWriter(dir + name, true)){

			fw.write(message + "\n");

		}catch(IOException e){
			e.printStackTrace( );
		}

	}

	public String getSummary( ) {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getName( ) {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDir( ) {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}
}

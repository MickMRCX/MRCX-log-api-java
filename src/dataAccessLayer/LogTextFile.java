/**
 * 
 */
package dataAccessLayer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import businessLogicLayer.Log;

/**
 * FileAccessObject
 * 
 * @author pascal
 *
 */
public class LogTextFile {

	private static LogTextFile	singleton;
	private String				summary;
	private String				name;
	private String				dir;

	private LogTextFile( ) {

	}

	public static LogTextFile getInstance( ) {
		if(null == singleton){
			singleton = new LogTextFile( );
		}

		return singleton;
	}

	public void initialize(String dir, String name, String summary) {
		setDir(dir);
		setName(name);
		setSummary(summary);
	}

	/**
	 * Create a new text file <br>
	 * 
	 * <code>return true</code> if the file is created or if the file already
	 * exist <br>
	 * 
	 * <code> return false</code> if the file cannot be created
	 * 
	 * @return
	 */
	public boolean createFile( ) {
		File file = new File(dir + name);

		if(!file.exists( )){
			try(FileWriter fw = new FileWriter(dir + name)){

				if(null != getSummary( )){
					fw.write(getSummary( ) + "\n\n");
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

			fw.write(log.toString( ) + "\n");

		}catch(IOException e){
			e.printStackTrace( );
		}
	}

	public void writeSeparation( ) {
		try(FileWriter fw = new FileWriter(dir + name, true)){

			fw.write("----------------------------------------------------------------\n");

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

/**
 * 
 */
package serviceLayer;

import java.sql.SQLException;
import java.util.ArrayList;

import businessLogicLayer.Log;
import constants.Configuration;
import constants.DalEnum;
import dataAccessLayer.LogCSVFile;
import dataAccessLayer.LogDB;
import dataAccessLayer.LogTextFile;

/**
 * @author pascal
 *
 */
public class CtrlLog {

	private static CtrlLog singleton = new CtrlLog( );

	public static CtrlLog getInstance( ) {
		return singleton;
	}

	private LogTextFile		logText;
	private LogCSVFile		logCSV;
	private LogDB			logDB;
	private int				severity;
	private ArrayList<Log>	logs	= new ArrayList<Log>( );

	public void createTextFile(String dir, String name, String summary) {
		logText = new LogTextFile(dir, name, summary);

	}

	public void createTextFile( ) {
		logText = new LogTextFile( );
	}

	public int writeLog(Log log, DalEnum dalEnum) {
		logs.add(log);

		switch(dalEnum) {
			case Database:
				boolean success = false;
				try{
					LogDB logdb = new LogDB( );

					logdb.insert(log);
					success = true;
				}catch(SQLException e){
					success = false;
				}catch(Exception e){
					success = false;
				}

				if(!success){
					if(logText == null){
						logText = new LogTextFile(Configuration.getDefaultDirectory( ),
								Configuration.getDefaultFileName( ), Configuration.getDefaultSummary( ));
					}
					logText.writeLog(log);

					return -2;
				}
				return 1;
			case CSVFile:
				// TODO write in CSV File
				break;
			case TextFile:
				logText.writeLog(log);

				return 1;
		}

		return -1;
	}

	public LogTextFile getLogText( ) {
		return logText;
	}

	public void setLogText(LogTextFile logText) {
		this.logText = logText;
	}

	public LogCSVFile getLogCSV( ) {
		return logCSV;
	}

	public void setLogCSV(LogCSVFile logCSV) {
		this.logCSV = logCSV;
	}

	public LogDB getLogDB( ) {
		return logDB;
	}

	public void setLogDB(LogDB logDB) {
		this.logDB = logDB;
	}

	public int getSeverity( ) {
		return severity;
	}

	public void setSeverity(int severity) {
		this.severity = severity;
	}

	public ArrayList<Log> getLogs( ) {
		return logs;
	}

	public void setLogs(ArrayList<Log> logs) {
		this.logs = logs;
	}

	public int countLogs( ) {
		return this.logs.size( );
	}
}

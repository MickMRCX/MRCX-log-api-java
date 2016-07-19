import java.util.Date;

import businessLogicLayer.Log;
import constants.Configuration;
import constants.Severity;
import dataAccessLayer.LogTextFile;
import utils.ReadXMLFile;

/**
 * 
 */

/**
 * @author pascal
 *
 */
public class Execution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ReadXMLFile.readDefaultConfiguration( );

		LogTextFile rapport = new LogTextFile(Configuration.getDefaultDirectory( ), Configuration.getDefaultFileName( ),
				Configuration.getDefaultSummary( ));

		if(rapport.createFile( )){

			Log log = new Log(Severity.Verbose, new Date( ), "give you up");

			rapport.writeLog(log);

			log = new Log(Severity.Warning, new Date( ), "let you down");

			rapport.writeLog(log);

			log = new Log(Severity.Error, new Date( ), "run around and desert you");

			rapport.writeLog(log);

			log = new Log(Severity.Critical, new Date( ), "make you cry");

			rapport.writeLog(log);

			log = new Log(Severity.Warning, new Date( ), "say goodbye");

			rapport.writeLog(log);

			log = new Log(Severity.Error, new Date( ), "tell a lie and hurt you");

			rapport.writeLog(log);

			rapport.writeSeparation( );

		}else{
			System.out.println("The file doesn't exist or couldn't be create.");
		}
	}

}

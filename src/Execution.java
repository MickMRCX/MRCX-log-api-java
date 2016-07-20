import java.util.Date;

import businessLogicLayer.Log;
import constants.DalEnum;
import constants.Severity;
import serviceLayer.CtrlLog;
import utils.ReadXMLFile;

/**
 * @author pascal
 *
 */
public class Execution {

	public static void exemple( ) {

		ReadXMLFile.readDefaultConfiguration( );

		CtrlLog rapport = CtrlLog.getInstance( );

		try{
			rapport.createTextFile( );

			Log log = new Log(Severity.Verbose, new Date( ), "give you up");

			rapport.writeLog(log, DalEnum.TextFile);

			log = new Log(Severity.Information, new Date( ), "let you down");

			rapport.writeLog(log, DalEnum.TextFile);

			log = new Log(Severity.Error, new Date( ), "run around and desert you");

			rapport.writeLog(log, DalEnum.TextFile);

			log = new Log(Severity.Critical, new Date( ), "make you cry");

			rapport.writeLog(log, DalEnum.TextFile);

			log = new Log(Severity.Warning, new Date( ), "say goodbye");

			rapport.writeLog(log, DalEnum.TextFile);

			log = new Log(Severity.Error, new Date( ), "tell a lie and hurt you");

			rapport.writeLog(log, DalEnum.TextFile);
		}catch(Exception e){
			e.printStackTrace( );
		}

	}

}

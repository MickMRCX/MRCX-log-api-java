import java.io.File;
import java.util.Date;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import businessLogicLayer.Log;
import constants.Configuration;
import constants.Severity;
import dataAccessLayer.LogTextFile;
import utils.ConfigHandler;

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

		try{
			File inputFile = new File("MRCXLogConfig.xml");
			SAXParserFactory factory = SAXParserFactory.newInstance( );
			SAXParser saxParser = factory.newSAXParser( );
			ConfigHandler configHandler = new ConfigHandler( );
			saxParser.parse(inputFile, configHandler);
		}catch(Exception e){
			e.printStackTrace( );
		}

		LogTextFile rapport = new LogTextFile(Configuration.getDefaultDirectory( ), Configuration.getDefaultFileName( ),
				Configuration.getDefaultMessage( ));

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
			System.out.println("Le fichier n'existe pas et n'a pas pu être créé.");
		}
	}

}

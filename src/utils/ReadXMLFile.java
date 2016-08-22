/**
 * 
 */
package utils;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * @author pascal
 *
 */
public class ReadXMLFile {

	public static void readDefaultConfiguration(String fichier) {
		try{
			File inputFile = new File(fichier);

			SAXParserFactory factory = SAXParserFactory.newInstance( );
			SAXParser saxParser = factory.newSAXParser( );
			ConfigHandler configHandler = new ConfigHandler( );
			saxParser.parse(inputFile, configHandler);
		}catch(Exception e){
			e.printStackTrace( );
		}
	}
}

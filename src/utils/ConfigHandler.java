/**
 * 
 */
package utils;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import constants.Configuration;

/**
 * @author pascal
 *
 */
public class ConfigHandler extends DefaultHandler {

	boolean	bDirectory	= false;
	boolean	bFileName	= false;
	boolean	bMessage	= false;

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if(qName.equalsIgnoreCase("directory")){
			bDirectory = true;
		}else if(qName.equalsIgnoreCase("filename")){
			bFileName = true;
		}else if(qName.equalsIgnoreCase("message")){
			bMessage = true;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("Fin de lecture du fichier XML");
	}

	@Override
	public void characters(char ch[], int start, int length) throws SAXException {
		if(bDirectory){
			Configuration.setDefaultDirectory(new String(ch, start, length));
			bDirectory = false;
		}else if(bFileName){
			Configuration.setDefaultFileName(new String(ch, start, length));
			bFileName = false;
		}else if(bMessage){
			Configuration.setDefaultMessage(new String(ch, start, length));
			bMessage = false;
		}
	}
}

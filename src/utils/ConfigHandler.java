/**
 * 
 */
package utils;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import constants.Configuration;
import constants.Severity;

/**
 * @author pascal
 *
 */
public class ConfigHandler extends DefaultHandler {

	boolean	bDirectory	= false;
	boolean	bFileName	= false;
	boolean	bSummary	= false;
	boolean	bSeverity	= false;

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if(qName.equalsIgnoreCase("directory")){
			bDirectory = true;
		}else if(qName.equalsIgnoreCase("filename")){
			bFileName = true;
		}else if(qName.equalsIgnoreCase("summary")){
			bSummary = true;
		}else if(qName.equalsIgnoreCase("severity")){
			bSeverity = true;
		}
	}

	@Override
	public void characters(char ch[], int start, int length) throws SAXException {
		if(bDirectory){
			Configuration.setDefaultDirectory(new String(ch, start, length));
			bDirectory = false;
		}else if(bFileName){
			Configuration.setDefaultFileName(new String(ch, start, length));
			bFileName = false;
		}else if(bSummary){
			Configuration.setDefaultSummary(new String(ch, start, length));
			bSummary = false;
		}else if(bSeverity){
			Configuration.setSeverity(Severity.valueOf(new String(ch, start, length)));
			bSummary = false;
		}
	}
}

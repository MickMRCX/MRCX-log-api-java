/**
 * 
 */
package businessLogicLayer;

import java.io.Serializable;
import java.util.Date;

import constants.Severity;

/**
 * @author Pascal Marcouyoux
 * @url https://github.com/P-marcou <html> <br>
 *      <br>
 *      private int identifier; <br>
 *      private String stackTrace; <br>
 *      private Severity severity; <br>
 *      private Date date; <br>
 *      private String message; <br>
 *      </html>
 *
 */
public class Log implements Serializable {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	private int					identifier;
	private String				stackTrace;
	private Severity			severity;
	private Date				date;
	private String				message;

	public Log(int identifier, String exception, Severity severity, Date date, String message) {
		super ( );
		this.identifier = identifier;
		this.stackTrace = exception;
		this.severity = severity;
		this.date = date;
		this.message = message;
	}

	public Log(String exception, Severity severity, Date date, String message) {
		super ( );
		this.stackTrace = exception;
		this.severity = severity;
		this.date = date;
		this.message = message;
	}

	public Log(Severity severity, Date date, String message) {
		super ( );
		this.severity = severity;
		this.date = date;
		this.message = message;
	}

	public int getIdentifier( ) {
		return identifier;
	}

	public void setIdentifier(int identifier) {
		this.identifier = identifier;
	}

	public String getStackTrace( ) {
		return stackTrace;
	}

	public void setStackTrace(String exception) {
		this.stackTrace = exception;
	}

	public Severity getSeverity( ) {
		return severity;
	}

	public void setSeverity(Severity severity) {
		this.severity = severity;
	}

	public Date getDate( ) {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMessage( ) {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

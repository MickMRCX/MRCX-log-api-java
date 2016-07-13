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
	private Exception			exception;
	private Severity			severity;
	private Date				date;
	private String				message;

	public Log(int identifier, Exception exception, Severity severity, Date date, String message) {
		super( );
		this.identifier = identifier;
		this.exception = exception;
		this.severity = severity;
		this.date = date;
		this.message = message;
	}

	public Log(Exception exception, Severity severity, Date date, String message) {
		super( );
		this.exception = exception;
		this.severity = severity;
		this.date = date;
		this.message = message;
	}

	public Log(Severity severity, Date date, String message) {
		super( );
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

	public Exception getException( ) {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
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

	public String toString( ) {
		StringBuilder strB = new StringBuilder( );

		strB.append(getDate( ).toString( ));
		strB.append(", ");
		strB.append(getSeverity( ).ordinal( ));
		strB.append(", ");
		strB.append(getMessage( ));
		strB.append(", ");
		strB.append(getException( ));
		strB.append(";");

		return strB.toString( );
	}
}

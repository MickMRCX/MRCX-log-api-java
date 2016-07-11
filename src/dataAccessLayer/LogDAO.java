/**
 * 
 */
package dataAccessLayer;

/**
 * @author Pascal Marcouyoux
 * @url https://github.com/P-marcou
 *
 */
public class LogDAO {

	private final String SELECT_BY_ID = "SELECT * FROM Logs WHERE identifier = ?;";
	
	private final String SELECT_BY_SEVERITY = "SELECT * FROM Logs WHERE severity = ?;";
	
	private final String SELECT_ALL = "SELECT * FROM Logs;";
	
	private final String INSERT = "INSERT INTO Logs VALUES(?,?,?,?,?);";
	
	private final String UPDATE = "UPDATE Logs SET severity = ?, date = ?, message = ?, exception = ? WHERE identifier = ?;";
	
	private final String DELETE = "DELETE FROM Logs WHERE identifier = ?;";
	
	public LogDAO(){
		
	}
}

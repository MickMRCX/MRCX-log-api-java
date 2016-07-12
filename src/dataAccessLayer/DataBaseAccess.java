package dataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

import businessLogicLayer.Log;
import constants.Severity;
import utils.Converter;

public class DataBaseAccess {

	public static Connection getConnection( ) {
		Connection cnx = null;
		try {
			Class.forName ("YOUR SQL DRIVER CLASS NAME");
			Log driverOk = new Log (Severity.Information, new Date ( ), "Driver O.K.");

			String url = "jdbc:DATABASE://DATABASE_ADDRESS";
			String user = "USERNAME";
			String passwd = "PASSWORD";

			cnx = DriverManager.getConnection (url, user, passwd);

		} catch (SQLException e) {
			Log log = new Log (Converter.StacktraceToString (e), Severity.Critical, new Date ( ),
					"Could not connect to database!");
			// TODO Ecrire dans rapport.txt

		} catch (Exception e) {
			Log log = new Log (Converter.StacktraceToString (e), Severity.Critical, new Date ( ),
					"An exception occured while trying to connect to the database!");
			// TODO Ecrire dans rapport.txt
		}

		return cnx;
	}
}

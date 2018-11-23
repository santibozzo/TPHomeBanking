package basico.jdbc;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DBManager {

	private static final String DB_DRIVER = "org.h2.Driver";
	private static final String DB_BASE_URL = "jdbc:h2:tcp://localhost//";
	private static final String DB_NAME = "uno";
	private static final String DB_USERNAME = "sa";
	private static final String DB_PASSWORD = "";

	public static Connection connect() {
		Connection c = null;
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
		}
		try {
			String url = DB_BASE_URL + obtenerUbicacionBase();
			c = DriverManager.getConnection(url, DB_USERNAME, DB_PASSWORD);
			c.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(0);
		}

		return c;
	}

	private static String obtenerUbicacionBase() {
		File currDir = new File("h2/base_de_datos/" + DB_NAME);
		return currDir.getAbsolutePath();
	}

}

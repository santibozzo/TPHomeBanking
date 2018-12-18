package basico.jdbc;

import java.io.File;
import java.sql.*;


public class DBManager {

	private static final String DB_DRIVER = "org.h2.Driver";
	private static final String DB_BASE_URL = "jdbc:h2:tcp://localhost//";
	private static final String DB_NAME = "uno";
	private static final String DB_USERNAME = "sa";
	private static final String DB_PASSWORD = "";

	private static String obtenerUbicacionBase() {
		File currDir = new File("h2/base_de_datos/" + DB_NAME);
		return currDir.getAbsolutePath();
	}

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

	public static void disconnect(Connection connection) throws SQLException{
		try {
			connection.close();
		}catch(SQLException e) {
			throw e;
		}
	}

	public static ResultSet executeQuery(String query) throws SQLException{
		Connection connection = connect();
		ResultSet result = null;
		try {
			Statement statement = connection.createStatement();
			result = statement.executeQuery(query);
		}catch(SQLException e) {
			throw e;
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw e;
			}
		}
		return result;
	}

	public static ResultSet executeQuery(String query, Connection connection) throws SQLException{
		ResultSet result = null;
		try {
			Statement statement = connection.createStatement();
			result = statement.executeQuery(query);
		}catch(SQLException e) {
			throw e;
		}
		return result;
	}

	public static int executeUpdate(String query) throws SQLException{
		Connection connection = connect();
		int resultCode = -1;
		try {
			Statement statement = connection.createStatement();
			resultCode = statement.executeUpdate(query);
			connection.commit();
		}catch(SQLException e) {
			try {
				connection.rollback();
				throw e;
			}catch(SQLException e1) {
				throw e1;
			}
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw e;
			}
		}
		return resultCode;
	}

}

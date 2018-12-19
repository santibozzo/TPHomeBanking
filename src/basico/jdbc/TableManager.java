package basico.jdbc;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableManager {

	public void dropTable(String table) {
		String query = "DROP TABLE " + table;
		try {
			DBManager.executeUpdate(query);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public void createUserTable() {
		String query = "CREATE TABLE usuarios ( id INTEGER IDENTITY, name VARCHAR(100), email VARCHAR(100), username VARCHAR(30), pass VARCHAR(20), type VARCHAR(20))";
		try {
			DBManager.executeUpdate(query);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public void createCuentasTable() {
		String query = "CREATE TABLE cuentas ( cbu INTEGER IDENTITY, alias VARCHAR(50), owner VARCHAR(30), debit FLOAT, credit FLOAT)";
		try {
			DBManager.executeUpdate(query);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public void createTarjetasTable() {
		String query = "CREATE TABLE tarjetas ( number INTEGER IDENTITY, type VARCHAR(30), owner VARCHAR(30), debit FLOAT, credit FLOAT )";
		try {
			DBManager.executeUpdate(query);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public void createMovimientosTable() {
		String query = "CREATE TABLE movimientos ( id INTEGER IDENTITY, entityId INTEGER, entityType VARCHAR(30), amount FLOAT, date DATE, movementType VARCHAR(30), description VARCHAR(100) )";
		try {
			DBManager.executeUpdate(query);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}

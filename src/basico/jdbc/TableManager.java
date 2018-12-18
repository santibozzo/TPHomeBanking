package basico.jdbc;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableManager {

	public void createUserTable() {
		String query = "CREATE TABLE usuarios ( id INTEGER IDENTITY, name VARCHAR(100), email VARCHAR(100), username VARCHAR(30), pass VARCHAR(20), type VARCHAR(20))";
		try {
			DBManager.executeUpdate(query);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void dropUserTable() {
		String query = "DROP TABLE usuarios";
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

	public void dropCuentasTable() {
		String query = "DROP TABLE cuentas";
		try {
			DBManager.executeUpdate(query);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}

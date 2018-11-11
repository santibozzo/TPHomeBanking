package basico.jdbc;

import modelo.Usuario;

import java.sql.SQLException;

public class Main {

	public static void main(String [] args) throws SQLException {

//		TableManager tm = new TableManager();
//		tm.createUserTable();
		
		
		DataManager dm = new DataManager();
		
//		String user = "santi";
//		String email = "santi@mail.com";
//		String pass = "123456";
//		Usuario aInsertar = new Usuario();
//		aInsertar.setUser(user);
//		aInsertar.setEmail(email);
//		aInsertar.setPass(pass);
//		dm.crearUsuario(aInsertar);
//
//		Usuario aInsertar2 = new Usuario();
//		aInsertar2.setUser(user);
//		aInsertar2.setEmail(email);
//		aInsertar2.setPass(pass);
//		dm.crearUsuario(aInsertar2);
		
//		String userx = "userx";
//		String emailx = "emailx";
//		String passx = "passx";
//		Usuario paraEditar = new Usuario(userx, emailx, passx);
//		dm.crearUsuario(paraEditar);
//
//		System.out.println("Ahora voy a mostrar el usuario recien cargado");
//		String unUser = "user1";
//		dm.muestraUsuario(unUser);
//		System.out.println("---------");
//
//		System.out.println("Voy a modificar un usuario");
//		String user2 = "user2";
//		String email2 = "email2";
//		String pass2 = "pass2";
//		Usuario aEditar = new Usuario(user2, email2, pass2);
//		dm.actualizaUsuario(aEditar);
//
//		System.out.println("Tengo estos usuarios:");
//		dm.muestraTodosLosusuarios();
//		System.out.println("------");
//
//
//		System.out.println("Voy a borrar un usuario segun su username");
//		String user3 = "use2";
//		dm.borraUsuario(user3);
		
		System.out.println("Tengo estos usuarios:");
		dm.muestraTodosLosusuarios();
		System.out.println("------");
		
		//tm.dropUserTable();


	}
	
}

package basico.jdbc;

import exceptions.ServicioException;
import modelo.Usuario;
import service.UsuarioService;

import java.sql.SQLException;

public class Main {

	public static void main(String [] args) throws SQLException {

        TableManager tableManager = new TableManager();
        UsuarioService usuarioService = new UsuarioService();

        // Manejo tablas
        tableManager.dropUserTable();
        tableManager.createUserTable();

        // Manejo datos
		Usuario usuarioNuevo = new Usuario("santiagoB", "sbozzo95", "123456", "sbozzo95@email.com");
		try{
		    usuarioService.crearUsuario(usuarioNuevo);
        }catch(ServicioException e){
		    System.out.println("No se pudo crear usuario");
        }


		//tm.dropUserTable();


	}
	
}

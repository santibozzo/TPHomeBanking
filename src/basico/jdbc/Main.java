package basico.jdbc;

import exceptions.ServiceException;
import modelo.Cuenta;
import modelo.Usuario;
import service.CuentaService;
import service.UsuarioService;

import java.sql.SQLException;
import java.util.List;

public class Main {

	public static void main(String [] args) {

        TableManager tableManager = new TableManager();
        UsuarioService usuarioService = new UsuarioService();
        CuentaService cuentaService = new CuentaService();

        // Manejo tablas
//        tableManager.dropUserTable();
//        tableManager.createUserTable();
//        tableManager.createCuentasTable();

        // Manejo datos
//		Usuario usuarioNuevo = new Usuario("Santiago Bozzo", "sbozzo", "123456", "santiagobozzo@hotmail.com", "admin");
//		usuarioService.crearUsuario(usuarioNuevo);
// 		Usuario usuarioNuevo = new Usuario("roberto", "rroberto", "123456", "roberto@hotmail.com", "user");
//		usuarioService.crearUsuario(usuarioNuevo);
// 		usuarioNuevo = new Usuario("carlos", "ccarlos", "123456", "ccarlos@hotmail.com", "user");
//		usuarioService.crearUsuario(usuarioNuevo);

//
//        Cuenta cuentaNueva = new Cuenta("cuenta.sbozzo", "sbozzo", 0, 10000.5f);
//        cuentaService.createCuenta(cuentaNueva);

//         Cuenta cuentaNueva = new Cuenta("cuenta.rroberto", "rroberto", 0, 10000.5f);
//         cuentaService.createCuenta(cuentaNueva);
//         cuentaNueva = new Cuenta("cuenta.ccarlos", "ccarlos", 0, 10000.5f);
//         cuentaService.createCuenta(cuentaNueva);

        //Pruebas modificar/get cuenta
//        Cuenta cuenta = cuentaService.getCuenta(1);
//        System.out.println(cuenta.getAlias());
//        cuenta.setCredit(cuenta.getCredit() + 500f);
//        cuenta.setDebit(cuenta.getDebit() + 500f);
//        cuentaService.modifyCuenta(cuenta);

        //Prueba list
//        List<Cuenta> cuentas = cuentaService.listCuentas();
//        System.out.println(cuentas.get(0).getOwner());
//        System.out.println(cuentas.get(1).getOwner());
//        System.out.println(cuentas.get(2).getOwner());

        List<Usuario> usuarios = usuarioService.listarUsuarios();
        System.out.println(usuarios.get(0).getName());
        System.out.println(usuarios.get(1).getName());

        Usuario usuario = usuarioService.getUsuario("sbozzo");
        System.out.println(usuario.getName());

        //Pruba delete cuenta
//        cuentaService.deleteCuenta(3);

	}
	
}

package basico.jdbc;

import exceptions.ServiceException;
import modelo.Cuenta;
import modelo.Movimiento;
import modelo.Tarjeta;
import modelo.Usuario;
import service.CuentaService;
import service.MovimientoService;
import service.TarjetaService;
import service.UsuarioService;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class Main {

	public static void main(String [] args) {

        TableManager tableManager = new TableManager();
        UsuarioService usuarioService = new UsuarioService();
        CuentaService cuentaService = new CuentaService();
        TarjetaService tarjetaService = new TarjetaService();
        MovimientoService movimientoService = new MovimientoService();

        // Manejo tablas
//        tableManager.createUserTable();
//        tableManager.createCuentasTable();
//        tableManager.createMovimientosTable();
//        tableManager.dropTable("tarjetas");
//        tableManager.createTarjetasTable();

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

//        Tarjeta tarjetaNueva = new Tarjeta("debito", "sbozzo");
//        tarjetaService.createTarjeta(tarjetaNueva);
//        Tarjeta tarjeta = tarjetaService.getTarjeta(1);
//        tarjeta.setCredit(tarjeta.getCredit() + 1000f);
//        tarjetaService.modifyTarjeta(tarjeta);
//        System.out.println(tarjetaService.listTarjetas().get(0).getOwner());

//        Date date = new Date(new java.util.Date().getTime());
//        Movimiento movimiento = new Movimiento(1, "tarjeta", 2000f, date, "credito", "credito a tarjeta");
//        movimientoService.createMovimiento(movimiento);
//        Movimiento movimiento = movimientoService.getMovimiento(1);
//        System.out.println(movimiento.getDate());
//        System.out.println(movimientoService.listMovimientos().get(0).getDescription());

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

//        List<Usuario> usuarios = usuarioService.listarUsuarios();
//        System.out.println(usuarios.get(0).getName());
//        System.out.println(usuarios.get(1).getName());
//
//        Usuario usuario = usuarioService.getUsuario("sbozzo");
//        System.out.println(usuario.getName());

        //Pruba delete cuenta
//        cuentaService.deleteCuenta(3);

	}
	
}

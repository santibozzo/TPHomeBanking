package basico.jdbc;

import modelo.Usuario;
import pantallas.cuentaManager.CuentaManagerPantalla;
import pantallas.cuentasList.CuentasOwnListPantalla;
import pantallas.logIn.LogInPantalla;
import pantallas.menues.AdminMenuPantalla;
import pantallas.tarjetaManager.TarjetaManagerPantalla;
import pantallas.usuarioManager.UsuarioManagerPantalla;
import pantallas.usuariosList.UsuariosListPantalla;

public class PantallasManager {

    public static void changePantalla(Usuario usuario, String from, String to) {
        if("menu".equals(to)){
            if("admin".equals(usuario.getType())){
                AdminMenuPantalla adminMenuPantalla = new AdminMenuPantalla(usuario);
                adminMenuPantalla.setVisible(true);
            }else{

            }
        }else if("usuariosList".equals(to)) {
            UsuariosListPantalla usuariosListPantalla = new UsuariosListPantalla(usuario);
            usuariosListPantalla.setVisible(true);
        }else if("usuarioManager".equals(to)){
            UsuarioManagerPantalla usuarioManagerPantalla = new UsuarioManagerPantalla(usuario);
            usuarioManagerPantalla.setVisible(true);
        }else if("cuentaManager".equals(to)){
            CuentaManagerPantalla cuentaManagerPantalla = new CuentaManagerPantalla(usuario);
            cuentaManagerPantalla.setVisible(true);
        }else if("tarjetaManager".equals(to)){
            TarjetaManagerPantalla tarjetaManagerPantalla = new TarjetaManagerPantalla(usuario);
            tarjetaManagerPantalla.setVisible(true);
        }else if("cuentasOwnList".equals(to)){
            CuentasOwnListPantalla cuentasOwnListPantalla = new CuentasOwnListPantalla(usuario);
            cuentasOwnListPantalla.setVisible(true);
        }else if("logIn".equals(to)){
            LogInPantalla logInPantalla = new LogInPantalla();
            logInPantalla.setVisible(true);
        }
    }
}

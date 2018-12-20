package basico.jdbc;

import modelo.Usuario;
import pantallas.logIn.LogInPantalla;
import pantallas.menues.AdminMenuPantalla;
import pantallas.usuarioManager.UsuarioManagerPantalla;
import pantallas.usuariosList.UsuariosListPantalla;

public class PantallasManager {

//    private LogInPantalla logInPantalla = new LogInPantalla();
//    private UsuariosListPantalla usuarioListPantalla = new UsuariosListPantalla();

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
        }else if("logIn".equals(to)){
            LogInPantalla logInPantalla = new LogInPantalla();
            logInPantalla.setVisible(true);
        }
    }
}

package pantallas;

import pantallas.usuarioList.UsuarioListPantalla;
import pantallas.usuarioManager.UsuarioManagerPantalla;

public class pruebasPantallasTest {

    public static void main(String[] args) {
//        UsuarioManagerPantalla usuarioManagerPantalla = new UsuarioManagerPantalla();
//        usuarioManagerPantalla.setVisible(true);
//        usuarioManagerPantalla.setDefaultCloseOperation(usuarioManagerPantalla.EXIT_ON_CLOSE);

        UsuarioListPantalla usuarioListPantalla = new UsuarioListPantalla();
        usuarioListPantalla.setVisible(true);
        usuarioListPantalla.setDefaultCloseOperation(usuarioListPantalla.EXIT_ON_CLOSE);
    }
}

package pantallas;

import pantallas.usuarioManager.UsuarioManagerPantalla;

public class pruebasPantallasTest {

    public static void main(String[] args) {
        UsuarioManagerPantalla usuarioManagerPantalla = new UsuarioManagerPantalla();
        usuarioManagerPantalla.setVisible(true);
        usuarioManagerPantalla.setDefaultCloseOperation(usuarioManagerPantalla.EXIT_ON_CLOSE);
    }
}

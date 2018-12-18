package basico.jdbc;

import exceptions.ServiceException;
import modelo.Usuario;
import service.UsuarioService;

import javax.swing.*;

public class Main2 {

    public static void main(String[] args) {
        String user = "user1";
        String email = "email1";
        String pass = "pass1";
        Usuario aInsertar = new Usuario();
        aInsertar.setUsername(user);
        aInsertar.setEmail(email);
        aInsertar.setPass(pass);

        try {
            UsuarioService s = new UsuarioService();
            s.crearUsuario(aInsertar);
        } catch (ServiceException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL CREEAR USUARIO");
        }
    }

}

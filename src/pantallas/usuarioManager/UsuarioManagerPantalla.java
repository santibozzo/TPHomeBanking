package pantallas.usuarioManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import exceptions.ServiceException;
import modelo.Usuario;
import service.UsuarioService;

public class UsuarioManagerPantalla extends JFrame implements ActionListener {
    private JTextField usernameTextField;
    private JTextField passwordTextField;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField nombreTextField;
    private JTextField emailTextField;
    private JLabel nombreLabel;
    private JLabel emailLabel;
    private JButton crearUsuarioBoton;
    private JButton modificarUsuarioBoton;
    private JPanel usuarioManagerPanel;
    private JButton eliminarUsuarioBoton;

    public UsuarioManagerPantalla() {
        add(usuarioManagerPanel);
        setTitle("Crear/Modificar usuario");
        setSize(400, 400);

        crearUsuarioBoton.addActionListener(this);
        modificarUsuarioBoton.addActionListener(this);
        eliminarUsuarioBoton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
        if(source instanceof JButton) {
            UsuarioService usuarioService = new UsuarioService();
            String nombre = nombreTextField.getText();
            Usuario usuario = null;
            if("Crear usuario".equals(((JButton) source).getText())){
                try{
                    if(usuarioService.getUsuario(usuario.getUsername()) == null){
                        usuarioService.crearUsuario(usuario);
                    }else{
                        System.out.println("Username ya esta en uso.");
                    }
                }catch(ServiceException e){
                    System.out.println("No se pudo crear el usuario");
                }
            }else if("Modificar usuario".equals(((JButton) source).getText())){
                try{
                    if(usuarioService.getUsuario(usuario.getUsername()) == null){
                        System.out.println("No existe usuario con ese username.");
                    }else{
                        usuarioService.modificarUsuario(usuario);
                    }
                }catch(ServiceException e){
                    System.out.println("No se pudo modificar el usuario");
                }
            }else if("Eliminar usuario".equals(((JButton) source).getText())){
                if(usuarioService.getUsuario(usuario.getUsername()) == null){
                    System.out.println("No existe ese username.");
                }else{
                    usuarioService.borrarUsuario(usuario);
                }
            }
        }
    }
}

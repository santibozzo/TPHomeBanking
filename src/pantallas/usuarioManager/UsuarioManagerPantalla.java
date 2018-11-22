package pantallas.usuarioManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import exceptions.ServicioException;
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

    public UsuarioManagerPantalla() {
        add(usuarioManagerPanel);
        setTitle("Crear/Modificar usuario");
        setSize(400, 400);

        crearUsuarioBoton.addActionListener(this);
        modificarUsuarioBoton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
        if(source instanceof JButton) {
            UsuarioService usuarioService = new UsuarioService();
            Usuario usuario = new Usuario(
                    nombreTextField.getText(),
                    usernameTextField.getText(),
                    passwordTextField.getText(),
                    emailTextField.getText());
            if("Crear usuario".equals(((JButton) source).getText())){
                try{
                    usuarioService.crearUsuario(usuario);
                }catch(ServicioException e){
                    System.out.println("No se pudo crear el usuario");
                }
            }else if("Modificar usuario".equals(((JButton) source).getText())){
                try{
                    usuarioService.modificarUsuario(usuario);
                }catch(ServicioException e){
                    System.out.println("No se pudo modificar el usuario");
                }
            }
        }
    }
}

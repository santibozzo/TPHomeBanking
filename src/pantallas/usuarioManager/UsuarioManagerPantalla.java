package pantallas.usuarioManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import basico.jdbc.PantallasManager;
import exceptions.ServiceException;
import modelo.Usuario;
import service.UsuarioService;

public class UsuarioManagerPantalla extends JFrame implements ActionListener {
    private UsuarioService usuarioService = new UsuarioService();
    private Usuario usuario;

    private JTextField usernameTextField;
    private JTextField passwordTextField;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField nameTextField;
    private JTextField emailTextField;
    private JLabel nombreLabel;
    private JLabel emailLabel;
    private JButton createUsuarioButton;
    private JButton modifyUsuarioButton;
    private JPanel usuarioManagerPanel;
    private JButton deleteUsuarioButton;
    private JLabel typeLabel;
    private JButton backButton;
    private JTextField typeTextField;

    public UsuarioManagerPantalla(Usuario usuario) {
        this.usuario = usuario;
        add(usuarioManagerPanel);
        setTitle("Crear/Modificar usuario");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        backButton.addActionListener(this);
        createUsuarioButton.addActionListener(this);
        modifyUsuarioButton.addActionListener(this);
        deleteUsuarioButton.addActionListener(this);
    }

    private void changePage(String to) {
        setVisible(false);
        dispose();
        PantallasManager.changePantalla(usuario, "usuarioManager", to);
    }

    private Usuario mapInputsToUsuario(){
        Usuario usuario = new Usuario(
                nameTextField.getText(),
                usernameTextField.getText(),
                passwordTextField.getText(),
                emailTextField.getText(),
                typeTextField.getText()
        );
        return usuario;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();

        if(source == createUsuarioButton){
            Usuario newUsuario = usuarioService.getUsuario(usernameTextField.getText());
            String type = typeTextField.getText();
            if(newUsuario != null) {
                System.out.println("Username esta en uso.");
            }else if(!("user".equals(type) || "admin".equals(type))){
                System.out.println("Tipo tiene que ser 'user' o 'admin'");
            }else{
                newUsuario = mapInputsToUsuario();
                usuarioService.createUsuario(newUsuario);
            }
        }else if(source == deleteUsuarioButton){
            Usuario toDeleteUsuario = usuarioService.getUsuario(usernameTextField.getText());
            if(toDeleteUsuario == null){
                System.out.println("Usuario no existe.");
            }else{
                usuarioService.deleteUsuario(toDeleteUsuario);
            }
        }else if(source == modifyUsuarioButton){
            Usuario modifiedUsuario = usuarioService.getUsuario(usernameTextField.getText());
            String type = typeTextField.getText();
            if(modifiedUsuario == null){
                System.out.println("Usuario no existe.");
            }else if(!("user".equals(type) || "admin".equals(type))){
                System.out.println("Tipo tiene que ser 'user' o 'admin'");
            }else{
                modifiedUsuario.setName(nameTextField.getText());
                modifiedUsuario.setEmail(emailTextField.getText());
                modifiedUsuario.setType(typeTextField.getText());
                modifiedUsuario.setPass(passwordTextField.getText());

                usuarioService.modifyUsuario(modifiedUsuario);
            }
        }else if(source == backButton){
            changePage("menu");
        }
    }

}

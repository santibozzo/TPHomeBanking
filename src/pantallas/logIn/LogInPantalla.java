package pantallas.logIn;

import basico.jdbc.PantallasManager;
import modelo.Usuario;
import service.UsuarioService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class LogInPantalla extends JFrame implements ActionListener {
    private UsuarioService usuarioService = new UsuarioService();

    private JPanel logInPanel;
    private JPanel buttonPanel;
    private JButton logInButton;
    private JTextField usernameTextField;
    private JPasswordField passwordTextField;
    private JLabel usernameLabel;
    private JLabel passwordLabel;

    public LogInPantalla() {
        add(logInPanel);
        setTitle("Inicio");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        logInButton.addActionListener(this);
    }

    private void closePantalla(Usuario usuario, String to) {
        setVisible(false);
        dispose();
        PantallasManager.changePantalla(usuario, "logIn", to);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
        if(source == logInButton){
            Usuario usuario = usuarioService.getUsuario(usernameTextField.getText());
            String password = new String(passwordTextField.getPassword());
            if(usuario == null || !password.equals(usuario.getPass())) {
                System.out.println("Usuario o contraseña equivocada.");
            }else{
                closePantalla(usuario, "menu");
            }
        }
    }
}

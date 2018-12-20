package pantallas.menues;

import basico.jdbc.PantallasManager;
import modelo.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserMenuPantalla extends JFrame implements ActionListener {
    private Usuario usuario;

    private JPanel userMenuPanel;
    private JButton logOutButton;
    private JButton cuentasOwnButton;

    public UserMenuPantalla(Usuario usuario) {
        this.usuario = usuario;
        add(userMenuPanel);
        setTitle("Menu principal");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        cuentasOwnButton.addActionListener(this);
        logOutButton.addActionListener(this);
    }

    private void changePantalla(String to) {
        setVisible(false);
        dispose();
        PantallasManager.changePantalla(usuario, "menu", to);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();

        if(source == cuentasOwnButton){
            changePantalla("cuentasOwnList");
        }else if(source == logOutButton){
            changePantalla("logIn");
        }
    }
}

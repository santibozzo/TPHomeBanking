package pantallas.menues;

import basico.jdbc.PantallasManager;
import modelo.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMenuPantalla extends JFrame implements ActionListener {
    private Usuario usuario;

    private JPanel menuPanel;
    private JButton usuariosListButton;
    private JButton logOutButton;
    private JButton usuarioManagerButton;
    private JButton cuentasOwnList;
    private JButton cuentaManagerButton;

    public AdminMenuPantalla(Usuario usuario) {
        this.usuario = usuario;
        add(menuPanel);
        setTitle("Menu principal");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        cuentasOwnList.addActionListener(this);
        usuarioManagerButton.addActionListener(this);
        cuentaManagerButton.addActionListener(this);
        usuariosListButton.addActionListener(this);
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
        if(source == usuariosListButton) {
            changePantalla("usuariosList");
        }else if(source == usuarioManagerButton){
            changePantalla("usuarioManager");
        }else if(source == cuentaManagerButton){
            changePantalla("cuentaManager");
        }else if(source == cuentasOwnList){
            changePantalla("cuentasOwnList");
        }else if(source == logOutButton){
            changePantalla("logIn");
        }
    }
}

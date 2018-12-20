package pantallas.cuentaManager;

import basico.jdbc.PantallasManager;
import modelo.Cuenta;
import modelo.Usuario;
import service.CuentaService;
import service.UsuarioService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CuentaManagerPantalla extends JFrame implements ActionListener {
    private CuentaService cuentaService = new CuentaService();
    private UsuarioService usuarioService = new UsuarioService();
    private Usuario usuario;

    private JPanel cuentaManagerPanel;
    private JPanel buttonsPanel;
    private JTextField aliasTextField;
    private JTextField ownerTextField;
    private JLabel ownerLabel;
    private JLabel aliasLabel;
    private JButton createCuentaButton;
    private JButton deleteCuentaButton;
    private JButton backButton;

    public CuentaManagerPantalla(Usuario usuario) {
        this.usuario = usuario;
        add(cuentaManagerPanel);
        setTitle("Cuenta ABM");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        createCuentaButton.addActionListener(this);
        deleteCuentaButton.addActionListener(this);
        backButton.addActionListener(this);
    }

    private void changePantalla(String to) {
        setVisible(false);
        dispose();
        PantallasManager.changePantalla(usuario, "cuentaManager", to);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();

        if(source == createCuentaButton){
            Cuenta newCuenta = cuentaService.getCuenta(aliasTextField.getText());
            Usuario usuario = usuarioService.getUsuario(ownerTextField.getText());
            if(newCuenta != null){
                System.out.println("Alias ya esta en uso.");
            }else if(usuario == null){
                System.out.println("No existe usuario con ese username.");
            }else{
                newCuenta = new Cuenta(aliasTextField.getText(), ownerTextField.getText());
                cuentaService.createCuenta(newCuenta);
                System.out.println("Cuenta creada.");
            }
        }else if(source == deleteCuentaButton){
            Cuenta toDeleteCuenta = cuentaService.getCuenta(aliasTextField.getText());
            if(toDeleteCuenta == null){
                System.out.println("Cuenta no existe");
            }else{
                cuentaService.deleteCuenta(aliasTextField.getText());
                System.out.println("Cuenta eliminada");
            }
        }else if(source == backButton){
            changePantalla("menu");
        }
    }
}

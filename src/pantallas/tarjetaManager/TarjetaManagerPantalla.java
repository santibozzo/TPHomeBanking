package pantallas.tarjetaManager;

import basico.jdbc.PantallasManager;
import modelo.Tarjeta;
import modelo.Usuario;
import service.TarjetaService;
import service.UsuarioService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TarjetaManagerPantalla extends JFrame implements ActionListener {
    private TarjetaService tarjetaService = new TarjetaService();
    private UsuarioService usuarioService = new UsuarioService();
    private Usuario usuario;

    private JPanel tarjetaManagerPanel;
    private JPanel buttonsPanel;
    private JTextField typeTextField;
    private JButton createTarjetaButton;
    private JButton deleteTarjetaButton;
    private JButton backButton;
    private JTextField ownerTextField;
    private JLabel ownerLabel;
    private JLabel typeLabel;
    private JTextField numberTextField;
    private JLabel numberLabel;

    public TarjetaManagerPantalla(Usuario usuario) {
        this.usuario = usuario;
        add(tarjetaManagerPanel);
        setTitle("ABM Tarjeta");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        createTarjetaButton.addActionListener(this);
        deleteTarjetaButton.addActionListener(this);
        backButton.addActionListener(this);
    }

    private void changePantalla(String to) {
        setVisible(false);
        dispose();
        PantallasManager.changePantalla(usuario, "tarjetaManager", to);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();

        if(source == createTarjetaButton){
            Usuario owner = usuarioService.getUsuario(ownerTextField.getText());
            String type = typeTextField.getText();
            if(owner == null){
                System.out.println("No existe usuario con ese username");
            }else if(!("debito".equals(type) || "credito".equals(type))){
                System.out.println("Tipo tiene que ser 'debito' o 'credito'");
            }else{
                Tarjeta newTarjeta = new Tarjeta(typeTextField.getText(), ownerTextField.getText());
                tarjetaService.createTarjeta(newTarjeta);
                System.out.println("Tarjeta creada");
            }
        }else if(source == deleteTarjetaButton){
            int number = Integer.parseInt(numberTextField.getText());
            Tarjeta toDeleteTarjeta = tarjetaService.getTarjeta(number);
            if(toDeleteTarjeta == null){
                System.out.println("No existe tarjeta con ese numero.");
            }else{
                tarjetaService.deleteTarjeta(number);
                System.out.println("Tarjeta eliminada.");
            }
        }else if(source == backButton){
            changePantalla("menu");
        }
    }
}

package pantallas.movimientoManager;

import basico.jdbc.PantallasManager;
import modelo.Cuenta;
import modelo.Movimiento;
import modelo.Tarjeta;
import modelo.Usuario;
import service.CuentaService;
import service.MovimientoService;
import service.TarjetaService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class MovimientoManagerPantalla extends JFrame implements ActionListener {
    private MovimientoService movimientoService = new MovimientoService();
    private CuentaService cuentaService = new CuentaService();
    private TarjetaService tarjetaService = new TarjetaService();
    private Usuario usuario;

    private JPanel movimientoManagerPanel;
    private JPanel buttonsPanel;
    private JTextField entityIdTextField;
    private JLabel entityIdLabel;
    private JTextField entityTypeTextField;
    private JLabel entityTypeLabel;
    private JTextField movementTypeTextField;
    private JTextField amountTextField;
    private JLabel movementTypeLabel;
    private JLabel amountLabel;
    private JButton createMovimientoButton;
    private JButton backButton;

    public MovimientoManagerPantalla(Usuario usuario) {
        this.usuario = usuario;
        add(movimientoManagerPanel);
        setTitle("Generar movimientos");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        createMovimientoButton.addActionListener(this);
        backButton.addActionListener(this);
    }

    private void changePantalla(String to) {
        setVisible(false);
        dispose();
        PantallasManager.changePantalla(usuario, "movimientoManager", to);
    }

    private void modifyCuenta(Cuenta cuenta, float amount, String movementType) {
        if("debito".equals(movementType)){
            cuenta.setDebit(cuenta.getDebit() + amount);
        }else if("credito".equals(movementType)){
            cuenta.setCredit(cuenta.getCredit() + amount);
        }
        cuentaService.modifyCuenta(cuenta);
    }

    private void modifyTarjeta(Tarjeta tarjeta, float amount, String movementType) {
        if("debito".equals(movementType)){
            tarjeta.setDebit(tarjeta.getDebit() + amount);
        }else if("credito".equals(movementType)){
            tarjeta.setCredit(tarjeta.getCredit() + amount);
        }
        tarjetaService.modifyTarjeta(tarjeta);
    }

    private void createMovimiento(int id, String entityType, float amount, String movementType) {
        Date date = new Date(new java.util.Date().getTime());
        Movimiento movimiento = new Movimiento(id, entityType, amount, date, movementType, movementType);
        movimientoService.createMovimiento(movimiento);
        System.out.println("Movimiento generado.");
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();

        if(source == createMovimientoButton){
            float amount = Float.valueOf(amountTextField.getText());
            String entityType = entityTypeTextField.getText();
            String movementType = movementTypeTextField.getText();
            if(!("debito".equals(movementType) || "credito".equals(movementType))){
                System.out.println("El movimiento tiene que ser 'debito' o 'credito'");
            }else if(!("cuenta".equals(entityType) || "tarjeta".equals(entityType))){
                System.out.println("El tipo de entidad tiene que ser 'cuenta' o 'tarjeta'.");
            }else if("cuenta".equals(entityType)){
                Cuenta cuenta = cuentaService.getCuenta(entityIdTextField.getText());
                if(cuenta == null){
                    System.out.println("No existe cuenta con ese alias.");
                }else{
                    modifyCuenta(cuenta, amount, movementType);
                    createMovimiento(cuenta.getCbu(), "cuenta", amount, movementType);
                }
            }else if("tarjeta".equals(entityType)){
                int number = Integer.parseInt(entityIdTextField.getText());
                Tarjeta tarjeta = tarjetaService.getTarjeta(number);
                if(tarjeta == null){
                    System.out.println("No existe tarjeta con ese numero.");
                }else{
                    modifyTarjeta(tarjeta, amount, movementType);
                    createMovimiento(tarjeta.getNumber(), "tarjeta", amount, movementType);
                }
            }
        }else if(source == backButton){
            changePantalla("menu");
        }
    }
}

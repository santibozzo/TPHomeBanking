package pantallas.transferencias;

import basico.jdbc.PantallasManager;
import modelo.Cuenta;
import modelo.Movimiento;
import modelo.Usuario;
import org.h2.util.StringUtils;
import service.CuentaService;
import service.MovimientoService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class TransferenciaPantalla extends JFrame implements ActionListener {
    private CuentaService cuentaService = new CuentaService();
    private MovimientoService movimientoService = new MovimientoService();
    private Usuario usuario;

    private JPanel transferenciaPanel;
    private JPanel buttonsPanel;
    private JTextField cuentaDestinoTextField;
    private JLabel cuentaDestinoLabel;
    private JTextField amountTextField;
    private JLabel amountLabel;
    private JButton generateTransferenciaButton;
    private JButton backButton;
    private JTextField cuentaOrigenTextField;
    private JLabel cuentaOrigenLabel;

    public TransferenciaPantalla(Usuario usuario) {
        this.usuario = usuario;
        add(transferenciaPanel);
        setTitle("Transferencia");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        generateTransferenciaButton.addActionListener(this);
        backButton.addActionListener(this);
    }

    private void changePantalla(String to){
        setVisible(false);
        dispose();
        PantallasManager.changePantalla(usuario, "transferencias", to);
    }

    private Cuenta getCuenta(String id) {
        Cuenta cuenta = null;
        if(StringUtils.isNumber(id)){
            cuenta = cuentaService.getCuenta(Integer.parseInt(id));
        }else{
            cuenta = cuentaService.getCuenta(id);
        }
        return cuenta;
    }

    private void generateMovimiento(Cuenta cuenta, String movementType, float amount, String description) {
        Date date = new Date(new java.util.Date().getTime());
        Movimiento movimiento = new Movimiento(cuenta.getCbu(), "cuenta", amount, date, movementType, description);
        movimientoService.createMovimiento(movimiento);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();

        if(source == generateTransferenciaButton){
            float amount = Float.valueOf(amountTextField.getText());
            Cuenta cuentaOrigen = getCuenta(cuentaOrigenTextField.getText());
            Cuenta cuentaDestino = getCuenta(cuentaDestinoTextField.getText());
            if(cuentaOrigen == null || cuentaDestino == null){
                System.out.println("Cuentas invalidas.");
            }else{
                cuentaOrigen.setDebit(cuentaOrigen.getDebit() + amount);
                cuentaDestino.setCredit(cuentaDestino.getCredit() + amount);
                cuentaService.modifyCuenta(cuentaOrigen);
                cuentaService.modifyCuenta(cuentaDestino);
                generateMovimiento(cuentaOrigen, "debito", amount, "transferencia a "+cuentaDestino.getAlias());
                generateMovimiento(cuentaDestino, "credito", amount, "transferencia de "+cuentaOrigen.getAlias());
                System.out.println("Transferencia realizada.");
            }
        }else if(source == backButton){
            changePantalla("menu");
        }
    }
}

package pantallas.cuentasList;

import basico.jdbc.PantallasManager;
import modelo.Cuenta;
import modelo.Usuario;
import service.CuentaService;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CuentasOwnListPantalla extends JFrame implements ActionListener {
    private CuentaService cuentaService = new CuentaService();
    private Usuario usuario;
    private String[] columns = {"cbu", "alias", "debito", "credito"};
    private Object[][] rows = new Object[10][4];
    private int page = 0;
    private int size = 10;

    private JPanel cuentasListPanel;
    private JPanel buttonsPanel;
    private JButton backButton;
    private JButton previousPageButton;
    private JButton nextPageButton;
    private JTable cuentasTable;

    public CuentasOwnListPantalla(Usuario usuario) {
        this.usuario = usuario;
        add(cuentasListPanel);
        setTitle("Mis Cuentas");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setRows(page, size);
        refreshRows();
        backButton.addActionListener(this);
        previousPageButton.addActionListener(this);
        nextPageButton.addActionListener(this);
    }

    private void createUIComponents() {
        String[] initColumns = {"cbu", "alias", "debito", "credito"};
        Object[][] initRows = new Object[10][4];
        cuentasTable = new JTable(initRows, initColumns);
    }

    private void changePantalla(String to) {
        setVisible(false);
        dispose();
        PantallasManager.changePantalla(usuario, "cuentasOwnList", to);
    }

    private Object[] cuentaToObject(Cuenta cuenta) {
        Object[] cuentaObject = {
                cuenta.getCbu(),
                cuenta.getAlias(),
                cuenta.getDebit(),
                cuenta.getCredit()
        };
        return cuentaObject;
    }

    private void setRows(int offset, int size) {
        Object[][] rows = new Object[size][4];
        List<Cuenta> cuentasPage = new ArrayList<>();
        if(usuario != null){
            cuentasPage = cuentaService.listCuentasByUsuario(usuario.getUsername(), offset, size);
        }
        for(int i = 0; i < cuentasPage.size(); i++){
            rows[i] = cuentaToObject(cuentasPage.get(i));
        }
        this.rows = rows;
    }

    private void refreshRows() {
        TableModel dataModel = cuentasTable.getModel();
        for(int i = 0; i < cuentasTable.getRowCount(); i++){
            for(int j = 0; j < cuentasTable.getColumnCount(); j++){
                Object value = i < rows.length ? rows[i][j] : null;
                dataModel.setValueAt(value, i, j);
            }
        }
        cuentasTable.setModel(dataModel);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();

        if(source == previousPageButton && page > 0){
            page--;
            setRows(page * size, size);
            refreshRows();
        }else if(source == nextPageButton && rows[size-1][0] != null){
            page++;
            setRows(page * size, size);
            refreshRows();
        }else if(source == backButton){
            changePantalla("menu");
        }
    }

}

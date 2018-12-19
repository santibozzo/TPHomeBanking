package pantallas.usuarioList;

import modelo.Usuario;
import service.UsuarioService;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class UsuarioListPantalla extends JFrame implements ActionListener {

    //private UsuarioService usuarioService = new UsuarioService();
    private String[] columns = {"Id", "Nombre", "Username", "email", "Tipo"};
    private Object[][] rows;
    private int page = 0;
    private int size = 10;

    private JTable usuariosTable;
    private JPanel usuarioListPanel;
    private JPanel buttonPanel;
    private JButton nextPageButton;
    private JButton previousPageButton;
    private JButton backButton;

    public UsuarioListPantalla() {
        add(usuarioListPanel);
        setTitle("Listado usuarios");
        setSize(400, 400);

        backButton.addActionListener(this);
        previousPageButton.addActionListener(this);
        nextPageButton.addActionListener(this);
    }

    private void createUIComponents() {
        setRows(page, size);
        usuariosTable = new JTable(rows, columns);
    }

    private Object[] usuarioToObject(Usuario usuario) {
        Object[] usuarioObject = {
                usuario.getId(),
                usuario.getName(),
                usuario.getUsername(),
                usuario.getEmail(),
                usuario.getType()
        };
        return usuarioObject;
    }

    private void setRows(int offset, int size) {
        UsuarioService usuarioService = new UsuarioService();
        Object[][] rows = new Object[size][5];
        List<Usuario> usuariosPage = usuarioService.listUsuarios(offset, size);
        for(int i = 0; i < usuariosPage.size(); i++){
            rows[i] = usuarioToObject(usuariosPage.get(i));
        }
        this.rows = rows;
    }

    private void refreshRows() {
        TableModel dataModel = usuariosTable.getModel();
        for(int i = 0; i < size; i++){
            for(int j = 0; j < columns.length; j++){
                Object value = i < rows.length ? rows[i][j] : null;
                dataModel.setValueAt(value, i, j);
            }
        }
        usuariosTable.setModel(dataModel);
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
        }
    }
}

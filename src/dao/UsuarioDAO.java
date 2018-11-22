package dao;

import exceptions.DAOException;
import modelo.Usuario;

import java.sql.SQLException;
import java.util.List;

public interface UsuarioDAO {

    public void crearUsuario(Usuario u) throws DAOException;
    public void borrarUsuario(Usuario u);
    public void modificarUsuario(Usuario u) throws DAOException;
    public List<Usuario> listarUsuarios();
    public Usuario consultarUsuario(String username);

}

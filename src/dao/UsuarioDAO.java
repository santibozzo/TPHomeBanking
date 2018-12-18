package dao;

import exceptions.DAOException;
import modelo.Usuario;

import java.sql.SQLException;
import java.util.List;

public interface UsuarioDAO {

    void createUsuario(Usuario u) throws DAOException;
    void deleteUsuario(Usuario u) throws DAOException;
    void modifyUsuario(Usuario u) throws DAOException;
    List<Usuario> listUsuarios() throws DAOException;
    Usuario getUsuario(String username) throws DAOException;

}

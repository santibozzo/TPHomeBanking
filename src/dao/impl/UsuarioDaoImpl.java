package dao.impl;

import basico.jdbc.DBManager;
import dao.UsuarioDAO;
import exceptions.DAOException;
import modelo.Usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDaoImpl implements UsuarioDAO {

    @Override
    public void createUsuario(Usuario unUsuario) throws DAOException {
        String name = unUsuario.getName();
        String user = unUsuario.getUsername();
        String email = unUsuario.getEmail();
        String pass = unUsuario.getPass();
        String type = unUsuario.getType();
        String query = "INSERT INTO usuarios (name, username, email, pass, type) VALUES ('" + name + "', '" + user + "', '" + email + "', '" + pass + "', '" + type + "')";
        try {
            DBManager.executeUpdate(query);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void deleteUsuario(Usuario u) throws DAOException{
        String username = u.getUsername();
        String query = "DELETE FROM usuarios WHERE username = '" + username + "'";
        try {
            DBManager.executeUpdate(query);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void modifyUsuario(Usuario unUsuario) throws DAOException{
        String name = unUsuario.getName();
        String user = unUsuario.getUsername();
        String email = unUsuario.getEmail();
        String pass = unUsuario.getPass();
        String query = "UPDATE usuarios set email = '" + email + "', pass = '" + pass + "', name = '" + name +"' WHERE username = '" + user + "'";
        try {
            DBManager.executeUpdate(query);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    private Usuario mapResultSetToModel(ResultSet result) throws SQLException{
        Usuario usuario = null;
        try {
            if(result.next()){
                usuario = new Usuario(
                        result.getString("name"),
                        result.getString("username"),
                        result.getString("pass"),
                        result.getString("email"),
                        result.getString("type")
                );
                usuario.setId(result.getInt("id"));
            }
        }catch(SQLException e){
            throw e;
        }
        return usuario;
    }

    @Override
    public List<Usuario> listUsuarios() throws DAOException{
        String query = "SELECT * FROM usuarios";
        Connection connection = DBManager.connect();
        List<Usuario> usuarios = new ArrayList<>();
        try {
            ResultSet result = DBManager.executeQuery(query, connection);
            while (!result.isLast()) {
                usuarios.add(mapResultSetToModel(result));
            }
            DBManager.disconnect(connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return usuarios;
    }

    @Override
    public Usuario getUsuario(String username) throws DAOException{
        String query = "SELECT * FROM usuarios WHERE username = '" + username + "'";
        Connection connection = DBManager.connect();
        Usuario usuario = null;
        try {
            ResultSet result = DBManager.executeQuery(query, connection);
            usuario = mapResultSetToModel(result);
            DBManager.disconnect(connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return usuario;
    }
}
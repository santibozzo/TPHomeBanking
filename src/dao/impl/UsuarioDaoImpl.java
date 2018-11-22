package dao.impl;

import basico.jdbc.DBManager;
import dao.UsuarioDAO;
import exceptions.DAOException;
import modelo.Usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDaoImpl implements UsuarioDAO {
    @Override
    public void crearUsuario(Usuario unUsuario) throws DAOException {
        String name = unUsuario.getName();
        String user = unUsuario.getUsername();
        String email = unUsuario.getEmail();
        String pass = unUsuario.getPass();

        String sql = "INSERT INTO usuarios (name, username, email, pass) VALUES ('" + name + "', '" + user + "', '" + email + "', '" + pass + "')";
        Connection c = DBManager.connect();
        try {
            Statement s = c.createStatement();
            s.executeUpdate(sql);
            c.commit();
        } catch (SQLException e) {
            try {
                e.printStackTrace();
                c.rollback();
            } catch (SQLException e1) {
                throw new DAOException(e);
            }
        } finally {
            try {
                c.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    @Override
    public void borrarUsuario(Usuario u) {
        String username = u.getUsername();
        String sql = "DELETE FROM usuarios WHERE user = '" + username + "'";
        Connection c = DBManager.connect();
        try {
            Statement s = c.createStatement();
            s.executeUpdate(sql);
            c.commit();
        } catch (SQLException e) {
            try {
                c.rollback();
                e.printStackTrace();
            } catch (SQLException e1) {
                //no hago nada
            }
        } finally {
            try {
                c.close();
            } catch (SQLException e1) {
                //no hago nada
            }
        }
    }

    @Override
    public void modificarUsuario(Usuario unUsuario) throws DAOException{
        String name = unUsuario.getName();
        String user = unUsuario.getUsername();
        String email = unUsuario.getEmail();
        String pass = unUsuario.getPass();

        String sql = "UPDATE usuarios set email = '" + email + "', pass = '" + pass + "', name = '" + name +"' WHERE username = '" + user + "'";
        Connection c = DBManager.connect();
        try {
            Statement s = c.createStatement();
            s.executeUpdate(sql);
            c.commit();
        } catch (SQLException e) {
            try {
                c.rollback();
                e.printStackTrace();
            } catch (SQLException e1) {
                throw new DAOException(e);
            }
        } finally {
            try {
                c.close();
            } catch (SQLException e1) {
                //no hago nada
            }
        }
    }

    @Override
    public List<Usuario> listarUsuarios() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        Connection c = DBManager.connect();
        try {
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                System.out.println("Usuario:");
                System.out.print("\t" + rs.getInt("id"));
                System.out.print("\t" + rs.getString("user"));
                System.out.print("\t" + rs.getString("email"));
                System.out.println();

            }
        } catch (SQLException e) {
            try {
                c.rollback();
            } catch (SQLException e1) {
                //no hago nada
            }
        } finally {
            try {
                c.close();
            } catch (SQLException e1) {
                //no hago nada
            }
        }
        return lista;
    }

    @Override
    public Usuario consultarUsuario(String username) {
        Usuario resultado = new Usuario();
        String sql = "SELECT * FROM usuarios WHERE user = '" + username + "'";
        Connection c = DBManager.connect();
        try {
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(sql);

            if (rs.next()) {
                System.out.println("Usuario:");
                System.out.print("\t" + rs.getInt("id"));
                System.out.print("\t" + rs.getString("name"));
                System.out.print("\t" + rs.getString("username"));
                System.out.print("\t" + rs.getString("email"));
                System.out.print("\t" + rs.getString("pass"));
                System.out.println();
            }

        } catch (SQLException e) {
            try {
                c.rollback();
                e.printStackTrace();
            } catch (SQLException e1) {
                //no hago nada
            }
        } finally {
            try {
                c.close();
            } catch (SQLException e1) {
                //no hago nada
            }
        }
        return resultado;
    }
}
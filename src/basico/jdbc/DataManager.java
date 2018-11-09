package basico.jdbc;

import modelo.Usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DataManager {

    public void crearUsuario(Usuario unUsuario) {
        String user = unUsuario.getUser();
        String email = unUsuario.getEmail();
        String pass = unUsuario.getPass();

        Connection c = DBManager.connect();
        try {
            Statement s = c.createStatement();
            String sql = "INSERT INTO usuarios (user, email, pass) VALUES ('" + user + "', '" + email + "', '" + pass + "')";
            s.executeUpdate(sql);
            c.commit();
        } catch (SQLException e) {
            try {
                e.printStackTrace();
                c.rollback();
            } catch (SQLException e1) {
                e.printStackTrace();
            }
        } finally {
            try {
                c.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    public void borraUsuario(String username) {
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
                e1.printStackTrace();
            }
        } finally {
            try {
                c.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    public void actualizaUsuario(Usuario unUsuario) {
        String user = unUsuario.getUser();
        String email = unUsuario.getEmail();
        String pass = unUsuario.getPass();

        String sql = "UPDATE usuarios set email = '" + email + "', pass = '" + pass + "' WHERE user = '" + user + "'";
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
                e1.printStackTrace();
            }
        } finally {
            try {
                c.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    public void muestraUsuario(String username) {
        String sql = "SELECT * FROM usuarios WHERE user = '" + username + "'";
        Connection c = DBManager.connect();
        try {
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(sql);

            if (rs.next()) {
                System.out.println("Usuario:");
                System.out.print("\t" + rs.getInt("id"));
                System.out.print("\t" + rs.getString("user"));
                System.out.print("\t" + rs.getString("email"));
                System.out.print("\t" + rs.getString("pass"));
                System.out.println();
            }

        } catch (SQLException e) {
            try {
                c.rollback();
                e.printStackTrace();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                c.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }


    public void muestraTodosLosusuarios() {
        String sql = "SELECT * FROM usuarios";
        Connection c = DBManager.connect();
        try {
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                System.out.println("Usuario:");
                System.out.print("\t" + rs.getString("user"));
                System.out.print("\t" + rs.getString("email"));
                System.out.print("\t" + rs.getString("pass"));
                System.out.println();

            }
        } catch (SQLException e) {
            try {
                c.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                c.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
}

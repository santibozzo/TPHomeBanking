package basico.jdbc;


import exceptions.ServicioException;
import modelo.Usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import service.UsuarioService;


public class DataManager {

    private UsuarioService usuarioService = new UsuarioService();

    public void crearUsuario(Usuario unUsuario) {
        try {
            usuarioService.crearUsuario(unUsuario);
        }catch (ServicioException e){
            e.printStackTrace();
        }
    }

    public void borraUsuario(String username) {
        String sql = "DELETE FROM usuarios WHERE username = '" + username + "'";
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
            usuarioService.actualizarUsuario(unUsuario);
    }

    public void muestraUsuario(String username) {

        String sql = "SELECT * FROM usuarios WHERE username = '" + username + "'";
        Connection c = DBManager.connect();
        try {
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(sql);

            if (rs.next()) {
                System.out.println("Usuario:");
                System.out.print("\t" + rs.getInt("id"));
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
                System.out.print("\t" + rs.getString("username"));
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

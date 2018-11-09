package service;

import dao.UsuarioDAO;
import dao.impl.UsuarioDaoImpl;
import exceptions.DAOException;
import exceptions.ServicioException;
import modelo.Usuario;

import java.util.List;

public class UsuarioService {

    public void crearUsuario(Usuario u) throws ServicioException {
        UsuarioDAO dao = new UsuarioDaoImpl();
        try {
            dao.crearUsuario(u);
        } catch (DAOException e) {
            throw new ServicioException(e);
        }
    }

    public void eliminarUsuario(Usuario u) {
        UsuarioDAO dao = new UsuarioDaoImpl();
        dao.borrarUsuario(u);
    }

    public void actualizarUsuario(Usuario u) {
        UsuarioDAO dao = new UsuarioDaoImpl();
        dao.modificarUsuario(u);
    }

    public List<Usuario> actualizarUsuario() {
        UsuarioDAO dao = new UsuarioDaoImpl();
        return dao.listarUsuarios();
    }

    public Usuario actualizarUsuario(String username) {
        UsuarioDAO dao = new UsuarioDaoImpl();
        return dao.consultarUsuario(username);
    }

}

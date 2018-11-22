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

    public void modificarUsuario(Usuario u) throws ServicioException{
        UsuarioDAO dao = new UsuarioDaoImpl();
        try{
            dao.modificarUsuario(u);
        }catch(DAOException e){
            throw new ServicioException(e);
        }
    }

    public List<Usuario> listarUsuarios() {
        UsuarioDAO dao = new UsuarioDaoImpl();
        return dao.listarUsuarios();
    }

    public Usuario consultarUsuario(String username) {
        UsuarioDAO dao = new UsuarioDaoImpl();
        return dao.consultarUsuario(username);
    }


}

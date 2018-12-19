package service;

import dao.UsuarioDAO;
import dao.impl.UsuarioDaoImpl;
import exceptions.DAOException;
import exceptions.ServiceException;
import modelo.Usuario;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioService {

    private UsuarioDAO usuarioDao = new UsuarioDaoImpl();

    public void crearUsuario(Usuario u) throws ServiceException {
        try {
            usuarioDao.createUsuario(u);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public void borrarUsuario(Usuario u) throws ServiceException {
        try {
            usuarioDao.deleteUsuario(u);
        }catch(DAOException e){
            throw new ServiceException();
        }
    }

    public void modificarUsuario(Usuario u) throws ServiceException {
        try{
            usuarioDao.modifyUsuario(u);
        }catch(DAOException e){
            throw new ServiceException(e);
        }
    }

    public List<Usuario> listUsuarios() throws ServiceException {
        try {
            return usuarioDao.listUsuarios();
        }catch(DAOException e){
            throw new ServiceException();
        }
    }

    public List<Usuario> listUsuarios(int offset, int size) throws ServiceException {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            usuarios = usuarioDao.listUsuarios();
        }catch(DAOException e) {
            throw new ServiceException(e);
        }
        return usuarios.subList(offset < usuarios.size() ? offset : 0, offset + size < usuarios.size() ? offset + size : usuarios.size());
    }

    public Usuario getUsuario(String username) throws ServiceException {
        try {
            Usuario usuario = usuarioDao.getUsuario(username);
            return usuario;
        }catch(DAOException e){
            throw new ServiceException();
        }
    }


}

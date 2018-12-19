package service;

import dao.TarjetaDAO;
import dao.impl.TarjetaDaoImpl;
import exceptions.DAOException;
import exceptions.ServiceException;
import modelo.Tarjeta;

import javax.xml.ws.Service;
import java.util.List;

public class TarjetaService {

    private TarjetaDAO tarjetaDao = new TarjetaDaoImpl();

    public void createTarjeta(Tarjeta tarjeta) throws ServiceException {
        try {
            tarjetaDao.crearTarjeta(tarjeta);
        }catch(DAOException e) {
            throw new ServiceException(e);
        }
    }

    public void deleteTarjeta(int number) throws ServiceException {
        try {
            tarjetaDao.deleteTarjeta(number);
        }catch(DAOException e) {
            throw new ServiceException(e);
        }
    }

    public void modifyTarjeta(Tarjeta tarjeta) throws ServiceException {
        try {
            tarjetaDao.modifyTarjeta(tarjeta);
        }catch(DAOException e) {
            throw new ServiceException(e);
        }
    }

    public Tarjeta getTarjeta(int number) throws ServiceException {
        try {
            return tarjetaDao.getTarjeta(number);
        }catch(DAOException e) {
            throw new ServiceException(e);
        }
    }

    public List<Tarjeta> listTarjetas() throws ServiceException {
        try {
            return tarjetaDao.listTarjeta();
        }catch(DAOException e) {
            throw new ServiceException(e);
        }
    }
}

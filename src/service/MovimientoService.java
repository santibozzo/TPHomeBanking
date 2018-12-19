package service;

import dao.impl.MovimientoDaoImpl;
import exceptions.DAOException;
import exceptions.ServiceException;
import modelo.Movimiento;

import java.util.List;

public class MovimientoService {

    private MovimientoDaoImpl movimientoDao = new MovimientoDaoImpl();

    public void createMovimiento(Movimiento movimiento) throws ServiceException {
        try {
            movimientoDao.createMovimiento(movimiento);
        }catch(DAOException e) {
            throw new ServiceException(e);
        }
    }

    public void deleteMovimiento(int id) throws ServiceException {
        try {
            movimientoDao.deleteMovimiento(id);
        }catch(DAOException e) {
            throw new ServiceException(e);
        }
    }

    public Movimiento getMovimiento(int id) throws ServiceException {
        try {
            return movimientoDao.getMovimiento(id);
        }catch(DAOException e) {
            throw new ServiceException(e);
        }
    }

    public List<Movimiento> listMovimientos() throws ServiceException {
        try {
            return movimientoDao.listMovimientos();
        }catch(DAOException e) {
            throw new ServiceException(e);
        }
    }
}

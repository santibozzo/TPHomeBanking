package service;

import dao.impl.CuentaDaoImpl;
import exceptions.DAOException;
import exceptions.ServiceException;
import modelo.Cuenta;

import java.util.List;


public class CuentaService {

    private CuentaDaoImpl cuentaDao = new CuentaDaoImpl();

    public void createCuenta(Cuenta cuenta) throws ServiceException {
        try {
            cuentaDao.createCuenta(cuenta);
        }catch(DAOException e) {
            throw new ServiceException(e);
        }
    }

    public void deleteCuenta(int cbu) throws ServiceException {
        try {
            cuentaDao.deleteCuenta(cbu);
        }catch(DAOException e) {
            throw new ServiceException(e);
        }
    }

    public void deleteCuenta(String alias) throws ServiceException {
        try {
            cuentaDao.deleteCuenta(alias);
        }catch(DAOException e) {
            throw new ServiceException(e);
        }
    }

    public void modifyCuenta(Cuenta cuenta) throws ServiceException {
        try {
            cuentaDao.modifyCuenta(cuenta);
        }catch(DAOException e) {
            throw new ServiceException(e);
        }
    }

    public Cuenta getCuenta(int cbu) throws ServiceException {
        try {
            return cuentaDao.getCuenta(cbu);
        }catch(DAOException e) {
            throw new ServiceException(e);
        }
    }

    public Cuenta getCuenta(String alias) throws ServiceException {
        try {
            return cuentaDao.getCuenta(alias);
        }catch(DAOException e) {
            throw new ServiceException(e);
        }
    }

    public List<Cuenta> listCuentas() throws ServiceException {
        try {
            return cuentaDao.listCuentas();
        }catch(DAOException e) {
            throw new ServiceException(e);
        }
    }
}

package dao;

import java.util.List;

import modelo.Cuenta;
import exceptions.DAOException;

public interface CuentaDAO {

    void createCuenta(Cuenta cuenta) throws DAOException;
    void deleteCuenta(int cbu) throws DAOException;
    void deleteCuenta(String alias) throws DAOException;
    void modifyCuenta(Cuenta cuenta) throws DAOException;
    Cuenta getCuenta(int cbu) throws DAOException;
    Cuenta getCuenta(String alias) throws DAOException;
    List<Cuenta> listCuentas() throws DAOException;
    List<Cuenta> listCuentasByUsuario(String username) throws DAOException;
}

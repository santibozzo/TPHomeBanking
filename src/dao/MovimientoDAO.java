package dao;

import exceptions.DAOException;
import modelo.Movimiento;

import java.util.List;

public interface MovimientoDAO {

    void createMovimiento(Movimiento movimiento) throws DAOException;
    void deleteMovimiento(int id) throws DAOException;
    Movimiento getMovimiento(int id) throws DAOException;
    List<Movimiento> listMovimientos() throws DAOException;
}

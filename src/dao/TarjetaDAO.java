package dao;

import exceptions.DAOException;
import modelo.Tarjeta;

import java.util.List;

public interface TarjetaDAO {

    void crearTarjeta(Tarjeta tarjeta) throws DAOException;
    void deleteTarjeta(int number) throws DAOException;
    void modifyTarjeta(Tarjeta tarjeta) throws DAOException;
    Tarjeta getTarjeta(int number) throws DAOException;
    List<Tarjeta> listTarjeta() throws DAOException;

}

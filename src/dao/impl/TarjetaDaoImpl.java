package dao.impl;

import basico.jdbc.DBManager;
import dao.TarjetaDAO;
import exceptions.DAOException;
import modelo.Tarjeta;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TarjetaDaoImpl implements TarjetaDAO {


    @Override
    public void crearTarjeta(Tarjeta tarjeta) throws DAOException {
        String type = tarjeta.getType();
        String owner = tarjeta.getOwner();
        float debit = tarjeta.getDebit();
        float credit = tarjeta.getCredit();
        String query = "INSERT INTO tarjetas (type, owner, debit, credit) VALUES ( '"+type+"', '"+owner+"', '"+debit+"', '"+credit+"' )";
        try {
            DBManager.executeUpdate(query);
        }catch(SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void deleteTarjeta(int number) throws DAOException {
        String query = "DELETE FROM tarjetas WHERE number = '"+number+"'";
        try {
            DBManager.executeUpdate(query);
        }catch(SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void modifyTarjeta(Tarjeta tarjeta) throws DAOException {
        int number = tarjeta.getNumber();
        float debit = tarjeta.getDebit();
        float credit = tarjeta.getCredit();
        String query = "UPDATE tarjetas SET debit = '"+debit+"', credit = '"+credit+"' WHERE number = '"+number+"'";
        try {
            DBManager.executeUpdate(query);
        }catch(SQLException e) {
            throw new DAOException(e);
        }
    }

    private Tarjeta mapResultSetToModel(ResultSet result) throws SQLException{
        Tarjeta tarjeta = null;
        try {
            if(result.next()){
                tarjeta = new Tarjeta(
                        result.getString("type"),
                        result.getString("owner"),
                        result.getFloat("debit"),
                        result.getFloat("credit")
                );
                tarjeta.setNumber(result.getInt("number"));
            }
        }catch(SQLException e){
            throw e;
        }
        return tarjeta;
    }

    @Override
    public Tarjeta getTarjeta(int number) throws DAOException {
        String query = "SELECT * FROM tarjetas WHERE number = '"+number+"'";
        Connection connection = DBManager.connect();
        Tarjeta tarjeta = null;
        try {
            ResultSet result = DBManager.executeQuery(query, connection);
            tarjeta = mapResultSetToModel(result);
            DBManager.disconnect(connection);
        }catch(SQLException e) {
            throw new DAOException(e);
        }
        return tarjeta;
    }

    @Override
    public List<Tarjeta> listTarjeta() throws DAOException {
        String query = "SELECT * FROM tarjetas";
        Connection connection = DBManager.connect();
        List<Tarjeta> tarjetas = new ArrayList<>();
        try {
            ResultSet result = DBManager.executeQuery(query, connection);
            while(!result.isLast()){
                tarjetas.add(mapResultSetToModel(result));
            }
            DBManager.disconnect(connection);
        }catch(SQLException e) {
            throw new DAOException(e);
        }
        return tarjetas;
    }
}

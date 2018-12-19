package dao.impl;

import basico.jdbc.DBManager;
import dao.MovimientoDAO;
import exceptions.DAOException;
import modelo.Movimiento;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovimientoDaoImpl implements MovimientoDAO {

    @Override
    public void createMovimiento(Movimiento movimiento) throws DAOException {
        int entityId = movimiento.getEntityId();
        String entityType = movimiento.getEntityType();
        float amount = movimiento.getAmount();
        Date date = movimiento.getDate();
        String movementType = movimiento.getMovementType();
        String description = movimiento.getDescription();
        String query = "INSERT INTO movimientos (entityId, entityType, amount, date, movementType, description) VALUES ('"+entityId+"', '"+entityType+"', '"+amount+"', '"+date+"', '"+movementType+"', '"+description+"')";
        try {
            DBManager.executeUpdate(query);
        }catch(SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void deleteMovimiento(int id) throws DAOException {
        String query = "DELETE FROM movimientos WHERE id = '"+id+"'";
        try {
            DBManager.executeUpdate(query);
        }catch(SQLException e) {
            throw new DAOException(e);
        }
    }

    private Movimiento mapResultSetToModel(ResultSet result) throws SQLException{
        Movimiento movimiento = null;
        try {
            if(result.next()){
                movimiento = new Movimiento(
                        result.getInt("entityId"),
                        result.getString("entityType"),
                        result.getFloat("amount"),
                        result.getDate("date"),
                        result.getString("movementType"),
                        result.getString("description")
                );
                movimiento.setMovementId(result.getInt("id"));
            }
        }catch(SQLException e){
            throw e;
        }
        return movimiento;
    }

    @Override
    public Movimiento getMovimiento(int id) throws DAOException {
        String query = "SELECT * FROM movimientos WHERE id = '"+id+"'";
        Connection connection = DBManager.connect();
        Movimiento movimiento = null;
        try {
            ResultSet result = DBManager.executeQuery(query, connection);
            movimiento = mapResultSetToModel(result);
            DBManager.disconnect(connection);
        }catch(SQLException e) {
            throw new DAOException(e);
        }
        return movimiento;
    }

    @Override
    public List<Movimiento> listMovimientos() throws DAOException {
        String query = "SELECT * FROM movimientos";
        Connection connection = DBManager.connect();
        List<Movimiento> movimientos = new ArrayList<>();
        try {
            ResultSet result = DBManager.executeQuery(query, connection);
            while(!result.isLast()){
                movimientos.add(mapResultSetToModel(result));
            }
            DBManager.disconnect(connection);
        }catch(SQLException e) {
            throw new DAOException(e);
        }
        return movimientos;
    }
}

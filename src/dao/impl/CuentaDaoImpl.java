package dao.impl;

import basico.jdbc.DBManager;
import dao.CuentaDAO;
import exceptions.DAOException;
import modelo.Cuenta;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CuentaDaoImpl implements CuentaDAO {

    @Override
    public void createCuenta(Cuenta cuenta) throws DAOException {
        String alias = cuenta.getAlias();
        String owner = cuenta.getOwner();
        float debit = cuenta.getDebit();
        float credit = cuenta.getCredit();
        String query = "INSERT INTO cuentas (alias, owner, debit, credit) VALUES ('"+alias+"', '"+owner+"', '"+debit+"', '"+credit+"')";
        try {
            DBManager.executeUpdate(query);
        }catch(SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void deleteCuenta(int cbu) throws DAOException{
        String query = "DELETE FROM cuentas WHERE cbu = '"+cbu+"'";
        try {
            DBManager.executeUpdate(query);
        }catch(SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void deleteCuenta(String alias) throws DAOException{
        String query = "DELETE FROM cuentas WHERE alias = '"+alias+"'";
        try {
            DBManager.executeUpdate(query);
        }catch(SQLException e){
            throw new DAOException(e);
        }
    }

    @Override
    public void modifyCuenta(Cuenta cuenta) throws DAOException {
        int cbu = cuenta.getCbu();
        double debit = cuenta.getDebit();
        double credit = cuenta.getCredit();
        String query = "UPDATE cuentas SET debit = '"+debit+"', credit = '"+credit+"' WHERE cbu = '"+cbu+"'";
        try {
            DBManager.executeUpdate(query);
        }catch(SQLException e) {
            throw new DAOException(e);
        }
    }

    private Cuenta mapResultSetToModel(ResultSet result) throws SQLException{
        Cuenta cuenta = null;
        try {
            if(result.next()){
                cuenta = new Cuenta(
                        result.getString("alias"),
                        result.getString("owner"),
                        result.getFloat("debit"),
                        result.getFloat("credit")
                );
                cuenta.setCbu(result.getInt("cbu"));
            }
        }catch(SQLException e){
            throw e;
        }
        return cuenta;
    }

    @Override
    public Cuenta getCuenta(int cbu) throws DAOException {
        String query = "SELECT * FROM cuentas WHERE cbu = '"+cbu+"'";
        Connection connection = DBManager.connect();
        Cuenta cuenta = null;
        try {
            ResultSet result = DBManager.executeQuery(query, connection);
            cuenta = mapResultSetToModel(result);
            DBManager.disconnect(connection);
        }catch(SQLException e){
            throw new DAOException(e);
        }
        return cuenta;
    }

    @Override
    public Cuenta getCuenta(String alias) throws DAOException {
        String query = "SELECT * FROM cuentas WHERE alias = '"+alias+"'";
        Connection connection = DBManager.connect();
        Cuenta cuenta = null;
        try {
            ResultSet result = DBManager.executeQuery(query, connection);
            cuenta = mapResultSetToModel(result);
            DBManager.disconnect(connection);
        }catch(SQLException e){
            throw new DAOException(e);
        }
        return cuenta;
    }

    @Override
    public List<Cuenta> listCuentas() throws DAOException{
        String query = "SELECT * FROM cuentas";
        Connection connection = DBManager.connect();
        List<Cuenta> cuentas = new ArrayList<>();
        try {
            ResultSet result = DBManager.executeQuery(query, connection);
            while(!result.isLast()){
                cuentas.add(mapResultSetToModel(result));
            }
            DBManager.disconnect(connection);
        }catch(SQLException e) {
            throw new DAOException(e);
        }
        return cuentas;
    }

    @Override
    public List<Cuenta> listCuentasByUsuario(String username) throws DAOException {
        String query = "SELECT * FROM cuentas WHERE owner = '"+username+"'";
        Connection connection = DBManager.connect();
        List<Cuenta> cuentas = new ArrayList<>();
        try {
            ResultSet result = DBManager.executeQuery(query, connection);
            boolean isEmpty = !result.isBeforeFirst();
            boolean firstIter = true;
            while(!result.isLast() && !isEmpty){
                if(firstIter){
                    firstIter = false;
                    result.beforeFirst();
                }
                cuentas.add(mapResultSetToModel(result));
            }
            DBManager.disconnect(connection);
        }catch(SQLException e) {
            throw new DAOException(e);
        }
        return cuentas;
    }
}

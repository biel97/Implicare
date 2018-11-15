/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.util.db;

/**
 *
 * @author Gabriel
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.security.util.Password;

public class JDBCPostegresqlConnection extends JDBCPassword implements JDBCConnectionFactory {

    private final static String dbDriver = "org.postgresql.Driver";

    public JDBCPostegresqlConnection() {
    }

    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(dbDriver);
        return DriverManager.getConnection(dbURL, user, pass);
    }
    
    public static void main(String[] args) {
        try {
            JDBCConnectionFactory cf = new JDBCPostegresqlConnection();            
            cf.getConnection();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(JDBCPostegresqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
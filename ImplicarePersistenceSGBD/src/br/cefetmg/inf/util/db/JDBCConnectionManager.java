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
import java.sql.SQLException;

public class JDBCConnectionManager {
  
    private static JDBCConnectionManager conexao;
    private static JDBCConnectionFactory cf;

    private JDBCConnectionManager() {
         JDBCConnectionManager.cf = new JDBCPostegresqlConnection();
    }

    public static JDBCConnectionManager getInstance() {
        if(conexao == null)
            conexao = new JDBCConnectionManager();

        return conexao;
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {

        return JDBCConnectionManager.cf.getConnection();
    }
}

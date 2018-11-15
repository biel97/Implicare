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

public interface JDBCConnectionFactory {

    public Connection getConnection() throws ClassNotFoundException, SQLException;
}

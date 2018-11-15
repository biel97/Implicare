/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.daoImpl;

import br.cefetmg.implicare.dao.EstadoDao;
import br.cefetmg.implicare.model.domain.Estado;
import br.cefetmg.implicare.model.exception.PersistenceException;
import br.cefetmg.inf.util.db.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 * 
 */

public class EstadoDaoImpl implements EstadoDao {

    @Override
    public ArrayList<Estado> listar() throws PersistenceException {
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Estado ORDER BY Nom_Estado;";

            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            ArrayList<Estado> lista = new ArrayList<>();
            
            if (rs.next()) {
                do {
                    Estado Est = new Estado();
                    Est.setCod_Estado(rs.getInt("Cod_Estado"));
                    Est.setNom_Estado(rs.getString("Nom_Estado"));
                    lista.add(Est);
                } while (rs.next());
            }

            rs.close();
            ps.close();
            connection.close();

            return lista;
            
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.toString());
            return null;
        }
    }

    @Override
    public Estado pesquisar(int Cod_Estado) throws PersistenceException {
        try {
           Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Estado WHERE Cod_Estado = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, Cod_Estado);
            ResultSet rs = ps.executeQuery();

            Estado Est = new Estado();
            
            if (rs.next()) {
                Est.setCod_Estado(rs.getInt("Cod_Estado"));
                Est.setNom_Estado(rs.getString("Nom_Razao_Social"));
            }

            rs.close();
            ps.close();
            connection.close();

            return Est;
            
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
    
}

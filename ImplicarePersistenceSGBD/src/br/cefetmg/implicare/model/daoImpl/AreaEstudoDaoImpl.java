/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.daoImpl;

import br.cefetmg.implicare.dao.AreaEstudoDao;
import br.cefetmg.implicare.model.domain.AreaEstudo;
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

public class AreaEstudoDaoImpl implements AreaEstudoDao {

    @Override
    public ArrayList<AreaEstudo> listar() throws PersistenceException {
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Area_Estudo ORDER BY Nom_Area_Estudo;";

            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            ArrayList<AreaEstudo> lista = new ArrayList<>();
            
            if (rs.next()) {
                do {
                    AreaEstudo Area = new AreaEstudo();
                    Area.setCod_Area_Estudo(rs.getInt("Cod_Area_Estudo"));
                    Area.setNom_Area_Estudo(rs.getString("Nom_Area_Estudo"));
                    lista.add(Area);
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
    public AreaEstudo pesquisar(int Cod_Area_Estudo) throws PersistenceException {
        try {
           Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Area_Estudo WHERE Cod_Area_Estudo = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, Cod_Area_Estudo);
            ResultSet rs = ps.executeQuery();

            AreaEstudo Area = new AreaEstudo();
            
            if (rs.next()) {
                Area.setCod_Area_Estudo(rs.getInt("Cod_Area_Estudo"));
                Area.setNom_Area_Estudo(rs.getString("Nom_Area_Estudo"));
            }

            rs.close();
            ps.close();
            connection.close();

            return Area;
            
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
    
}

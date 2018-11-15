/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.daoImpl;

import br.cefetmg.implicare.dao.CidadeDao;
import br.cefetmg.implicare.model.domain.Cidade;
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

public class CidadeDaoImpl implements CidadeDao {

    @Override
    public ArrayList<Cidade> listar(int Cod_Estado) throws PersistenceException {
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Cidade WHERE Cod_Estado = ? ORDER BY Nom_Cidade;";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, Cod_Estado);
            ResultSet rs = ps.executeQuery();

            ArrayList<Cidade> lista = new ArrayList<>();
            
            if (rs.next()) {
                do {
                    Cidade Cid = new Cidade();
                    Cid.setCod_Estado(rs.getInt("Cod_Estado"));
                    Cid.setCod_Cidade(rs.getInt("Cod_Cidade"));
                    Cid.setNom_Cidade(rs.getString("Nom_Cidade"));
                    lista.add(Cid);
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
    public Cidade pesquisar(int Cod_Cidade) throws PersistenceException {
        try {
           Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Cidade WHERE Cod_Estado = ?, Cod_Cidade = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setInt(1, Cod_Cidade);
            
            ResultSet rs = ps.executeQuery();

            Cidade Cid = new Cidade();
            
            if (rs.next()) {
                Cid.setCod_Estado(rs.getInt("Cod_Estado"));
                Cid.setCod_Cidade(rs.getInt("Cod_Cidade"));
                Cid.setNom_Cidade(rs.getString("Nom_Cidade"));
            }

            rs.close();
            ps.close();
            connection.close();

            return Cid;
            
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
    
}

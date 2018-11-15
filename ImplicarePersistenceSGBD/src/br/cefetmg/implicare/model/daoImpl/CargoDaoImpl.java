/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.daoImpl;

import br.cefetmg.implicare.dao.CargoDao;
import br.cefetmg.implicare.model.domain.Cargo;
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

public class CargoDaoImpl implements CargoDao{

    @Override
    public ArrayList<Cargo> listar() throws PersistenceException {
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Cargo ORDER BY Nom_Cargo;";

            PreparedStatement ps = connection.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();

            ArrayList<Cargo> lista = new ArrayList<>();
            
            if (rs.next()) {
                do {
                    Cargo Car = new Cargo();
                    Car.setCod_Cargo(rs.getInt("Cod_Cargo"));
                    Car.setNom_Cargo(rs.getString("Nom_Cargo"));
                    lista.add(Car);
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
    public ArrayList<Cargo> listarCargoAreaEstudo(long CPF) throws PersistenceException {
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            ArrayList<Cargo> lista = new ArrayList<>();
            
            String sql = "SELECT * FROM Cargo A"
                    + "JOIN Cargo_AreaEstudo B ON "
                    + "A.Cod_Cargo = B.Cod_Cargo"
                    + "JOIN Formacao_Academica C"
                    + "B.Cod_Area_Estudo = C.Cod_Area_Estudo"
                    + "WHERE C.CPF = ?";
                
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, CPF);
            ResultSet rs = ps.executeQuery();
            
             if (rs.next()) {
                do {
                    Cargo Car = new Cargo();

                    Car.setCod_Cargo(rs.getInt("A.Cod_Cargo"));
                    Car.setNom_Cargo(rs.getString("A.Nom_Cargo"));
                    lista.add(Car);
                    
                }while (rs.next());
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
    public Cargo pesquisar(int Cod_Cargo) throws PersistenceException {
        try {
           Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Cargo WHERE Cod_Cargo = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, Cod_Cargo);
            ResultSet rs = ps.executeQuery();

            Cargo Car = new Cargo();
            
            if (rs.next()) {
                Car.setCod_Cargo(rs.getInt("Cod_Cargo"));
                Car.setNom_Cargo(rs.getString("Nom_Cargo"));
            }

            rs.close();
            ps.close();
            connection.close();

            return Car;
            
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
    
}

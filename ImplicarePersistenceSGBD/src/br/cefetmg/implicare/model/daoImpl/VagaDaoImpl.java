/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.daoImpl;

import br.cefetmg.implicare.dao.VagaDao;
import br.cefetmg.implicare.model.domain.Vaga;
import br.cefetmg.implicare.model.exception.PersistenceException;
import br.cefetmg.inf.util.db.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 * 
 */

public class VagaDaoImpl implements VagaDao{
    
    @Override
    public boolean insert(Vaga Vaga) throws PersistenceException{
        try {
                    
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO Vaga (CNPJ, Cod_Cargo, Dat_Publicacao, Num_Vagas,"
                    + "Carga_Horaria, Remuneracao, Desc_Vaga, Status_Vaga) "
                    + "VALUES(?,?,?,?,?,?,?,?)";

            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setLong(1, Vaga.getCNPJ());
            ps.setInt(2, Vaga.getCod_Cargo());
            ps.setDate(3, Vaga.getDat_Publicacao());
            ps.setInt(4, Vaga.getNum_Vagas());
            ps.setInt(5, Vaga.getCarga_Horaria());
            ps.setDouble(6, Vaga.getRemuneracao());
            ps.setString(7, Vaga.getDesc_Vaga());
            ps.setInt(8, Vaga.getStatus_Vaga());
            
            ResultSet rs = ps.executeQuery();

            rs.close();
            ps.close();
            connection.close();
            
            return true;

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.toString());
            return false;
        }
    }
    
    @Override
    public boolean update(Vaga Vaga) throws PersistenceException{
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();
            
            String SQL = "UPDATE Vaga SET Cod_Cargo = ?, Num_Vagas = ?, Carga_Horaria = ?,"
                    + "Remuneracao = ?, Desc_Vaga = ?, Status_Vaga = ?"
                    + " WHERE Seq_Vaga = ?";
            
            PreparedStatement ps = connection.prepareStatement(SQL);
       
            ps.setInt(1, Vaga.getCod_Cargo());
            ps.setInt(2, Vaga.getNum_Vagas());
            ps.setInt(3, Vaga.getCarga_Horaria());
            ps.setDouble(4, Vaga.getRemuneracao());
            ps.setString(5, Vaga.getDesc_Vaga());
            ps.setInt(6, Vaga.getStatus_Vaga());
            ps.setInt(7, Vaga.getSeq_Vaga());
            
            ps.executeQuery(SQL);
            ps.close();
            connection.close();
            return true;
            
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }
    }
    
    @Override
    public boolean delete(Vaga Vaga) throws PersistenceException{
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();
            
            String SQL = "DELETE FROM Vaga"
                    + "WHERE Seq_Vaga";
            
            PreparedStatement ps = connection.prepareStatement(SQL);
            
            ps.setInt(1, Vaga.getSeq_Vaga());
            
            ps.executeQuery(SQL);
            ps.close();
            connection.close();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.toString());
            return false;
        }
    }
    
    @Override
    public ArrayList<Vaga> listarVagaEmpresa(long CNPJ) throws PersistenceException {
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Vaga WHERE CNPJ = ? ORDER BY Cod_Cargo, Dat_Publicacao";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, CNPJ);
            ResultSet rs = ps.executeQuery();

            ArrayList<Vaga> lista = new ArrayList<>();
            
            if (rs.next()) {
                do {
                    Vaga Vag = new Vaga();
                    
                    Vag.setCNPJ(rs.getLong("CNPJ"));
                    Vag.setSeq_Vaga(rs.getInt("Seq_Vaga"));
                    Vag.setCod_Cargo(rs.getInt("Cod_Cargo"));
                    Vag.setDat_Publicacao(rs.getDate("Dat_Publicacao"));
                    Vag.setNum_Vagas(rs.getInt("Num_Vagas"));
                    Vag.setCarga_Horaria(rs.getInt("Caraga_Horaria"));
                    Vag.setRemuneracao(rs.getDouble("Remuneracao"));
                    Vag.setDesc_Vaga(rs.getString("Desc_Vaga"));
                    Vag.setStatus_Vaga(rs.getInt("Status_Vaga"));
                    
                    lista.add(Vag);
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
    public ArrayList<Vaga> listarVagaCandidato(long CPF) throws PersistenceException{
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            ArrayList<Vaga> lista = new ArrayList<>();
            
            String sql = "SELECT * FROM Vaga A "
                    + "JOIN Cargo_Interesse B ON"
                    + "A.Cod_Cargo = B.Cod_Cargo"
                    + "WHERE B.CPF = ? ORDER BY A.Cod_Cargo, A.Dat_Publicacao";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, CPF);
            ResultSet rs = ps.executeQuery();
                
            if (rs.next()) {
                do{
                    Vaga Vag = new Vaga();

                    Vag.setCNPJ(rs.getLong("CNPJ"));
                    Vag.setSeq_Vaga(rs.getInt("Seq_Vaga"));
                    Vag.setCod_Cargo(rs.getInt("Cod_Cargo"));
                    Vag.setDat_Publicacao(rs.getDate("Dat_Publicacao"));
                    Vag.setNum_Vagas(rs.getInt("Num_Vagas"));
                    Vag.setCarga_Horaria(rs.getInt("Caraga_Horaria"));
                    Vag.setRemuneracao(rs.getDouble("Remuneracao"));
                    Vag.setDesc_Vaga(rs.getString("Desc_Vaga"));
                    Vag.setStatus_Vaga(rs.getInt("Status_Vaga"));

                    lista.add(Vag);
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

}

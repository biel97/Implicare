/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.daoImpl;

import br.cefetmg.implicare.dao.CandidatoVagaDao;
import br.cefetmg.implicare.model.domain.CandidatoVaga;
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

public class CandidatoVagaDaoImpl implements CandidatoVagaDao {

    @Override
    public boolean insert(CandidatoVaga CandidatoVaga) throws PersistenceException {
        try {
                    
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO Candidato_Vaga (CPF, Cod_Cargo, CNPJ,"
                    + "Dat_Publicacao, Status_Candidato) VALUES(?,?,?,?,?)";

            PreparedStatement ps = connection.prepareStatement(sql);
           
            ps.setLong(1, CandidatoVaga.getCPF());
            ps.setInt(2, CandidatoVaga.getCod_Cargo());
            ps.setLong(3, CandidatoVaga.getCNPJ());
            ps.setDate(4, CandidatoVaga.getDat_Publicacao());
            ps.setString(5, CandidatoVaga.getStatus_Candidato());
            
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
    public boolean update(CandidatoVaga CandidatoVaga) throws PersistenceException {
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();
            
            String SQL = "UPDATE Candidato_Vaga SET Status_Candidato = ? "
                    + "WHERE CPF = ? , Seq_Vaga = ?";
            
            PreparedStatement ps = connection.prepareStatement(SQL);
            
            ps.setString(1, CandidatoVaga.getStatus_Candidato());
            ps.setLong(2, CandidatoVaga.getCPF());
            ps.setInt(3, CandidatoVaga.getSeq_Vaga());
            
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
   public ArrayList<CandidatoVaga> listar(int Seq_Vaga) throws PersistenceException {
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();
            
            String SQL = "SELECT * FROM Candidato_Vaga"
                    + "WHERE Seq_Vaga = ?";
            
            PreparedStatement ps = connection.prepareStatement(SQL);
            
            ps.setInt(1, Seq_Vaga);
            
            ResultSet rs = ps.executeQuery(SQL);
            
            ArrayList<CandidatoVaga> lista = new ArrayList();
            CandidatoVaga Cand = new CandidatoVaga();
            
            while (rs.next()) {
                Cand.setCPF(rs.getLong("CPF"));
                Cand.setSeq_Vaga(rs.getInt("Seq_Vaga"));
                Cand.setCod_Cargo(rs.getInt("Cod_Cargo"));
                Cand.setCNPJ(rs.getLong("CNPJ"));
                Cand.setDat_Publicacao(rs.getDate("Dat_Publicacao"));
                Cand.setStatus_Candidato(rs.getString("Status_Candidato"));
                lista.add(Cand);
            }

            rs.close();
            ps.close();
            connection.close();
            
            return lista; 
           
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
   
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.daoImpl;

import br.cefetmg.implicare.dao.CandidatoDao;
import br.cefetmg.implicare.model.domain.Candidato;
import br.cefetmg.implicare.model.exception.PersistenceException;
import br.cefetmg.inf.util.db.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Gabriel
 * 
 */

public class CandidatoDaoImpl implements CandidatoDao {
    
    @Override
    public boolean insert(Candidato Candidato) throws PersistenceException {
        try {
                    
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO Candidato (CPF, Nome, Data_Nascimento, Email, Senha, Foto,"
                    + "Cod_Cep, Endereco, Desc_Usuario) VALUES(?,?,?,?,?,?,?,?,?) ";

            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setLong(1, Candidato.getCPF_CNPJ());
            ps.setString(2, Candidato.getNome());
            ps.setDate(3, Candidato.getData_Nascimento());
            ps.setString(4, Candidato.getEmail());
            ps.setString(5, Candidato.getSenha());
            ps.setString(6, Candidato.getFoto());
            ps.setLong(7, Candidato.getCod_CEP());
            ps.setString(8, Candidato.getEndereco());
            ps.setString(9, Candidato.getDesc_Usuario());
            
            
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
    public boolean update(Candidato Candidato) throws PersistenceException {
       try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();
            
            String SQL = "UPDATE Candidato SET Email = ?, Nome = ?, Data_Nascimento = ?,"
                    + "Senha = ?, Foto = ?, Cod_CEP, Endereco = ?, Desc_Usuario = ? "
                    + "WHERE CPF = ?";
            
            PreparedStatement ps = connection.prepareStatement(SQL);
       
            ps.setString(1, Candidato.getNome());
            ps.setDate(2, Candidato.getData_Nascimento());
            ps.setString(3, Candidato.getEmail());
            ps.setString(4, Candidato.getSenha());
            ps.setString(5, Candidato.getFoto());
            ps.setLong(6, Candidato.getCod_CEP());
            ps.setString(7, Candidato.getEndereco());
            ps.setString(8, Candidato.getDesc_Usuario());
            ps.setLong(9, Candidato.getCPF_CNPJ());
            
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
    public boolean delete(Candidato Candidato) throws PersistenceException {
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();
            
            String SQL = "DELETE FROM Candidato WHERE CPF = ?";
            
            PreparedStatement ps = connection.prepareStatement(SQL);

            ps.setLong(1, Candidato.getCPF_CNPJ());
            
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
    public Candidato pesquisar(long CPF) throws PersistenceException {
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Candidato WHERE CPF = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, CPF);
            ResultSet rs = ps.executeQuery();

            Candidato Cand = new Candidato();
            
            if (rs.next()) {
                Cand.setCPF_CNPJ(rs.getLong("CPF_CNPJ"));
                Cand.setNome(rs.getString("Nome"));
                Cand.setData_Nascimento(rs.getDate("Data_Nascimento"));
                Cand.setEmail(rs.getString("Email"));
                Cand.setFoto(rs.getString("Foto"));
                Cand.setEndereco(rs.getString("Endereco"));
                Cand.setDesc_Usuario(rs.getString("Desc_Usuario"));
            }

            rs.close();
            ps.close();
            connection.close();

            return Cand;
            
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
    
}

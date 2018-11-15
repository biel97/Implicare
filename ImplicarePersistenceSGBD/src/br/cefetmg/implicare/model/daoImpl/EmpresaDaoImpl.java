/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.daoImpl;

import br.cefetmg.implicare.dao.EmpresaDao;
import br.cefetmg.implicare.model.domain.Empresa;
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

public class EmpresaDaoImpl implements EmpresaDao{

    @Override
    public boolean insert(Empresa Empresa) throws PersistenceException {
        try {
                    
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO Empresa (CNPJ, Nom_Razao_Social = ?, Nome_Fantasia, "
                    + "Data_Nascimento, Email, Senha, Foto,"
                    + "Cod_Cep, Endereco, Desc_Usuario) VALUES(?,?,?,?,?,?,?,?,?) ";

            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setLong(1, Empresa.getCPF_CNPJ());
            ps.setString(2, Empresa.getNom_Razao_Social());
            ps.setString(3, Empresa.getNome_Fantasia());
            ps.setString(4, Empresa.getEmail());
            ps.setString(5, Empresa.getSenha());
            ps.setString(6, Empresa.getFoto());
            ps.setLong(7, Empresa.getCod_CEP());
            ps.setString(8, Empresa.getEndereco());
            ps.setString(9, Empresa.getDesc_Usuario());
            
            
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
    public boolean update(Empresa Empresa) throws PersistenceException {
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();
            
            String SQL = "UPDATE Empresa SET Nom_Razao_Social = ?, Nome_Fantasia = ?, Email = ?,"
                    + "Data_Nascimento = ?, Senha = ?, Foto = ?, "
                    + "Cod_CEP, Endereco = ?, Desc_Usuario = ? "
                    + "WHERE CNPJ = ?";
            
            PreparedStatement ps = connection.prepareStatement(SQL);
       
            ps.setString(1, Empresa.getNom_Razao_Social());
            ps.setString(2, Empresa.getNome_Fantasia());
            ps.setString(3, Empresa.getEmail());
            ps.setString(4, Empresa.getSenha());
            ps.setString(5, Empresa.getFoto());
            ps.setLong(6, Empresa.getCod_CEP());
            ps.setString(7, Empresa.getEndereco());
            ps.setString(8, Empresa.getDesc_Usuario());
            ps.setLong(9, Empresa.getCPF_CNPJ());
            
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
    public boolean delete(Empresa Empresa) throws PersistenceException {
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();
            
            String SQL = "DELETE FROM Empresa WHERE CNPJ = ?";
            
            PreparedStatement ps = connection.prepareStatement(SQL);

            ps.setLong(1, Empresa.getCPF_CNPJ());
            
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
    public Empresa pesquisar(long CNPJ) throws PersistenceException {
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Empresa WHERE CNPJ = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, CNPJ);
            ResultSet rs = ps.executeQuery();

            Empresa Empr = new Empresa();
            
            if (rs.next()) {
                Empr.setCPF_CNPJ(rs.getLong("CNPJ"));
                Empr.setNom_Razao_Social(rs.getString("Nom_Razao_Social"));
                Empr.setNome_Fantasia(rs.getString("Nom_Fantasia"));
                Empr.setEmail(rs.getString("Email"));
                Empr.setFoto(rs.getString("Foto"));
                Empr.setEndereco(rs.getString("Endereco"));
                Empr.setDesc_Usuario(rs.getString("Desc_Usuario"));
            }

            rs.close();
            ps.close();
            connection.close();

            return Empr;
            
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
    
}

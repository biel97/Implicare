/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.daoImpl;

import br.cefetmg.implicare.dao.UsuarioDao;
import br.cefetmg.implicare.model.domain.Usuario;
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

public class UsuarioDaoImpl implements UsuarioDao{

    @Override
    public Usuario login(long CPF_CNPJ, String Senha) throws PersistenceException {
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Usuario WHERE CPF_CNPJ = ? AND Senha = md5(?)";

            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setLong(1, CPF_CNPJ);
            ps.setString(2, Senha);
            
            ResultSet rs = ps.executeQuery();

            Usuario User = null;
            
            if (rs.next()) {
                User = new Usuario();
                User.setCPF_CNPJ(rs.getLong("CPF_CNPJ"));
                User.setEmail(rs.getString("Email"));
                User.setSenha(rs.getString("Senha"));
                User.setFoto(rs.getString("Foto"));
                User.setCod_CEP(rs.getLong("Cod_CEP"));
                User.setEndereco(rs.getString("Endereco"));
                User.setDesc_Usuario(rs.getString("Desc_Usuario"));
            }

            rs.close();
            ps.close();
            connection.close();

            return User;
            
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.toString());
            return null;
        }
    }

}

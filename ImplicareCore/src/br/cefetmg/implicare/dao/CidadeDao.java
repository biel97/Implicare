/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.dao;

import br.cefetmg.implicare.model.domain.Cidade;
import br.cefetmg.implicare.model.exception.PersistenceException;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 * 
 */

public interface CidadeDao {
    public ArrayList<Cidade> listar(int Cod_Estado) throws PersistenceException;
    public Cidade pesquisar(int Cod_Cidade) throws PersistenceException;
}

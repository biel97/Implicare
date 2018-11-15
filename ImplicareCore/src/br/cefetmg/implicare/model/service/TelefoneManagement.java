/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.service;

import br.cefetmg.implicare.model.domain.Telefone;
import br.cefetmg.implicare.model.exception.BusinessException;
import br.cefetmg.implicare.model.exception.PersistenceException;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 * 
 */

public interface TelefoneManagement {
    public boolean insert(Telefone Telefone) throws BusinessException, PersistenceException;
    public boolean update(Telefone Telefone) throws BusinessException, PersistenceException;
    public boolean delete(Telefone Telefone) throws PersistenceException;
    public ArrayList<Telefone> listar(long CPF_CNPJ) throws PersistenceException;
}

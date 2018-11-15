/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.dao;

import br.cefetmg.implicare.model.domain.Candidato;
import br.cefetmg.implicare.model.exception.PersistenceException;

/**
 *
 * @author Gabriel
 * 
 */

public interface CandidatoDao {
    public boolean insert(Candidato Candidato) throws PersistenceException;
    public boolean update(Candidato Candidato) throws PersistenceException;
    public boolean delete(Candidato Candidato) throws PersistenceException;
    public Candidato pesquisar(long CPF_CNPJ) throws PersistenceException;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.service;

import br.cefetmg.implicare.model.domain.Candidato;
import br.cefetmg.implicare.model.exception.BusinessException;
import br.cefetmg.implicare.model.exception.PersistenceException;

/**
 *
 * @author Gabriel
 * 
 */

public interface CandidatoManagement {
    public boolean insert(Candidato Candidato) throws BusinessException, PersistenceException;
    public boolean update(Candidato Candidato) throws BusinessException, PersistenceException;
    public boolean delete(Candidato Candidato) throws BusinessException, PersistenceException;
    public Candidato pesquisar(long CPF) throws PersistenceException;
}

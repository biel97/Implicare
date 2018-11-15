/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.serviceImpl;

import br.cefetmg.implicare.dao.CandidatoDao;
import br.cefetmg.implicare.model.daoImpl.CandidatoDaoImpl;
import br.cefetmg.implicare.model.domain.Candidato;
import br.cefetmg.implicare.model.exception.BusinessException;
import br.cefetmg.implicare.model.exception.PersistenceException;
import br.cefetmg.implicare.model.service.CandidatoManagement;

/**
 *
 * @author Gabriel
 * 
 */

public class CandidatoManagementImpl implements CandidatoManagement{
    private final CandidatoDao CandidatoDao;
    
    public CandidatoManagementImpl(){
        CandidatoDao = new CandidatoDaoImpl();
    }
    
    
    @Override
    public boolean insert(Candidato Candidato) throws BusinessException, PersistenceException {
        boolean result = CandidatoDao.insert(Candidato);
        return result;
    }

    @Override
    public boolean update(Candidato Candidato) throws BusinessException, PersistenceException {
        boolean result = CandidatoDao.update(Candidato);
        return result;
    }

    @Override
    public boolean delete(Candidato Candidato) throws BusinessException, PersistenceException {
        boolean result = CandidatoDao.delete(Candidato);
        return result;
    }

    @Override
    public Candidato pesquisar(long CPF) throws PersistenceException {
        Candidato result = CandidatoDao.pesquisar(CPF);
        return result;
    }
    
}

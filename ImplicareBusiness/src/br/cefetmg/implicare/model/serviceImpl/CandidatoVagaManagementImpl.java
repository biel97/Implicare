/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.serviceImpl;

import br.cefetmg.implicare.dao.CandidatoVagaDao;
import br.cefetmg.implicare.model.daoImpl.CandidatoVagaDaoImpl;
import br.cefetmg.implicare.model.domain.CandidatoVaga;
import br.cefetmg.implicare.model.exception.BusinessException;
import br.cefetmg.implicare.model.exception.PersistenceException;
import br.cefetmg.implicare.model.service.CandidatoVagaManagement;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 * 
 */

public class CandidatoVagaManagementImpl implements CandidatoVagaManagement {
    private final CandidatoVagaDao CandidatoVagaDao;
    
    public CandidatoVagaManagementImpl(){
        CandidatoVagaDao = new CandidatoVagaDaoImpl();
    }
    
    @Override
    public boolean insert(CandidatoVaga CandidatoVaga) throws BusinessException, PersistenceException {
        boolean result = CandidatoVagaDao.insert(CandidatoVaga);
        return result;
    }

    @Override
    public boolean update(CandidatoVaga CandidatoVaga) throws BusinessException, PersistenceException {
        boolean result = CandidatoVagaDao.update(CandidatoVaga);
        return result;
    }

    @Override
    public ArrayList<CandidatoVaga> listar(int Seq_Vaga) throws PersistenceException {
        ArrayList<CandidatoVaga> result = CandidatoVagaDao.listar(Seq_Vaga);
        return result;
    }
    
}

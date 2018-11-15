/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.serviceImpl;

import br.cefetmg.implicare.dao.ExperienciaProfissionalDao;
import br.cefetmg.implicare.model.daoImpl.ExperienciaProfissionalDaoImpl;
import br.cefetmg.implicare.model.domain.ExperienciaProfissional;
import br.cefetmg.implicare.model.exception.BusinessException;
import br.cefetmg.implicare.model.exception.PersistenceException;
import br.cefetmg.implicare.model.service.ExperienciaProfissionalManagement;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 * 
 */

public class ExperienciaProfissionalManagementImpl implements ExperienciaProfissionalManagement {
    private final ExperienciaProfissionalDao ExperienciaProfissionalDao;
    
    public ExperienciaProfissionalManagementImpl(){
        ExperienciaProfissionalDao = new ExperienciaProfissionalDaoImpl();
    }
    
    @Override
    public boolean insert(ExperienciaProfissional ExperienciaProfissional) throws BusinessException, PersistenceException {
        boolean result = ExperienciaProfissionalDao.insert(ExperienciaProfissional);
        return result;
    }

    @Override
    public boolean update(ExperienciaProfissional ExperienciaProfssional) throws BusinessException, PersistenceException {
        boolean result = ExperienciaProfissionalDao.update(ExperienciaProfssional);
        return result;
    }

    @Override
    public boolean delete(ExperienciaProfissional ExperienciaProfissional) throws PersistenceException {
        boolean result = ExperienciaProfissionalDao.delete(ExperienciaProfissional);
        return result;
    }

    @Override
    public ArrayList<ExperienciaProfissional> listar(long CPF) throws PersistenceException {
        ArrayList<ExperienciaProfissional> result = ExperienciaProfissionalDao.listar(CPF);
        return result;
    }

}

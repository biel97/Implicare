/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.serviceImpl;

import br.cefetmg.implicare.dao.FormacaoAcademicaDao;
import br.cefetmg.implicare.model.daoImpl.FormacaoAcademicaDaoImpl;
import br.cefetmg.implicare.model.domain.FormacaoAcademica;
import br.cefetmg.implicare.model.exception.BusinessException;
import br.cefetmg.implicare.model.exception.PersistenceException;
import br.cefetmg.implicare.model.service.FormacaoAcademicaManagement;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 * 
 */

public class FormacaoAcademicaManagementImpl implements FormacaoAcademicaManagement {
    private final FormacaoAcademicaDao FormacaoAcademicaDao;
    
    public FormacaoAcademicaManagementImpl(){
        FormacaoAcademicaDao = new FormacaoAcademicaDaoImpl();
    }

    @Override
    public boolean insert(FormacaoAcademica FormacaoAcademica) throws BusinessException, PersistenceException {
        boolean result = FormacaoAcademicaDao.insert(FormacaoAcademica);
        return result;
    }

    @Override
    public boolean update(FormacaoAcademica FormacaoAcademica) throws BusinessException, PersistenceException {
        boolean result = FormacaoAcademicaDao.update(FormacaoAcademica);
        return result;
    }

    @Override
    public boolean delete(FormacaoAcademica FormacaoAcademica) throws PersistenceException {
        boolean result = FormacaoAcademicaDao.delete(FormacaoAcademica);
        return result;
    }

    @Override
    public ArrayList<FormacaoAcademica> listar(long CPF) throws PersistenceException {
        ArrayList<FormacaoAcademica> result = FormacaoAcademicaDao.listar(CPF);
        return result;
    }
    
}

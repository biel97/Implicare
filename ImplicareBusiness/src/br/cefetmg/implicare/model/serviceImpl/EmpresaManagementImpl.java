/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.serviceImpl;

import br.cefetmg.implicare.dao.EmpresaDao;
import br.cefetmg.implicare.model.daoImpl.EmpresaDaoImpl;
import br.cefetmg.implicare.model.domain.Empresa;
import br.cefetmg.implicare.model.exception.BusinessException;
import br.cefetmg.implicare.model.exception.PersistenceException;
import br.cefetmg.implicare.model.service.EmpresaManagement;

/**
 *
 * @author Gabriel
 * 
 */

public class EmpresaManagementImpl implements EmpresaManagement{
    private final EmpresaDao EmpresaDao;
    
    public EmpresaManagementImpl(){
        EmpresaDao = new EmpresaDaoImpl();
    }
    
    
    @Override
    public boolean insert(Empresa Empresa) throws BusinessException, PersistenceException {
        boolean result = EmpresaDao.insert(Empresa);
        return result;
    }

    @Override
    public boolean update(Empresa Empresa) throws BusinessException, PersistenceException {
        boolean result = EmpresaDao.update(Empresa);
        return result;
    }

    @Override
    public boolean delete(Empresa Empresa) throws BusinessException, PersistenceException {
        boolean result = EmpresaDao.delete(Empresa);
        return result;
    }

    @Override
    public Empresa pesquisar(long CNPJ) throws PersistenceException {
        Empresa result = EmpresaDao.pesquisar(CNPJ);
        return result;
    }
    
}

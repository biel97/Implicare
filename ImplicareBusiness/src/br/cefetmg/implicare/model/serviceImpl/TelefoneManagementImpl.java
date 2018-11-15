/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.serviceImpl;

import br.cefetmg.implicare.dao.TelefoneDao;
import br.cefetmg.implicare.model.daoImpl.TelefoneDaoImpl;
import br.cefetmg.implicare.model.domain.Telefone;
import br.cefetmg.implicare.model.exception.BusinessException;
import br.cefetmg.implicare.model.exception.PersistenceException;
import br.cefetmg.implicare.model.service.TelefoneManagement;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 * 
 */

public class TelefoneManagementImpl implements TelefoneManagement {
    private final TelefoneDao TelefoneDao;
    
    public TelefoneManagementImpl(){
        TelefoneDao = new TelefoneDaoImpl();
    }
    
    @Override
    public boolean insert(Telefone Telefone) throws BusinessException, PersistenceException {
        boolean result = TelefoneDao.insert(Telefone);
        return result;
    }

    @Override
    public boolean update(Telefone Telefone) throws BusinessException, PersistenceException {
        boolean result = TelefoneDao.update(Telefone);
        return result;
    }

    @Override
    public boolean delete(Telefone Telefone) throws PersistenceException {
        boolean result = TelefoneDao.delete(Telefone);
        return result;
    }

    @Override
    public ArrayList<Telefone> listar(long CPF_CNPJ) throws PersistenceException {
        ArrayList<Telefone> result = TelefoneDao.listar(CPF_CNPJ);
        return result;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.serviceImpl;

import br.cefetmg.implicare.dao.CidadeDao;
import br.cefetmg.implicare.model.daoImpl.CidadeDaoImpl;
import br.cefetmg.implicare.model.domain.Cidade;
import br.cefetmg.implicare.model.exception.PersistenceException;
import br.cefetmg.implicare.model.service.CidadeManagement;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 * 
 */

public class CidadeManagementImpl implements CidadeManagement {
    private final CidadeDao CidadeDao;
    
    public CidadeManagementImpl(){
        CidadeDao = new CidadeDaoImpl();
    }
    
    @Override
    public ArrayList<Cidade> listar(int Cod_Estado) throws PersistenceException {
        ArrayList<Cidade> result = CidadeDao.listar(Cod_Estado);
        return result;
    }

    @Override
    public Cidade pesquisar(int Cod_Cidade) throws PersistenceException {
        Cidade result = CidadeDao.pesquisar(Cod_Cidade);
        return result;
    }
    
}

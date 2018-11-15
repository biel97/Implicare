/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.serviceImpl;

import br.cefetmg.implicare.dao.AreaEstudoDao;
import br.cefetmg.implicare.model.daoImpl.AreaEstudoDaoImpl;
import br.cefetmg.implicare.model.domain.AreaEstudo;
import br.cefetmg.implicare.model.exception.PersistenceException;
import br.cefetmg.implicare.model.service.AreaEstudoManagement;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 * 
 */

public class AreaEstudoManagementImpl implements AreaEstudoManagement {
    private final AreaEstudoDao AreaEstudoDao;
    
    public AreaEstudoManagementImpl(){
        AreaEstudoDao = new AreaEstudoDaoImpl();
    }
    
    @Override
    public ArrayList<AreaEstudo> listar() throws PersistenceException {
        ArrayList<AreaEstudo> result = AreaEstudoDao.listar();
        return result;
    }

    @Override
    public AreaEstudo pesquisar(int Cod_Area_Estudo) throws PersistenceException {
        AreaEstudo result = AreaEstudoDao.pesquisar(Cod_Area_Estudo);
        return result;
    }
    
}

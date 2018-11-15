/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.serviceImpl;

import br.cefetmg.implicare.dao.EstadoDao;
import br.cefetmg.implicare.model.daoImpl.EstadoDaoImpl;
import br.cefetmg.implicare.model.domain.Estado;
import br.cefetmg.implicare.model.exception.PersistenceException;
import br.cefetmg.implicare.model.service.EstadoManagement;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 * 
 */

public class EstadoManagementImpl implements EstadoManagement {
    private final EstadoDao EstadoDao;
    
    public EstadoManagementImpl(){
        EstadoDao = new EstadoDaoImpl();
    }
    
    @Override
    public ArrayList<Estado> listar() throws PersistenceException {
        ArrayList<Estado> result = EstadoDao.listar();
        return result;
    }

    @Override
    public Estado pesquisar(int Cod_Estado) throws PersistenceException {
        Estado result = EstadoDao.pesquisar(Cod_Estado);
        return result;
    }
    
}

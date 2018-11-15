/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.serviceImpl;

import br.cefetmg.implicare.dao.CargoDao;
import br.cefetmg.implicare.model.daoImpl.CargoDaoImpl;
import br.cefetmg.implicare.model.domain.Cargo;
import br.cefetmg.implicare.model.exception.PersistenceException;
import br.cefetmg.implicare.model.service.CargoManagement;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 * 
 */

public class CargoManagementImpl implements CargoManagement {
    private final CargoDao CargoDao;
    
    public CargoManagementImpl(){
        CargoDao = new CargoDaoImpl();
    }
    
    @Override
    public ArrayList<Cargo> listar() throws PersistenceException {
        ArrayList<Cargo> result = CargoDao.listar();
        return result;
    }
    
    @Override
    public ArrayList<Cargo> listarCargoAreaEstudo(long CPF) throws PersistenceException {
        ArrayList<Cargo> result = CargoDao.listarCargoAreaEstudo(CPF);
        return result;
    }
    
    @Override
    public Cargo pesquisar(int Cod_Cargo) throws PersistenceException {
        Cargo result = CargoDao.pesquisar(Cod_Cargo);
        return result;
    }

}

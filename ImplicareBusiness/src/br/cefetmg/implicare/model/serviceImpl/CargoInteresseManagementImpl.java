/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.serviceImpl;

import br.cefetmg.implicare.dao.CargoInteresseDao;
import br.cefetmg.implicare.model.daoImpl.CargoInteresseDaoImpl;
import br.cefetmg.implicare.model.domain.CargoInteresse;
import br.cefetmg.implicare.model.exception.BusinessException;
import br.cefetmg.implicare.model.exception.PersistenceException;
import br.cefetmg.implicare.model.service.CargoInteresseManagement;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 * 
 */

public class CargoInteresseManagementImpl implements CargoInteresseManagement {
    private final CargoInteresseDao CargoInteresseDao;
    
    public CargoInteresseManagementImpl(){
        CargoInteresseDao = new CargoInteresseDaoImpl();
    }
    
    @Override
    public boolean insert(CargoInteresse CargoInteresse) throws BusinessException, PersistenceException {
        boolean result = CargoInteresseDao.insert(CargoInteresse);
        return result;
    }

    @Override
    public boolean delete(CargoInteresse CargoInteresse) throws PersistenceException {
        boolean result = CargoInteresseDao.delete(CargoInteresse);
        return result;
    }

    @Override
    public ArrayList<CargoInteresse> listar(long CPF) throws PersistenceException {
        ArrayList<CargoInteresse> result = CargoInteresseDao.listar(CPF);
        return result;
    }
    
}

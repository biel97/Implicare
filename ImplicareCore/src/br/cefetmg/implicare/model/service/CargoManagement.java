/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.service;

import br.cefetmg.implicare.model.domain.Cargo;
import br.cefetmg.implicare.model.exception.PersistenceException;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 * 
 */

public interface CargoManagement {
    public ArrayList<Cargo> listar() throws PersistenceException;
    public ArrayList<Cargo> listarCargoAreaEstudo(long CPF) throws PersistenceException;
    public Cargo pesquisar(int Cod_Cargo) throws PersistenceException;
}

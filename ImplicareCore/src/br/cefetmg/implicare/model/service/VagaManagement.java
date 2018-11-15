/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.service;

import br.cefetmg.implicare.model.domain.Vaga;
import br.cefetmg.implicare.model.exception.BusinessException;
import br.cefetmg.implicare.model.exception.PersistenceException;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 * 
 */

public interface VagaManagement {
    public boolean insert(Vaga Vaga) throws BusinessException, PersistenceException;
    public boolean update(Vaga Vaga) throws BusinessException, PersistenceException;
    public boolean delete(Vaga Vaga) throws PersistenceException;
    public ArrayList<Vaga> listarVagaEmpresa(long CNPJ) throws PersistenceException;
    public ArrayList<Vaga> listarVagaCandidato(long CPF) throws PersistenceException;
}

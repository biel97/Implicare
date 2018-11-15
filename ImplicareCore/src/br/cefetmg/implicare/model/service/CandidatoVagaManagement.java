/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.service;

import br.cefetmg.implicare.model.domain.CandidatoVaga;
import br.cefetmg.implicare.model.exception.BusinessException;
import br.cefetmg.implicare.model.exception.PersistenceException;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 * 
 */

public interface CandidatoVagaManagement {
    public boolean insert(CandidatoVaga CandidatoVaga) throws BusinessException, PersistenceException;
    public boolean update(CandidatoVaga CandidatoVaga) throws BusinessException, PersistenceException;
    public ArrayList<CandidatoVaga> listar(int Seq_Vaga) throws PersistenceException;
}

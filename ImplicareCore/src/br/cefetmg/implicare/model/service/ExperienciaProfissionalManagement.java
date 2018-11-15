/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.service;

import br.cefetmg.implicare.model.domain.ExperienciaProfissional;
import br.cefetmg.implicare.model.exception.BusinessException;
import br.cefetmg.implicare.model.exception.PersistenceException;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 * 
 */

public interface ExperienciaProfissionalManagement {
    public boolean insert(ExperienciaProfissional ExperienciaProfissional) throws BusinessException, PersistenceException;
    public boolean update(ExperienciaProfissional ExperienciaProfissional) throws BusinessException, PersistenceException;
    public boolean delete(ExperienciaProfissional ExperienciaProfissional) throws PersistenceException;
    public ArrayList<ExperienciaProfissional> listar(long CPF) throws PersistenceException;
}

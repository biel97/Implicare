/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.dao;

import br.cefetmg.implicare.model.domain.ExperienciaProfissional;
import br.cefetmg.implicare.model.exception.PersistenceException;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 * 
 */

public interface ExperienciaProfissionalDao {
    public boolean insert(ExperienciaProfissional ExperienciaProfissional) throws PersistenceException;
    public boolean update(ExperienciaProfissional ExperienciaProfssional) throws PersistenceException;
    public boolean delete(ExperienciaProfissional ExperienciaProfissional) throws PersistenceException;
    public ArrayList<ExperienciaProfissional> listar(long CPF) throws PersistenceException;
}

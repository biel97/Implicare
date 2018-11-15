/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.dao;

import br.cefetmg.implicare.model.domain.FormacaoAcademica;
import br.cefetmg.implicare.model.exception.PersistenceException;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 * 
 */

public interface FormacaoAcademicaDao {
    public boolean insert(FormacaoAcademica FormacaoAcademica) throws PersistenceException;
    public boolean update(FormacaoAcademica FormacaoAcademica) throws PersistenceException;
    public boolean delete(FormacaoAcademica FormacaoAcademica) throws PersistenceException;
    public ArrayList<FormacaoAcademica> listar(long CPF) throws PersistenceException;
}

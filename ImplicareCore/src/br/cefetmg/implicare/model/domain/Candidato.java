/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.domain;

import java.sql.Date;

/**
 *
 * @author Gabriel
 * 
 */

public class Candidato extends Usuario{
    private String Nome;
    private Date Data_Nascimento;
    
    public Candidato(){}
    
    public Candidato(String Nome, Date Data_Nascimento){
        this.Nome = Nome;
        this.Data_Nascimento = Data_Nascimento;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public Date getData_Nascimento() {
        return Data_Nascimento;
    }

    public void setData_Nascimento(Date Data_Nascimento) {
        this.Data_Nascimento = Data_Nascimento;
    }
    
}

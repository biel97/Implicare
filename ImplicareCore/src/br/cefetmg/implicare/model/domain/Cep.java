/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.domain;

/**
 *
 * @author Gabriel
 * 
 */

public class Cep {
    private long Cod_CEP;
    private int Cod_Cidade;
    private int Cod_Estado;
    
    public Cep(){}

    public Cep(long Cod_CEP, int Cod_Cidade, int Cod_Estado){
        this.Cod_CEP = Cod_CEP;
        this.Cod_Cidade = Cod_Cidade;
        this.Cod_Estado = Cod_Estado;
    }
    
    public long getCod_CEP() {
        return Cod_CEP;
    }

    public void setCod_CEP(long Cod_CEP) {
        this.Cod_CEP = Cod_CEP;
    }

    public int getCod_Cidade() {
        return Cod_Cidade;
    }

    public void setCod_Cidade(int Cod_Cidade) {
        this.Cod_Cidade = Cod_Cidade;
    }

    public int getCod_Estado() {
        return Cod_Estado;
    }

    public void setCod_Estado(int Cod_Estado) {
        this.Cod_Estado = Cod_Estado;
    }
    
}

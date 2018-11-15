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

public class Cargo {
    private int Cod_Cargo;
    private String Nom_Cargo;
    
    public Cargo(){}

    public Cargo(int Cod_Cargo, String Nom_Cargo){
        this.Cod_Cargo = Cod_Cargo;
        this.Nom_Cargo = Nom_Cargo;
    }
    
    public int getCod_Cargo() {
        return Cod_Cargo;
    }

    public void setCod_Cargo(int Cod_Cargo) {
        this.Cod_Cargo = Cod_Cargo;
    }

    public String getNom_Cargo() {
        return Nom_Cargo;
    }

    public void setNom_Cargo(String Nom_Cargo) {
        this.Nom_Cargo = Nom_Cargo;
    }
    
}

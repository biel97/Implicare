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

public class AreaEstudo {
    private int Cod_Area_Estudo;
    private String Nom_Area_Estudo;
    
    public AreaEstudo(){}
    
    public AreaEstudo(int Cod_Area_Estudo, String Nom_Area_Estudo){
        this.Cod_Area_Estudo = Cod_Area_Estudo;
        this.Nom_Area_Estudo = Nom_Area_Estudo;
    }

    public int getCod_Area_Estudo() {
        return Cod_Area_Estudo;
    }

    public void setCod_Area_Estudo(int Cod_Area_Estudo) {
        this.Cod_Area_Estudo = Cod_Area_Estudo;
    }

    public String getNom_Area_Estudo() {
        return Nom_Area_Estudo;
    }

    public void setNom_Area_Estudo(String Nom_Area_Estudo) {
        this.Nom_Area_Estudo = Nom_Area_Estudo;
    }
    
}

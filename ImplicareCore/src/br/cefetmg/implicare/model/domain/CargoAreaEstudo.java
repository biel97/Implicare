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

public class CargoAreaEstudo {
    private int Cod_Area_Estudo;
    private int Cod_Cargo;
    
    public CargoAreaEstudo(){}
    
    public CargoAreaEstudo(int Cod_Area_Estudo, int Cod_Cargo){
        this.Cod_Area_Estudo = Cod_Area_Estudo;
        this.Cod_Cargo = Cod_Cargo;
    }

    public int getCod_Area_Estudo() {
        return Cod_Area_Estudo;
    }

    public void setCod_Area_Estudo(int Cod_Area_Estudo) {
        this.Cod_Area_Estudo = Cod_Area_Estudo;
    }

    public int getCod_Cargo() {
        return Cod_Cargo;
    }

    public void setCod_Cargo(int Cod_Cargo) {
        this.Cod_Cargo = Cod_Cargo;
    }
    
}

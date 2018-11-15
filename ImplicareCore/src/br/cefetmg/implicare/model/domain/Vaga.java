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

public class Vaga {
    private long CNPJ;
    private int Seq_Vaga;
    private int Cod_Cargo;
    private Date Dat_Publicacao;
    private int Num_Vagas;
    private int Carga_Horaria;
    private double Remuneracao;
    private String Desc_Vaga;
    private int Status_Vaga;
    
    public Vaga(){}
    
    public Vaga(long CNPJ, int Seq_Vaga, int Cod_Cargo, Date Dat_Publicacao, int Num_Vagas, int Carga_Horaria, double Remuneracao, String Desc_Vaga, int Status_Vaga){
        this.CNPJ = CNPJ;
        this.Seq_Vaga = Seq_Vaga;
        this.Cod_Cargo = Cod_Cargo;
        this.Dat_Publicacao = Dat_Publicacao;
        this.Num_Vagas = Num_Vagas;
        this.Carga_Horaria = Carga_Horaria;
        this.Remuneracao = Remuneracao;
        this.Desc_Vaga = Desc_Vaga;
        this.Status_Vaga = Status_Vaga;
    }

    public long getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(long CNPJ) {
        this.CNPJ = CNPJ;
    }
    
     public int getSeq_Vaga() {
        return Seq_Vaga;
    }

    public void setSeq_Vaga(int Seq_Vaga) {
        this.Seq_Vaga = Seq_Vaga;
    }
    
    public int getCod_Cargo() {
        return Cod_Cargo;
    }

    public void setCod_Cargo(int Cod_Cargo) {
        this.Cod_Cargo = Cod_Cargo;
    }

    public Date getDat_Publicacao() {
        return Dat_Publicacao;
    }

    public void setDat_Publicacao(Date Dat_Publicacao) {
        this.Dat_Publicacao = Dat_Publicacao;
    }

    public int getNum_Vagas() {
        return Num_Vagas;
    }

    public void setNum_Vagas(int Num_Vagas) {
        this.Num_Vagas = Num_Vagas;
    }

    public int getCarga_Horaria() {
        return Carga_Horaria;
    }

    public void setCarga_Horaria(int Carga_Horaria) {
        this.Carga_Horaria = Carga_Horaria;
    }

    public double getRemuneracao() {
        return Remuneracao;
    }

    public void setRemuneracao(double Remuneracao) {
        this.Remuneracao = Remuneracao;
    }

    public String getDesc_Vaga() {
        return Desc_Vaga;
    }

    public void setDesc_Vaga(String Desc_Vaga) {
        this.Desc_Vaga = Desc_Vaga;
    }

    public int getStatus_Vaga() {
        return Status_Vaga;
    }

    public void setStatus_Vaga(int Status_Vaga) {
        this.Status_Vaga = Status_Vaga;
    }
    
}

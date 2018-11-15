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

public class CandidatoVaga {
    private long CPF;
    private int Seq_Vaga;
    private int Cod_Cargo;
    private long CNPJ;
    private Date Dat_Publicacao;
    private String Status_Candidato;
    
    public CandidatoVaga(){}

    public CandidatoVaga(long CPF, int Seq_Vaga, int Cod_Cargo, long CNPJ, Date Dat_Publicacao, String Status_Candidato){
        this.CPF = CPF;
        this.Seq_Vaga = Seq_Vaga;
        this.Cod_Cargo = Cod_Cargo;
        this.CNPJ = CNPJ;
        this.Dat_Publicacao = Dat_Publicacao;
        this.Status_Candidato = Status_Candidato;
    }
    
    public long getCPF() {
        return CPF;
    }

    public void setCPF(long CPF) {
        this.CPF = CPF;
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

    public long getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(long CNPJ) {
        this.CNPJ = CNPJ;
    }

    public Date getDat_Publicacao() {
        return Dat_Publicacao;
    }

    public void setDat_Publicacao(Date Dat_Publicacao) {
        this.Dat_Publicacao = Dat_Publicacao;
    }

    public String getStatus_Candidato() {
        return Status_Candidato;
    }

    public void setStatus_Candidato(String Status_Candidato) {
        this.Status_Candidato = Status_Candidato;
    }
    
}

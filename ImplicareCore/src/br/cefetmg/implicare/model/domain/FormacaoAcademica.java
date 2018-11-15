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

public class FormacaoAcademica {
    private long CPF;
    private int Seq_Formacao;
    private String Instituicao_Ensino;
    private int Cod_Area_Estudo;
    private String Atividades_Desenvolvidas;
    private Date Data_Inicio;
    private Date Data_Termino;
    private String Desc_Formacao_Academica;

    public FormacaoAcademica(){}
    
    public FormacaoAcademica(long CPF, int Seq_Formacao, String Instituicao_Ensino, int Cod_Area_Estudo, String Atividades_Desenvolvidas, Date Data_Inicio, Date Data_Termino, String Desc_Formacao_Academica){
        this.CPF = CPF;
        this.Seq_Formacao = Seq_Formacao;
        this.Instituicao_Ensino = Instituicao_Ensino;
        this.Cod_Area_Estudo = Cod_Area_Estudo;
        this.Atividades_Desenvolvidas = Atividades_Desenvolvidas;
        this.Data_Inicio = Data_Inicio;
        this.Data_Termino = Data_Termino;
        this.Desc_Formacao_Academica = Desc_Formacao_Academica;
    }
    
    public long getCPF() {
        return CPF;
    }

    public void setCPF(long CPF) {
        this.CPF = CPF;
    }

    public int getSeq_Formacao() {
        return Seq_Formacao;
    }

    public void setSeq_Formacao(int Seq_Formacao) {
        this.Seq_Formacao = Seq_Formacao;
    }

    public String getInstituicao_Ensino() {
        return Instituicao_Ensino;
    }
    
    public void setInstituicao_Ensino(String Instituicao_Ensino) {
        this.Instituicao_Ensino = Instituicao_Ensino;
    }

    public int getCod_Area_Estudo() {
        return Cod_Area_Estudo;
    }

    public void setCod_Area_Estudo(int Cod_Area_Estudo) {
        this.Cod_Area_Estudo = Cod_Area_Estudo;
    }

    public String getAtividades_Desenvolvidas() {
        return Atividades_Desenvolvidas;
    }

    public void setAtividades_Desenvolvidas(String Atividades_Desenvolvidas) {
        this.Atividades_Desenvolvidas = Atividades_Desenvolvidas;
    }

    public Date getData_Inicio() {
        return Data_Inicio;
    }

    public void setData_Inicio(Date Data_Inicio) {
        this.Data_Inicio = Data_Inicio;
    }

    public Date getData_Termino() {
        return Data_Termino;
    }

    public void setData_Termino(Date Data_Termino) {
        this.Data_Termino = Data_Termino;
    }

    public String getDesc_Formacao_Academica() {
        return Desc_Formacao_Academica;
    }

    public void setDesc_Formacao_Academica(String Desc_Formacao_Academica) {
        this.Desc_Formacao_Academica = Desc_Formacao_Academica;
    }
    
}

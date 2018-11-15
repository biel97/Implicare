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

public class Usuario {
    private long CPF_CNPJ;
    private String Email;
    private String Senha;
    private String Foto;
    private long Cod_CEP;
    private String Endereco;
    private String Desc_Usuario;
    
    public Usuario(){}
    
    public Usuario(long CPF_CNPJ, String Email, String Senha, String Foto, long Cod_Cep, String Endereco, String Desc_Usuario){
        this.CPF_CNPJ = CPF_CNPJ;
        this.Email = Email;
        this.Senha = Senha;
        this.Foto = Foto;
        this.Cod_CEP = Cod_Cep;
        this.Endereco = Endereco;
        this.Desc_Usuario = Desc_Usuario;
    }
    
    public void setCPF_CNPJ(Long CPF_CNPJ) {
        this.CPF_CNPJ = CPF_CNPJ;
    }
    
     public Long getCPF_CNPJ() {
        return CPF_CNPJ;
    }
     
    public void setEmail(String Email){
        this.Email = Email;
    }
    
    public String getEmail(){
        return Email;
    }
    
    public void setSenha(String Senha){
        this.Senha = Senha;
    }
    
    public String getSenha(){
        return Senha;
    }
    
    public void setFoto(String Foto){
        this.Foto = Foto;
    }
    
    public String getFoto(){
        return Foto;
    }
    
    public void setCod_CEP(Long Cod_CEP){
        this.Cod_CEP = Cod_CEP;
    }
    
    public Long getCod_CEP(){
        return Cod_CEP;
    }
    
    public void setEndereco(String Endereco){
        this.Endereco = Endereco;
    }
    
    public String getEndereco(){
        return Endereco;
    }
    
    public void setDesc_Usuario(String Desc_Usuario){
        this.Desc_Usuario = Desc_Usuario;
    }   
    
    public String getDesc_Usuario(){
        return Desc_Usuario;
    }
    
}

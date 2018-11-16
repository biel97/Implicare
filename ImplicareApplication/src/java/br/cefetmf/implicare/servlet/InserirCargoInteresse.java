/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmf.implicare.servlet;

import br.cefetmg.implicare.model.domain.CargoInteresse;
import br.cefetmg.implicare.model.service.CargoInteresseManagement;
import br.cefetmg.implicare.model.serviceImpl.CargoInteresseManagementImpl;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Gabriel
 * 
 */

class InserirCargoInteresse {

    static String execute(HttpServletRequest request) {
        String jsp="";
        try{

            Long CPF = (Long) request.getSession().getAttribute("CPF_CNPJ");
            int Cod_Cargo = Integer.parseInt(request.getParameter("Cod_Cargo"));
            
            CargoInteresseManagement CargoManagement = new CargoInteresseManagementImpl(); 
            CargoInteresse CargoInteresse = new CargoInteresse();
            
            CargoInteresse.setCPF(CPF);
            CargoInteresse.setCod_Cargo(Cod_Cargo);
            
            boolean Cargo = CargoManagement.insert(CargoInteresse);

            if (Cargo =! false) {
                jsp="";
            } else {
                String Erro = "Ocorreu erro ao Inserir Cargo Interesse!";
                jsp="/WEB-Pages/Erro.jsp";
                request.setAttribute("Erro", Erro);
            }
        } catch(Exception e) {
            e.printStackTrace();
            jsp="";
        }
        
        return jsp;
    }
    
}

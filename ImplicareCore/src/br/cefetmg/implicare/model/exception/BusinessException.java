/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.exception;

/**
 *
 * @author Gabriel
 */
public class BusinessException extends Exception{
    
    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(BusinessException ex) {
        super(ex);
    }
    
}

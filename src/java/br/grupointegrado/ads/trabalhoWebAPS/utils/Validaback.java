/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.grupointegrado.ads.trabalhoWebAPS.utils;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author alamv
 */
public class Validaback {
     public static boolean validaString(String valor, int minimo) {

//        if(valor == null || valor.length() < minimo){
//            return false;
//        }
//        return true;
        return valor != null && valor.length() >= minimo;
    }
    
    public static boolean validaDouble(Double valor, double minimo, double maximo) {
        
        
        return valor >= minimo && valor <= maximo;
        
    }

    public static boolean validaLong(Long valor, long minimo, long maximo) {
       
        
        return valor >= minimo && valor <= maximo;
        
    }
    
    public static boolean validaData(Date data, Date minimo, Date maximo) {
        
        
        return data != null 
                && (data.after(minimo) || data.equals(minimo))
                && (data.before(maximo) || data.equals(maximo));
        
    }
    
    public static boolean validaDataAno(String data, Date maximo) {
        Date dataDate = Formata.stringParaData(data);
        
        return dataDate != null 
                && (dataDate.before(maximo) || dataDate.equals(maximo));
        
    }
    public static boolean validaData(String data, Long maximo) {
        Long dataDate = Formata.stringParaLong(data);
        
        return dataDate != null 
                && (dataDate <= maximo );
        
    }
    
    public static boolean validaEmail(String email){
        Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
	Matcher m = p.matcher(email);
        boolean matchFound = m.matches();
        return matchFound == true;
        
    }
}

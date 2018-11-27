/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.grupointegrado.ads.trabalhoWebAPS.utils;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author alamv
 */
public class Formata {

    public static Double stringParaDouble(String valor) {
        try {

           

            return Double.parseDouble(valor) ;

        } catch (Exception ex) {
            return 0d;
        }
    }

    public static Long stringParaLong(String valor) {
        try {
            return Long.parseLong(valor);

        } catch (Exception ex) {
            return 0L;
        }
    }

    public static Integer stringParaint(String valor) {
        try {
            return Integer.parseInt(valor);

        } catch (Exception ex) {
            return 0;
        }
    }

    public static Date stringParaData(String data) {
        try {
            SimpleDateFormat formt = new SimpleDateFormat("yyyy-MM-dd");
            return formt.parse(data);

        } catch (Exception ex) {
            return null;
        }
    }

    public static String dataParaString(Date data) {
        try {
            SimpleDateFormat formt = new SimpleDateFormat("dd/MM/yyyy");
            return formt.format(data);

        } catch (Exception ex) {
            return "";
        }
    }

    public static Date stringParaDataAno(String data) {
        try {
            SimpleDateFormat formt = new SimpleDateFormat("yyyy");
            return formt.parse(data);

        } catch (Exception ex) {
            return null;
        }
    }

    public static Date stringParaDataAnoa(String data) {
        try {
            SimpleDateFormat formt = new SimpleDateFormat("yyyy");
            return formt.parse(data);

        } catch (Exception ex) {
            return null;
        }
    }

    public static String sHora(Date data) {
        try {
            SimpleDateFormat formt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            return formt.format(data);

        } catch (Exception ex) {
            return null;
        }
    }

}

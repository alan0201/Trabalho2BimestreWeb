/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.grupointegrado.ads.trabalhoWebAPS.utils;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author jsoliveira
 */
public class ComboUtils {

    public static void preencherCombo(JComboBox combo, List<?> list) {

        DefaultComboBoxModel model = (DefaultComboBoxModel) combo.getModel();
        try {
            model.removeAllElements();

            for (int i = 0; i < list.size(); i++) {

                model.addElement(list.get(i));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

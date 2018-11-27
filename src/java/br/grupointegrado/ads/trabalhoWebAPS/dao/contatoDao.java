/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.grupointegrado.ads.trabalhoWebAPS.dao;

import br.grupointegrado.ads.trabalhoWebAPS.modelos.contato;
import br.grupointegrado.ads.trabalhoWebAPS.modelos.veiculos;
import br.grupointegrado.ads.trabalhoWebAPS.utils.Formata;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author alamv
 */
public class contatoDao extends Dao{

    public contatoDao(Connection conexao) throws Exception {
        super(conexao);
    }

    
     
    
    
     public contato getContatoByRequest(HttpServletRequest req) throws SQLException {
        contato c = new contato();

        c.setNome(req.getParameter("contato-nome"));
        c.setEmail(req.getParameter("contato-email"));
        c.setMensagem(req.getParameter("contato-mensagem"));
       
        

        return c;
    }
}

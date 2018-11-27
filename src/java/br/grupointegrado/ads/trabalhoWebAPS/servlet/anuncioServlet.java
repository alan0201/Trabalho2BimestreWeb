/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.grupointegrado.ads.trabalhoWebAPS.servlet;

import br.grupointegrado.ads.trabalhoWebAPS.dao.veiculosDao;
import br.grupointegrado.ads.trabalhoWebAPS.modelos.veiculos;
import br.grupointegrado.ads.trabalhoWebAPS.utils.Formata;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alamv
 */
public class anuncioServlet extends HttpServlet {

    private Connection conexao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            conexao = (Connection) req.getAttribute("conexao");
            veiculosDao vDao = new veiculosDao(conexao);

            long anuncioId = Formata.stringParaLong(req.getParameter("anuncio"));
            

            
                veiculos v = vDao.buscaPorId(anuncioId);
                req.setAttribute("veiculosanu", v);
                RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/anuncio.jsp");
                dispatcher.forward(req, resp);
            

        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(anuncioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

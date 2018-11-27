/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.grupointegrado.ads.trabalhoWebAPS.servlet;

import br.grupointegrado.ads.trabalhoWebAPS.dao.JavaMailApp;
import br.grupointegrado.ads.trabalhoWebAPS.dao.contatoDao;
import br.grupointegrado.ads.trabalhoWebAPS.modelos.contato;
import br.grupointegrado.ads.trabalhoWebAPS.utils.Validaback;
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
public class contatoServlet extends HttpServlet {
    private Connection conexao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/contato.jsp");
        dispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            conexao = (Connection) req.getAttribute("conexao");
            contatoDao cDao = new contatoDao(conexao);
            String mensagemErro = validaContato(req);
            contato c = cDao.getContatoByRequest(req);
            String mendagemSalvo = "E-mail enviado com sucesso !!!!";

            if (mensagemErro == null) {
                
                JavaMailApp mail = new JavaMailApp();
                mail.email(c.getEmail(), c.getNome(), c.getMensagem());
                
                req.setAttribute("mensagem-salvo", mendagemSalvo);
                //resp.sendRedirect("/TrabalhoWebAPS/contato");
                doGet(req, resp);
            }else{
                req.setAttribute("mensagem-erro", mensagemErro);
                req.setAttribute("contato", c);
                doGet(req, resp);
            }

            

        } catch (Exception ex) {
             ex.printStackTrace();
            Logger.getLogger(contatoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private String validaContato(HttpServletRequest req) {

        if (!Validaback.validaString(req.getParameter("contato-nome"), 2)) {
            return "O nome deve possuir ao menos 2 caracteres.";
        }
        if (!Validaback.validaEmail(req.getParameter("contato-email"))) {
            return "Email com formato incorrreto.";
        }
        if (!Validaback.validaString(req.getParameter("contato-mensagem"), 10)) {
            return "A mensagem deve possuir no minino 10 caracteres.";
        }

        return null;

    }

}

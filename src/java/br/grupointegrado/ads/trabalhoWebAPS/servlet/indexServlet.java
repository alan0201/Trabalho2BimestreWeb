/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.grupointegrado.ads.trabalhoWebAPS.servlet;

import br.grupointegrado.ads.trabalhoWebAPS.dao.categoriasDao;
import br.grupointegrado.ads.trabalhoWebAPS.dao.veiculosDao;
import br.grupointegrado.ads.trabalhoWebAPS.modelos.categoria;
import br.grupointegrado.ads.trabalhoWebAPS.modelos.veiculos;
import br.grupointegrado.ads.trabalhoWebAPS.utils.Formata;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
public class indexServlet extends HttpServlet {

    private Connection conexao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            conexao = (Connection) req.getAttribute("conexao");

            veiculosDao vDao = new veiculosDao(conexao);
            String termoBusca = req.getParameter("busca-veiculo");
            categoriasDao cDao = new categoriasDao(conexao);
            Long veiculoIdexcluir = Formata.stringParaLong(req.getParameter("excluirProduto"));

            Integer idcategoria = Formata.stringParaint(req.getParameter("categoria"));

            if (veiculoIdexcluir > 0) {
                try {
                    // excluir o produto do banco de dados.
                    vDao.deletAnuncio(veiculoIdexcluir);
                    resp.sendRedirect("/TrabalhoWebAPS/index");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    req.setAttribute("mensagem-erro", "Não foi possível excluir o produto.");

                    doGet(req, resp);
                }

            }
            List<veiculos> vl = new ArrayList<>();

            if (idcategoria != null && idcategoria > 0) {

                vl = vDao.buscaAllCategoria(idcategoria);
            } else if (!ehInteiro(termoBusca)) {
                vl = vDao.buscaAll(termoBusca);
            } else {
                vl = vDao.buscaAllDouble(termoBusca);
            }

            List<categoria> c = cDao.getByAll();
            req.setAttribute("categoria", c);
            req.setAttribute("veiculos", vl);

            RequestDispatcher dispathcher = req.getRequestDispatcher("/WEB-INF/paginas/index.jsp");
            dispathcher.forward(req, resp);

        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(indexServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean ehInteiro(String s) {

        if (s != null) {
            char[] c = s.toCharArray();
            boolean d = true;
            for (int i = 0; i < c.length; i++) // verifica se o char não é um dígito
            {
                if (!Character.isDigit(c[i])) {
                    d = false;
                    break;
                }
            }
            return d;
        }
        return false;
    }

}

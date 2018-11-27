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
import br.grupointegrado.ads.trabalhoWebAPS.utils.Validaback;
import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author alamv
 */
public class anunciarServlet extends HttpServlet {

    private Connection conexao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            conexao = (Connection) req.getAttribute("conexao");
            veiculosDao vdao = new veiculosDao(conexao);
            categoriasDao cDao = new categoriasDao(conexao);
            Long veiculoId = Formata.stringParaLong(req.getParameter("veiculoid"));
            
            // verifica se o id do produto foi informado na url

            if (veiculoId > 0) {
                veiculos veiculoEncontrado = null;
                veiculoEncontrado = vdao.buscaPorId(veiculoId);
                if (veiculoId != null) {
                    //se o produto existe, então devolve o produto
                    req.setAttribute("veiculo", veiculoEncontrado);
                } else {
                    // se nao, exibe uma mensagem de erro
                    req.setAttribute("mensagem-erro", "Veiculo não encontrado");
                }

            }

            List<categoria> c = cDao.getByAll();
            req.setAttribute("categoria", c);

        } catch (Exception ex) {
            Logger.getLogger(anunciarServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/anunciar.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            conexao = (Connection) req.getAttribute("conexao");
            veiculosDao vDao = new veiculosDao(conexao);
            veiculos v = vDao.getProdutoByRequest(req);
            String mensagemErro = validaCadastro(v);
            String mendagemSalvo = "Anuncio postado com Sucesso";

            if (mensagemErro == null) {
                if (v.getId() > 0) {
                    
                    vDao.atualizarV(v);
                    req.setAttribute("mensagem-salvo", mendagemSalvo);
                    
                } else {

                    
                    vDao.insert(v);
                    req.setAttribute("mensagem-salvo", mendagemSalvo);

                }
                //resp.sendRedirect("/TrabalhoWebAPS/anunciar");
                doGet(req, resp);

            } else {
                //dados do produtonão são invalidos
                req.setAttribute("mensagem-erro", mensagemErro);
                req.setAttribute("veiculo", v);
                doGet(req, resp);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(anunciarServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private String validaCadastro(veiculos v) {

        if (!Validaback.validaString(v.getTitulo(), 2)) {
            return "O Titulo do Anuncio deve possuir ao menos 2 caracteres.";
        }
        if (!Validaback.validaDouble(v.getPreco(), 0.01, Double.MAX_VALUE)) {
            return "O preço do produto é obrigatorio.";
        }
        if (!Validaback.validaDouble(v.getKm(), 0, Double.MAX_VALUE)) {
            return "O quilometragem é obrigatorio e não pode ser negativa.";
        }
        if (!Validaback.validaString(v.getCombustivel(), 0)) {
            return "O tipo do combustivel é obrigatorio.";
        }
        if (v.getImg() == null) {
            return "A imagem do produto é obrigatória.";
        }

        Calendar calendar = GregorianCalendar.getInstance();

        calendar.add(calendar.YEAR, 1);
        Date dataMaxima = calendar.getTime();
        String data = Formata.dataParaString(dataMaxima);
        char d1 = data.charAt(6);
        char d2 = data.charAt(7);
        char d3 = data.charAt(8);
        char d4 = data.charAt(9);
        String d = String.valueOf(d1) + String.valueOf(d2) + String.valueOf(d3) + String.valueOf(d4);
        Long dataL = Long.parseLong(d);

        if (!Validaback.validaData(v.getAnoFabricacao().toString(), dataL)) {
            return "informe o Ano de Fabricação do veiculo.";
        }
        if (!Validaback.validaData(v.getAnoModelo().toString(), dataL)) {
            return "informe o Ano do modelo do veiculo.";
        }
        return null;
    }

}

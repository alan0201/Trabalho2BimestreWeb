/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.grupointegrado.ads.trabalhoWebAPS.filtros;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author alamv
 */
public class conexao implements Filter {

     @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        
    }
    
    private Connection abrirConexao() throws SQLException{
        Properties config = new Properties();
        config.setProperty("user", "root");
        config.setProperty("password", "");
        config.setProperty("serverTimezone", "America/Sao_Paulo");
        
        String url = "jdbc:mysql://localhost:3306/trabwebaps";
        
        return DriverManager.getConnection(url, config);
    }
    
    private void fecharConexao(Connection conn){
        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Connection conexao = null;
        
        try {
            conexao = abrirConexao();
            
            request.setAttribute("conexao", conexao);
            chain.doFilter(request, response);
            
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally{
            fecharConexao(conexao);
        }
    }


    @Override
    public void destroy() {
    }
    
   
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.grupointegrado.ads.trabalhoWebAPS.dao;


import br.grupointegrado.ads.trabalhoWebAPS.filtros.conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 *
 * @author alamv
 */
public class Dao {
    
    protected Connection conexao;   
    protected PreparedStatement pstmt;
    protected ResultSet resultSet;
    private ResultSetMetaData metaData;

    public Dao(Connection conexao) throws Exception{
       
        this.conexao = conexao;
    }
    
    
    protected void insert() throws SQLException{
        this.pstmt.executeUpdate();
        
    }
    protected void delete() throws SQLException{
        this.pstmt.executeUpdate();
    }
    protected void update() throws SQLException{
        this.pstmt.executeUpdate();
    }
    protected void executeSql() throws SQLException{
        try {
            resultSet = this.pstmt.executeQuery();
        } catch (Exception e) {
            throw new SQLException(e.getMessage());
        }
        try {
            metaData = this.pstmt.getMetaData();
        } catch (Exception e) {
             throw new SQLException(e.getMessage());
        }
    }
    
}

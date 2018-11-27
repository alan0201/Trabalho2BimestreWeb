/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.grupointegrado.ads.trabalhoWebAPS.dao;

import br.grupointegrado.ads.trabalhoWebAPS.modelos.categoria;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alamv
 */
public class categoriasDao extends Dao{

    public categoriasDao(Connection conexao) throws Exception {
        super(conexao);
    }

    

    
    
    
   public categoria getByIdCategoria(String c) throws SQLException {

        String sql = "SELECT * FROM categoriav WHERE codigocv = ? ";
        super.pstmt = super.conexao.prepareStatement(sql);

        super.pstmt.setString(1, c);

        super.executeSql();
        return categoriaObject(super.resultSet);
    }

    public List<categoria> getByAll() throws SQLException {

        String sql = "SELECT * FROM categoriav ";
        super.pstmt = super.conexao.prepareStatement(sql);

        super.executeSql();
        return categoriaObjectList(super.resultSet);
    }
    
     public categoria categoriaObject(ResultSet resultSet) throws SQLException {
        categoria c = new categoria();

        if (resultSet.next()) {
            c.setId(resultSet.getInt("codigocv"));
            c.setDsTipo(resultSet.getString("ds_tipo"));
        }
        return c;
    }

    public List<categoria> categoriaObjectList(ResultSet resultSet) throws SQLException {
        List<categoria> cL = new ArrayList<>();

        while (resultSet.next()) {
            categoria c = new categoria();
            c.setId(resultSet.getInt("codigocv"));
            c.setDsTipo(resultSet.getString("ds_tipo"));
            cL.add(c);
        }
        return cL;
    }

    
}

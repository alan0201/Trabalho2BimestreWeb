/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.grupointegrado.ads.trabalhoWebAPS.dao;

import br.grupointegrado.ads.trabalhoWebAPS.modelos.categoria;
import br.grupointegrado.ads.trabalhoWebAPS.modelos.veiculos;
import br.grupointegrado.ads.trabalhoWebAPS.utils.Formata;
import br.grupointegrado.ads.trabalhoWebAPS.utils.ServletUtil;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.swing.JFileChooser;
import org.apache.tomcat.util.http.fileupload.FileUploadException;

/**
 *
 * @author alamv
 */
public class veiculosDao extends Dao {

    categoriasDao cDao = new categoriasDao(conexao);

    public veiculosDao(Connection conexao) throws Exception {
        super(conexao);
    }

    public void insert(veiculos v) throws SQLException {

        String sql = "INSERT INTO trabwebaps.veiculos(cod_vei, titulo , tipo, km, combustivel, descricao, anofabricacao, anomodelo, preco, imagem, datapostagem) VALUES(?,?,?,?,?,?,?,?,?,?,?)";

        super.pstmt = super.conexao.prepareStatement(sql);

        super.pstmt.setLong(1, v.getId());
        super.pstmt.setString(2, v.getTitulo());
        super.pstmt.setInt(3, v.getTipo().getId());
        super.pstmt.setDouble(4, v.getKm());
        super.pstmt.setString(5, v.getCombustivel());
        super.pstmt.setString(6, v.getDescricao());
        super.pstmt.setLong(7, v.getAnoFabricacao());
        super.pstmt.setLong(8, v.getAnoModelo());
        super.pstmt.setDouble(9, v.getPreco());
        super.pstmt.setString(10, v.getImg());
        super.pstmt.setTimestamp(11, new Timestamp(v.getDatapost().getTime()));

        super.insert();
        super.pstmt.close();

    }

    public void deletAnuncio(Long id) throws SQLException {

        String sql = "delete from veiculos where  cod_vei = ? ";
                

        super.pstmt = super.conexao.prepareStatement(sql);
        super.pstmt.setLong(1, id);

        super.pstmt.execute();

    }

    public void atualizarV(veiculos veiculo) throws SQLException {

        if (veiculo.getImg() != null) {
            String sql = "UPDATE trabwebaps.veiculos SET "
                    + "titulo = ?, anofabricacao = ?, anomodelo = ?, km = ? , preco = ?"
                    + ", combustivel = ?, tipo = ?, imagem = ?, descricao = ?, datapostagem = ?"
                    + "WHERE cod_vei = ?";

            super.pstmt = super.conexao.prepareStatement(sql);
            super.pstmt.setString(1, veiculo.getTitulo());
            super.pstmt.setLong(2, veiculo.getAnoFabricacao());
            super.pstmt.setLong(3, veiculo.getAnoModelo());
            super.pstmt.setDouble(4, veiculo.getKm());
            super.pstmt.setDouble(5, veiculo.getPreco());
            super.pstmt.setString(6, veiculo.getCombustivel());
            super.pstmt.setInt(7, veiculo.getTipo().getId());
            super.pstmt.setString(8, veiculo.getImg());
            super.pstmt.setString(9, veiculo.getDescricao());
            super.pstmt.setTimestamp(10, new Timestamp(veiculo.getDatapost().getTime()));
            super.pstmt.setLong(11, veiculo.getId());

            super.pstmt.execute();
        } else {
            String sql = "UPDATE trabwebaps.veiculos SET "
                    + "titulo = ?, anofabricacao = ?, anomodelo = ?, km = ? , preco = ?"
                    + ", combustivel = ?, tipo = ?, descricao = ?, datapostagem = ?"
                    + "WHERE cod_vei = ?";

            super.pstmt = super.conexao.prepareStatement(sql);
            super.pstmt.setString(1, veiculo.getTitulo());
            super.pstmt.setLong(2, veiculo.getAnoFabricacao());
            super.pstmt.setLong(3, veiculo.getAnoModelo());
            super.pstmt.setDouble(4, veiculo.getKm());
            super.pstmt.setDouble(5, veiculo.getPreco());
            super.pstmt.setString(6, veiculo.getCombustivel());
            super.pstmt.setInt(7, veiculo.getTipo().getId());
            
            super.pstmt.setString(9, veiculo.getDescricao());
            super.pstmt.setTimestamp(10, new Timestamp(veiculo.getDatapost().getTime()));
            super.pstmt.setLong(11, veiculo.getId());

            super.pstmt.execute();
        }

    }

    public veiculos getProdutoByRequest(HttpServletRequest req) throws SQLException, FileUploadException, IOException {
        Map<String, Object> parametters = ServletUtil.recuperaParametrosMultipart(req);

        System.out.println(parametters);

        String id = (String) parametters.get("anuncio-id");
        String titulo = (String) parametters.get("anuncio-titulo");
        String descricao = (String) parametters.get("anuncio-descricao");
        String preco = (String) parametters.get("anuncio-valor");
        String anoModelo = (String) parametters.get("anuncio-ano-modelo");
        String anoFabricado = (String) parametters.get("anuncio-ano-fabricacao");
        String km = (String) parametters.get("anuncio-quilometragem");
        String combustivel = (String) parametters.get("anuncio-combustivel");
        String tipo = (String) parametters.get("anuncio-categoria");

        Arquivo arquivoImagem = (Arquivo) parametters.get("anuncio-imagem");

        String imagemCaminho = null;
        if (arquivoImagem != null && arquivoImagem.temConteudo()) {
            imagemCaminho = ServletUtil.gravarArquivo(arquivoImagem);
        }

        veiculos v = new veiculos();

        v.setId(Formata.stringParaLong(id));
        v.setDescricao(descricao);
        v.setPreco(Formata.stringParaDouble(preco));
        v.setAnoModelo(Formata.stringParaLong(anoModelo));
        v.setAnoFabricacao(Formata.stringParaLong(anoFabricado));
        v.setKm(Formata.stringParaDouble(km));
        v.setCombustivel(combustivel);
        v.setTipo(cDao.getByIdCategoria(tipo));
        v.setTitulo(titulo);
        v.setImg(imagemCaminho);

        return v;
    }

    public veiculos buscaPorId(Long veiculoId) throws SQLException {
        String sql = "SELECT * FROM veiculos WHERE cod_vei = ? ";
        super.pstmt = super.conexao.prepareStatement(sql);

        super.pstmt.setLong(1, veiculoId);

        super.executeSql();
        return veiculoObject(super.resultSet);
    }

    public List<veiculos> buscaAll(String termoBusca) throws SQLException {
        String paraBusca = "%%";
        if (termoBusca != null) {
            paraBusca = "%" + termoBusca + "%";
        }

        String sql = "SELECT * FROM veiculos "
                + "  WHERE titulo LIKE ?   "
                + "  OR descricao LIKE ?      "
                // + "  OR km = ?      "
                // + "  OR preco = ?      "
                + "  OR anomodelo LIKE ?      "
                + "  OR anofabricacao LIKE ?      "
                + "  OR combustivel LIKE ?      "
                + "  order by datapostagem desc   ";
        super.pstmt = super.conexao.prepareStatement(sql);

        pstmt.setString(1, paraBusca);
        pstmt.setString(2, paraBusca);
        pstmt.setString(3, paraBusca);
        pstmt.setString(4, paraBusca);
        pstmt.setString(5, paraBusca);
        //pstmt.setString(6, paraBusca);
        //pstmt.setString(7, paraBusca);

        super.executeSql();
        return veiculoObjectList(super.resultSet);
    }

    public List<veiculos> buscaAllDouble(String termoBusca) throws SQLException {
        String paraBusca = "%%";
        if (termoBusca != null) {
            paraBusca = "" + termoBusca + "%";
        }

        String sql = "SELECT * FROM veiculos "
                + "  WHERE km like ?      "
                + "  OR preco like ?      "
                + "  order by datapostagem desc   ";
        super.pstmt = super.conexao.prepareStatement(sql);

        pstmt.setString(1, paraBusca);
        pstmt.setString(2, paraBusca);

        super.executeSql();
        return veiculoObjectList(super.resultSet);
    }

    public List<veiculos> buscaAllCategoria(Integer termoBusca) throws SQLException {

        String sql = "SELECT * FROM veiculos    "
                + "  WHERE tipo = ?   "
                + "  order by datapostagem desc   ";
        super.pstmt = super.conexao.prepareStatement(sql);

        pstmt.setInt(1, termoBusca);

        super.executeSql();
        return veiculoObjectList(super.resultSet);
    }

    public veiculos veiculoObject(ResultSet resultSet) throws SQLException {
        veiculos v = new veiculos();

        if (resultSet.next()) {
            v.setId(resultSet.getLong("cod_vei"));
            v.setDescricao(resultSet.getString("descricao"));
            v.setPreco(resultSet.getDouble("preco"));
            v.setAnoModelo(resultSet.getLong("anomodelo"));
            v.setAnoFabricacao(resultSet.getLong("anofabricacao"));
            v.setKm(resultSet.getDouble("km"));
            v.setCombustivel(resultSet.getString("combustivel"));
            v.setTipo(cDao.getByIdCategoria(resultSet.getString("tipo")));
            v.setTitulo(resultSet.getString("titulo"));
            v.setImg(resultSet.getString("imagem"));
            v.setDatapost(resultSet.getTimestamp("datapostagem"));
        }
        return v;
    }

    public List<veiculos> veiculoObjectList(ResultSet resultSet) throws SQLException {

        List<veiculos> vl = new ArrayList<>();

        while (resultSet.next()) {

            veiculos v = new veiculos();
            v.setId(resultSet.getLong("cod_vei"));
            v.setDescricao(resultSet.getString("descricao"));
            v.setPreco(resultSet.getDouble("preco"));
            v.setAnoModelo(resultSet.getLong("anomodelo"));
            v.setAnoFabricacao(resultSet.getLong("anofabricacao"));
            v.setKm(resultSet.getDouble("km"));
            v.setCombustivel(resultSet.getString("combustivel"));
            v.setTipo(cDao.getByIdCategoria(resultSet.getString("tipo")));
            v.setTitulo(resultSet.getString("titulo"));

            v.setImg(resultSet.getString("imagem"));
            v.setDatapost(resultSet.getTimestamp("datapostagem"));
            vl.add(v);
        }

        return vl;
    }

}

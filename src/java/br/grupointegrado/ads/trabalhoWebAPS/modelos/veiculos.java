/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.grupointegrado.ads.trabalhoWebAPS.modelos;

import br.grupointegrado.ads.trabalhoWebAPS.utils.Formata;
import java.util.Date;
import org.apache.catalina.core.ApplicationPart;

/**
 *
 * @author alamv
 */
public class veiculos {

    private Long id;
    private categoria tipo;
    private Double km;
    private String combustivel;
    private String descricao;
    private Long anoFabricacao;
    private Long anoModelo;
    private Double preco;
    private String titulo;
    private String img;
    private Date datapost = new Date();

    public veiculos() {
        
        titulo = "";
        descricao = "";
        anoFabricacao = null;
        anoModelo = null;
        preco = null;
        
    }

    public Date getDatapost() {
        return datapost;
    }

    public void setDatapost(Date datapost) {
        this.datapost = datapost;
    }
    

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

   

   
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public categoria getTipo() {
        return tipo;
    }

    public void setTipo(categoria tipo) {
        this.tipo = tipo;
    }

    public Double getKm() {
        return km;
    }

    public void setKm(Double km) {
        this.km = km;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Long anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public Long getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Long anoModelo) {
        this.anoModelo = anoModelo;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

}

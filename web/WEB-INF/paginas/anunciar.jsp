<%-- 
    Document   : anunciar
    Created on : 06/11/2018, 10:26:53
    Author     : alamv
--%>

<%@page import="java.util.List"%>
<%@page import="br.grupointegrado.ads.trabalhoWebAPS.modelos.categoria"%>
<%@page import="br.grupointegrado.ads.trabalhoWebAPS.modelos.veiculos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    veiculos ve;

    if (request.getAttribute("veiculo") != null) {
        ve = (veiculos) request.getAttribute("veiculo");
    } else {
        ve = new veiculos();

    }

    Object mensagemErro = request.getAttribute("mensagem-erro");
    Object mensagemSalve = request.getAttribute("mensagem-salvo");
    List<categoria> ceL = (List<categoria>) request.getAttribute("categoria");


%>
<!DOCTYPE html>
<html lang="pt-BR">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Anunciar Veículo</title>

        <link rel="stylesheet" type="text/css" href="css/fontawesome.all.min.css">
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/style-default.css">
        <link rel="stylesheet" type="text/css" href="css/style-anunciar.css">
        <script type="text/javascript" src="/TrabalhoWebAPS/js/validations.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js"></script>

        <script>
            function validarFormulario() {
                var idInput = document['form-anunciar']['anuncio-id'];
                var inputTitulo = document['form-anunciar']['anuncio-titulo'];
                var inputAnoFabricacao = document['form-anunciar']['anuncio-ano-fabricacao'];
                var inputAnoModelo = document['form-anunciar']['anuncio-ano-modelo'];
                var inputQuilometragem = document['form-anunciar']['anuncio-quilometragem'];
                var inputValor = document['form-anunciar']['anuncio-valor'];
                var inputCombustivel = document['form-anunciar']['anuncio-combustivel'];
                var inputCategoria = document['form-anunciar']['anuncio-categoria'];
                var inputImagem = document['form-anunciar']['anuncio-imagem'];
                var inputDescricao = document['form-anunciar']['anuncio-descricao'];

                var validoform = true;


                if (!validaString(inputTitulo.value, 2)) {
                    validoform = false;
                    inputTitulo.classList.add('is-invalid');
                    inputTitulo.classList.remove('is-valid');
                } else {
                    inputTitulo.classList.remove('is-invalid');
                    inputTitulo.classList.add('is-valid');
                }

                var dataMaxima = moment().startOf('year').add('year', 1);
                var data = moment().startOf('year');

                if (!validaDataAno(inputAnoFabricacao.value, data)) {
                    validoform = false;
                    inputAnoFabricacao.classList.add('is-invalid');
                    inputAnoFabricacao.classList.remove('is-valid');
                } else {
                    inputAnoFabricacao.classList.remove('is-invalid');
                    inputAnoFabricacao.classList.add('is-valid');
                }

                if (!validaDataAno(inputAnoModelo.value, dataMaxima)) {
                    validoform = false;
                    inputAnoModelo.classList.add('is-invalid');
                    inputAnoModelo.classList.remove('is-valid');
                } else {
                    inputAnoModelo.classList.remove('is-invalid');
                    inputAnoModelo.classList.add('is-valid');
                }

                if (!validaNumber(inputQuilometragem.value, 0, Number.MAX_VALUE)) {
                    validoform = false;
                    inputQuilometragem.classList.add('is-invalid');
                    inputQuilometragem.classList.remove('is-valid');
                } else {
                    inputQuilometragem.classList.remove('is-invalid');
                    inputQuilometragem.classList.add('is-valid');
                }

                if (!validaNumber(inputValor.value, 1, Number.MAX_VALUE)) {
                    validoform = false;
                    inputValor.classList.add('is-invalid');
                    inputValor.classList.remove('is-valid');
                } else {
                    inputValor.classList.remove('is-invalid');
                    inputValor.classList.add('is-valid');
                }

                if (!validaCombustivel(inputCombustivel.value)) {
                    validoform = false;
                    inputCombustivel.classList.add('is-invalid');
                    inputCombustivel.classList.remove('is-valid');
                } else {
                    inputCombustivel.classList.remove('is-invalid');
                    inputCombustivel.classList.add('is-valid');
                }

                if (!validaCategoria(inputCategoria.value)) {
                    validoform = false;
                    inputCategoria.classList.add('is-invalid');
                    inputCategoria.classList.remove('is-valid');
                } else {
                    inputCategoria.classList.remove('is-invalid');
                    inputCategoria.classList.add('is-valid');
                }

                if (!inputImagem.value) {
                    validoform = false;
                    inputImagem.classList.add('is-invalid');
                    inputImagem.classList.remove('is-valid');
                } else {
                    inputImagem.classList.remove('is-invalid');
                    inputImagem.classList.add('is-valid');
                }

                if (!validaString(inputDescricao.value, 10)) {
                    validoform = false;
                    inputDescricao.classList.add('is-invalid');
                    inputDescricao.classList.remove('is-valid');
                } else {
                    inputDescricao.classList.remove('is-invalid');
                    inputDescricao.classList.add('is-valid');
                }


                return validoform;





            }
            
            



        </script>
    </head>

    <body>

        <header>
            <%@include file="/WEB-INF/includes/menuBarra.jsp" %>
        </header>


        <main class="container-fluid">
            <div class="conteudo col-sm-12 col-md-11 col-lg-10">
                <h3>Preencha os dados do anúncio</h3>
                <%                    if (mensagemErro != null) {
                %>
                <div class="alert alert-danger" role="alert">
                    <%=mensagemErro%>
                </div>

                <%
                    }
                %>

                <%                    if (mensagemSalve != null) {
                %>
                <div class="alert alert-success" role="alert">
                    <%=mensagemSalve%>
                </div>

                <%
                    }
                %>
                <div class="dropdown-divider"></div>

                <form name="form-anunciar" method="POST" onsubmit="return validarFormulario()" enctype="multipart/form-data"  accept-charset="utf-8">
                    <input  type="hidden" name="anuncio-id" value="<%=ve.getId()%>"/>
                    <input name="anuncio-data" type="hidden" value="<%=ve.getDatapost()%>"/>

                    <div class="form-row">
                        <div class="col-md-8 col-lg-7 col-xl-6">
                            <div class="form-group">
                                <label for="anuncio-titulo">Título</label>
                                <input type="text" class="form-control" name="anuncio-titulo" id="anuncio-titulo" value="<%=ve.getTitulo()%>" placeholder="Passat TSI 211CV Revisado 3º Dono" 
                                       >
                                <div class="invalid-feedback">
                                    Informe o título do anúncio.
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="col-6 col-md-4 col-lg-3 col-xl-2">
                            <div class="form-group">
                                <label for="anuncio-ano-fabricacao">Ano de fabricação</label>
                                <input type="number" step="1" name="anuncio-ano-fabricacao" class="form-control" id="anuncio-ano-fabricacao" value="<%=ve.getAnoFabricacao()%>" placeholder="2016">
                                <div class="invalid-feedback">
                                    Informe o ano de fabricação do veículo.
                                </div>
                            </div>
                        </div>
                        <div class="col-6 col-md-4 col-lg-3 col-xl-2">
                            <div class="form-group">
                                <label for="anuncio-ano-modelo">Ano do modelo</label>
                                <input type="number" step="1" name="anuncio-ano-modelo" class="form-control" id="anuncio-ano-modelo" value="<%=ve.getAnoModelo()%>" placeholder="2017">
                                <div class="invalid-feedback">
                                    Informe o ano do modelo do veículo.
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="col-6 col-md-4 col-lg-3">
                            <div class="form-group">
                                <label for="anuncio-quilometragem">Quilometragem</label>
                                <div class="input-group">
                                    <input type="number" step="0.1" name="anuncio-quilometragem" class="form-control" value="<%=ve.getKm()%>" id="anuncio-quilometragem"
                                           placeholder="34000">
                                    <div class="input-group-append">
                                        <span class="input-group-text">Km</span>
                                    </div>
                                    <div class="invalid-feedback">
                                        Informe a quilometragem do veículo
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-6 col-md-4 col-lg-3">
                            <div class="form-group">
                                <label for="anuncio-valor">Valor</label>
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">R$</span>
                                    </div>
                                    <input type="number" step="1" name="anuncio-valor" class="form-control" id="anuncio-valor" value="<%= ve.getPreco()%>" placeholder="119990">
                                    <div class="input-group-append">
                                        <span class="input-group-text">,00</span>
                                    </div>
                                    <div class="invalid-feedback">
                                        Informe o valor do veículo.
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="col-md-8 col-lg-7 col-xl-6">
                            <div class="form-group">
                                <!-- Os tipos de combustíveis podem ser fixados no código -->
                                <label for="anuncio-combustivel">Tipo de combustível</label>
                                <select class="form-control" name="anuncio-combustivel"  id="anuncio-combustivel">
                                    <option value=""></option>
                                    <option value="GASOLINA">Gasolina</option>
                                    <option value="ETANOL">Etanol</option>
                                    <option value="FLEX">Flex</option>
                                    <option value="GAS">Gás</option>
                                    <option value="DIESEL">Díesel</option>
                                </select>
                                <div class="invalid-feedback">
                                    Selecione o tipo de combustível do veículo.
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="col-md-8 col-lg-7 col-xl-6">
                            <div class="form-group">
                                <!-- As categorias devem ser carregadas do banco de dados -->
                                <label for="anuncio-categoria">Categoria</label>

                                <select class="form-control" name="anuncio-categoria"  id="anuncio-categoria">
                                    <option value=""></option>
                                    <%
                                        for (categoria c : ceL) {
                                    %>
                                    <option value="<%= c.getId()%>"><%= c.getDsTipo()%></option>

                                    <%
                                        }
                                    %>
                                </select>
                                <div class="invalid-feedback">
                                    Selecione a categoria do veículo.
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="col-lg-8 col-xl-7">
                            <div class="form-group">
                                <label for="anuncio-imagem">Imagem</label>
                                <div class="custom-file">
                                    <input type="file" accept="image/jpg,image/jpeg,image/png" name="anuncio-imagem" value="<%= ve.getImg()%>" class="custom-file-input" id="anuncio-imagem">
                                    <label class="custom-file-label" for="anuncio-imagem">Selecionar arquivo</label>
                                    <div class="invalid-feedback">
                                        Selecione uma foto do veículo.
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="col-lg-8 col-xl-7">
                            <div class="form-group">
                                <label for="anuncio-descricao">Descrição</label>
                                <textarea class="form-control" id="anuncio-descricao" name="anuncio-descricao" value="<%=ve.getDescricao()%>" placeholder="Carro em ótimas condições..."></textarea>
                                <div class="invalid-feedback">
                                    Informe a descrição do anúncio.
                                </div>
                            </div>
                        </div>
                    </div>

                    <a href="/TrabalhoWebAPS/index" class="btn">Cancelar</a>
                    <button type="submit" class="btn btn-primary">Anunciar</button>



                </form>

            </div>
        </main>

        <script src="js/jquery-3.3.1.slim.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/scripts-default.js"></script>
    </body>

</html>


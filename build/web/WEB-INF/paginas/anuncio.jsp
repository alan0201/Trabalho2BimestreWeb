<%-- 
    Document   : anuncio
    Created on : 06/11/2018, 10:28:01
    Author     : alamv
--%>

<%@page import="br.grupointegrado.ads.trabalhoWebAPS.modelos.veiculos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%

    veiculos ve = (veiculos) request.getAttribute("veiculosanu");

%>

<!DOCTYPE html>
<html lang="pt-BR">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Contato</title>

        <link rel="stylesheet" type="text/css" href="css/fontawesome.all.min.css">
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/style-default.css">
        <link rel="stylesheet" type="text/css" href="css/style-anuncio.css">
        <script>
            function excluirProduto(veiculoid) {
                var resultado = confirm("Deseja excluir o produto " + veiculoid + "?");
                if (resultado) {
                    window.location = "index?excluirProduto=" + veiculoid;
                }
            }
        </script>
    </head>

    <body>
        <header>
            <header>
                <%@include file="/WEB-INF/includes/menuBarra.jsp" %>
            </header>
        </header>

        <main class="container-fluid">
            <div class="conteudo col-sm-12 col-md-11 col-lg-10">
                <nav aria-label="breadcrumb">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="/TrabalhoWebAPS/index">Veículos</a></li>
                        <li class="breadcrumb-item"><a href="/TrabalhoWebAPS/index?categoria=<%= ve.getTipo().getId()%>"><%= ve.getTipo().getDsTipo()%></a></li>
                    </ol>
                </nav>

                <h3><%= ve.getTitulo()%></h3>
                <div class="dropdown-divider"></div>



                <div class="row">
                    <div class="col-md-6 mb-4">
                        <img src="imagem?caminho=<%= ve.getImg()%>" class="rounded float-left veiculo-imagem">
                    </div>
                    <div class="col-md-6 mb-3">
                        <div class="veiculo-valor rounded mb-2">
                            <span>R$ <%=ve.getPreco()%></span>
                        </div>
                        <div>
                            <strong>Ano:</strong>
                            <span><%= ve.getAnoModelo()%>/<%= ve.getAnoFabricacao()%></span>
                        </div>
                        <div>
                            <strong>Quilometragem:</strong>
                            <span><%= ve.getKm()%></span>
                        </div>
                        <div>
                            <strong>Combustível:</strong>
                            <span><%= ve.getCombustivel()%></span>
                        </div>
                       
                    </div>
                </div>

                <h4>Descrição</h4>

                <div class="row">
                    <div class="col">
                        <%= ve.getDescricao()%>
                    </div>
                     <div class="btn-group btn-group-sm" role="group">
                            <a href="anunciar?veiculoid=<%= ve.getId() %>"
                               class="btn">
                                Editar
                            </a>
                               <button onclick="excluirProduto(<%= ve.getId() %>)"
                                    type="button" 
                                    class="btn btn-danger">
                                Excluir
                            </button>
                        </div>
                </div>
        </main>

        <script src="js/jquery-3.3.1.slim.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/scripts-default.js"></script>
    </body>

</html>


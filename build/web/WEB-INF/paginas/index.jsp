<%-- 
    Document   : index
    Created on : 09/11/2018, 09:28:13
    Author     : alamv
--%>

<%@page import="br.grupointegrado.ads.trabalhoWebAPS.modelos.categoria"%>
<%@page import="br.grupointegrado.ads.trabalhoWebAPS.utils.Formata"%>
<%@page import="java.util.List"%>
<%@page import="br.grupointegrado.ads.trabalhoWebAPS.modelos.veiculos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%

    List<veiculos> veL = (List<veiculos>) request.getAttribute("veiculos");
    List<categoria> ceL = (List<categoria>) request.getAttribute("categoria");
    
    String termobusca = request.getParameter("busca-veiculo");
    if (termobusca == null) {
        termobusca = "";
    }
 
%>
<!DOCTYPE html>
<html lang="pt-BR">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Anúncios de Veículos</title>

        <link rel="stylesheet" type="text/css" href="css/fontawesome.all.min.css">
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/style-default.css">
        <link rel="stylesheet" type="text/css" href="css/style-index.css">
        
         <style>
            .produto-imagem {
                max-height: 100px;
                max-width: 100px;
            }
        </style>

        <script>
            function abrirAnuncio(anuncioId) {
                window.location = "/TrabalhoWebAPS/anuncio?anuncio=" + anuncioId;
            }
           
        </script>
    </head>

    <body>

        <header>
            <%@include file="/WEB-INF/includes/menuBarra.jsp" %>
        </header>


        <main class="container-fluid">
            <div class="conteudo col-sm-12 col-md-11 col-lg-10">

                <div class="row">
                    <div class="menu-esquerdo col-md-auto">
                        <nav>
                            <form>
                                <div class="input-group input-group-sm mb-3">
                                    <input type="text" class="form-control" placeholder="Busca por palavras chave" name="busca-veiculo" value="<%= termobusca %>"
                                           aria-label="Busca por palavras chave" aria-describedby="button-search">
                                    <div class="input-group-append">
                                        <button class="btn btn-outline-primary" title="Buscar" type="submit" id="button-search">
                                            <i class="fas fa-search"></i>
                                        </button>
                                    </div>
                                </div>
                            </form>

                            <ul class="list-group list-group-flush">
                                <%
                                    for(categoria c : ceL){
                                %>
                                <li class="list-group-item">
                                    <a href="?categoria=<%= c.getId() %>" ><%= c.getDsTipo() %></a>
                                </li>
                                <% 
                                     }
                                      
                                %>
                            </ul>
                        </nav>
                    </div>

                    <div class="col">
                        <h3>Veículos anunciados</h3>
                        <table class="table table-hover">
                            <%                            for (veiculos v : veL) {
                            %>


                            <tr class="tabela-veiculos-linha" onclick="abrirAnuncio(<%= v.getId()%>)">
                                <td class="tv-col-imagem">
                                    <img src="imagem?caminho=<%= v.getImg() %> "  />
                                </td>
                                <td class="informacoes-anuncio">
                                    <div class="row">
                                        <div class="col descricao-anuncio">
                                            <p>
                                                <%= v.getTitulo()%> - <%= v.getAnoModelo()%> | <%= v.getKm()%> KM <br>  
                                                Combustivel: <%= v.getCombustivel()%> 

                                            </p>
                                        </div>
                                        <div class="col-sm-auto valor-anuncio" name="preco">
                                            <p> R$ <%= v.getPreco() %></p>
                                        </div>
                                        <div class="col-sm-auto data-hora-anuncio">
                                            <p>
                                                <%= Formata.sHora(v.getDatapost())%>
                                            </p>
                                        </div>
                                    </div>
                                </td>
                            </tr>




                            <%
                                }
                            %>


                        </table>

                    </div>
                </div>

            </div>
        </main>

        <script src="js/jquery-3.3.1.slim.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/scripts-default.js"></script>
    </body>

</html>

<%-- 
    Document   : contato
    Created on : 06/11/2018, 10:11:40
    Author     : alamv
--%>

<%@page import="br.grupointegrado.ads.trabalhoWebAPS.modelos.contato"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
    contato ce;
     if (request.getAttribute("contato") != null) {
        ce = (contato) request.getAttribute("contato");
    } else {
      ce = new contato();
     
       

    }
    Object mensagemErro = request.getAttribute("mensagem-erro");
    Object mensagemSalve = request.getAttribute("mensagem-salvo");
 

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
        <link rel="stylesheet" type="text/css" href="css/style-contato.css">
        <script type="text/javascript" src="/TrabalhoWebAPS/js/validations.js"></script>

        <script>
            function validarFormulario() {
                var inputNome = document['form-contato']['contato-nome'];
                var inputEmail = document['form-contato']['contato-email'];
                var inputMensagem = document['form-contato']['contato-mensagem'];

                var validoform = true;


                if (!validaString(inputNome.value, 2)) {
                    validoform = false;
                    inputNome.classList.add('is-invalid');
                    inputNome.classList.remove('is-valid');
                } else {
                    inputNome.classList.remove('is-invalid');
                    inputNome.classList.add('is-valid');
                }

                if (!validaEmail(inputEmail.value)) {
                    validoform = false;
                    inputEmail.classList.add('is-invalid');
                    inputEmail.classList.remove('is-valid');
                } else {
                    inputEmail.classList.remove('is-invalid');
                    inputEmail.classList.add('is-valid');
                }
                if (!validaString(inputMensagem.value, 10)) {
                    validoform = false;
                    inputMensagem.classList.add('is-invalid');
                    inputMensagem.classList.remove('is-valid');
                } else {
                    inputMensagem.classList.remove('is-invalid');
                    inputMensagem.classList.add('is-valid');
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
                <h3>Preencha o formulário para entrar em contato com o maior site de anúncios do Brasil</h3>
                <div class="dropdown-divider"></div>
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

                <form name="form-contato" method="POST" onsubmit="return validarFormulario()">

                    <div class="form-row">
                        <div class="col-md-8 col-lg-7 col-xl-6">
                            <div class="form-group">
                                <label for="contato-nome">Nome completo</label>
                                <input type="text" class="form-control" name="contato-nome" id="contato-nome" value="<%= ce.getNome() %>" placeholder="Seu nome">
                                <div class="invalid-feedback">
                                    Informe seu nome completo.
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="col-md-8 col-lg-7 col-xl-6">
                            <div class="form-group">
                                <label for="contato-email">E-mail</label>
                                <input type="email" class="form-control" name="contato-email" id="contato-email" placeholder="Seu e-mail">
                                <div class="invalid-feedback">
                                    Informe seu e-mail de contato.
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="col-lg-8 col-xl-7">
                            <div class="form-group">
                                <label for="contato-mensagem">Mensagem</label>
                                <textarea class="form-control" id="contato-mensagem" name="contato-mensagem" placeholder="Escreva sua mensagem aqui..."></textarea>
                                <div class="invalid-feedback">
                                    Informe sua mensagem.
                                </div>
                            </div>
                        </div>
                    </div>

                    <a href="/index.html" class="btn">Cancelar</a>
                    <button type="submit" class="btn btn-primary">Enviar</button>

                </form>

            </div>
        </main>

        <script src="js/jquery-3.3.1.slim.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/scripts-default.js"></script>
    </body>

</html>


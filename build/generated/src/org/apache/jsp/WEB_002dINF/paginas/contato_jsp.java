package org.apache.jsp.WEB_002dINF.paginas;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class contato_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"pt-BR\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n");
      out.write("    <title>Contato</title>\n");
      out.write("\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.min.css\">\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style-default.css\">\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style-contato.css\">\n");
      out.write("\n");
      out.write("    <script>\n");
      out.write("        function validarFormulario() {\n");
      out.write("            var inputNome = document['form-contato']['contato-nome'];\n");
      out.write("            var inputEmail = document['form-contato']['contato-email'];\n");
      out.write("            var inputMensagem = document['form-contato']['contato-mensagem'];\n");
      out.write("\n");
      out.write("            inputNome.classList.add('is-invalid');\n");
      out.write("            inputEmail.classList.add('is-invalid');\n");
      out.write("            inputMensagem.classList.add('is-invalid');\n");
      out.write("\n");
      out.write("            return false;\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    <header>\n");
      out.write("        <nav class=\"navbar navbar-expand-sm navbar-dark bg-dark\">\n");
      out.write("            <a class=\"navbar-brand\" href=\"index.html\">VEÍCULOS</a>\n");
      out.write("            <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarText\" aria-controls=\"navbarText\"\n");
      out.write("                aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("            </button>\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"navbarText\">\n");
      out.write("                <ul class=\"navbar-nav mr-auto\">\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a class=\"nav-link\" href=\"index.html\">Início</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a class=\"nav-link\" href=\"anunciar.html\">Anunciar</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item active\">\n");
      out.write("                        <a class=\"nav-link\" href=\"contato.html\">Contato</a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("    </header>\n");
      out.write("\n");
      out.write("    <main class=\"container-fluid\">\n");
      out.write("        <div class=\"conteudo col-sm-12 col-md-11 col-lg-10\">\n");
      out.write("            <h3>Preencha o formulário para entrar em contato com o maior site de anúncios do Brasil</h3>\n");
      out.write("            <div class=\"dropdown-divider\"></div>\n");
      out.write("\n");
      out.write("            <form name=\"form-contato\" onsubmit=\"return validarFormulario()\">\n");
      out.write("\n");
      out.write("                <div class=\"form-row\">\n");
      out.write("                    <div class=\"col-md-8 col-lg-7 col-xl-6\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"contato-nome\">Nome completo</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" id=\"contato-nome\" placeholder=\"Seu nome\">\n");
      out.write("                            <div class=\"invalid-feedback\">\n");
      out.write("                                Informe seu nome completo.\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"form-row\">\n");
      out.write("                    <div class=\"col-md-8 col-lg-7 col-xl-6\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"contato-email\">E-mail</label>\n");
      out.write("                            <input type=\"email\" class=\"form-control\" id=\"contato-email\" placeholder=\"Seu e-mail\">\n");
      out.write("                            <div class=\"invalid-feedback\">\n");
      out.write("                                Informe seu e-mail de contato.\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"form-row\">\n");
      out.write("                    <div class=\"col-lg-8 col-xl-7\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"contato-mensagem\">Mensagem</label>\n");
      out.write("                            <textarea class=\"form-control\" id=\"contato-mensagem\" placeholder=\"Escreva sua mensagem aqui...\"></textarea>\n");
      out.write("                            <div class=\"invalid-feedback\">\n");
      out.write("                                Informe sua mensagem.\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <a href=\"/index.html\" class=\"btn\">Cancelar</a>\n");
      out.write("                <button type=\"submit\" class=\"btn btn-primary\">Enviar</button>\n");
      out.write("\n");
      out.write("            </form>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </main>\n");
      out.write("\n");
      out.write("    <script src=\"js/jquery-3.3.1.slim.min.js\"></script>\n");
      out.write("    <script src=\"js/popper.min.js\"></script>\n");
      out.write("    <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("    <script src=\"js/scripts-default.js\"></script>\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.34
 * Generated at: 2013-11-05 16:59:17 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class defaultLogin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("<title>Login Page</title>\n");
      out.write("<link rel = \"stylesheet\" href = \"/stylesheets/potopotophoto_login.css\" type = \"text/css\" />\n");
      out.write("<link href='http://fonts.googleapis.com/css?family=Lato:100,300' rel='stylesheet' type='text/css'>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<nav>\n");
      out.write("\t\t<div id = \"gotoHome\" onclick=\"location.href='/';\">\n");
      out.write("\t\t\t홈화면으로\n");
      out.write("\t\t</div>\n");
      out.write("\t</nav>\n");
      out.write("\t<div id = \"loginMessage\">\n");
      out.write("\t\tLogin, Please\n");
      out.write("\t</div>\n");
      out.write("\t<div id = \"loginSection\">\n");
      out.write("\t\t<div id = \"loginForm\">\n");
      out.write("\t\t\t<form action = \"/login/signIn\" method = \"post\">\n");
      out.write("\t\t\t\t<input class = \"input\" type = \"text\" name = \"userEmail\" placeholder=\" ID\"/><br/><br/>\n");
      out.write("\t\t\t\t<input class = \"input\" type = \"password\" name = \"password\" placeholder=\" password\"/><br/></br>\n");
      out.write("\t\t\t\t<button type = \"submit\" id = \"loginButton\">\n");
      out.write("\t\t\t\t\t로그인\n");
      out.write("\t\t\t\t</button>\n");
      out.write("\t\t\t</form>\n");
      out.write("\t</div>\n");
      out.write("\t\t<div id = \"registerButton\" onclick=\"location.href='/login/register';\">\n");
      out.write("\t\t\t가입하기\n");
      out.write("\t\t</div>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

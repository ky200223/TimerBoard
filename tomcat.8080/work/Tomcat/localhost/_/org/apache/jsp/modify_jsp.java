/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.34
 * Generated at: 2013-11-05 19:56:26 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class modify_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<style type=\"text/css\">\n");
      out.write("body {\n");
      out.write("\tbackground-color: #ecf0f1;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#main {\n");
      out.write("\twidth: 600px;\n");
      out.write("\theight: 60px;\n");
      out.write("\tmargin: 0 auto;\n");
      out.write("\tfont-size: 3.0em;\n");
      out.write("\ttext-align: center;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#contents {\n");
      out.write("\tfont-size: 16px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#blank1 {\n");
      out.write("\twidth: 600px;\n");
      out.write("\theight: 10px;\n");
      out.write("\tmargin: 0 auto;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#blank2 {\n");
      out.write("\twidth: 600px;\n");
      out.write("\theight: 40px;\n");
      out.write("\tmargin: 0 auto;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#blank3 {\n");
      out.write("\twidth: 600px;\n");
      out.write("\theight: 10px;\n");
      out.write("\tmargin: 0 auto;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("<title>파일을 수정해 보자꾸나</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<div id=\"blank1\"></div>\n");
      out.write("\t<div id=\"main\">\n");
      out.write("\t\t사진을 수정해보장 <br>\n");
      out.write("\t\t<hr style=\"width: 400px\">\n");
      out.write("\t\t<div id=\"blank2\"></div>\n");
      out.write("\t\t<div id = \"contents\">\n");
      out.write("\t\t<form action=\"/board/modifySubmit/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${board.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" method=\"post\"\n");
      out.write("\t\t\tenctype=\"multipart/form-data\">\n");
      out.write("\t\t\t<div id=\"content\">\n");
      out.write("\t\t\t\t이 사진 제목이랑 내용을 뭘로 바꿀까? &nbsp;: &nbsp; <input type=\"text\" name=\"title\"\n");
      out.write("\t\t\t\t\tstyle=\"width: 100px\" /> <br /> <br /> <input type=\"text\"\n");
      out.write("\t\t\t\t\tname=\"contents\" style=\"width: 280px; height: 70px\">\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div id=\"blank3\"></div>\n");
      out.write("\t\t\t<!-- accept = \"image/*\" 으로 이미지 파일만 업로드 할 수 있게 한다. -->\n");
      out.write("\t\t\t이미지 파일도 변경을 원하신다면 여기에서 다시 선택해주세요. <br/><br/><input type=\"file\" name=\"file\"\n");
      out.write("\t\t\t\tsize=\"50\" accept=\"image/*\" /> <input type=\"submit\" value=\"수정완료\" />\n");
      out.write("\t\t\t<input type=\"reset\" value=\"리셋하기\" />\n");
      out.write("\t\t</form>\n");
      out.write("\t\t<br/><br/>\n");
      out.write("\t\t<a href=\"/\"> 그냥 수정 안할래요 </a>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
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

package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class demo_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  private org.apache.jasper.runtime.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      String resourceInjectorClassName = config.getInitParameter("com.sun.appserv.jsp.resource.injector");
      if (resourceInjectorClassName != null) {
        _jspx_resourceInjector = (org.apache.jasper.runtime.ResourceInjector) Class.forName(resourceInjectorClassName).newInstance();
        _jspx_resourceInjector.setContext(application);
      }

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Hello DWR!!!</title>\r\n");
      out.write("<script type='text/javascript' src='/DWRExample/js/demo.js'></script>\r\n");
      out.write("<script type='text/javascript' src='/DWRExample/dwr/interface/Demo.js'></script>\r\n");
      out.write("<script type='text/javascript' src='/DWRExample/dwr/engine.js'></script>\r\n");
      out.write("<script type='text/javascript' src='/DWRExample/dwr/util.js'></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<p>Name: <input type=\"text\" id=\"demoName\" /> <input value=\"Send\"\r\n");
      out.write("\ttype=\"button\" onclick=\"update()\" /> <br />\r\n");
      out.write("Reply: <span id=\"demoReply\"></span></p>\r\n");
      out.write("<br>\r\n");
      out.write("<br>\r\n");
      out.write("<p>\r\n");
      out.write("  <input value=\"Include Page\" type=\"button\" onclick=\"forward()\"/><br/>\r\n");
      out.write("  Included Page:\r\n");
      out.write("</p>\r\n");
      out.write("<div id=\"forward\"></div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

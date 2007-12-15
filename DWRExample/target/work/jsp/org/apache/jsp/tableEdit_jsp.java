package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class tableEdit_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>Table Editing</title>\r\n");
      out.write("<script type='text/javascript' src='/DWRExample/dwr/interface/People.js'></script>\r\n");
      out.write("<script type='text/javascript' src='/DWRExample/dwr/engine.js'></script>\r\n");
      out.write("<script type='text/javascript' src='/DWRExample/dwr/util.js'></script>\r\n");
      out.write("<script type='text/javascript' src='/DWRExample/js/myDwr.js'></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body onLoad=\"init()\">\r\n");
      out.write("<h3>All People</h3>\r\n");
      out.write("<table border=\"1\" class=\"rowed grey\">\r\n");
      out.write("\t<thead>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th>Person</th>\r\n");
      out.write("\t\t\t<th>Salary</th>\r\n");
      out.write("\t\t\t<th>Actions</th>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</thead>\r\n");
      out.write("\t<tbody id=\"peoplebody\">\r\n");
      out.write("\t\t<tr id=\"pattern\" style=\"display:none;\">\r\n");
      out.write("\t\t\t<td><span id=\"tableName\">Name</span><br />\r\n");
      out.write("\t\t\t<small> <span id=\"tableAddress\">Address</span></small></td>\r\n");
      out.write("\t\t\t<td>$<span id=\"tableSalary\">Salary</span></td>\r\n");
      out.write("\t\t\t<td><input id=\"edit\" type=\"button\" value=\"Edit\"\r\n");
      out.write("\t\t\t\tonclick=\"editClicked(this.id)\" /> <input id=\"delete\" type=\"button\"\r\n");
      out.write("\t\t\t\tvalue=\"Delete\" onclick=\"deleteClicked(this.id)\" /></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</tbody>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("<h3>Edit Person</h3>\r\n");
      out.write("<table class=\"plain\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>Name:</td>\r\n");
      out.write("\t\t<td><input id=\"name\" type=\"text\" size=\"30\" /></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>Salary:</td>\r\n");
      out.write("\t\t<td>$<input id=\"salary\" type=\"text\" size=\"20\" /></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>Address:</td>\r\n");
      out.write("\t\t<td><input type=\"text\" id=\"address\" size=\"40\" /></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td colspan=\"2\" align=\"right\"><small>(ID=<span id=\"id\">-1</span>)</small>\r\n");
      out.write("\t\t<input type=\"button\" value=\"Save\" onclick=\"writePerson()\" /> <input\r\n");
      out.write("\t\t\ttype=\"button\" value=\"Clear\" onclick=\"clearPerson()\" /></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
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

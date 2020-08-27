package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import domain.Basket;
import java.util.ArrayList;
import domain.User;

public final class basket_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Product List</title>\n");
      out.write("        ");
 ArrayList<Basket> baskets = (ArrayList<Basket>) request.getAttribute("baskets");
      out.write("\n");
      out.write("        ");
 User user = (User) request.getAttribute("user");
      out.write("\n");
      out.write("        ");
 session.setAttribute("user", user);
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h2>Hello, ");
      out.print( user.getUsername());
      out.write("</h2>\n");
      out.write("        <table border=\"2px\">\n");
      out.write("            <tr>\n");
      out.write("                <th width=\"200\">Basket ID</th>\n");
      out.write("                <th width=\"200\">User Name</th>\n");
      out.write("                <th width=\"200\">Product ID</th>\n");
      out.write("                <th width=\"200\">Numbers</th>\n");
      out.write("            </tr>\n");
      out.write("            ");

                for (int i = 0; i < baskets.size(); i++) {
                    Basket basket = baskets.get(i);
            
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td align=\"center\">");
      out.print(basket.getBasketid());
      out.write("</td>\n");
      out.write("                <td align=\"center\">");
      out.print(user.getUsername());
      out.write("</td>\n");
      out.write("                <td align=\"center\">");
      out.print(basket.getProductid());
      out.write("</td>\n");
      out.write("                <td align=\"center\">");
      out.print(basket.getNumbers());
      out.write("</td>\n");
      out.write("                <td align=\"center\">\n");
      out.write("                    <form action=\"delete\" method=\"post\">\n");
      out.write("                        <input type=\"hidden\" name=\"basketid\" value=\"");
      out.print(basket.getBasketid());
      out.write("\">\n");
      out.write("                        <input type=\"hidden\" name=\"userid\" value=\"");
      out.print(user.getUserid());
      out.write("\">\n");
      out.write("                        <input type=\"submit\" value=\"Delete\">\n");
      out.write("                    </form></td>\n");
      out.write("            </tr>\n");
      out.write("            ");
 }
      out.write("\n");
      out.write("        </table>\n");
      out.write("    </body>\n");
      out.write("</html>");
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

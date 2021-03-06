package web;
import domain.Product;
import domain.ProductService;
import domain.UserService;
import domain.User;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import oracle.jdbc.pool.OracleDataSource;
import util.Status;

public final class LoginServlet extends HttpServlet {
    
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }
    public void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        RequestDispatcher view = null;
        UserService UserService = null;
        ProductService ProductService = null;
        Status status = new Status();
        request.setAttribute("status", status);
        String usertype = request.getParameter("usertype");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if (usertype.equals("unknown")) {
            status.addException(new Exception(
                    "Please select a login type"));
        }
        if ((username == null) || (username.length() == 0)) {
            status.addException(new Exception(
                    "Please enter your username"));
        }
        if ((password == null) || (password.length() == 0)) {
            status.addException(new Exception(
                    "Please enter your password"));
        }
        
        User user = null;
        ArrayList<Product> products = null;
        
        try {
            UserService = new UserService();
            user = UserService.getUser(usertype, username, password);
            ProductService = new ProductService();
            products = ProductService.getAllProduct();
            
            if (user == null) {
                status.addException(new Exception(
                        "Please enter your user information in the right way"));
            }
            
            if (products == null) {
                status.addException(new Exception(
                        "The product database error"));
            }
           
            if (!status.isSuccessful()) {
                view = request.getRequestDispatcher("main.jsp");
                view.forward(request, response);
                return;
            }
            request.setAttribute("user", user);
            request.setAttribute("products", products);
        } catch (Exception e) {
            status.addException(e);
            view = request.getRequestDispatcher("main.jsp");
            view.forward(request, response);
        }
        if (usertype.equals("A")) {
            view = request.getRequestDispatcher("admin/login.jsp");
            view.forward(request, response);
        }
        if (usertype.equals("C")) {
            view = request.getRequestDispatcher("login.jsp");
            view.forward(request, response);
        }
    }
}
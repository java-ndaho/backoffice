package org.example.contoller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AuthenticationServlet ",urlPatterns = {"/login"})
public class AuthenticationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        final String login = request.getParameter("login");
        final String password = request.getParameter("password");
        if((login.equals("Honore")&&password.equals("123456")) || (login.equals("honore2")&& password.equals("abcdef"))){
            HttpSession session=request.getSession();
            session.setAttribute("login",login);
            out.println("<html><body> <p>connexion réussie</p><br>");
            out.println("<a href=\"home.jsp\"> Allez à la home </a></body></html><br>");
        } else {
            out.println("<html><body> <p>login / mdp erroné</p><br>");
            out.println("<a href=\"login.html\"> Réessayez</a></body></html><br>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

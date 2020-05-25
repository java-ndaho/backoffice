package org.example.contoller;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HomeServlet",urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();

        PrintWriter out =response.getWriter();
        out.print("<html><body> <h1>OnlineStore, Gestion boutique multimedia en ligne</h1><br>");
        out.print("<p>Bonjour "+session.getAttribute("identifiant")+"</p>");
        out.print("<a href=\"add-work-form.html\">Ajouter une oeuvre au catalogue</a><br>");
        out.print("<a href=\"catalogue\">Accés aux au catalogue</a><br>");
        out.print("</body></html>");
    }
}

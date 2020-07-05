package org.example.contoller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "WorkAddedSuccessServlet  ", urlPatterns = {"/workAddedSuccessServlet"})
public class WorkAddedSuccessServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String identifiantOeuvre =String.valueOf((Long)request.getAttribute("identifiantOeuvre"));
        out.print("<html><body><p>L'oeuvre d'id: "+identifiantOeuvre +" à bien été ajoutée<p><br>");
        out.print("<a href=\"home.jsp\">Retour à l'acceuil</a><br>");
        out.print("<a href=\"add-work\">Ajouter une nouvelle oeuvre</a><br>");
        out.print("</body></html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("test");
    }

}

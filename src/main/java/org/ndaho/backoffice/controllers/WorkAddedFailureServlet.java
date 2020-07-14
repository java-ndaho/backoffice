package org.ndaho.backoffice.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "WorkAddedFailureServlet  ", urlPatterns = {"/workAddedFailureServlet"})
public class WorkAddedFailureServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String errorMessage=(String)request.getAttribute("errorMessage");
        out.print("<html><body><p>Une erreur est survenue, l'oeuvre n'a pas été ajoutée, "+errorMessage +"<p><br>");
        out.print("</body></html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}

package org.ndaho.backoffice.controllers;

import org.apache.commons.lang3.StringUtils;
import org.ndaho.models.Artist;
import org.ndaho.models.Catalogue;
import org.ndaho.models.Work;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddWorkServlet ", urlPatterns = {"/add-work"})
public class AddWorkServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        final String titre = request.getParameter("titre");
        final String annee = request.getParameter("annee");
        final String genre = request.getParameter("genre");
        final String summary = request.getParameter("summary");
        final String artistName = request.getParameter("artistName");
        Work work = new Work(titre);
        work.setAnnee(annee);
        work.setGenre(genre);
        work.setSummary(summary);
        work.setMainArtist(new Artist(artistName));

// check
        if (!StringUtils.isNumeric(annee) || Catalogue.exist(Catalogue.listsOfWorks, work)) {
            String errorMessage = null;
//            Ajouter un message qui preciser l'erreur
            if (!StringUtils.isNumeric(annee)) {
                errorMessage = "L'année de sortie doit etre numerique";
            } else {
                errorMessage = "L'oeuvre existe deja";
            }
            request.setAttribute("errorMessage", errorMessage);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("workAddedFailureServlet");
            requestDispatcher.forward(request, response);
        } else {
            Catalogue.listsOfWorks.add(work);
            request.setAttribute("identifiantOeuvre", work.getId());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("workAddedSuccessServlet");
            requestDispatcher.forward(request, response);


        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
    }
}

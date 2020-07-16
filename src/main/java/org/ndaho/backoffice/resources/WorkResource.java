package org.ndaho.backoffice.resources;


import org.apache.commons.lang3.StringUtils;
import org.ndaho.models.Artist;
import org.ndaho.models.Catalogue;
import org.ndaho.models.Work;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

@Path("/work")
public class WorkResource {
    //    annotation pour path d'appel de la méthode
    @GET
//    annotation pour decrire le type/format de donne retourne
    @Produces(MediaType.APPLICATION_JSON)
    public List<Work> getAllOeuvres() {
        if (Catalogue.listsOfWorks.isEmpty()) {
            Artist tomCruise = new Artist("Tom");
            Artist honore = new Artist("Honore");
            Artist louis = new Artist("Louis");

            Work mirror = new Work("Mirror");
            Work bad = new Work("Bad");
            Work laLegende = new Work("laLegende");

            mirror.setMainArtist(tomCruise);
            mirror.setSummary("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy");
            mirror.setGenre("Science fiction");
            mirror.setAnnee("2019");

            bad.setMainArtist(honore);
            bad.setSummary("It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters");
            bad.setGenre("pop");
            bad.setAnnee("2018");

            laLegende.setMainArtist(louis);
            laLegende.setSummary("Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old");
            laLegende.setGenre("Comedie");
            laLegende.setAnnee("2020");
            Catalogue.listsOfWorks.addAll(Arrays.asList(mirror, bad, laLegende));

        }
        return Catalogue.listsOfWorks;
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Response add(@FormParam("titre") String titre, @FormParam("annee") String release,
                        @FormParam("genre") String genre, @FormParam("summary") String summary, @FormParam("artistName") String artistName) {
        Work work = new Work(titre);
        work.setAnnee(release);
        work.setGenre(genre);
        work.setSummary(summary);
        work.setMainArtist(new Artist(artistName));

// check
        if (!StringUtils.isNumeric(release) || Catalogue.exist(Catalogue.listsOfWorks, work)) {
            String errorMessage = null;
//            Ajouter un message qui preciser l'erreur
            if (!StringUtils.isNumeric(release)) {
                errorMessage = "L'année de sortie doit etre numerique";
            } else {
                errorMessage = "L'oeuvre existe deja";
            }
//            request.setAttribute("errorMessage", errorMessage);
//            RequestDispatcher requestDispatcher = request.getRequestDispatcher("workAddedFailureServlet");
//            requestDispatcher.forward(request, response);
            return Response.status(Response.Status.FORBIDDEN.getStatusCode(), "error").entity(work.getId()).build();
        } else {
            Catalogue.listsOfWorks.add(work);
//            request.setAttribute("identifiantOeuvre", work.getId());
//            RequestDispatcher requestDispatcher = request.getRequestDispatcher("workAddedSuccessServlet");
//            requestDispatcher.forward(request, response);
            return Response.status(Response.Status.CREATED.getStatusCode(), "yes yes success").entity(work.getId()).build();

        }
    }


}

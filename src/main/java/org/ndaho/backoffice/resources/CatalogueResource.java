package org.ndaho.backoffice.resources;


import org.ndaho.models.Artist;
import org.ndaho.models.Catalogue;
import org.ndaho.models.Work;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

@Path("/catalogue")
public class CatalogueResource {
    //    annotation pour path d'appel de la méthode
    @Path("/liste")
    //    annotation pour la methode http utilisé
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

}

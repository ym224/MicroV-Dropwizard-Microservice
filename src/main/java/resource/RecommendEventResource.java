package resource;

import model.Dto.EventDto;
import model.Event;
import service.RecommendationService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/recommend")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RecommendEventResource {

    private RecommendationService recommendationService;

    public RecommendEventResource(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @GET
    @Path("/{userId}")
    public List<EventDto> getEvents(@PathParam("userId") Long userId) {

        // get event in user wish list
        return recommendationService.recommendEventsForUser(userId);
    }
}


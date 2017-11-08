package resource;

import dao.EventDAO;
import dao.EventInterestDAO;
import dao.InterestDAO;
import model.Event;
import model.EventInterest;
import model.Interest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Timestamp;
import java.util.List;

@Path("/event")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EventResource {

    private EventDAO eventDAO;
    private EventInterestDAO eventInterestDAO;
    private InterestDAO interestDAO;

    public EventResource(EventDAO eventDAO, EventInterestDAO eventInterestDAO, InterestDAO interestDAO) {
        this.eventDAO = eventDAO;
        this.eventInterestDAO = eventInterestDAO;
        this.interestDAO = interestDAO;
    }

    @POST
    public Response addEvent(Event event) {
        Long eventId = eventDAO.addEvent(event.getOrganizationId(), event.getName(), event.getDescription(), event.getContactName(),
                event.getEmail(), event.getApplicationURL(), event.getLocation(), event.getZipCode(), event.getTime(),
                event.getSize(), event.getLength());

        //tag event with interest based on event description and add to event interest
        tagEvent(eventId, event);
        return Response.ok().build();
    }

    //TODO: update event


    //TODO: make use of the nlp lib for tagging
    private void tagEvent(Long eventId, Event event) {
        List<Interest> interests = interestDAO.getAllInterests();
        for (Interest interest: interests) {
            if (event.getDescription().toLowerCase().contains(interest.getName().toLowerCase())) {
                eventInterestDAO.addEventInterest(eventId, interest.getId(), new Timestamp(System.currentTimeMillis()));
            }
        }

    }
}

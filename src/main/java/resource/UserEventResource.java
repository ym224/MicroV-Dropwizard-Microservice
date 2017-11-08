package resource;

import dao.EventInterestDAO;
import dao.UserInterestDAO;
import dao.UserWishListDAO;
import model.Event;
import model.UserWishList;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Path("/userWishList")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserEventResource {

    private UserWishListDAO userWishListDAO;
    private EventInterestDAO eventInterestDAO;
    private UserInterestDAO userInterestDAO;

    public UserEventResource(UserWishListDAO userWishListDAO, EventInterestDAO eventInterestDAO, UserInterestDAO userInterestDAO) {
        this.userWishListDAO = userWishListDAO;
        this.eventInterestDAO = eventInterestDAO;
        this.userInterestDAO = userInterestDAO;
    }

    @POST
    public Response addToWishList(@QueryParam("eventId") Long eventId, @QueryParam("userId") Long userId) {
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        System.out.println(eventId + userId);
        userWishListDAO.addEventToWishList(userId, eventId, UserWishList.status.ADDED.toString(), currentTime, currentTime);

        // find all interests tagged to selected event but not to user interests
        List<Long> newInterestIds = eventInterestDAO.findNewUserInterests(userId, eventId);

        // if event is tagged with interest not in user interest, add interest to user interest
        for (Long interestId: newInterestIds) {
            userInterestDAO.addUserInterest(userId, interestId, BigDecimal.ZERO, currentTime);
        }

        return Response.ok().build();
    }

    //update status of item on wishlist
    @PUT
    @Path("/send")
    public Response updateStatus(@QueryParam("eventId") Long eventId, @QueryParam("userId") Long userId) {

        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        userWishListDAO.updateEventInWishList(userId, eventId, UserWishList.status.EMAIL_QUEUED.toString(), currentTime);
        return Response.ok().build();
    }

    @GET
    public List<Event> getUserWishList(@QueryParam("userId") Long userId) {
        System.out.println(userId);
        return userWishListDAO.getEventsByUserId(userId);
    }

    @POST
    @Path("/batchSendEmails")
    public Response batchSendEmails() {

        // get list of queued items in user wish list
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        //userWishListDAO.updateEventInWishList(userId, eventId, UserWishList.status.EMAILED.toString(), currentTime);
        return Response.ok().build();
    }
}

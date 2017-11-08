package resource;

import dao.UserInfoDAO;
import dao.UserInterestDAO;
import dao.UserPreferenceDAO;
import model.Dto.UserDto;
import model.UserInfo;
import model.UserPreference;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {


    private UserInfoDAO userInfoDAO;
    private UserPreferenceDAO userPreferenceDAO;
    private UserInterestDAO userInterestDAO;

    public UserResource(UserInfoDAO userInfoDAO, UserPreferenceDAO userPreferenceDAO, UserInterestDAO userInterestDAO) {
        this.userInfoDAO = userInfoDAO;
        this.userPreferenceDAO = userPreferenceDAO;
        this.userInterestDAO = userInterestDAO;
    }


    @GET
    @Path("/{id}")
    public UserInfo getUser(@PathParam("id") Long userId){
       return userInfoDAO.findUserById(userId);
    }

    @POST
    public Response addUser(UserDto user) {
        Long userId = userInfoDAO.addUser(user.getFirstName(), user.getLastName(), user.getGender(), user.getAge(),
                user.getEmail(), user.getAddress(), user.getPhone());

        if (userId < 1) throw new WebApplicationException("insert into user info table failed");

        Timestamp now = new Timestamp(System.currentTimeMillis());
        userPreferenceDAO.addUserPreference(user.getId(), user.getMaxDistance(), user.getMaxEventLength(),
                user.getMinHour(), user.getMaxHour(), null, null, null, now);

        // add user interests
        for (Long interestId: user.getInterestIds()) {
            userInterestDAO.addUserInterest(userId, interestId, BigDecimal.ZERO, new Timestamp(System.currentTimeMillis()));
        }

        return Response.ok().build();
    }

    @PUT
    @Path("/info/{id}")
    public void updateUserInfo(UserPreference userPreference) {

    }

    @PUT
    @Path("/preference/{id}")
    public void updateUserPreference(UserPreference userPreference) {

    }

    @PUT
    @Path("/interest/{id}")
    public void updateUserInterest(UserPreference userPreference) {

    }
}
package resource;

import dao.InterestDAO;
import model.Interest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/interests")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class InterestResource {

    private InterestDAO interestDAO;

    public InterestResource(InterestDAO interestDAO) {
        this.interestDAO = interestDAO;
    }

    @GET
    public List<Interest> getInterests(){
        return interestDAO.getAllInterests();
    }

}

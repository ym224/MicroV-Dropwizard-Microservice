package resource;

import dao.OrganizationDAO;
import model.Organization;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/organization")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrganizationResource {

    private OrganizationDAO organizationDAO;

    public OrganizationResource(OrganizationDAO organizationDAO) {

        this.organizationDAO = organizationDAO;
    }

    @POST
    public Response addOrganization(Organization organization) {
        organizationDAO.addOrganization(organization.getName(), organization.getAddress(),
                organization.getEmail(), organization.getWebsite());
        return Response.ok().build();
    }

    //TODO: update event
}

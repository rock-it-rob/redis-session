package rob.proto.redis.session.resource;

import rob.proto.redis.session.response.SessionResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("sessions")
public class SessionResource
{
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSession()
    {
        return Response.ok().entity(new SessionResponse("todo: add this")).build();
    }
}

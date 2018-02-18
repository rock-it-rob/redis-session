package rob.proto.redis.session.resource;

import rob.proto.redis.session.response.SessionResponse;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("sessions")
public class SessionResource
{
    @Context
    private ServletContext servletContext;

    @Context
    private HttpServletRequest httpServletRequest;

    /**
     * Gets the id of the current session.
     *
     * @return the id of the current HttpSession or 404 if there is no existing
     * session.
     */
    @GET
    @Path("currentSession")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSessionId()
    {
        HttpSession httpSession = httpServletRequest.getSession(false);
        if (httpSession == null)
        {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok().entity(new SessionResponse(httpSession.getId(), servletContext.hashCode())).build();
    }

    /**
     * Creates a new HttpSession.
     *
     * @return 200 status
     */
    @POST
    @Path("create")
    public Response createSession()
    {
        httpServletRequest.getSession().invalidate();
        httpServletRequest.getSession();
        return Response.ok().build();
    }
}

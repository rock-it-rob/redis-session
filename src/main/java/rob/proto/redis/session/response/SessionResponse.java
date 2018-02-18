package rob.proto.redis.session.response;

public class SessionResponse
{
    private String id;
    private int servletContextId;

    /**
     * Creates a new instance with id properties.
     *
     * @param id               the HttpSession id.
     * @param servletContextId the id of the ServletContext where the HttpSession originates.
     */
    public SessionResponse(String id, int servletContextId)
    {
        this.id = id;
        this.servletContextId = servletContextId;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public int getServletContextId()
    {
        return servletContextId;
    }

    public void setServletContextId(int servletContextId)
    {
        this.servletContextId = servletContextId;
    }
}

package rob.proto.redis.session.response;

public class SessionResponse
{
    private String id;

    public SessionResponse(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }
}

function createSession()
{
    $.post(
        "/redis-session/v1/sessions/create",
        getSessionId
    );
}

function getSessionId()
{
    $.getJSON(
        "/redis-session/v1/sessions/currentSession",
        function(data) {
            $("#sessionId").text(data.id);
            $("#servletContextId").text(data.servletContextId);
        }
    ).fail(function(jqxhr) {
        // ignore 404s.
        if (jqxhr.status != 404) { log(jqxhr.statusText); alert(jqxhr.statusText); }
    });
}
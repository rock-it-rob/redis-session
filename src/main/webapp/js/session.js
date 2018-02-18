function createSession()
{
    $.post(
        "/redis-session/v1/sessions/create",
        getSessionInfo
    );
}

function getSessionInfo()
{
    $.getJSON(
        "/redis-session/v1/sessions/currentSession",
        function(data) {
            $("#session-id").text(data.id);
            $("#servlet-context-id").text(data.servletContextId);
        }
    ).fail(function(jqxhr) {
        // ignore 404s.
        if (jqxhr.status != 404) { log(jqxhr.statusText); alert(jqxhr.statusText); }
    });
}
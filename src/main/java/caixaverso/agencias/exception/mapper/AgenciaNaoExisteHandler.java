package caixaverso.agencias.exception.mapper;

import caixaverso.agencias.exception.AgenciaNaoExisteException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class AgenciaNaoExisteHandler implements ExceptionMapper<AgenciaNaoExisteException> {

    @Override
    public Response toResponse(AgenciaNaoExisteException e){
        return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
    }
}

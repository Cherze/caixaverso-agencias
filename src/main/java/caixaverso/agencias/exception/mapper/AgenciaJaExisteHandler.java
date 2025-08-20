package caixaverso.agencias.exception.mapper;

import caixaverso.agencias.exception.AgenciaJaExisteException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class AgenciaJaExisteHandler implements ExceptionMapper<AgenciaJaExisteException> {

    @Override
    public Response toResponse(AgenciaJaExisteException e) {
        return Response
                .status(Response.Status.CONFLICT)
                .entity(e.getMessage())
                .build();
    }
}

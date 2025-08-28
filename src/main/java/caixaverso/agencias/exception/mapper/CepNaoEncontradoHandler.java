package caixaverso.agencias.exception.mapper;

import caixaverso.agencias.exception.CepNaoEncontradoException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class CepNaoEncontradoHandler implements ExceptionMapper<CepNaoEncontradoException> {

    @Override
    public Response toResponse(CepNaoEncontradoException e) {
        return Response
                .status(Response.Status.CONFLICT)
                .entity(e.getMessage())
                .build();
    }
}

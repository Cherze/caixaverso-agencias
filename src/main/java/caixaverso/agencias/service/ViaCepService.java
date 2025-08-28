package caixaverso.agencias.service;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@RestClient
@RegisterRestClient(baseUri = "https://viacep.com.br/ws")
public interface ViaCepService {
    @GET
    @Path("/{cep}/json")
    @Produces(MediaType.APPLICATION_JSON)
    ViaCepResponse getCepInfo(@PathParam("cep") String cep);

}


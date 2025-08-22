package caixaverso.agencias.controller;

import caixaverso.agencias.dto.AgenciaDTO;
import caixaverso.agencias.model.Agencia;
import caixaverso.agencias.repository.AgenciaRepository;
import caixaverso.agencias.service.AgenciaService;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@Path("/agencias")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class AgenciasController {

//Construtor para controller (@inject)

    private final AgenciaRepository repository;
    private final AgenciaService agenciaService;

    public AgenciasController(AgenciaRepository repository, AgenciaService agenciaService) {
        this.repository = repository;
        this.agenciaService = agenciaService;
    }

    @GET
    public Response getAgencias() {
        List<Agencia> agencias = repository.findAll().list();
        return Response.status(Response.Status.OK).entity(agencias).build();
    }
    @GET
    @Path("/buscar")
    public Response getAgencia(@QueryParam("cgc") int cgc) {
        Agencia agencia = repository.findByCgc(cgc);
        return Response.status(Response.Status.OK).entity(agencia).build();
    }
    @PUT
    @Transactional
    @Path("/{cgc}")
    public Response updateAgencia(@PathParam("cgc") int cgc, AgenciaDTO agenciaDto){
        agenciaService.update(cgc,agenciaDto);
        //Optional<Agencia> agencia = repository.findByCgc(cgc);
        return Response.status(Response.Status.OK).build();
    }

    @POST
    @Transactional
    public Response addAgencia(AgenciaDTO agenciaDto) {
        Agencia agencia = agenciaService.create(agenciaDto);
        //repository.persist(AgenciaMapper.toEntity(agenciaDto));
        return Response.status(Response.Status.CREATED).entity(agencia).build();
    }

}

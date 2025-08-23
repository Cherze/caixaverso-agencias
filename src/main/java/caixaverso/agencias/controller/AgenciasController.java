package caixaverso.agencias.controller;

import caixaverso.agencias.dto.AgenciaDTO;
import caixaverso.agencias.model.Agencia;
import caixaverso.agencias.repository.AgenciaRepository;
import caixaverso.agencias.service.AgenciaService;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.RestPath;

import java.util.List;

@Path("/agencias")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class AgenciasController {

//Construtor para controller (@inject)

    //private final AgenciaRepository repository;
    private final AgenciaService agenciaService;

    public AgenciasController(AgenciaRepository repository, AgenciaService agenciaService) {
       // this.repository = repository;
        this.agenciaService = agenciaService;
    }

    @POST
    @Transactional
    public Response addAgencia(AgenciaDTO agenciaDto) {
        Agencia agencia = agenciaService.create(agenciaDto);
        //repository.persist(AgenciaMapper.toEntity(agenciaDto));
        return Response.status(Response.Status.CREATED).entity(agencia).build();
    }

    @GET
    public Response getAgencias() {
        List<AgenciaDTO> agencias = agenciaService.getAll();
        return Response.status(Response.Status.OK).entity(agencias).build();
    }

    @GET
    @Path("/{cgc}")
    public Response getByCgc(@PathParam("cgc") int cgc) {
        //Agencia agencia = repository.findByCgc(cgc);
        return Response.status(Response.Status.OK).entity(agenciaService.getByCgc(cgc)).build();
    }

    @PUT
    @Transactional
    @Path("/{cgc}")
    public Response updateAgencia(@PathParam("cgc") int cgc, AgenciaDTO agenciaDto){
        agenciaService.update(cgc,agenciaDto);
        //Optional<Agencia> agencia = repository.findByCgc(cgc);
        return Response.status(Response.Status.OK).build();
    }

    @Path("/{cgc}")
    @DELETE
    @Transactional
    public Response deleteAgencia(@PathParam("cgc") int cgc) {
        agenciaService.delete(cgc);
        return Response.status(Response.Status.NO_CONTENT).build();
    }


}

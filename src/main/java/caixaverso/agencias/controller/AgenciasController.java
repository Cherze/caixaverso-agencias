package caixaverso.agencias.controller;

import caixaverso.agencias.dto.AgenciaDTO;
import caixaverso.agencias.model.Agencia;
import caixaverso.agencias.repository.AgenciaRepository;
import caixaverso.agencias.service.AgenciaService;
import caixaverso.agencias.util.ExcelExporter;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.eclipse.microprofile.openapi.annotations.Operation;
//import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;

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
    @DELETE
    @Path("/{cgc}")
    @Transactional
    public Response deleteAgencia(@PathParam("cgc") int cgc) {
        agenciaService.delete(cgc);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @PATCH
    @Path("/{cgc}")
    @Transactional
    public Response updateAgenciaParcial(@PathParam("cgc") int cgc, Map<String, Object> atualizacao){
        agenciaService.updateParcial(cgc, atualizacao);
        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("/export/excel")
    @Produces("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")

    public Response exportToExcel() {
        try {
            List<AgenciaDTO> agenciasDto = agenciaService.getAll();
            XSSFWorkbook workbook = ExcelExporter.exportToExcel(agenciasDto);

            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            workbook.write(stream);

            return Response.ok(stream.toByteArray())
                    .header("Content-Disposition", "attachment; filename=agencias.xlsx")
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

}

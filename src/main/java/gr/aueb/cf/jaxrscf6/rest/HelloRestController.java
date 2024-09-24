package gr.aueb.cf.jaxrscf6.rest;

import gr.aueb.cf.jaxrscf6.model.TeacherReadOnlyDTO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/greetings")
public class HelloRestController {
    @GET
    @Path("hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello(){
        return "Hello Coding Factory";
    }

    @GET
    @Path("/hello-json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response sayHelloJson(){
        TeacherReadOnlyDTO readOnlyDTO = TeacherReadOnlyDTO.builder()
                .id(1L)
                .firstname("Themis")
                .lastname("pilarinos")
                .build();

        return Response.ok(readOnlyDTO).build();
    }


    @GET
    @Path("/teachers")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTeachers(@QueryParam("city") String city){
        if(city == null || city.isEmpty()){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        List<TeacherReadOnlyDTO> teachersReadOnlyDTOs = List.of(
                new TeacherReadOnlyDTO(1L, "Vaso", "nikoloulia"),
                new TeacherReadOnlyDTO(2L, "themis", "Pila"));

        return Response.ok(teachersReadOnlyDTOs).build();
    }

}



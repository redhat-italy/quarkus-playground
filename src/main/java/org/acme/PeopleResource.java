package org.acme;

import io.agroal.api.AgroalDataSource;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/people")
public class PeopleResource {


    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "I'm working";
    }


    @GET
    @Path("{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getByName(@PathParam("name") String name) {
        return Person.findByName(name);
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAll() {
        return Person.findAllPersons();
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(Person person) {
        System.out.println("About to persist" + person);

        if (person.name == null || person.surname == null || person.date_of_birth == null) {
            throw new WebApplicationException("Invalid data.", 422);
        }
        person.persist();
        System.out.println("Done insert " + person);
        return Response.ok(person).status(201).build();
    }

}
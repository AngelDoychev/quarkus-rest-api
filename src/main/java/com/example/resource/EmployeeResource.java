package com.example.resource;

import com.example.model.dto.EmployeeRequest;
import com.example.service.EmployeeService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("api/employees")
public class EmployeeResource {
    @Inject
    EmployeeService employeeService;

    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(EmployeeRequest employee) {
        this.employeeService.create(employee);
        return Response.ok().build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/get/{id}")
    public Response getById(@PathParam("id") Long id) {
        return Response.ok(this.employeeService.getById(id)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public Response getAll() {
        return Response.ok(this.employeeService.getAll()).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/update/{id}")
    public Response update(@PathParam("id") Long id, EmployeeRequest employee) {
        this.employeeService.update(id, employee);
        return Response.ok().build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/delete/{id}")
    public Response delete(@PathParam("id") Long id) {
        this.employeeService.delete(id);
        return Response.ok().build();
    }
}

package org.acme.controller;

import java.util.List;
import java.util.UUID;

import org.acme.dto.EmployeeDto;
import org.acme.entity.Employee;
import org.acme.entity.Task;
import org.acme.repository.EmployeeRepository;
import org.acme.repository.TaskRepository;
import org.jboss.resteasy.reactive.RestResponse.StatusCode;

import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("/employees")
public class EmployeeResource {
    
    @Inject
    private EmployeeRepository employeeRepo;
    @Inject
    private TaskRepository taskRepo;

    
    @POST
    @Transactional
    public Response createEmployee(Employee employee){
        employeeRepo.persist(employee);
        return Response.status(StatusCode.CREATED).build();    
    }

    @POST
    @Path("/{id}/task")
    @Transactional
    public Response addTask(@PathParam("id") UUID id, Task task){
        var employee = employeeRepo.findByIdOptional(id).orElse(null);
        task.setEmployee(employee);
        taskRepo.persist(task);
        employeeRepo.persist(employee);
        return Response.status(StatusCode.CREATED).build();    
    }

    @GET
    @Path("/{id}")
    public Response getEmployee(@PathParam("id") UUID id){
        return Response.ok(employeeRepo.findById(id)).build();
    }

    @GET
    @Transactional
    @Produces
    public Response getAllEmployee(){
        List<EmployeeDto> employees = employeeRepo.findAll().project(EmployeeDto.class).list();
        return Response.ok(employees).build();
    }
}

package org.acme.controller;

import java.util.List;

import org.acme.entity.Employee;
import org.acme.entity.Task;
import org.acme.params.TaskParam;
import org.acme.repository.EmployeeRepository;
import org.acme.repository.TaskRepository;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.RestResponse.ResponseBuilder;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/tasks")
public class TaskResource {

    @Inject
    private TaskRepository taskRepo;
    @Inject
    private EmployeeRepository employeeRepo;

    @POST
    @Transactional()
    public Response createTask(Task task){
        var emplo = new Employee();
        employeeRepo.persist(emplo);
        task.setEmployee(emplo);
        taskRepo.persist(task);
        return Response.ok(task).build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Task> getAllTasks(){
        return taskRepo.listAll();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/param")                         //personalizar una clase para que sea un bean de un parametro
    public RestResponse<Task> getTaskParams(@BeanParam TaskParam taskParam){
        return ResponseBuilder.ok(new Task(), MediaType.APPLICATION_JSON)
            .header("X-task-pong", taskParam.header)
            .build(); 
    }
}

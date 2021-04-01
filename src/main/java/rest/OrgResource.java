package rest;

import DTOs.DepartmentDTO;
import DTOs.DepartmentsDTO;
import DTOs.EmployeeDTO;
import DTOs.EmployeesDTO;
import DTOs.ProjectDTO;
import DTOs.ProjectsDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.Department;
import entities.Departments;
import entities.Employee;
import entities.Employees;
import entities.Project;
import entities.Projects;
import errorhandling.AlreadyExistsException;
import errorhandling.MissingInputException;
import facade.OrgFacade;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeoutException;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import utils.EMF_Creator;

/**
 *
 * @author claes
 */
@Path("org")
public class OrgResource {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final OrgFacade EMPFACADE = OrgFacade.getEmployeeFacade(EMF);

    @Context
    UriInfo uriInfo;

    @GET
    @Path("empl")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployees() throws IOException, InterruptedException, ExecutionException, TimeoutException {
        EmployeesDTO result = EMPFACADE.getAllEmps();
        return Response.ok(gson.toJson(result)).build();

    }

    @POST
    @Path("empl")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String addEmpl(String emp) throws MissingInputException, AlreadyExistsException {
        Employee em = gson.fromJson(emp, Employee.class);
        EmployeeDTO result = EMPFACADE.addEmpl(em.getFirstName(), em.getLastName(), em.getEmail());
        return gson.toJson(result);
    }

    @GET
    @Path("proj")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProjects() throws IOException, InterruptedException, ExecutionException, TimeoutException {
        ProjectsDTO result = EMPFACADE.getAllProjects();
        return Response.ok(gson.toJson(result)).build();
    }

    @POST
    @Path("proj")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String addProject(String pr) throws MissingInputException {
        Project proj = gson.fromJson(pr, Project.class);
        ProjectDTO result = EMPFACADE.addProject(proj.getTitle(), proj.getDuration());
        return gson.toJson(result);
    }

    @GET
    @Path("dept")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDepartments() throws IOException, InterruptedException, ExecutionException, TimeoutException {
        DepartmentsDTO result = EMPFACADE.getAllDepartments();
        return Response.ok(gson.toJson(result)).build();

    }

    @POST
    @Path("dept")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String addDepartment(String dp) throws MissingInputException {
        Department dep = gson.fromJson(dp, Department.class);
        DepartmentDTO result = EMPFACADE.addDepartment(dep.getCode(), dep.getName(), dep.getDescription());
        return gson.toJson(result);
    }

    @GET
    @Path("empdept/{empid}/{deptid}")
    @Produces(MediaType.APPLICATION_JSON)
    public String addEmpToDept(@PathParam("empid") Long empid, @PathParam("deptid") Long deptid) throws IOException, InterruptedException, ExecutionException, TimeoutException {
        String result = EMPFACADE.addEmplToDept(empid, deptid);
        return gson.toJson(result);
    }

    @GET
    @Path("empproject/{empid}/{projid}")
    @Produces(MediaType.APPLICATION_JSON)
    public String addEmpToProject(@PathParam("empid") Long empid, @PathParam("projid") Long projid) throws IOException, InterruptedException, ExecutionException, TimeoutException {
        String result = EMPFACADE.addEmplToProject(empid, projid);
        return gson.toJson(result);

    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("deleteEmp/{empid}")
    public Response deleteEmp(@PathParam("empid") Long empid) {
        Employee deleteEmployee = EMPFACADE.deleteEmployee(empid);
        return Response.ok(gson.toJson(deleteEmployee)).build();
    }
}

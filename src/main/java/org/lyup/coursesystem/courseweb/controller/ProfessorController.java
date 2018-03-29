package org.lyup.coursesystem.courseweb.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.lyup.coursesystem.courserservice.model.Professor;
import org.lyup.coursesystem.courseweb.manager.ProfessorManager;
import org.lyup.coursesystem.courseweb.manager.impl.ProfessorManagerImpl;

@Path("/professors")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfessorController {

	    private ProfessorManager professorManager = new ProfessorManagerImpl();

	    @GET
	    public List<Professor> listAllProfessors() {
	        return professorManager.listAllProfessors();
	    }

	    @GET
	    @Path("/{professorId}")
	    public Professor getProfessorById(@PathParam("ProfessorId") String id) {
	        return professorManager.getProfessorById(id);
	    }

	    @POST
	    public boolean addProfessor(Professor professor) {
	        return professorManager.addProfessor(professor);
	    }

	    @PUT
	    @Path("/{professorId}")
	    public boolean updateProfessor(@PathParam("professorId") String id, Professor professor) {
	        return professorManager.updateProfessor(id, professor);
	    }

	    @DELETE
	    @Path("/{professorId}")
	    public void removeProgram(@PathParam("professorId") String id) {
	        professorManager.removeProfessorById(id);
	    }
}

package com.mkyong.rest;
 
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import my.test.notepad.entity.Note;
import my.test.notepad.resourceEntity.NoteEntity;
import my.test.rest.service.NotesServiceImpl;
 
@Path("/hello")
public class HelloWorldService {
 
	@Autowired
	NotesServiceImpl notesServiceImpl;
	
	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {
 
		String output = "Jersey say : " + msg;
 
		return Response.status(200).entity(output).build();
 
	}
 
	
	@GET
	@Path("/note/{noteId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Note getNote(@PathParam("noteId") String noteId) {
		NotesServiceImpl notesServiceImpl = new NotesServiceImpl();
		Note note=notesServiceImpl.getNote(Integer.parseInt(noteId));
		//return Response.status(200).entity(output).build();
		return note;
 
	}
	@GET
	@Path("/notexml/{noteId}")
	@Produces(MediaType.APPLICATION_XML)
	public Note getNoteXML(@PathParam("noteId") String noteId) {
		NotesServiceImpl notesServiceImpl = new NotesServiceImpl();
		Note note=notesServiceImpl.getNote(Integer.parseInt(noteId));
		//return Response.status(200).entity(output).build();
		return note;
 
	}
	
	@POST @Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/create")	
	public Note createNote(final NoteEntity noteEntity) {
		//NotesServiceImpl notesServiceImpl = new NotesServiceImpl();
		notesServiceImpl.saveOrUpdateNote(notesServiceImpl.getNote(noteEntity));
		Note note = notesServiceImpl.getNote(noteEntity.getId());
	    System.out.println("Note = " + note.toString());
	    return note;
	}
}
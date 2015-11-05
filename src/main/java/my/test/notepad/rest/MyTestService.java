package my.test.notepad.rest;
 
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sun.jersey.api.core.InjectParam;

import my.test.notepad.entity.Note;
import my.test.notepad.entity.User;
import my.test.notepad.resourceEntity.NoteEntity;
import my.test.notepad.resourceEntity.UserEntity;
import my.test.notepad.service.INotesService;
import my.test.notepad.service.NotesServiceImpl;
 
@Component
@Path("/api")
public class MyTestService {
 
@Autowired
INotesService notesServiceImpl;
	
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
		Note note=notesServiceImpl.getNote(Integer.parseInt(noteId));
		//return Response.status(200).entity(output).build();
		return note;
 
	}
	
	@GET
	@Path("/user/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(@PathParam("id") String id) {
		User user=notesServiceImpl.getUser(Integer.parseInt(id));
		//return Response.status(200).entity(output).build();
		return user;
 
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
	
	
	@POST @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/createNote")	
	public Note createNote(final NoteEntity noteEntity) {
		//NotesServiceImpl notesServiceImpl = new NotesServiceImpl();
		notesServiceImpl.saveOrUpdateNote(notesServiceImpl.getNote(noteEntity));
		Note note = notesServiceImpl.getNote(noteEntity.getId());
	    System.out.println("Note = " + note.toString());
	    return note;
	}
	
	@POST @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/registerUser")	
	public User registerUser(final UserEntity userEntity) {
		//NotesServiceImpl notesServiceImpl = new NotesServiceImpl();
		notesServiceImpl.createOrUpdateUser(notesServiceImpl.getUser(userEntity));
		User user = notesServiceImpl.getUser(userEntity.getId());
	    System.out.println("Note = " + user.toString());
	    return user;
	}
}
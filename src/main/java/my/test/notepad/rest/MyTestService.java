package my.test.notepad.rest;
 
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sun.jersey.api.core.InjectParam;
import com.sun.jersey.core.spi.factory.ResponseBuilderImpl;
import com.sun.jersey.spi.inject.Errors.ErrorMessage;

import my.test.notepad.entity.Note;
import my.test.notepad.entity.NoteBook;
import my.test.notepad.entity.User;
import my.test.notepad.lib.ErrorResponseMessage;
import my.test.notepad.lib.exception.NoteException;
import my.test.notepad.resourceEntity.NoteBookEntity;
import my.test.notepad.resourceEntity.NoteEntity;
import my.test.notepad.resourceEntity.UserEntity;
import my.test.notepad.service.INotesService;
import my.test.notepad.service.NotesServiceImpl;
 
@Component
@Path("/api")
public class MyTestService {
 
	private final ResponseBuilderImpl jerseyResponseBuilder = new ResponseBuilderImpl(); 

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
		Note note=notesServiceImpl.getNote(Long.parseLong(noteId));
		//return Response.status(200).entity(output).build();
		return note;
 
	}
	
	@GET
	@Path("/user/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(@PathParam("id") String id) {
		User user=notesServiceImpl.getUser(Long.parseLong(id));
		//return Response.status(200).entity(output).build();
		return user;
 
	}
	
	@GET
	@Path("/notexml/{noteId}")
	@Produces(MediaType.APPLICATION_XML)
	public Note getNoteXML(@PathParam("noteId") String noteId) {
		NotesServiceImpl notesServiceImpl = new NotesServiceImpl();
		Note note=notesServiceImpl.getNote(Long.parseLong(noteId));
		//return Response.status(200).entity(output).build();
		return note;
 
	}
	
	
	@POST @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/createNote")	
	public Response createNote(final NoteEntity noteEntity) {
		Note note = null;
		Response response = null;
		try {
			note = notesServiceImpl.createNote(notesServiceImpl.getNote(noteEntity));
			NoteEntity noteEntity1 = notesServiceImpl.getNoteEntity(note);
			System.out.println("Note = " + noteEntity1.toString());
		    response = createResponse(Status.CREATED, noteEntity1);

		} catch (NoteException e) {
			response = createErrorResponse(Status.INTERNAL_SERVER_ERROR, e);
		}
	        
	    return response;
	}
	
	@DELETE
	@Path("/deleteNote/{noteId}")	
	public Response deleteNote(@PathParam("noteId") final long noteId) {
		Response response = null;
		try {
			notesServiceImpl.deleteNote(noteId);
		    response = createResponse(Status.OK, null);

		} catch (NoteException e) {
			response = createErrorResponse(Status.INTERNAL_SERVER_ERROR, e);
		}
	        
	    return response;
	}
	
	@DELETE
	@Path("/deleteNoteBook/{noteBookId}")
	public Response deleteNoteBook(@PathParam("noteBookId") final long noteBookId) {
		Response response = null;
		try {
			notesServiceImpl.deleteNoteBook(noteBookId);
		    response = createResponse(Status.OK, null);

		} catch (NoteException e) {
			response = createErrorResponse(Status.INTERNAL_SERVER_ERROR, e);
		}
	        
	    return response;
	}
	
	@PUT @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/updateNote/{noteId}")	
	public Response updateNote(@PathParam("noteId") final long noteId, final String note) {
		Response response = null;
		try {
			notesServiceImpl.updateNote(noteId, note);
			Note note1 = notesServiceImpl.getNote(noteId);
			System.out.println("Note = " + note1.toString());
		    response = createResponse(Status.OK, note);

		} catch (Exception e) {

			createErrorResponse(Status.INTERNAL_SERVER_ERROR, e);
		}
	    
	    
	    return response;
	}
	@POST @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/createNoteBook")	
	public Response createNoteBook(final NoteBookEntity noteBookEntity) {
		NoteBook noteBook = null;
		Response response = null;
		try {
			noteBook = notesServiceImpl.createNoteBook(notesServiceImpl.getNoteBook(noteBookEntity));
			NoteBookEntity noteBookEntity1 = notesServiceImpl.getNoteBookEntity(noteBook);
			System.out.println("Note = " + noteBookEntity1.toString());
		    response = createResponse(Status.CREATED, noteBookEntity1);

		} catch (NoteException e) {
			response = createErrorResponse(Status.INTERNAL_SERVER_ERROR, e);
		}
	        
	    return response;
	}
	
	@POST @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/registerUser")	
	public User registerUser(final UserEntity userEntity) {
		//NotesServiceImpl notesServiceImpl = new NotesServiceImpl();
		notesServiceImpl.createOrUpdateUser(notesServiceImpl.getUser(userEntity));
		User user = notesServiceImpl.getUser(userEntity.getUserId());
	    System.out.println("User = " + user.toString());
	    return user;
	}
	
	private Response createResponse(Status status, Object entity) {
		ResponseBuilder builder = jerseyResponseBuilder
				.status(status)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		if (entity != null)
			builder.entity(entity);
		return builder.build();
	}
	
	private Response createErrorResponse(Status status, Exception ex) {
		ErrorResponseMessage errorMessage = new ErrorResponseMessage();
		NoteException ex2 = (NoteException) ex;
		errorMessage.setErroCode(ex2.getErrorCode());
		errorMessage.setDescription(ex2.getErrorDescription());
		ResponseBuilder builder = jerseyResponseBuilder
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		if (errorMessage != null)
			builder.entity(errorMessage);
		return builder.build();
	}
}
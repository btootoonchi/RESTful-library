package RESTful.library.resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import RESTful.library.model.Books;


/*This class will implement all the request on the resource: 
 * GET
 * PUT
 * DELETE
 * POST
 */
@Path("/books")
public class BookResource {
    
	DataBaseSQLite db = new DataBaseSQLite();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)	
	public List<Books> getBooks(){
		List<Books> books = db.query();		
		return books;
	}
	

}

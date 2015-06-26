package RESTful.library.resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import RESTful.library.model.Books;

/*Sqlite Database operations:
 * Access
 * Insert
 * Query
 * Delete
 * Update
 */
public class DataBaseSQLite {
	
	public Connection accessDB(){
		Connection c = null;
		try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Arturo\\Documents\\SelfAdaptiveSystems\\workspace\\library\\library.db");
	      System.out.println("Access Granted.");	    
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );	      
	      System.exit(0);
	    }
	    
		return c;
	}
	
	public List<Books> query(){
		List<Books> results = new ArrayList<>();
		Connection c = null; 
	    c=accessDB();
		if (c!=null){
			try{
				ResultSet rs=null;				 
				Statement stmt = c.createStatement();
				rs = stmt.executeQuery( "SELECT id,name,author,year,publisher FROM books;" );								
				while ( rs.next() ) {
					//Get record from cursor
					int id = rs.getInt("id");
					String  name = rs.getString("name");
					String author  = rs.getString("author");
					int year = rs.getInt("year");
					String publisher = rs.getString("publisher");
					Books b= new Books(id,name,author,year,publisher);                
					//add the record into the list
					results.add(b);
				}
			
            rs.close();
            stmt.close();
            c.close();
			}catch ( Exception e ) {
		    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		    	System.exit(0);
            }
	    }  
		return results;
			
	}
}

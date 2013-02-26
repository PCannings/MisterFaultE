package uk.ac.dundee.computing.aec.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

import javax.sql.DataSource;

import uk.ac.dundee.computing.aec.store.UsernamePasswordStore;

public class UsernamePasswordModel {
	
	private DataSource _ds = null;

	public UsernamePasswordModel() 
	{
		// TODO Auto-generated constructor stub
	}
	
	public void setDatasource(DataSource _ds){
		this._ds=_ds;
		System.out.println("Set Data Source in Model"+_ds.toString());
	}

    public LinkedList<UsernamePasswordStore> getParts()
    {
    	LinkedList<UsernamePasswordStore> psl =  new LinkedList<UsernamePasswordStore>();
    	Connection Conn ;
    	UsernamePasswordStore ps=null;
    	ResultSet rs=null;
    	try{
			Conn = _ds.getConnection();
	    }catch(Exception et){
	
		     System.out.println("No Connection in Parts Model");
		     return null;	
	    }
	
    	PreparedStatement pmst=null;
    	Statement stmt=null;
    	String sqlQuery="select username,password from members";
    	System.out.println("Parts Query "+sqlQuery);
    	try {
    		try{
    			stmt =Conn.createStatement();
    		}catch(Exception et){
    			System.out.println("Can't create prepare statement");
    			return null;
    		}
    		   System.out.println("Created prepare");
    		try{
    			rs=stmt.executeQuery(sqlQuery);
    		}catch (Exception et){
    			System.out.println("Can not execut query "+et);
    			return null;
    		}
            System.out.println("Statement executed");
            if (rs.wasNull()){
     			System.out.println("result set was null");
     		}else {
     			System.out.println("Well it wasn't null");
     		}
    		while (rs.next() ){
    			System.out.println("Getting RS");
    			ps= new UsernamePasswordStore();
    			ps.setPassword(rs.getString("password"));
    			ps.setUsername(rs.getString("username"));
    			psl.add(ps);
     		}
    	}catch(Exception ex){
    		System.out.println("Opps, error in query "+ex);
    		return null;
    	}
    	
	    	try{
	    		System.out.println("Bugger that I'm doing a finally");
	    		Conn.close();
	    	}catch(Exception ex){
	    		return null;
	    	}
	    	return psl;
    	
    }
    
    public boolean authenticate(String username, String password)
    {
    	LinkedList<UsernamePasswordStore> psl =  new LinkedList<UsernamePasswordStore>();
    	Connection Conn ;
    	UsernamePasswordStore ps=null;
    	ResultSet rs=null;
    	try{
			Conn = _ds.getConnection();
	    }catch(Exception et){
	
		     System.out.println("No Connection in Parts Model");
		     return false;	
	    }
	
    	PreparedStatement pmst=null;
    	Statement stmt=null;
    	String sqlQuery="select username,password from members";
    	System.out.println("Parts Query "+sqlQuery);
    	try {
    		try{
    			stmt =Conn.createStatement();
    		}catch(Exception et){
    			System.out.println("Can't create prepare statement");
    			return false;
    		}
    		   System.out.println("Created prepare");
    		try{
    			rs=stmt.executeQuery(sqlQuery);
    		}catch (Exception et){
    			System.out.println("Can not execut query "+et);
    			return false;
    		}
            System.out.println("Statement executed");
            if (rs.wasNull()){
     			System.out.println("result set was null");
     		}else {
     			System.out.println("Well it wasn't null");
     		}
    		while (rs.next() ){
    			System.out.println("Getting RS");
    			ps= new UsernamePasswordStore();
    			ps.setPassword(rs.getString("password"));
    			ps.setUsername(rs.getString("username"));
    			psl.add(ps);
    			if(username.equals(rs.getString("username"))&&password.equals(rs.getString("password")))
    			{
    				return true;
    			}
    			else
    			{
    				return false;
    			}
     		}
    	}catch(Exception ex){
    		System.out.println("Opps, error in query "+ex);
    		return false;
    	}
    	
	    	try{
	    		System.out.println("Bugger that I'm doing a finally");
	    		Conn.close();
	    	}catch(Exception ex){
	    		return false;
	    	}
	    	return false;  	
    	
    }
    
    public boolean registerUser(String username, String password)
    {
    	LinkedList<UsernamePasswordStore> psl =  new LinkedList<UsernamePasswordStore>();
    	Connection Conn ;
    	UsernamePasswordStore ps=null;
    	
    	try{
			Conn = _ds.getConnection();
	    }catch(Exception et){
	
		     System.out.println("No Connection in Parts Model");
		     return false;	
	    }
	
    	PreparedStatement pmst=null;
    	Statement stmt=null;
    	String sqlUpdate="INSERT INTO `test_schema`.`members` (`username`, `password`) VALUES ('"+username+"', '"+password+"')";
    	System.out.println("Members Update "+sqlUpdate);
    	try {
    		try{
    			stmt =Conn.createStatement();
    		}catch(Exception et){
    			System.out.println("Can't create prepare statement");
    			return false;
    		}
    		   System.out.println("Created prepare");
    		try{
    			stmt.executeUpdate(sqlUpdate);
    		}catch (Exception et){
    			System.out.println("Can not execut query "+et);
    			return false;
    		}
            System.out.println("Statement executed");

    	}catch(Exception ex){
    		System.out.println("Opps, error in query "+ex);
    		return false;
    	}
    	
	    	try{
	    		System.out.println("Bugger that I'm doing a finally");
	    		Conn.close();
	    	}catch(Exception ex){
	    		return false;
	    	}
	    	return true;  	
    	
    }
	
}

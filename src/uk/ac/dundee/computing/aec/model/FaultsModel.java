package uk.ac.dundee.computing.aec.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

import javax.sql.DataSource;

import uk.ac.dundee.computing.aec.store.FaultsStore;
import uk.ac.dundee.computing.aec.store.FaultsStore;

public class FaultsModel {
	
	private DataSource _ds = null;

	public FaultsModel() {
		// TODO Auto-generated constructor stub
	}
	
	public void setDatasource(DataSource _ds){
		this._ds=_ds;
		System.out.println("Set Data Source in Faults Model"+_ds.toString());
	}
	
    public LinkedList<FaultsStore> getFaults()
    {
    	LinkedList<FaultsStore> psl =  new LinkedList<FaultsStore>();
    	Connection Conn;
    	FaultsStore ps=null;
    	ResultSet rs=null;
    	
    	try
    	{
			Conn = _ds.getConnection();
	    }catch(Exception et){
	
		     System.out.println("No Connection in Faults Model");
		     return null;	
	    }
	
    	PreparedStatement pmst=null;
    	Statement stmt=null;
    	String sqlQuery="select idfault,fault_title,fault_information,fault_author from fault";
    	System.out.println("Faults Query "+sqlQuery);
    	
    	try 
    	{
    		try
    		{
    			stmt =Conn.createStatement();
    		}catch(Exception et)
    		{
    			System.out.println("Can't create prepare statement");
    			return null;
    		}
    		   System.out.println("Created prepare");
    		try
    		{
    			rs=stmt.executeQuery(sqlQuery);
    		}catch (Exception et)
    		{
    			System.out.println("Can not execut query "+et);
    			return null;
    		}
    		
            System.out.println("Statement executed");
            
            if (rs.wasNull())
            {
     			System.out.println("result set was null");
     		}
            else 
     		{
     			System.out.println("Well it wasn't null");
     		}
            
    		while (rs.next() )
    		{
    			System.out.println("Getting RS");
    			
    			ps= new FaultsStore();
    			ps.setIDFault(rs.getInt("idfault"));
    			ps.setFaultTile(rs.getString("fault_title"));
    			ps.setFaultInformation(rs.getString("fault_information"));
    			ps.setFaultAuthor(rs.getString("fault_author"));
    			
    			psl.add(ps);
     		}
    	}catch(Exception ex)
    	{
    		System.out.println("Opps, error in query "+ex);
    		return null;
    	}
 	    	try
 	    	{
	    		System.out.println("Bugger that I'm doing a finally");
	    		Conn.close();
	    	}catch(Exception ex)
	    	{
	    		return null;
	    	}
 	    	
	   	return psl;
    }

}

package uk.ac.dundee.computing.aec.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

import javax.sql.DataSource;

import uk.ac.dundee.computing.aec.store.NewsStore;

public class NewsModel {
	
	private DataSource _ds = null;

	public NewsModel() {
		// TODO Auto-generated constructor stub
	}
	
	public void setDatasource(DataSource _ds){
		this._ds=_ds;
		System.out.println("Set Data Source in News Model"+_ds.toString());
	}
	
    public LinkedList<NewsStore> getParts()
    {
    	LinkedList<NewsStore> psl =  new LinkedList<NewsStore>();
    	Connection Conn;
    	NewsStore ps=null;
    	ResultSet rs=null;
    	
    	try
    	{
			Conn = _ds.getConnection();
	    }catch(Exception et){
	
		     System.out.println("No Connection in News Model");
		     return null;	
	    }
	
    	PreparedStatement pmst=null;
    	Statement stmt=null;
    	String sqlQuery="select idnews,datenews,textnews,authornews from news";
    	System.out.println("News Query "+sqlQuery);
    	
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
    			
    			ps= new NewsStore();
    			ps.setIDNews(rs.getInt("idnews"));
    			ps.setDateNews(rs.getString("datenews"));
    			ps.setTextNews(rs.getString("textnews"));
    			ps.setAuthorNews(rs.getString("authornews"));
    			
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

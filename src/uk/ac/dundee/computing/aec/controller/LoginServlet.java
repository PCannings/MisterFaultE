package uk.ac.dundee.computing.aec.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import javax.naming.Binding;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import uk.ac.dundee.computing.aec.model.UsernamePasswordModel;
import uk.ac.dundee.computing.aec.store.UsernamePasswordStore;

@WebServlet(urlPatterns = { "/LoginServlet"},initParams = {@WebInitParam(name = "data-source", value = "jdbc/TestDB", description = "Jdbc link to test.db")})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DataSource _ds = null;
	
    public LoginServlet() 
    {
        super();

    }

	public void init(ServletConfig config) throws ServletException
	{

		assemble(config);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Iterator<UsernamePasswordStore> iterator;
		UsernamePasswordModel Parts= new UsernamePasswordModel();
		
		Parts.setDatasource(_ds);
		LinkedList<UsernamePasswordStore> psl=Parts.getParts();
		
		//check if user exists and password matches
		if(Parts.authenticate(username, password))
		{
			request.setAttribute("Members", psl);
			RequestDispatcher rd=request.getRequestDispatcher("Members.jsp");
			rd.forward(request,response);			
		}
		else
		{
			request.setAttribute("Members", psl);
			RequestDispatcher rd=request.getRequestDispatcher("HomePageController");
			rd.forward(request,response);			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}
	
    private void assemble(ServletConfig config) throws ServletException
	{
		     
    	String dataSourceName = config.getInitParameter("data-source");
		System.out.println("Data Source Parameter" + dataSourceName);
		
		if (dataSourceName == null) throw new ServletException("data-source must be specified");
			Context envContext=null;
			try{		
				Context ic = new InitialContext();
			    System.out.println("initial context "+ic.getNameInNamespace() );
			    envContext= (Context)ic.lookup("java:/comp/env");
			    System.out.println("envcontext  "+envContext );
			    listContext(envContext, "");
			}catch (Exception et)
			{
				throw new ServletException("Can't get contexts "+et);
			}

			try
			{
				_ds=(DataSource)envContext.lookup(dataSourceName);
			    if (_ds == null) throw new ServletException(dataSourceName + " is an unknown data-source.");
			    
			} catch (NamingException e) {
				throw new ServletException("Cant find datasource name"+e);
			}
	}
    
    private static final void listContext(Context ctx, String indent) 
    {
    	try 
    	{
    	   
    		NamingEnumeration list = ctx.listBindings("");
    	   
    		while (list.hasMore()) 
    		{
    			Binding item = (Binding) list.next();
    			String className = item.getClassName();
    			String name = item.getName();
    			System.out.println( "" +className + " " + name);
    			Object o = item.getObject();
    			
    			if (o instanceof javax.naming.Context) 
    			{
    				listContext((Context) o, indent + " ");
    			}
    	   }
    	} catch (NamingException ex) 
    	{
    		System.out.println( "JNDI failure: "+ ex);
    	}
    }

}

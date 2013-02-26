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

import uk.ac.dundee.computing.aec.model.FaultsModel;
import uk.ac.dundee.computing.aec.store.FaultsStore;


@WebServlet(urlPatterns = {"/FaultServlet"}, initParams = {@WebInitParam(name = "data-source", value = "jdbc/TestDB", description = "Jdbc link to test.db")})
public class FaultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DataSource _ds = null;

    public FaultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		assemble(config);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Iterator<FaultsStore> iterator;
		FaultsModel Faults= new FaultsModel();
		
		Faults.setDatasource(_ds);
		LinkedList<FaultsStore> psl=Faults.getFaults();
		 
		 /* If we want to forward to a jsp page do this*/
		request.setAttribute("Faults", psl);
		RequestDispatcher rd=request.getRequestDispatcher("RenderFaults.jsp");
					
		rd.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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

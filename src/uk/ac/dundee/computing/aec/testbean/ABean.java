package uk.ac.dundee.computing.aec.testbean;

public class ABean {
	
	private int Counter = 0;
	private boolean loggedIn = false;

	public ABean() {
		// TODO Auto-generated constructor stub
	}
	
	public int getCounter()
	{
		return Counter;
	}
	
	public boolean getLoggedIn()
	{
		return loggedIn;
	}
	
	public void setLoggedIn(boolean loggedIn)
	{
		this.loggedIn = loggedIn;
	}
	
	public void incrementCounter()
	{
		Counter++;
	}
	
	public void setCounter(int Counter)
	{
		this.Counter=Counter;
	}

}

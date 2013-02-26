package uk.ac.dundee.computing.aec.store;

public class UsernamePasswordStore {
	
	private String Password;
	private String Username;

	public UsernamePasswordStore() {
		// TODO Auto-generated constructor stub
	}
	
	public void setPassword(String password){
		Password=password;
	}
	
	public void setUsername(String username){
		Username=username;
	}
	
	public String getPassword(){
		return Password;
	}
	
	public String getUsername(){
		return Username;
	}

}

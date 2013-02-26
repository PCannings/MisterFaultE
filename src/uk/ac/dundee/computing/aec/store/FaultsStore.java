package uk.ac.dundee.computing.aec.store;

public class FaultsStore {
	
	private int IDFault;
	private String FaultTile;
	private String FaultInformation;
	private String FaultAuthor;

	public FaultsStore() {
		// TODO Auto-generated constructor stub
	}
	
	public void setIDFault(int idfault){
		IDFault=idfault;
	}
	
	public void setFaultTile(String fault_title){
		FaultTile=fault_title;
	}
	
	public void setFaultInformation(String fault_information){
		FaultInformation=fault_information;
	}
	
	public void setFaultAuthor(String fault_author){
		FaultAuthor=fault_author;
	}

	public int getIDFault(){
		return IDFault;
	}
	
	public String getFaultTile(){
		return FaultTile;
	}
	
	public String getFaultInformation(){
		return FaultInformation;
	}
	
	public String getFaultAuthor(){
		return FaultAuthor;
	}
	
}

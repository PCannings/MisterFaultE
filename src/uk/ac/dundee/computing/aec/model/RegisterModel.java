package uk.ac.dundee.computing.aec.model;

import javax.sql.DataSource;

public class RegisterModel {
	
	private DataSource _ds = null;
	
	public RegisterModel() {
		// TODO Auto-generated constructor stub
	}
	
	public void setDatasource(DataSource _ds){
		this._ds=_ds;
		System.out.println("Set Data Source in Model"+_ds.toString());
	}

}

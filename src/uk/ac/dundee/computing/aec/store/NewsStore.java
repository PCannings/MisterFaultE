package uk.ac.dundee.computing.aec.store;

public class NewsStore {
	
	private int IDNews;
	private String DateNews;
	private String TextNews;
	private String AuthorNews;

	public NewsStore() {

	}
	
	public void setIDNews(int idnews){
		IDNews=idnews;
	}
	
	public void setDateNews(String datenews){
		DateNews=datenews;
	}
	
	public void setTextNews(String textnews){
		TextNews=textnews;
	}
	
	public void setAuthorNews(String authornews){
		AuthorNews=authornews;
	}

	
	public int getIDNews(){
		return IDNews;
	}
	
	public String getDateNews(){
		return DateNews;
	}
	
	public String getTextNews(){
		return TextNews;
	}
	
	public String getAuthorNews(){
		return AuthorNews;
	}

}

package bean;

public class Gonggao {

	private int gid;
	private String gname;
	private String gclue;
	private String gonggao;
	private String ofschool;
	
	public Gonggao()
	{
		super();
	}
	public Gonggao(int gid,String gname,String gclue,String gonggao,String ofschool)
	{
		super();
		this.gid=gid;
		this.gname=gname;
		this.gclue=gclue;
		this.gonggao=gonggao;
		this.ofschool=ofschool;
		
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	
	
	
	public String getGclue() {
		return gclue;
	}
	public void setGclue(String gclue) {
		this.gclue = gclue;
	}
	public String getGonggao() {
		return gonggao;
	}
	public void setGonggao(String gonggao) {
		this.gonggao = gonggao;
	}
	public String getOfschool() {
		return ofschool;
	}
	public void setOfschool(String ofschool) {
		this.ofschool = ofschool;
	}
	
	
	
}

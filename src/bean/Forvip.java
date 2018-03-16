package bean;

public class Forvip {

	private int rid;
	private String name;
	private String reason;
	
	public Forvip()
	{
		super();
	}
	public Forvip(int rid,String name,String reason)
	{
		super();
		this.rid=rid;
		this.name=name;
		this.reason=reason;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
}

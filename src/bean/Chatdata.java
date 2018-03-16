package bean;

public class Chatdata {
	
	private int cid;
	private String isname;
	private String istext;
	private String toname;
	public Chatdata()
	{
		super();
	}
	
	public Chatdata(int cid,String isname,String istext,String toname)
	{
		super();
		this.cid=cid;
		this.isname=isname;
		this.istext=istext;
		this.toname=toname;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getIsname() {
		return isname;
	}

	public void setIsname(String isname) {
		this.isname = isname;
	}

	public String getIstext() {
		return istext;
	}

	public void setIstext(String istext) {
		this.istext = istext;
	}

	public String getToname() {
		return toname;
	}

	public void setToname(String toname) {
		this.toname = toname;
	}
	
	
	
	
}

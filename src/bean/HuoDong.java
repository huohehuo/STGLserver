package bean;

public class HuoDong {

	private int hid;
	private int rid;
	private String hname;
	private String htitle;
	private String htime;
	private String hword;
	private String ofschool;
	private String ofclue;
	public HuoDong()
	{
		super();
	}
	
	public HuoDong(int hid,int rid,String hname,String htitle,String htime,String hword,String ofschool,String ofclue)
	{
		super();
		this.hid=hid;
		this.rid=rid;
		this.hname=hname;
		this.htitle=htitle;
		this.htime=htime;
		this.hword=hword;
		this.ofschool=ofschool;
		this.ofclue=ofclue;
	}
	
	

	public int getHid() {
		return hid;
	}

	public void setHid(int hid) {
		this.hid = hid;
	}

	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getHname() {
		return hname;
	}
	public void setHname(String hname) {
		this.hname = hname;
	}
	public String getHtitle() {
		return htitle;
	}
	public void setHtitle(String htitle) {
		this.htitle = htitle;
	}
	public String getHtime() {
		return htime;
	}
	public void setHtime(String htime) {
		this.htime = htime;
	}

	public String getHword() {
		return hword;
	}

	public void setHword(String hword) {
		this.hword = hword;
	}

	public String getOfschool() {
		return ofschool;
	}

	public void setOfschool(String ofschool) {
		this.ofschool = ofschool;
	}

	public String getOfclue() {
		return ofclue;
	}

	public void setOfclue(String ofclue) {
		this.ofclue = ofclue;
	}

	
}

package bean;

public class PingLun {

	private int pid;
	private int hid;
	private int rid;
	private String pname;
	private String pword;
	
	public PingLun()
	{
		super();
	}
	public PingLun(int pid,int hid,int rid,String pname,String pword)
	{
		super();
		this.pid=pid;
		this.hid=hid;
		this.rid=rid;
		this.pname=pname;
		this.pword=pword;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
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
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPword() {
		return pword;
	}
	public void setPword(String pword) {
		this.pword = pword;
	}
	
	

}

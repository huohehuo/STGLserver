package bean;

public class Friends {

	private int fid;
	private int rid;
	private int friendid;
	private String friendname;
	public Friends()
	{
		super();
	}
	
	public Friends(int fid,int rid,int friendid,String friendname){
		super();
		this.fid=fid;
		this.rid=rid;
		this.friendid=friendid;
		this.friendname=friendname;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public int getFriendid() {
		return friendid;
	}

	public void setFriendid(int friendid) {
		this.friendid = friendid;
	}

	public String getFriendname() {
		return friendname;
	}

	public void setFriendname(String friendname) {
		this.friendname = friendname;
	}
	
	
	
	
}

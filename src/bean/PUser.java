package bean;

public class PUser {

	private int rid;
	private String name;
	private String password;
	private String sex;
	private int age;
	private String clue;
	private String vip;
	private String mishi;
	private String school;
	public PUser()
	{
		super();
	}
	
	public PUser(int rid,String name,String password,String sex,int age,String clue,String vip,String mishi,String school){
		super();
		this.rid=rid;
		this.name=name;
		this.password=password;
		this.sex=sex;
		this.age=age;
		this.clue=clue;
		this.vip=vip;
		this.mishi=mishi;
		this.school=school;
	}
	public PUser(int rid,String name,String password,String sex,int age,String clue){
		super();
		this.rid=rid;
		this.name=name;
		this.password=password;
		this.sex=sex;
		this.age=age;
		this.clue=clue;
		
	}
	
	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getClue() {
		return clue;
	}

	public void setClue(String clue) {
		this.clue = clue;
	}

	public String getVip() {
		return vip;
	}

	public void setVip(String vip) {
		this.vip = vip;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public String getMishi() {
		return mishi;
	}

	public void setMishi(String mishi) {
		this.mishi = mishi;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
	
	
	
}

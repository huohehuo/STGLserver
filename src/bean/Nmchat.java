package bean;

public class Nmchat {

	private int nid;
	private String name;
	private String sex;
	private String clue;
	private String school;
	private String saytext;
	public Nmchat()
	{
		super();
	}
	public Nmchat(int nid,String name,String sex,String clue,String school,String saytext)
	{
		super();
		this.nid=nid;
		this.name=name;
		this.sex=sex;
		this.clue=clue;
		this.school=school;
		this.saytext=saytext;
	}
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getClue() {
		return clue;
	}
	public void setClue(String clue) {
		this.clue = clue;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getSaytext() {
		return saytext;
	}
	public void setSaytext(String saytext) {
		this.saytext = saytext;
	}
	
	
	
}

package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Chatdata;
import bean.Forvip;
import bean.Friends;
import bean.Gonggao;
import bean.HuoDong;
import bean.Nmchat;
import bean.PUser;
import bean.PingLun;






public class PhoneDao {

	protected static final String FIELDS_INSERT = "name,password,sex,age";
	protected static String INSERT_SQL = "insert into user("+FIELDS_INSERT+")"+"values(?,?,?,?)";
	protected static String SELECT_SQL = "select "+FIELDS_INSERT+" from user where name=?";
	protected static String UPDATE_SQL = "update user set name=?,password=?,sex=?,age=? where name=?";
	protected static String DELETE_SQL = "delete from user where name=?";

	public PreparedStatement prepStmt = null;
	//�����µ��û�  ------------------------------------------------------
		 public PUser create(PUser use){
				try{
					DbUtil dbu=new DbUtil();
					dbu.connDb();
					PreparedStatement prepStmt=dbu.getPstm("insert into user(name,password,sex,age,clue,school)"+"values(?,?,?,?,?,?)");
					
					prepStmt.setString(1, use.getName());
					prepStmt.setString(2,use.getPassword());
					prepStmt.setString(3, use.getSex());
					prepStmt.setInt(4, use.getAge());
					prepStmt.setString(5, use.getClue());
					prepStmt.setString(6,use.getSchool());
					prepStmt.executeUpdate();
					dbu.closeDb();
				}catch(Exception e){
					e.printStackTrace();
				}finally{	
				}
				return use;
			}
		
	

	 //����ָ�����û�
	 public List<PUser> findupdate(String name) throws Exception{
			
			
			DbUtil dbu=new DbUtil();
			dbu.connDb();
			List<PUser> puser =new ArrayList<PUser>();
			PreparedStatement prepStmt=dbu.getPstm("select * from user where name=?");
			prepStmt.setString(1, name);
			ResultSet rs=prepStmt.executeQuery();
				while(rs.next()){
					PUser pu = new PUser();
					pu.setRid(rs.getInt(1));
					pu.setName(rs.getString(2));
					pu.setPassword(rs.getString(3));
					pu.setSex(rs.getString(4));
					pu.setAge(rs.getInt(5));
					pu.setClue(rs.getString(6));
					pu.setVip(rs.getString(7));
					pu.setMishi(rs.getString(8));
					pu.setSchool(rs.getString(9));
					puser.add(pu);
					
				}
				dbu.closeDb();
			return puser;
		}
	 //����ϵ��---��ʾ�����û�
	 public List<PUser> show_allmen(String clue,String school) throws Exception{
			
			DbUtil dbu=new DbUtil();
			dbu.connDb();
			List<PUser> puser =new ArrayList<PUser>();
			PreparedStatement prepStmt=dbu.getPstm("select * from user where clue=? and school=?");
			prepStmt.setString(1, clue);
			prepStmt.setString(2, school);
			ResultSet rs=prepStmt.executeQuery();
				while(rs.next()){
					PUser pu = new PUser();
					pu.setRid(rs.getInt(1));
					pu.setName(rs.getString(2));
					pu.setPassword(rs.getString(3));
					pu.setSex(rs.getString(4));
					pu.setAge(rs.getInt(5));
					pu.setClue(rs.getString(6));
					//pu.setVip(rs.getString(7));
					pu.setSchool(rs.getString(7));
					puser.add(pu);
					
				}
				dbu.closeDb();
			return puser;
		}
	//�����û�����------------------------------------------------
	 public int update_user(PUser use){
			// TODO Auto-generated method stub
			int rowCount = 0;
			DbUtil dbu=new DbUtil();
			try{
				dbu.connDb();
				PreparedStatement prepStmt=dbu.getPstm("update user set name=?,password=?,sex=?,age=?,clue=?,mishi=? where name=?");
				prepStmt.setString(1, use.getName());
				prepStmt.setString(2, use.getPassword());
				prepStmt.setString(3, use.getSex());
				prepStmt.setInt(4, use.getAge());
				prepStmt.setString(5,use.getClue());
				prepStmt.setString(6, use.getMishi());
				prepStmt.setString(7, use.getName());
				rowCount=prepStmt.executeUpdate();
				if(rowCount==0){
					throw new Exception("Update Error:Student Name:"+use.getName());}
				
			}catch(Exception e){
			}finally{
				dbu.closeDb();
			}
		return rowCount;
		}
	 //�ж��Ƿ����  �û���---------------------------------------------------
	 public boolean chackname(String name) throws Exception{
	    	DbUtil lk=new DbUtil();
		    lk.connDb();
	    	   boolean i = false;
	    	   String sql = "select * from user where name=?";
	    	   PreparedStatement ps=lk.getPstm(sql);
	    	   ps.setString(1, name);
	    	   ResultSet rs1 = (ResultSet) ps.executeQuery();
	    	   if (rs1.next())
	    	   	{
	    		   i = true;
	    		   rs1.close();
	    		   ps.close();
	    	   }
	    	   else 
	    	   {
	    		   i = false ;
	    		   rs1.close();
	    		   ps.close();
	    	   }
	    	   lk.closeDb();
	    	   return i;
	    	}
	 
	 //�ж�  �û������ܳ��Ƿ�ƥ��---------------------------------------------------
	 public boolean chackmishi(String name,String mishi) throws Exception{
	    	DbUtil lk=new DbUtil();
		    lk.connDb();
	    	   boolean i = false;
	    	   String sql = "select * from user where name=? and mishi=?";
	    	   PreparedStatement ps=lk.getPstm(sql);
	    	   ps.setString(1, name);
	    	   ps.setString(2, mishi);
	    	   ResultSet rs1 = (ResultSet) ps.executeQuery();
	    	   if (rs1.next())
	    	   	{
	    		   i = true;
	    		   rs1.close();
	    		   ps.close();
	    	   }
	    	   else 
	    	   {
	    		   i = false ;
	    		   rs1.close();
	    		   ps.close();
	    	   }
	    	   lk.closeDb();
	    	   return i;
	    	}
	//��������------------------------------------------------
		 public int update_pwd(PUser use){
				// TODO Auto-generated method stub
				int rowCount = 0;
				DbUtil dbu=new DbUtil();
				try{
					dbu.connDb();
					PreparedStatement prepStmt=dbu.getPstm("update user set password=? where name=?");

					prepStmt.setString(1, use.getPassword());
					prepStmt.setString(2, use.getName());
					rowCount=prepStmt.executeUpdate();
					if(rowCount==0){
						throw new Exception("Update Error:Student Name:"+use.getName());}
					
				}catch(Exception e){
				}finally{
					dbu.closeDb();
				}
			return rowCount;
			}
	
	//�ж��û��Ƿ��¼�ɹ�-------------------------------------------------
	 public boolean chack_login(String n,String p) throws Exception{
	    	DbUtil lk=new DbUtil();
		    lk.connDb();
	    	   boolean i = false;
	    	   String sql = "select * from user where name=? and password=?";
	    	   PreparedStatement ps=lk.getPstm(sql);
	    	   ps.setString(1, n);
	    	   ps.setString(2, p);
	    	   ResultSet rs1 = (ResultSet) ps.executeQuery();
	    	   if (rs1.next())
	    	   	{
	    		   i = true;
	    		   rs1.close();
	    		   ps.close();
	    	   }
	    	   else 
	    	   {
	    		   i = false ;
	    		   rs1.close();
	    		   ps.close();
	    	   }
	    	   lk.closeDb();
	    	   return i;
	    	}
	 
					 /*PingLun
					  * ���۹���
					  * 
					  * 
					  * */
	 
	//�����µ�����  ------------------------------------------------------
		 public PingLun createpl(PingLun use){
				try{
					DbUtil dbu=new DbUtil();
					dbu.connDb();
					PreparedStatement prepStmt=dbu.getPstm("insert into pinglun(hid,rid,pname,pword) values(?,?,?,?)");
					prepStmt.setInt(1,use.getHid());
					prepStmt.setInt(2,use.getRid());
					prepStmt.setString(3, use.getPname());
					prepStmt.setString(4,use.getPword());
					prepStmt.executeUpdate();
					dbu.closeDb();
				}catch(Exception e){
					e.printStackTrace();
				}finally{	
				}
				return use;
			}
	//��ʾ��������---------------------show-------------------------
	 public List<PingLun> show_pl() throws Exception {
				DbUtil dbu=new DbUtil();
				dbu.connDb();
				List<PingLun> pus =new ArrayList<PingLun>();
				PreparedStatement prepStmt=dbu.getPstm("select * from pinglun");
				ResultSet rs=prepStmt.executeQuery();
					while(rs.next()){
						PingLun pu = new PingLun();
						pu.setPid(rs.getInt(1));
						pu.setHid(rs.getInt(2));
						pu.setRid(rs.getInt(3));
						pu.setPname(rs.getString(4));
						pu.setPword(rs.getString(5));
						
						pus.add(pu);
					}
					dbu.closeDb();
				return pus;
			}
	 //����ָ��������--------------------find----------------
	 public List<PingLun> findpl(int hid) throws Exception{
			
			
			DbUtil dbu=new DbUtil();
			dbu.connDb();
			List<PingLun> puser =new ArrayList<PingLun>();
			PreparedStatement prepStmt=dbu.getPstm("select * from pinglun where hid=?");
			prepStmt.setInt(1, hid);
			ResultSet rs=prepStmt.executeQuery();
				while(rs.next()){
					PingLun pu = new PingLun();
					pu.setPid(rs.getInt(1));
					pu.setHid(rs.getInt(2));
					pu.setRid(rs.getInt(3));
					pu.setPname(rs.getString(4));
					pu.setPword(rs.getString(5));
					puser.add(pu);
					
				}
				dbu.closeDb();
			return puser;
		}
	 
	 /*�
	  *  HuoDong
	  *  
	  *  ���ط���
	  * */
	
	//�����µĻ  ------------------------------------------------------
	 public HuoDong createhd(HuoDong use){
			try{
				DbUtil dbu=new DbUtil();
				dbu.connDb();
				PreparedStatement prepStmt=dbu.getPstm("insert into huodong(rid,hname,htitle,htime,hword,ofschool,ofclue) values(?,?,?,?,?,?,?)");
				prepStmt.setInt(1,use.getRid());
				prepStmt.setString(2, use.getHname());
				prepStmt.setString(3,use.getHtitle());
				prepStmt.setString(4,use.getHtime());
				prepStmt.setString(5,use.getHword());
				prepStmt.setString(6,use.getOfschool());
				prepStmt.setString(7,use.getOfclue());
				prepStmt.executeUpdate();
				dbu.closeDb();
			}catch(Exception e){
				e.printStackTrace();
			}finally{	
			}
			return use;
		}
	//��������ѧУ�����л---------------------------------------------------
	 public List<HuoDong> show_hdby(String sc) throws Exception {
				DbUtil dbu=new DbUtil();
				dbu.connDb();
				List<HuoDong> pus =new ArrayList<HuoDong>();
				PreparedStatement prepStmt=dbu.getPstm("select * from huodong where ofschool=?");
				prepStmt.setString(1,sc);
				
				ResultSet rs=prepStmt.executeQuery();
					while(rs.next()){
						HuoDong pu = new HuoDong();
						pu.setHid(rs.getInt(1));
						pu.setRid(rs.getInt(2));
						pu.setHname(rs.getString(3));
						pu.setHtitle(rs.getString(4));
						pu.setHtime(rs.getString(5));
						pu.setHword(rs.getString(6));
						pu.setOfschool(rs.getString(7));
						pu.setOfclue(rs.getString(8));
						pus.add(pu);
					}
					dbu.closeDb();
				return pus;
			}
	//��������ѧУ����ϵ�����л---------------------------------------------------
		 public List<HuoDong> show_hd(String sc,String cl) throws Exception {
					DbUtil dbu=new DbUtil();
					dbu.connDb();
					List<HuoDong> pus =new ArrayList<HuoDong>();
					PreparedStatement prepStmt=dbu.getPstm("select * from huodong where ofschool=? and ofclue=?");
					prepStmt.setString(1,sc);
					prepStmt.setString(2,cl);
					ResultSet rs=prepStmt.executeQuery();
						while(rs.next()){
							HuoDong pu = new HuoDong();
							pu.setHid(rs.getInt(1));
							pu.setRid(rs.getInt(2));
							pu.setHname(rs.getString(3));
							pu.setHtitle(rs.getString(4));
							pu.setHtime(rs.getString(5));
							pu.setHword(rs.getString(6));
							pu.setOfschool(rs.getString(7));
							pu.setOfclue(rs.getString(8));
							pus.add(pu);
						}
						dbu.closeDb();
					return pus;
				}
		//���Ҹ������л---------------------------------------------------
		 public List<HuoDong> show_hdbyname(String name) throws Exception {
					DbUtil dbu=new DbUtil();
					dbu.connDb();
					List<HuoDong> pus =new ArrayList<HuoDong>();
					PreparedStatement prepStmt=dbu.getPstm("select * from huodong where hname=?");
					prepStmt.setString(1,name);
					
					ResultSet rs=prepStmt.executeQuery();
						while(rs.next()){
							HuoDong pu = new HuoDong();
							pu.setHid(rs.getInt(1));
							pu.setRid(rs.getInt(2));
							pu.setHname(rs.getString(3));
							pu.setHtitle(rs.getString(4));
							pu.setHtime(rs.getString(5));
							pu.setHword(rs.getString(6));
							pu.setOfschool(rs.getString(7));
							pu.setOfclue(rs.getString(8));
							pus.add(pu);
						}
						dbu.closeDb();
					return pus;
				}
		 //ɾ��ָ���-----------------------delete--------------------------
		 public void deletehd(HuoDong stu) throws Exception {
				// TODO Auto-generated method stub	
				try{
					DbUtil dbu=new DbUtil();
					dbu.connDb();
					PreparedStatement prepStmt=dbu.getPstm("delete from huodong where hid=?");
					prepStmt.setInt(1,stu.getHid());
					prepStmt.executeUpdate();
					dbu.closeDb();
				}catch(Exception e){
					
				}finally{		
				}
			}
		//�ж��û��Ƿ�Ϊvip-------------------------------------------------
		 public boolean chack_vip(String n) throws Exception{
		    	DbUtil lk=new DbUtil();
			    lk.connDb();
		    	   boolean i = false;
		    	   String sql = "select * from user where name=? and vip is not null";
		    	   PreparedStatement ps=lk.getPstm(sql);
		    	   ps.setString(1, n);
		    	   ResultSet rs1 = (ResultSet) ps.executeQuery();
		    	   if (rs1.next())
		    	   	{
		    		   i = true;
		    		   rs1.close();
		    		   ps.close();
		    	   }
		    	   else 
		    	   {
		    		   i = false ;
		    		   rs1.close();
		    		   ps.close();
		    	   }
		    	   lk.closeDb();
		    	   return i;
		    	}
		 
		 /*Friends
		  * ���ѹ���
		  * 
		  * 
		 */
		 
		//�����ҵĺ���
		 public List<Friends> show_fd(String rid) throws Exception{
				
				DbUtil dbu=new DbUtil();
				dbu.connDb();
				List<Friends> puser =new ArrayList<Friends>();
				PreparedStatement prepStmt=dbu.getPstm("select * from friends where rid=?");
				prepStmt.setString(1, rid);
				ResultSet rs=prepStmt.executeQuery();
					while(rs.next()){
						Friends pu = new Friends();
						pu.setFid(rs.getInt(1));
						pu.setRid(rs.getInt(2));
						pu.setFriendid(rs.getInt(3));
						pu.setFriendname(rs.getString(4));
						puser.add(pu);
						
					}
					dbu.closeDb();
				return puser;
			}
		//��Ӻ���  ------------------------------------------------------
		 public Friends add_friend(Friends use){
				try{
					DbUtil dbu=new DbUtil();
					dbu.connDb();
					PreparedStatement prepStmt=dbu.getPstm("insert into friends(rid,friendid,friendname)"+"values(?,?,?)");
					
					prepStmt.setInt(1, use.getRid());
					prepStmt.setInt(2,use.getFriendid());
					prepStmt.setString(3, use.getFriendname());
					
					prepStmt.executeUpdate();
					dbu.closeDb();
				}catch(Exception e){
					e.printStackTrace();
				}finally{	
				}
				return use;
			}
		//�ж��Ƿ��Ѵ�������---------------------------------------------------
		 public boolean chackfriend(int rid,int fid) throws Exception{
		    	DbUtil lk=new DbUtil();
			    lk.connDb();
		    	   boolean i = false;
		    	   String sql = "select * from friends where rid=? and friendid=?";
		    	   PreparedStatement ps=lk.getPstm(sql);
		    	   ps.setInt(1, rid);
		    	   ps.setInt(2, fid);
		    	   ResultSet rs1 = (ResultSet) ps.executeQuery();
		    	   if (rs1.next())
		    	   	{
		    		   i = true;
		    		   rs1.close();
		    		   ps.close();
		    	   }
		    	   else 
		    	   {
		    		   i = false ;
		    		   rs1.close();
		    		   ps.close();
		    	   }
		    	   lk.closeDb();
		    	   return i;
		    	}
		 
		/* gonggao
		 * ��������
		 * 
		 */
		 
	/*	//��ʾ����---------------------------------------------------
		 public List<Gonggao> show_allgg() throws Exception {
					DbUtil dbu=new DbUtil();
					dbu.connDb();
					List<Gonggao> pus =new ArrayList<Gonggao>();
					PreparedStatement prepStmt=dbu.getPstm("select * from gonggao");
					ResultSet rs=prepStmt.executeQuery();
						while(rs.next()){
							Gonggao pu = new Gonggao();
							pu.setGid(rs.getInt(1));
							pu.setGname(rs.getString(2));
							pu.setGclue(rs.getString(3));
							pu.setGonggao(rs.getString(4));
							pus.add(pu);
						}
						dbu.closeDb();
					return pus;
				}
		 */
		 
		 //����----ϵ��---��ʾ����
		 public List<Gonggao> show_ggbyclueschool(String gclue,String school) throws Exception{
				
				DbUtil dbu=new DbUtil();
				dbu.connDb();
				List<Gonggao> puser =new ArrayList<Gonggao>();
				PreparedStatement prepStmt=dbu.getPstm("select * from xgonggao where gclue=? and ofschool=?");
				prepStmt.setString(1, gclue);
				prepStmt.setString(2, school);
				ResultSet rs=prepStmt.executeQuery();
					while(rs.next()){
						Gonggao pu = new Gonggao();
						pu.setGid(rs.getInt(1));
						pu.setGname(rs.getString(2));
						pu.setGclue(rs.getString(3));
						pu.setOfschool(rs.getString(4));
						pu.setGonggao(rs.getString(5));
						
						puser.add(pu);
						
					}
					dbu.closeDb();
				return puser;
			}
		 
		// ��չ���------------------------------------------------------
			public void removegg(String gname) throws Exception {
				// TODO Auto-generated method stub
				try {
					DbUtil dbu = new DbUtil();
					dbu.connDb();
					PreparedStatement prepStmt = dbu
							.getPstm("delete from xgonggao where gname=?");
					prepStmt.setString(1, gname);
					prepStmt.executeUpdate();
					dbu.closeDb();
				} catch (Exception e) {

				} finally {
				}
			}
			
			//���¹���------------------------------------------------
			 public int updata_gg(Gonggao use){
					// TODO Auto-generated method stub
					int rowCount = 0;
					DbUtil dbu=new DbUtil();
					try{
						dbu.connDb();
						PreparedStatement prepStmt=dbu.getPstm("update xgonggao set gname=?,gclue=?,ofschool=?,gonggao=? where gname=?");
						
						prepStmt.setString(1, use.getGname());
						prepStmt.setString(2, use.getGclue());
						prepStmt.setString(3, use.getOfschool());
						prepStmt.setString(4, use.getGonggao());
						prepStmt.setString(5, use.getGname());
						
						rowCount=prepStmt.executeUpdate();
						if(rowCount==0){
							throw new Exception("Update Error:Student Name:"+use.getGname());}
						
					}catch(Exception e){
					}finally{
						dbu.closeDb();
					}
				return rowCount;
				}
			//�ж��Ƿ����  �û���---------------------------------------------------
			 public boolean chackggname(String name) throws Exception{
			    	DbUtil lk=new DbUtil();
				    lk.connDb();
			    	   boolean i = false;
			    	   String sql = "select * from xgonggao where gname=?";
			    	   PreparedStatement ps=lk.getPstm(sql);
			    	   ps.setString(1, name);
			    	   ResultSet rs1 = (ResultSet) ps.executeQuery();
			    	   if (rs1.next())
			    	   	{
			    		   i = true;
			    		   rs1.close();
			    		   ps.close();
			    	   }
			    	   else 
			    	   {
			    		   i = false ;
			    		   rs1.close();
			    		   ps.close();
			    	   }
			    	   lk.closeDb();
			    	   return i;
			    	}
			//��ӹ��� ------------------------------------------------------
			 public Gonggao addgg(Gonggao use){
					try{
						DbUtil dbu=new DbUtil();
						dbu.connDb();
						PreparedStatement prepStmt=dbu.getPstm("insert into xgonggao(gname,gclue,gonggao,ofschool) values(?,?,?,?)");
						prepStmt.setString(1,use.getGname());
						prepStmt.setString(2, use.getGclue());
						prepStmt.setString(3,use.getGonggao());
						prepStmt.setString(4, use.getOfschool());
						prepStmt.executeUpdate();
						dbu.closeDb();
					}catch(Exception e){
						e.printStackTrace();
					}finally{	
					}
					return use;
				}
			 
			 
			 
			 
			 
			 //��ʾ���԰���Ϣ--------------------find----------------
			 public List<Chatdata> show_chatby(String toname) throws Exception{
					
					
					DbUtil dbu=new DbUtil();
					dbu.connDb();
					List<Chatdata> puser =new ArrayList<Chatdata>();
					PreparedStatement prepStmt=dbu.getPstm("select * from chatdata where toname=?");
					prepStmt.setString(1, toname);
					ResultSet rs=prepStmt.executeQuery();
						while(rs.next()){
							Chatdata pu = new Chatdata();
							pu.setCid(rs.getInt(1));
							pu.setIsname(rs.getString(2));
							pu.setIstext(rs.getString(3));
							pu.setToname(rs.getString(4));
							puser.add(pu);
							
						}
						dbu.closeDb();
					return puser;
				}
			 
			 
			//�����µĻظ�  ------------------------------------------------------
			 public Chatdata forreply(Chatdata use){
					try{
						DbUtil dbu=new DbUtil();
						dbu.connDb();
						PreparedStatement prepStmt=dbu.getPstm("insert into chatdata(isname,istext,toname) values(?,?,?)");
						prepStmt.setString(1,use.getIsname());
						prepStmt.setString(2,use.getIstext());
						prepStmt.setString(3, use.getToname());
						prepStmt.executeUpdate();
						dbu.closeDb();
					}catch(Exception e){
						e.printStackTrace();
					}finally{	
					}
					return use;
				}
			/* 
			 vip����
			 ��ط���
			 */
			//�ж��Ƿ����������vip��  �û���---------------------------------------------------
			 public boolean chackforvip(String name) throws Exception{
			    	DbUtil lk=new DbUtil();
				    lk.connDb();
			    	   boolean i = false;
			    	   String sql = "select * from forvip where name=?";
			    	   PreparedStatement ps=lk.getPstm(sql);
			    	   ps.setString(1, name);
			    	   ResultSet rs1 = (ResultSet) ps.executeQuery();
			    	   if (rs1.next())
			    	   	{
			    		   i = true;
			    		   rs1.close();
			    		   ps.close();
			    	   }
			    	   else 
			    	   {
			    		   i = false ;
			    		   rs1.close();
			    		   ps.close();
			    	   }
			    	   lk.closeDb();
			    	   return i;
			    	}
			//�����µ��û�  ------------------------------------------------------
			 public Forvip createforvip(Forvip use){
					try{
						DbUtil dbu=new DbUtil();
						dbu.connDb();
						PreparedStatement prepStmt=dbu.getPstm("insert into forvip(rid,name,reason)"+"values(?,?,?)");
						
						prepStmt.setInt(1, use.getRid());
						prepStmt.setString(2,use.getName());
						prepStmt.setString(3, use.getReason());
						prepStmt.executeUpdate();
						dbu.closeDb();
					}catch(Exception e){
						e.printStackTrace();
					}finally{	
					}
					return use;
				}
			 
			 
			//�����µ�������Ϣ  ------------------------------------------------------
			 public Nmchat createnm(Nmchat use){
					try{
						DbUtil dbu=new DbUtil();
						dbu.connDb();
						PreparedStatement prepStmt=dbu.getPstm("insert into nmchat(name,sex,clue,school,saytext) values(?,?,?,?,?)");
						//prepStmt.setInt(1,use.getNid());
						prepStmt.setString(1, use.getName());
						prepStmt.setString(2,use.getSex());
						prepStmt.setString(3,use.getClue());
						prepStmt.setString(4,use.getSchool());
						prepStmt.setString(5,use.getSaytext());
						prepStmt.executeUpdate();
						dbu.closeDb();
					}catch(Exception e){
						e.printStackTrace();
					}finally{	
					}
					return use;
				}
			//��ʾ���е�������Ϣ---------------------------------------------------
			 public List<Nmchat> show_nmchat() throws Exception {
						DbUtil dbu=new DbUtil();
						dbu.connDb();
						List<Nmchat> pus =new ArrayList<Nmchat>();
						PreparedStatement prepStmt=dbu.getPstm("select * from nmchat");
						ResultSet rs=prepStmt.executeQuery();
							while(rs.next()){
								Nmchat pu = new Nmchat();
								pu.setNid(rs.getInt(1));
								pu.setName(rs.getString(2));
								pu.setSex(rs.getString(3));
								pu.setClue(rs.getString(4));
								pu.setSchool(rs.getString(5));
								pu.setSaytext(rs.getString(6));
							
								pus.add(pu);
							}
							dbu.closeDb();
						return pus;
					}
			 
}

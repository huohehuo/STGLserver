package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DbUtil;
import bean.Admin;
import bean.Forvip;
import bean.Gonggao;
import bean.HuoDong;
import bean.Nmchat;
import bean.PUser;
import bean.PingLun;

public class WebDao {

	protected static final String FIELDS_INSERT = "rid,name,password,sex,age,clue,vip";
	protected static String INSERT_SQL = "insert into user(" + FIELDS_INSERT
			+ ")" + "values(?,?,?,?)";
	protected static String SELECT_SQL = "select " + FIELDS_INSERT
			+ " from user where name=?";
	protected static String UPDATE_SQL = "update user set "
			+ "name=?,password=?,sex=?,age=? where name=?";
	protected static String DELETE_SQL = "delete from user where name=?";

	public PreparedStatement prepStmt = null;
	
	/*
	admin  set
	*/
	// 管理员登陆
	public boolean login(Admin user) throws Exception {
		DbUtil lk = new DbUtil();
		lk.connDb();
		boolean i = false;
		String sql = "select * from admin where name=? and pwd=?";
		PreparedStatement ps = lk.getPstm(sql);
		ps.setString(1, user.getName());
		ps.setString(2, user.getPwd());
		ResultSet rs1 = (ResultSet) ps.executeQuery();
		if (rs1.next()) {
			i = true;
			rs1.close();
			ps.close();
		} else {
			i = false;
			rs1.close();
			ps.close();
		}
		lk.closeDb();
		return i;
	}

	// 创建新的用户 ------------------------------------------------------
	public PUser create(PUser use) {
		try {
			DbUtil dbu = new DbUtil();
			dbu.connDb();
			PreparedStatement prepStmt = dbu
					.getPstm("insert into user(name,password,sex,age,clue,vip,mishi)"
							+ "values(?,?,?,?,?,?,?)");

			prepStmt.setString(1, use.getName());
			prepStmt.setString(2, use.getPassword());
			prepStmt.setString(3, use.getSex());
			prepStmt.setInt(4, use.getAge());
			prepStmt.setString(5, use.getClue());
			prepStmt.setString(6, use.getVip());
			prepStmt.setString(7, use.getMishi());
			prepStmt.executeUpdate();
			dbu.closeDb();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return use;
	}

	// 更新用户资料
	public int update(PUser stu) {
		// TODO Auto-generated method stub
		int rowCount = 0;
		DbUtil dbu = new DbUtil();
		try {

			dbu.connDb();
			PreparedStatement prepStmt = dbu
					.getPstm("update user set name=?,password=?,sex=?,age=?,clue=? where name=?");
			prepStmt.setString(1, stu.getName());
			prepStmt.setString(2, stu.getPassword());
			prepStmt.setString(3, stu.getSex());
			prepStmt.setInt(4, stu.getAge());
			prepStmt.setString(5, stu.getName());
			rowCount = prepStmt.executeUpdate();
			if (rowCount == 0) {
				throw new Exception("Update Error:Student Name:"
						+ stu.getName());
			}

		} catch (Exception e) {
		} finally {
			dbu.closeDb();
		}
		return rowCount;
	}

	// 查找指定的用户
	public List<PUser> findupdate(String name) throws Exception {

		DbUtil dbu = new DbUtil();
		dbu.connDb();
		List<PUser> puser = new ArrayList<PUser>();
		PreparedStatement prepStmt = dbu
				.getPstm("select * from user where name=?");
		prepStmt.setString(1, name);
		ResultSet rs = prepStmt.executeQuery();
		while (rs.next()) {
			PUser pu = new PUser();
			pu.setRid(rs.getInt(1));
			pu.setName(rs.getString(2));
			pu.setPassword(rs.getString(3));
			pu.setSex(rs.getString(4));
			pu.setAge(rs.getInt(5));
			pu.setClue(rs.getString(6));
			pu.setVip(rs.getString(7));
			pu.setMishi(rs.getString(8));
			puser.add(pu);

		}
		dbu.closeDb();
		return puser;
	}

	// 查找所有用户
	public List<PUser> findAll() throws Exception {
		DbUtil dbu = new DbUtil();
		dbu.connDb();
		List<PUser> pus = new ArrayList<PUser>();
		PreparedStatement prepStmt = dbu.getPstm("select * from user");
		ResultSet rs = prepStmt.executeQuery();
		while (rs.next()) {
			PUser pu = new PUser();
			pu.setRid(rs.getInt(1));
			pu.setName(rs.getString(2));
			pu.setPassword(rs.getString(3));
			pu.setSex(rs.getString(4));
			pu.setAge(rs.getInt(5));
			pu.setClue(rs.getString(6));
			pu.setVip(rs.getString(7));
			pu.setMishi(rs.getString(8));
			pus.add(pu);
		}
		dbu.closeDb();
		return pus;
	}

	// 删除用户-------------------------web------------------------------
	public void remove(PUser stu) throws Exception {
		// TODO Auto-generated method stub
		try {
			DbUtil dbu = new DbUtil();
			dbu.connDb();
			PreparedStatement prepStmt = dbu
					.getPstm("delete from user where name=?");
			prepStmt.setString(1, stu.getName());
			prepStmt.executeUpdate();
			dbu.closeDb();
		} catch (Exception e) {

		} finally {
		}
	}

	// 按 姓名 查找-----------------web------------------------------------
	public List<PUser> finduserby(String name) throws Exception {
		List<PUser> users = new ArrayList<PUser>();
		DbUtil dbu = new DbUtil();
		dbu.connDb();
		PreparedStatement prepStmt = dbu
				.getPstm("select rid,name,password,sex,age,clue,vip,mishi from user where name=?");
		prepStmt.setString(1, name);
		ResultSet rs = prepStmt.executeQuery();
		try {
			while (rs.next()) {
				PUser u = new PUser();
				u.setRid(rs.getInt("rid"));
				u.setName(rs.getString("name"));
				u.setPassword(rs.getString("password"));
				u.setAge(rs.getInt("age"));
				u.setSex(rs.getString("sex"));
				u.setClue(rs.getString("clue"));
				u.setVip(rs.getString("vip"));
				u.setMishi(rs.getString("mishi"));
				// u.setName(rs.getString("name"));
				users.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbu.closeDb();
		}
		return users;
	}

	// 查找所有用户
	public List<PUser> show_user() throws Exception {
		DbUtil dbu = new DbUtil();
		dbu.connDb();
		List<PUser> pus = new ArrayList<PUser>();
		PreparedStatement prepStmt = dbu.getPstm("select * from user");
		ResultSet rs = prepStmt.executeQuery();
		while (rs.next()) {
			PUser pu = new PUser();
			pu.setRid(rs.getInt(1));
			pu.setName(rs.getString(2));
			pu.setPassword(rs.getString(3));
			pu.setSex(rs.getString(4));
			pu.setAge(rs.getInt(5));
			pu.setClue(rs.getString(6));
			pu.setVip(rs.getString(7));
			pu.setMishi(rs.getString(8));
			pus.add(pu);
		}
		dbu.closeDb();
		return pus;
	}
				/*
					HuoDong
					活动
					相关方法
					
					
					*/
	
	// 创建新的活动 ------------------------------------------------------
	public HuoDong createhd(HuoDong use) {
		try {
			DbUtil dbu = new DbUtil();
			dbu.connDb();
			PreparedStatement prepStmt = dbu
					.getPstm("insert into huodong(rid,hname,htitle,htime,hword) values(?,?,?,?,?)");
			prepStmt.setInt(1, use.getRid());
			prepStmt.setString(2, use.getHname());
			prepStmt.setString(3, use.getHtitle());
			prepStmt.setString(4, use.getHtime());
			prepStmt.setString(5, use.getHword());

			prepStmt.executeUpdate();
			dbu.closeDb();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return use;
	}

	// 显示所有活动---------------------------------------------------
	public List<HuoDong> show_hd() throws Exception {
		DbUtil dbu = new DbUtil();
		dbu.connDb();
		List<HuoDong> pus = new ArrayList<HuoDong>();
		PreparedStatement prepStmt = dbu.getPstm("select * from huodong");
		ResultSet rs = prepStmt.executeQuery();
		while (rs.next()) {
			HuoDong pu = new HuoDong();
			pu.setHid(rs.getInt(1));
			pu.setRid(rs.getInt(2));
			pu.setHname(rs.getString(3));
			pu.setHtitle(rs.getString(4));
			pu.setHtime(rs.getString(5));
			pu.setHword(rs.getString(6));
			pus.add(pu);
		}
		dbu.closeDb();
		return pus;
	}

	// 删除指定活动------------------delete-------------------------------
	public void deletehd(HuoDong stu) throws Exception {
		// TODO Auto-generated method stub
		try {
			DbUtil dbu = new DbUtil();
			dbu.connDb();
			PreparedStatement prepStmt = dbu
					.getPstm("delete from huodong where hid=?");
			prepStmt.setInt(1, stu.getHid());
			prepStmt.executeUpdate();
			dbu.closeDb();
		} catch (Exception e) {

		} finally {
		}
	}
				/*	
				 * 
					PingLun
					评论相关方法
				*/
	// 创建新的评论 ------------------------------------------------------
	public PingLun createpl(PingLun use) {
		try {
			DbUtil dbu = new DbUtil();
			dbu.connDb();
			PreparedStatement prepStmt = dbu
					.getPstm("insert into pinglun(hid,rid,pname,pword) values(?,?,?,?)");
			prepStmt.setInt(1, use.getHid());
			prepStmt.setInt(2, use.getRid());
			prepStmt.setString(3, use.getPname());
			prepStmt.setString(4, use.getPword());
			prepStmt.executeUpdate();
			dbu.closeDb();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return use;
	}

	// 显示所有评论---------------------------------------------------
	public List<PingLun> show_pl() throws Exception {
		DbUtil dbu = new DbUtil();
		dbu.connDb();
		List<PingLun> pus = new ArrayList<PingLun>();
		PreparedStatement prepStmt = dbu.getPstm("select * from pinglun");
		ResultSet rs = prepStmt.executeQuery();
		while (rs.next()) {
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

	// 查找指定的评论
	public List<PingLun> findpl(int hid) throws Exception {

		DbUtil dbu = new DbUtil();
		dbu.connDb();
		List<PingLun> puser = new ArrayList<PingLun>();
		PreparedStatement prepStmt = dbu
				.getPstm("select * from pinglun where hid=?");
		prepStmt.setInt(1, hid);
		ResultSet rs = prepStmt.executeQuery();
		while (rs.next()) {
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
	 //删除指定评论-----------------------delete--------------------------
	 public void deletepl(PingLun stu) throws Exception {
			// TODO Auto-generated method stub	
			try{
				DbUtil dbu=new DbUtil();
				dbu.connDb();
				PreparedStatement prepStmt=dbu.getPstm("delete from pinglun where pid=?");
				prepStmt.setInt(1,stu.getPid());
				prepStmt.executeUpdate();
				dbu.closeDb();
			}catch(Exception e){
				
			}finally{		
			}
		}

	/*社长申请
	 * forvip
	 * 相关方法
	 * 
	 */
	 
	// 更新社长资料
		public int add_vip(PUser stu) {
			// TODO Auto-generated method stub
			int rowCount = 0;
			DbUtil dbu = new DbUtil();
			try {

				dbu.connDb();
				PreparedStatement prepStmt = dbu
						.getPstm("update user set vip=? where rid=?");
				prepStmt.setString(1,stu.getVip());	
				prepStmt.setInt(2, stu.getRid());
				rowCount = prepStmt.executeUpdate();
				if (rowCount == 0) {
					throw new Exception("Update Error:Student Name:"
							+ stu.getName());
				}

			} catch (Exception e) {
			} finally {
				dbu.closeDb();
			}
			return rowCount;
		}
		 //删除已经确定的申请-----------------------delete--------------------------
		 public void del_forvip(Forvip stu) throws Exception {
				// TODO Auto-generated method stub	
				try{
					DbUtil dbu=new DbUtil();
					dbu.connDb();
					PreparedStatement prepStmt=dbu.getPstm("delete from forvip where rid=?");
					prepStmt.setInt(1,stu.getRid());
					prepStmt.executeUpdate();
					dbu.closeDb();
				}catch(Exception e){
					
				}finally{		
				}
			}
		// 显示所有评论---------------------------------------------------
		public List<Forvip> show_forvip() throws Exception {
			DbUtil dbu = new DbUtil();
			dbu.connDb();
			List<Forvip> pus = new ArrayList<Forvip>();
			PreparedStatement prepStmt = dbu.getPstm("select * from forvip");
			ResultSet rs = prepStmt.executeQuery();
			while (rs.next()) {
				Forvip pu = new Forvip();
				
				pu.setRid(rs.getInt(1));
				pu.setName(rs.getString(2));
				pu.setReason(rs.getString(3));
				pus.add(pu);
			}
			dbu.closeDb();
			return pus;
		}
	 
		//显示公告---------------------------------------------------
		 public List<Gonggao> show_allgg() throws Exception {
					DbUtil dbu=new DbUtil();
					dbu.connDb();
					List<Gonggao> pus =new ArrayList<Gonggao>();
					PreparedStatement prepStmt=dbu.getPstm("select * from xgonggao");
					ResultSet rs=prepStmt.executeQuery();
						while(rs.next()){
							Gonggao pu = new Gonggao();
							pu.setGid(rs.getInt(1));
							pu.setGname(rs.getString(2));
							pu.setGclue(rs.getString(3));
							pu.setGonggao(rs.getString(4));
							pu.setOfschool(rs.getString(5));
							pus.add(pu);
						}
						dbu.closeDb();
					return pus;
				}
		// 删除公告------------------------------------------------------
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
					
					//显示所有的匿名信息---------------------------------------------------
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
					// 删除指定匿名信息------------------delete-------------------------------
						public void deletenm(Nmchat stu) throws Exception {
							// TODO Auto-generated method stub
							try {
								DbUtil dbu = new DbUtil();
								dbu.connDb();
								PreparedStatement prepStmt = dbu
										.getPstm("delete from nmchat where nid=?");
								prepStmt.setInt(1, stu.getNid());
								prepStmt.executeUpdate();
								dbu.closeDb();
							} catch (Exception e) {

							} finally {
							}
						}
}

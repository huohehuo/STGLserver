package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.DBConnection;

public class DbUtil{
	private Connection con=null;
	private PreparedStatement pstm=null;
	private ResultSet rs=null;
	
	public Connection connDb() {
		return con=DBConnection.getDBconnection();
	}
	public void closeDb() {
		DBConnection.closeDB(con, pstm, rs);
		con = null;
	}
	
	public PreparedStatement getPstm(String sql) throws SQLException {
			return con.prepareStatement(sql);
	}
	
	public Connection getCon() {
		return con;
	}	
	
}
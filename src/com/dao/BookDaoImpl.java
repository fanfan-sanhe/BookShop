package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.po.BookBean;

import util.JDBCUitl;

public class BookDaoImpl implements BookDao {
	private Connection conn=null;
	private Statement st=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;

	@Override
	public int add(BookBean p) {
		int f=0;
		try {
			conn=JDBCUitl.getConnection();
			String sql="insert into products(name,price,category,pnum,imgurl,description) values(?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, p.getName());//顺序不能错
			ps.setDouble(2, p.getPrice());
			ps.setString(3, p.getCategory());
			ps.setInt(4, p.getPnum());
			ps.setString(5, p.getImgurl());
			ps.setString(6, p.getDescription());
			f=ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//创建一个 Connection 对象
		JDBCUitl.release(ps, conn);
		return f;
	}

}

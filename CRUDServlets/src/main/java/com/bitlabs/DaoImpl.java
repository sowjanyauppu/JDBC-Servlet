package com.bitlabs;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

	public class DaoImpl {
	 Connection con;
		DaoImpl(){
			try {
				Class.forName("com.mysql.jdbc.Driver");  
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		public boolean validate(String username, String password) {
			
			try {
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select * from useraccount");
				while(rs.next()) {
				if(rs.getString(1).equals(username) && rs.getString(2).equals(password)) {
					return true;
				}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			return false;
		}
		
		public boolean delete(User user) {
			
			try {
				Statement st=con.createStatement();
				int i=st.executeUpdate("delete from user where username='"+user.getUsername()+"' and password='"+user.getPassword()+"'");
				if(i>0) {
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return false;
		}
	public boolean insert(User user) {
			
			try {
				PreparedStatement pstmt=con.prepareStatement("insert into useraccount values(?,?)");
				pstmt.setString(1, user.getUsername());
				pstmt.setString(2, user.getPassword());
				
				int i=pstmt.executeUpdate();
				if(i>0) {
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return false;
		}
	public boolean update(User user) {
		
		try {
			Statement st=con.createStatement();
			int i=st.executeUpdate("update user set password='"+user.getPassword()+"' where username='"+user.getUsername()+"'");
			if(i>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}
	}



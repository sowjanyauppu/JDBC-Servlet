package com.bitlabs.JDBCConnectivityExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class DaoImpl implements DaoInterface {
	Connection con=null;
	//creating constructor
	public DaoImpl()
	{
		//loading driver class
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			//connection establishment
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","root");
			if(con!=null)
			{
				System.out.println("connection established");
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void patientRegistration(Patient p) {
		// TODO Auto-generated method stub
		try {
		PreparedStatement pstmt=con.prepareStatement("insert into patient values(?,?,?,?,?)");
		pstmt.setInt(1,p.getPid());
		pstmt.setString(2,p.getPname());
		pstmt.setInt(3,p.getAge());
		pstmt.setString(4,p.getCity());
		pstmt.setLong(5,p.getMobile());
		int i=pstmt.executeUpdate();
		if(i!=0)
		{
			System.out.println("patient added successfully");
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		}
		public void viewAllPatients()
		{
			try
			{
			 java.sql.Statement stmt=con.createStatement();
			 ResultSet rs=stmt.executeQuery("select * from patient");
			 while(rs.next()) {
				 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4)+" "+rs.getLong(5));
			 }
			 
			}
			catch(Exception e)
			{
			System.out.println(e);
			}
		}
		public void updatePatient(Patient p) {
			// TODO Auto-generated method stub
			try {
			Statement stmt=con.createStatement();
			int i=stmt.executeUpdate("update patient set Pname='"+p.getPname()+"' where pid='"+p.getPid()+" ' ");
			if(i!=0)
			{
				System.out.println("updated successfully");
			}
					
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
						
		}
		public void getPatientInfo(int pid)
		{
			try {
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery("select * from patient where pid=+'"+pid+"'");
				while(rs.next())
				{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4)+" "+rs.getLong(5));
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}



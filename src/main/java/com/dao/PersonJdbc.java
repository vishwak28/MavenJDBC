package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PersonJdbc {
	
	Connection con;
	PreparedStatement ps;
	int i;
	public Connection myConnection(){
		//1.load driver
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","System","Newuser123");
			System.out.println("Connection to db..");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("catch connection..");
		} catch (SQLException e) {
			System.out.println("catch connection..2");
			e.printStackTrace();
		}
		return con;
	}

		public int saveData(String fname,String lname){
			try {
				con=myConnection();
				ps=con.prepareStatement("insert into person1 values(?,?)");
				ps.setString(1,fname);
				ps.setString(2,lname);
				i = ps.executeUpdate();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("test11");
				e.printStackTrace();
			}
			catch(Exception e){
				System.out.println("global.."+e);
			}
			return i;
		}
}

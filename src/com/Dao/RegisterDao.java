package com.Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.model.*;
import com.Dao.*;
import com.controller.*;
public class RegisterDao {
	MyConnection my=new MyConnection();
	Connection con=null;
	PreparedStatement pst=null;
	Increpete_Decrepete in1=new Increpete_Decrepete();
	public int create(Customer r)
	{
		
		con=my.getConnection();
		int i=0;
		String pass=r.getPassword();
		String pass1=in1.getEncodedString(pass);
		try {
			pst=con.prepareStatement("insert into Registration values(?,?,?,?,?,?)");
			pst.setString(1,r.getName());
			pst.setString(2,r.getEmail());
			pst.setString(3,r.getMobno());
			pst.setString(4,r.getBalance());
			pst.setString(5,r.getUsername());
			pst.setString(6,pass1);
			i=pst.executeUpdate();
			if (i>0) {
				System.out.println("register successfully!");
				
				return i;
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}
	public int validateUser(Logins l)
	{
		int j=0;
		con=my.getConnection();
		String pass=l.getPassword();
		String pass1=in1.getEncodedString(pass);
		try
		{
			PreparedStatement ps=con.prepareStatement("select * from Registration where username=? and password=?");
			ps.setString(1,l.getUsername());
			ps.setString(2,pass1);
			java.sql.ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				System.out.println("login successfully");
				j=1;
			}
			con.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
		return j;
	}
	public int checkuser(Customer r)
	{
		con=my.getConnection();
		int b=0;
		try
		{
			PreparedStatement ps=con.prepareStatement("select * from Registration where username=? and password=?");
			ps.setString(1,r.getUsername());
			ps.setString(2,r.getPassword());
			java.sql.ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				System.out.println("check user successfully");
				b=1;
			}
			con.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
		return b;
	}
	
}
	

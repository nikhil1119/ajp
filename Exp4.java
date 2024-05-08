package exp4;

import java.util.*;
import javax.swing.*;
import java.sql.*;

class Student {
	public int rollno, marks;
	public String sname, batch;

	void getData()
	{
			System.out.println("Enter Student Information : ");
			Scanner Sc = new Scanner(System.in);
			System.out.println("Enter RollNo : ");
			rollno = Sc.nextInt();
			Sc.nextLine();
			System.out.println("Enter Name : ");
			sname = Sc.nextLine();
			System.out.println("Enter marks : ");
			marks = Sc.nextInt();
			Sc.nextLine();
			System.out.println("Enter Batch : ");
			batch = Sc.nextLine();
	}
}

class Queries{
	Connection con;
	Statement st;
	ResultSet rs;
	Student s1;
	PreparedStatement pst;
	
	public Queries()
	{
		try {
			getConnection();
			createTable();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	void getConnection() throws Exception{
		String url = "jdbc:mysql://localhost:3306/bankmanagementsystem";
		String uname = "root";
		String pass = "Nikhil@1119";
	
		Class.forName("com.mysql.cj.jdbc.Driver");
	
		con = DriverManager.getConnection(url,uname,pass);
		System.out.println("Connected");
	}
	
	void createTable() throws SQLException{
		String query = "create table ENTC_Data(RollNo int primary key ,sname varchar(40),marks int, batch varchar(10))";
		st = con.createStatement();
		int val = st.executeUpdate(query);
		System.out.println("Table created "+val);
	}
	
	void insertData() throws SQLException{
		s1 = new Student();
		s1.getData();
		String Query = "insert into ENTC_Data(RollNo,sname,marks,batch)"+" values (?, ?, ?, ?)";
		pst = con.prepareStatement(Query);
		pst.setInt(1, s1.rollno);
		pst.setString(2, s1.sname);
		pst.setInt(3,s1.marks);
		pst.setString(4, s1.batch);
		int insertedRow = pst.executeUpdate();
		System.out.println("Affected rows : "+insertedRow);
	}
	
	boolean searchData(int rollval)throws Exception{
		String query = "select RollNo from ENTC_Data";
		st = con.createStatement();
		rs = st.executeQuery(query);
		while (rs.next())
		{
			int roll = rs.getInt("RollNo");
			if(roll==rollval)
			{
				return true;
			}
		}
		return false;
	}
	
	void deleteData() throws Exception{
		System.out.println("Enter Roll No of student to delete data : ");
		Scanner Sc = new Scanner(System.in);
		int roll = Sc.nextInt();
		boolean res = searchData(roll);
		if(res)
		{
			String query = "delete from ENTC_Data where RollNo = ?";
			pst = con.prepareStatement(query);
			pst.setInt(1, roll);
			pst.executeUpdate();
			System.out.println("Data deleted successfully.");
			fetchData();
		}
		else {
			System.out.println("Data not found");
		}
	}
	
	void updateData() throws Exception
	{
	System.out.println("Enter Roll No of student to update data : ");
	Scanner Sc = new Scanner(System.in);
	int roll = Sc.nextInt();
	Sc.nextLine();
	boolean res = searchData(roll);
	if(res)
	{
		System.out.println("Enter data that you have to update : ");
		String name = Sc.nextLine();
		String sql = "update ENTC_Data set sname=? where RollNo=?";
		pst = con.prepareStatement(sql);
		pst.setString(1, name);
		pst.setInt(2, roll);
		pst.executeUpdate();
		System.out.println("Data updated successfully.");
		fetchData();
	}
	else {
		System.out.println("Data not found");
	}
}
	
	void fetchData() throws SQLException
	{
		String query = "select * from ENTC_Data";
		st = con.createStatement();
		rs = st.executeQuery(query);
		System.out.println("ROLLNo "+"\tName "+"\tMarks"+"\tBatch");
		while (rs.next())
		{
			int roll,marks;
			String name,batch;
			roll = rs.getInt("RollNo");
			name= rs.getString("sname");
			marks= rs.getInt("marks");
			batch = rs.getString("batch");
			System.out.println(""+roll+"\t"+name+"\t"+marks+"\t"+batch);
		}
	}
}

public class Exp4 {
	public static void main(String[] args) throws Exception
	{
		Queries Q = new Queries();
		while(true)
		{
		int choice;
		Scanner Sc = new Scanner(System.in);
		System.out.println("\n1.Insert Data into Table \n2.Display Table \n3.Delete Data from Table \n4.Search Data from Table \n5.Update Data from Table");
		System.out.println("Enter your choice : ");
		choice = Sc.nextInt();
		switch(choice)
		{
			case 1: 
				Q.insertData();
				break;
		
			case 2: 
				Q.fetchData();
				break;
		
			case 3: 
				Q.deleteData();
				break;
		
			case 4:
				System.out.println("Enter Roll No of student to update data : ");
				int roll = Sc.nextInt();
				boolean res = Q.searchData(roll);
				if(res) System.out.println("Data Found");
				else System.out.println("Data not found");
				break;
	
			case 5 : 
				Q.updateData();
				break;
		}
		String ans ;
		System.out.println("Do you want to continue : ");
		ans = Sc.next();
		if(ans.charAt(0)=='n') break;
		}
	}
}


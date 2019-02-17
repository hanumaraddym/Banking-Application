
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOModel 
{
PreparedStatement pstmt;
Connection con;
ResultSet res;
private int accno;
private int cusID;
private String cusPwd;
private int balance;
private int amttransf;
private int amt;


DAOModel()
{
	DBConnector dc=new DBConnector();
	con=dc.getConnection();
}


public int getAccno() {
	return accno;
}
public int getCusID() {
	return cusID;
}
public String getCusPwd() {
	return cusPwd;
}
public int getBalance() {
	return balance;
}
public int getAmttransf() {
	return amttransf;
}

public void setAccno(int accno) {
	this.accno = accno;
}
public void setCusID(int cusID) {
	this.cusID = cusID;
}
public void setCusPwd(String cusPwd) {
	this.cusPwd = cusPwd;
}
public void setBalance(int balance) {
	this.balance = balance;
}
public void setAmttransf(int amttransf) {
	this.amttransf = amttransf;
}

boolean verify()
{
	try
	{
		String s="SELECT * FROM BANK WHERE CUSTOMERID=? AND PASSWORD=?";
		pstmt=con.prepareStatement(s);
		pstmt.setInt(1,cusID);
		pstmt.setString(2,cusPwd);
		res=pstmt.executeQuery();
		while(res.next()==true)
		{
			cusID=res.getInt(6);
			cusPwd=res.getString(3);
			accno=res.getInt(1);
		}
		return true;
	}
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
}
}

boolean transfer(int amttransf)
{
	try
	{
	pstmt=con.prepareStatement("UPDATE BANK SET BALANCE=BALANCE-? WHERE ACCNO=?");
	pstmt.setInt(1,amttransf);
	pstmt.setInt(2,accno);
	int rows=pstmt.executeUpdate();
	
	pstmt=con.prepareStatement("INSERT INTO STATEMENT VALUES(?,?)");
	pstmt.setInt(1,accno);
	pstmt.setInt(2,amttransf);
	pstmt.executeUpdate();
	if(rows==0)
	{
		return false;
	}
	else
	{
		return true;
	}
	}
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
}
	return false;
}

boolean balance()
{
	try
	{
	pstmt=con.prepareStatement("SELECT * FROM BANK WHERE ACCNO=?");
	pstmt.setInt(1,accno);
	res=pstmt.executeQuery();
	while(res.next()==true)
	{
		balance=res.getInt(9);
	}
	return true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return false;
	}


 boolean change(String npw)
 {
 try
	{
	 
	pstmt=con.prepareStatement("UPDATE BANK SET PASSWORD=? WHERE PASSWORD=?");
	pstmt.setString(1,npw);
	pstmt.setString(2,cusPwd);
	int rows=pstmt.executeUpdate();
	if(rows==0)
	{
		return false;
	}
	else
	{
		return true;
	}
	}
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
}
	return false;
}
 
 ArrayList statement(int accno)
 {
	 try
	 {
		pstmt=con.prepareStatement("SELECT * FROM STATEMENT WHERE ACCNO=?");
		pstmt.setInt(1, accno);
		pstmt.executeQuery();
		res=pstmt.executeQuery();
		ArrayList al=new ArrayList();
		while(res.next()==true)
		{
			al.add(res.getInt(2));
			
		}
		return al;
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	return null;
 }
boolean forgotPassword(String npw,String toEmail)
{
	try
	{
		pstmt=con.prepareStatement("UPDATE BANK SET PASSWORD=? WHERE EMAIL=?");
		pstmt.setString(1,npw);
		pstmt.setString(2,toEmail);
		int row=pstmt.executeUpdate();
		if(row==1)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return false;
}
}







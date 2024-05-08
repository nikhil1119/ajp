package exp8;

import java.rmi.*;
import java.rmi.server.*;
public class Policy_Class extends UnicastRemoteObject implements Remote, Policy_Interface{
	String username="nikhil1119";
	String password="Nikhil123";
	Policy_Class() throws RemoteException
	{
		super();
	}
	public String policyCheck(String s1,String s2) throws RemoteException
	{
		if(s1.equals(username) && s2.equals(password))
			return "Correct password and username";
		else return "InCorrect password and username";
	}
}

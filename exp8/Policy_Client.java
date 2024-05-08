package exp8;

import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;

public class Policy_Client {
	public static void main(String[] args) throws Exception{
		try{
				Policy_Interface obj1 =(Policy_Interface) Naming.lookup("rmi://localhost:1900/XYZ");
				String uname,pname;
				Scanner Sc = new Scanner(System.in);
				System.out.println("Enter username : ");
				uname = Sc.nextLine();
				System.out.println("Enter password: ");
				pname = Sc.nextLine();
				String res = obj1.policyCheck(uname,pname);
				System.out.println(res);
		}
		catch(Exception e){
			System.out.println(e);
		}	
	}
}

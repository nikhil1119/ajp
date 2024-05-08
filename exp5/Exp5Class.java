package exp5;

import java.rmi.*;
import java.rmi.server.*;

public class Exp5Class extends UnicastRemoteObject implements Exp5Interface{
	protected Exp5Class() throws RemoteException {
		super();
	}

	public Boolean palindrome(String s) {
		String temp = "";
		for(int i=s.length()-1;i>=0;i--) {
			temp+=s.charAt(i);
		}
		if(s.equals(temp)) return true;
		else return false;
	}
}

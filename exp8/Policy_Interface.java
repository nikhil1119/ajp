package exp8;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Policy_Interface extends Remote
{
	public String policyCheck(String s1,String s2) throws RemoteException;
}

package exp5;

import java.rmi.*;

public interface Exp5Interface extends Remote{
	Boolean palindrome (String str) throws RemoteException;
}

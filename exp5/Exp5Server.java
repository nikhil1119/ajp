package exp5;

import java.rmi.*;
import java.rmi.registry.*;

public class Exp5Server {
	public static void main(String[] args) throws Exception{
		try {
			Registry reg = LocateRegistry.createRegistry(1905);
			Exp5Interface obj = new Exp5Class();
			reg.bind("CheckPalindrome", obj);
			System.out.println("Server started");
		}
		catch(Exception e) {
			System.out.println("Server not started" + e);
		}
		
	}
}

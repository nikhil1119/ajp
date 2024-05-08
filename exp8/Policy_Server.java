package exp8;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Policy_Server{
	public static void main(String[] args) throws Exception
	{
		Registry reg = LocateRegistry.createRegistry(1900);
		Policy_Interface obj = (Policy_Interface) new Policy_Class();
		reg.bind("XYZ", obj);
		System.out.println("Server started");
	}
}

package exp6;

import java.net.*;

public class InetAdd {

	public static void main(String[] args) throws Exception{
		//Factory Methods
		//1)getLocalHost():
		InetAddress id1 = InetAddress.getLocalHost();
		System.out.println(id1);
		
		//2)getByName():
		InetAddress id2 =InetAddress.getByName("www.youtube.com");
		System.out.println(id2);
		
		//3)getAllByName():
		InetAddress []id3 =InetAddress.getAllByName("www.pict.edu");
		System.out.println(id3);
		
		//4)getByAddress(IP Address):
		byte []address = {10,10,14,18};
		InetAddress id4 = InetAddress.getByAddress(address);
		System.out.println(id3);
		
		//5)getByAddress(HostName,raw IPAddress):
		InetAddress id5= InetAddress.getByAddress("pict.edu",address);
		System.out.println(id5);
		
		
		//Instance Methods
		//1)getHostName(): 
		System.out.println("Host Name: "+id2.getHostName());
		
		//2)getHostAddress():
		System.out.println("Host Address: "+id1.getHostAddress());
		
		//3)equals():
		System.out.println("Address is equal: "+ id1.equals(id2));
		
		//4)It is an identify for the set of an Interface
		System.out.println("Multicast or not: "+ id4.isMulticastAddress());

	}

}

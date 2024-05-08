package exp5;

import java.util.Scanner;
import java.net.MalformedURLException;
import java.rmi.*;

public class Exp5Client {
	public static void main(String[] args) throws Exception{
		System.out.println("1");
		String path = "rmi://localhost:5000/CheckPalindrome";
		System.out.println("2");
		Exp5Interface obj = (Exp5Interface) Naming.lookup(path);
		System.out.println("3");
		System.out.println(obj.palindrome("Hello"));
		System.out.println("4");
	}
}

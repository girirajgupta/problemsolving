package com.main.pub;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MakeChange {

	public static void main(String[] args) throws UnknownHostException {
		System.out.println("Hellow");
		InetAddress address = InetAddress.getLocalHost();
		System.out.println(address.toString());
		System.out.println(address.getHostName());
		InetAddress address2 = InetAddress.getByName("10.224.213.189");
		System.out.println(address2.toString());
		System.out.println(address2.getHostName());
		//System.out.println(address2.get);
	}

}

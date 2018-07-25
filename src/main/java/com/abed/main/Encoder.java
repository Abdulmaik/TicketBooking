package com.abed.main;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



public class Encoder {
	
	
	public void encode()
	{
	 BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	 
     String encoded = bCryptPasswordEncoder.encode("abed92");
     String encoded1 = bCryptPasswordEncoder.encode("issa91");
     System.out.println(encoded + " " + encoded1);
	}
	
	public static void main(String args[])
	{
		Encoder e = new Encoder();
		 e.encode();
	}
}

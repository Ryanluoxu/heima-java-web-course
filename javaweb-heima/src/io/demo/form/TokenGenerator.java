package io.demo.form;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import sun.misc.BASE64Encoder;

public class TokenGenerator {

	// singleton
	
	// 1. private constructor
	// 2. create instance by self
	// 3. public getInstance
	
	private TokenGenerator() {
		super();
	}
	
	private static final TokenGenerator instance = new TokenGenerator();
	
	public static TokenGenerator getInstance() {
		return instance;
	}
	
	public String generateToker() {
		
		String randomNumber = System.currentTimeMillis() + new Random().nextInt() + "";
		
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			byte[] md5 = md.digest(randomNumber.getBytes());
			BASE64Encoder encoder = new BASE64Encoder();
			System.out.println(encoder.encode(md5));
			return encoder.encode(md5);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		
	}

}

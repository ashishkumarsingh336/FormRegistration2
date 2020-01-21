package com.example.random;

import java.security.SecureRandom;

import org.springframework.stereotype.Component;
/**
 * create class to generate random number
 *
 */
@Component
public class RandomPassword {
          
	  public String getAlphaNumeric(int len) {
          
	    char[] ch = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();

	    char[] c = new char[len];
	    SecureRandom random = new SecureRandom();
	    for (int i = 0; i < len; i++) {
	      c[i] = ch[random.nextInt(ch.length)];
	    }

	    return new String(c);
	  }
	}

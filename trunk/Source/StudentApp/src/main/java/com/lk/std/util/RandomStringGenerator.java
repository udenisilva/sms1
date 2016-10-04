package com.lk.std.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component(value="randomStringGenerator")
public class RandomStringGenerator {
	
	private static RandomStringGenerator instance;

    private RandomStringGenerator() {
    }
	
	public String getRandomString(){		
		SimpleDateFormat sdf=new SimpleDateFormat("DDyyHHmmMMMssSS");
		StringBuffer stb=new StringBuffer(sdf.format(Calendar.getInstance().getTime()));
		int endIndex=stb.length();
		int startIndex=endIndex-6;
		stb=new StringBuffer(stb.substring((startIndex-1), (endIndex-1)));		
		stb.append(getRandomSingleString());
		stb.append(getRandomSingleString());
		return stb.toString();
		
	}
	
	public String getRandomSingleString(){
		String[] letterArray={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z",
							"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
		Random random=new Random();		
		return letterArray[random.nextInt(letterArray.length)];
	}
	
	 public static synchronized RandomStringGenerator getInstance() {
	        if (instance == null) {
	            instance = new RandomStringGenerator();
	        }
	        return instance;
	 }
	
	

}

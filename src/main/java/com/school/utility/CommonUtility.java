package com.school.utility;

import java.util.Random;
import java.util.stream.IntStream;

public class CommonUtility{
public static String getRandomToken() {
		
		Random r = new Random();
		
		IntStream i1 = r.ints(65, 90).limit(5);
		IntStream i2 = r.ints(48, 57).limit(5);
		IntStream i3 = r.ints(97, 122).limit(5);
		
		String generatedString = IntStream.concat(IntStream.concat(i1,i2),i3).boxed().sorted((o1, o2) -> new Random().nextInt(2)-1)
	    	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	    	      .toString();
	    	      
	    return generatedString;
		
		
	}
}

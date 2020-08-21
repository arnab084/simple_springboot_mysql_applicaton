/**
 * 
 */
package com.school.users;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Arnab Chakraborty
 *
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class UserException extends Exception{
	
	public UserException(String s) 
    { 
        super(s); 
    } 

}

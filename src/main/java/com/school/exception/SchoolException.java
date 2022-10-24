/**
 * 
 */
package com.school.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Arnab Chakraborty
 *
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class SchoolException extends Exception{
	
	public SchoolException(String s)
    { 
        super(s); 
    } 

}

package com.cg.grocerydeliveryapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class OrderIdNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public OrderIdNotFoundException() {
		super();
	}
	public OrderIdNotFoundException(String msg) {
		super(msg);
	}

}

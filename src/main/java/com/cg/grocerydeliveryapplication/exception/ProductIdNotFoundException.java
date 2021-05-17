package com.cg.grocerydeliveryapplication.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProductIdNotFoundException extends Exception{

	public ProductIdNotFoundException() {
		super();
	}
	public ProductIdNotFoundException(String msg) {
		super(msg);
	}

}

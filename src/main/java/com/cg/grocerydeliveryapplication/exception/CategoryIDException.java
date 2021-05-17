package com.cg.grocerydeliveryapplication.exception;
/**
 * desc:This is a categoryIDException class having custom category id exception
 * @author Suparna Arya
**/
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CategoryIDException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CategoryIDException() {
		super();
	}

	public CategoryIDException(String errMsg) {
		super(errMsg);
	}
}

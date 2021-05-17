package com.cg.grocerydeliveryapplication.exception;

public class CategoryIdExceptionResponse {
	private String cid;

	public CategoryIdExceptionResponse(String cid) {
		super();
		this.cid = cid;
	}

	public String getProjectIdentifier() {
		return cid;
	}

	public void setProjectIdentifier(String cid) {
		this.cid = cid;
	}
}

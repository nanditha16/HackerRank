package com.hackerrank.challenges.digitalWallet;

public class TransactionException  extends RuntimeException  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7850649148693136425L;

	
	String errorCode;
	String errorMessage;
	
	
	TransactionException(String errorMessage, String errorCode){
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
	}
	
	
	public String getErrorCode() {
		return this.errorCode;
	}

	public String getMessage() {
		return this.errorMessage;
	}
}

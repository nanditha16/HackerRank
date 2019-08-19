package com.hackerrank.challenges.digitalWallet;

public class DigitalWallet {

	private String walletId;
	private String userName;
	private String userAccessToken;
	private int walletBalance;
	
	public DigitalWallet() {}
	
	// constructor DigitalWallet(String walletId, String userName) 
	public DigitalWallet(String walletId, String userName) {
		this.walletId = walletId;
		this.userName = userName;
	}

	// constructor DigitalWallet(String walletId, String userName, String userAccessCode) 
	public DigitalWallet(String walletId, String userName, String userAccessCode) {
		this(walletId, userName);
		this.userAccessToken = userAccessCode;
	}

	// The method String getWalletId() to return the owner's user name
	public String getUsername() {
		return userName;
	}

	public void setUsername(String userName) {
		this.userName = userName;
	}

	// The method String getWalletId() to return the wallet ID
	public String getWalletId() {
		return walletId;
	}

	public void setWalletId(String walletId) {
		this.walletId = walletId;
	}

	// The method String getUserAccessToken() to return the access token
	public String getUserAccessToken() {
		return userAccessToken;
	}

	public void setUserAccessToken(String userAccessToken) {
		this.userAccessToken = userAccessToken;
	}

	// The method int getWalletBalance() to return the wallet balance
	public int getWalletBalance() {
		return walletBalance;
	}

	// The method void setWalletBalance(int walletBalance) to update the  wallet balance
	public void setWalletBalance(int walletBalance) {
		this.walletBalance = walletBalance;
	}

}

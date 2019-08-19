package com.hackerrack.challenges.digitalWallet;

public class DigitalWalletTransaction {

    /*
     * The method void addMoney(DigitalWallet digitalWallet, int amount)
     * to add money to wallet.
     * Throws the required exceptions for any invalid transactions
     * 
     */
    public void addMoney(DigitalWallet digitalWallet, int amount) throws TransactionException {
        String userAccessToken = digitalWallet.getUserAccessToken();
        isValidAccessToken(userAccessToken);
        
        if (amount <= 0) {
            throw new TransactionException("Amount should be greater than zero", "INVALID_AMOUNT");
        }
        
        digitalWallet.setWalletBalance(digitalWallet.getWalletBalance() + amount);
        
    }

    private void isValidAccessToken(String userAccessToken) throws TransactionException{
        if (userAccessToken == null) {
            throw new TransactionException("User not authorized", "USER_NOT_AUTHORIZED");

        }
        
    }

    /*
     * The method void payMoney(DigitalWallet digitalWallet, int amount)
     * to make a payment from the wallet.
     *  Throws the required exceptions for any invalid transactions
     */
    public void payMoney(DigitalWallet digitalWallet, int amount) throws TransactionException {
        String userAccessToken = digitalWallet.getUserAccessToken();
        isValidAccessToken(userAccessToken);

        if(digitalWallet.getWalletBalance() < amount ) {
            throw new TransactionException("Insufficient balance","INSUFFICIENT_BALANCE"); 
        } 
        if(amount <= 0 ) {
            throw new TransactionException("Amount should be greater than zero","INVALID_AMOUNT"); 
        }
        digitalWallet.setWalletBalance(digitalWallet.getWalletBalance()-amount);
            
    }

}


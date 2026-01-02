package com.intro.services;

public interface AccountProvider {

    boolean AccountExists(String accountId);
    String AddAccount(String accountId, String ownerId);
    String AddAccount(String accountId, String ownerId, Double initialBalance);
    boolean RemoveAccount(String accountId);
    double GetBalance(String accountId);
    double SetBalance(String accountId, double amount);
}

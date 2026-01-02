package com.intro.services.impl.bank;

import com.intro.services.AccountProvider;
import com.intro.services.PaymentGateway;
import org.springframework.stereotype.Component;


//@Component marks the class as Beans
//default scope is singleton
@Component
public class OnlinePayment implements PaymentGateway {

    private final AccountProvider accountProvider;

    public OnlinePayment(AccountProvider accountProvider) {
        this.accountProvider = accountProvider;
    }

    @Override
    public Boolean processPayment(String accountNumber, double amount) {

        if(!accountProvider.AccountExists(accountNumber)){
            //log account not exist
            return false;
        }

        double actualBalance = accountProvider.GetBalance(accountNumber);

        if(actualBalance < amount){
            //log unsufficient balance
            return false;
        }

        accountProvider.SetBalance(accountNumber, actualBalance - amount);
        return true;
    }
}

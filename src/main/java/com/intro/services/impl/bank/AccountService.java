package com.intro.services.impl.bank;

import com.intro.model.Account;
import com.intro.repository.AccountRepository;
import com.intro.services.AccountProvider;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService implements AccountProvider {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accRespository) {
        this.accountRepository = accRespository;
    }

    @Override
    public boolean AccountExists(String accountId) {
        return accountRepository.existsById(accountId);
    }

    @Override
    public String AddAccount(String accountId, String ownerId) {
        if (accountRepository.existsById(accountId)) {;
            return null;
        }

        Account account = new Account(ownerId, 0.00);
        Account savedAccount = accountRepository.save(account);
        return savedAccount.getId();
    }

    @Override
    public String AddAccount(String accountId, String ownerId, Double initialBalance) {
        if (accountId != null && accountRepository.existsById(accountId)) {;
            return null;
        }
        Account account = new Account(ownerId, initialBalance);
        Account savedAccount = accountRepository.save(account);
        return savedAccount.getId();
    }

    @Override
    public boolean RemoveAccount(String accountId) {
        if (!accountRepository.existsById(accountId)) {;
            return false;
        }

        Account accountToDelete = accountRepository.findById(accountId).orElse(null);
        if (accountToDelete == null) {
            return false;
        }

        accountRepository.delete(accountToDelete);
        return true;
    }

    @Override
    public double GetBalance(String accountId) {
        if(!accountRepository.existsById(accountId)){
            return -1;
        }

        return accountRepository.findById(accountId)
                .map(Account::getBalance)   //operátor :: je reference na metodu
                .orElse(-1.0);
    }

    @Override
    public double SetBalance(String accountId, double amount) {
        if(!accountRepository.existsById(accountId)){
            return -1;
        }

        Optional<Account> account =  accountRepository.findById(accountId);
        if(account.isPresent()){
            account.get().setBalance(amount);
        }
        //functional style equivalent:
        //account.ifPresent(value -> value.setBalance(amount))

        if(account.isEmpty()){
            return -1;
        }

        accountRepository.save(account.get());
        return amount;
    }
}

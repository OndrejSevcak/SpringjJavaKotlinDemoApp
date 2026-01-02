package com.intro.example.demo;

import com.intro.DemoApplication;
import com.intro.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = DemoApplication.class)
class DemoApplicationTests {

    @Autowired
    private AccountRepository accountRepository;

    @Test
	void contextLoads() {
	}

    @Test
    void printDataBaseData(){
        accountRepository.findAll().forEach(account -> {;
            System.out.println("Account ID: " + account.getId() + ", Balance: " + account.getBalance());
        });
    }

}

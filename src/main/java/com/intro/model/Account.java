package com.intro.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    private String accNum;
    private String owner;
    private Double balance = 0.0;

    @PrePersist
    private void ensureId(){
        if(this.accNum == null){
            this.accNum = java.util.UUID.randomUUID().toString();
        }
    }

    protected Account() {}

    public Account(String owner, Double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public String getId() {
        return accNum;
    }
    public String getOwner() {
        return owner;
    }
    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}

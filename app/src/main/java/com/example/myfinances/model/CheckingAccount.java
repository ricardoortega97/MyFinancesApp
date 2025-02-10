package com.example.myfinances.model;

public class CheckingAccount {
    private int checking_id;
    private int account_number;
    private float current_balance;

    public CheckingAccount() {
        checking_id = -1;
    }

    public int getChecking_id() {
        return checking_id;
    }

    public void setChecking_id(int checking_id) {
        this.checking_id = checking_id;
    }

    public int getAccount_number() {
        return account_number;
    }

    public void setAccount_number(int account_number) {
        this.account_number = account_number;
    }

    public float getCurrent_balance() {
        return current_balance;
    }

    public void setCurrent_balance(float current_balance) {
        this.current_balance = current_balance;
    }
}

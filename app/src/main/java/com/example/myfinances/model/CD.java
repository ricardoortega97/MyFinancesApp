package com.example.myfinances.model;

public class CD {

    private int cd_id;
    private int account_number;
    private float initial_balance;
    private float interest_rate;
    private float current_balance;

    public CD() {
        cd_id = -1;
    }

    public int getCd_id() {
        return cd_id;
    }

    public void setCd_id(int cd_id) {
        this.cd_id = cd_id;
    }

    public int getAccount_number() {
        return account_number;
    }

    public void setAccount_number(int account_number) {
        this.account_number = account_number;
    }

    public float getInitial_balance() {
        return initial_balance;
    }

    public void setInitial_balance(float initial_balance) {
        this.initial_balance = initial_balance;
    }

    public float getInterest_rate() {
        return interest_rate;
    }

    public void setInterest_rate(float interest_rate) {
        this.interest_rate = interest_rate;
    }

    public float getCurrent_balance() {
        return current_balance;
    }

    public void setCurrent_balance(float current_balance) {
        this.current_balance = current_balance;
    }
}

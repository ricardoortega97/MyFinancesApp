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

    public void setCd_id(int i) {
        this.cd_id = i;
    }

    public int getAccount_number() {
        return account_number;
    }

    public void setAccount_number(int i) {
        this.account_number = i;
    }

    public float getInitial_balance() {
        return initial_balance;
    }

    public void setInitial_balance(float f) {
        this.initial_balance = f;
    }

    public float getInterest_rate() {
        return interest_rate;
    }

    public void setInterest_rate(float f) {
        this.interest_rate = f;
    }

    public float getCurrent_balance() {
        return current_balance;
    }

    public void setCurrent_balance(float f) {
        this.current_balance = f;
    }
}

package com.example.myfinances.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myfinances.model.CD;
import com.example.myfinances.model.CheckingAccount;
import com.example.myfinances.model.Loans;

public class FinancesDataSource {

    private SQLiteDatabase database;
    private FinanceDBHelper FinanceDbHelper;

    public FinancesDataSource(Context context) {
        FinanceDbHelper = new FinanceDBHelper(context);
    }

    public void open() {
        database =  FinanceDbHelper.getWritableDatabase();
    }
    public void close() {
        FinanceDbHelper.close();
    }

    //import CD object class
    public boolean insertCD(CD cd) {
        boolean didSucceed = false;
        try {
            ContentValues initialValues = new ContentValues();

            initialValues.put("account_number", cd.getAccount_number());
            initialValues.put("initial_balance", cd.getInitial_balance());
            initialValues.put("interest_rate", cd.getInterest_rate());
            initialValues.put("current_balance", cd.getCurrent_balance());

            didSucceed = database.insert("cd", null, initialValues) > 0;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return didSucceed;
    }
    public boolean updateCD(CD cd) {
        boolean didSucceed = false;
        try {
            long rowId = (long) cd.getCd_id();
            ContentValues updateValues = new ContentValues();

            updateValues.put("account_number", cd.getAccount_number());
            updateValues.put("initial_balance", cd.getInitial_balance());
            updateValues.put("interest_rate", cd.getInterest_rate());
            updateValues.put("current_balance", cd.getCurrent_balance());

            didSucceed = database.update("cd", updateValues, "_id=" + rowId, null) > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return didSucceed;
    }
    public int getLastCDId() {
        int lastId;
        try {
            String query = "Select MAX(cd_id) from cd";
            Cursor cursor = database.rawQuery(query, null);

            cursor.moveToFirst();
            lastId = cursor.getInt(0);
            cursor.close();
        } catch (Exception e) {
            lastId = -1;
        }
        return lastId;
    }

    //import Loans object class
    public boolean insertLoans(Loans l) {
        boolean didSucceed = false;
        try {
            ContentValues initialValues = new ContentValues();

            initialValues.put("account_number", l.getAccount_number());
            initialValues.put("initial_balance", l.getInitial_balance());
            initialValues.put("interest_rate", l.getInterest_rate());
            initialValues.put("current_balance", l.getCurrent_balance());
            initialValues.put("payment_amount", l.getPayment_amount());

            didSucceed = database.insert("loans", null, initialValues) > 0;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return didSucceed;
    }
    public boolean updateLoans(Loans loans) {
        boolean didSucceed = false;
        try {
            long rowId = (long) loans.getLoan_id();
            ContentValues updateValues = new ContentValues();

            updateValues.put("account_number", loans.getAccount_number());
            updateValues.put("initial_balance", loans.getInitial_balance());
            updateValues.put("interest_rate", loans.getInterest_rate());
            updateValues.put("current_balance", loans.getCurrent_balance());
            updateValues.put("payment_amount", loans.getPayment_amount());

            didSucceed = database.update("loans", updateValues, "_id=" + rowId, null) > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return didSucceed;
    }
    public int getLastLoansId() {
        int lastId;
        try {
            String query = "Select MAX(loan_id) from loans";
            Cursor cursor = database.rawQuery(query, null);

            cursor.moveToFirst();
            lastId = cursor.getInt(0);
            cursor.close();
        } catch (Exception e) {
            lastId = -1;
        }
        return lastId;
    }

    //import CheckingAccount object class
    public boolean insertCheckingAccount(CheckingAccount ca) {
        boolean didSucceed = false;
        try {
            ContentValues initialValues = new ContentValues();

            initialValues.put("account_number", ca.getAccount_number());
            initialValues.put("current_balance", ca.getCurrent_balance());

            didSucceed = database.insert("checking", null, initialValues) > 0;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return didSucceed;
    }
    public boolean updateCheckingAccount(CheckingAccount ca) {
        boolean didSucceed = false;
        try {
            long rowId = (long) ca.getChecking_id();
            ContentValues updateValues = new ContentValues();

            updateValues.put("account_number", ca.getAccount_number());
            updateValues.put("current_balance", ca.getCurrent_balance());

            didSucceed = database.update("checking", updateValues, "_id=" + rowId, null) > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return didSucceed;
    }
    public int getLastCAId() {
        int lastId;
        try {
            String query = "Select MAX(checking_id) from checking";
            Cursor cursor = database.rawQuery(query, null);

            cursor.moveToFirst();
            lastId = cursor.getInt(0);
            cursor.close();
        } catch (Exception e) {
            lastId = -1;
        }
        return lastId;
    }
}
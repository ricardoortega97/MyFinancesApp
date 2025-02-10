package com.example.myfinances.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class FinanceDBHelper  extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "finances.db";
    private static final int DATABASE_VERSION = 1;

    public FinanceDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    //Create table for CD
    private static final String CREATE_TABLE_CD = "CREATE TABLE cd (" +
            "cd_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "account_number INTEGER, " +
            "initial_balance FLOAT, " +
            "interest_rate FLOAT, " +
            "current_balance FLOAT)";

    //Create table for Loans
    private static final String CREATE_TABLE_LOANS = "CREATE TABLE loans (" +
            "loan_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "account_number INTEGER, " +
            "initial_balance FLOAT, " +
            "interest_rate FLOAT, " +
            "current_balance FLOAT, " +
            "payment_amount FLOAT)";

    //Create table for Checking Account
    private static final String CREATE_TABLE_CHECKING = "CREATE TABLE checking (" +
            "checking_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "account_number INTEGER, " +
            "current_balance FLOAT)";

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_CD);
        sqLiteDatabase.execSQL(CREATE_TABLE_LOANS);
        sqLiteDatabase.execSQL(CREATE_TABLE_CHECKING);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVer, int newVer) {
        Log.w(FinanceDBHelper.class.getName(),
                "Upgrading database from version " + oldVer + " to " + newVer +
                        ", which will destroy all old data");

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS cd");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS loans");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS checking");
    }
}

package com.example.myfinances;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setForEditing();
        selectAccountType("CD");
    }

    public void selectAccountType(String accountType) {
        RadioGroup accountTypeGroup = findViewById(R.id.radioGroup);

        accountTypeGroup.setOnCheckedChangeListener(
                (group, checkedId) -> {
                    if (checkedId == R.id.radioCD) {
                        enableCDTexts();
                    } else if (checkedId == R.id.radioLoans) {
                        enableLoanTexts();
                    } else if (checkedId == R.id.radioCA) {
                        enableCheckingTexts();
                    }
                }
        );
    }



    //set for editing on the fields; we do not talk about this..
    private  void enableCDTexts() {
        EditText accountNumber = findViewById(R.id.editAccount);
        EditText initialBalance = findViewById(R.id.editInitialBal);
        EditText currentBalance = findViewById(R.id.editCurrentBal);
        EditText interestRate = findViewById(R.id.editInterestRate);

        accountNumber.setEnabled(true);
        initialBalance.setEnabled(true);
        currentBalance.setEnabled(true);
        interestRate.setEnabled(true);

        EditText payment = findViewById(R.id.editPayment);

        payment.setEnabled(false);
    }
    private void enableLoanTexts() {
        EditText accountNumber = findViewById(R.id.editAccount);
        EditText initialBalance = findViewById(R.id.editInitialBal);
        EditText currentBalance = findViewById(R.id.editCurrentBal);
        EditText interestRate = findViewById(R.id.editInterestRate);
        EditText payment = findViewById(R.id.editPayment);

        accountNumber.setEnabled(true);
        initialBalance.setEnabled(true);
        currentBalance.setEnabled(true);
        interestRate.setEnabled(true);
        payment.setEnabled(true);
    }
    private void enableCheckingTexts() {
        EditText accountNumber = findViewById(R.id.editAccount);
        EditText currentBalance = findViewById(R.id.editCurrentBal);

        accountNumber.setEnabled(true);
        currentBalance.setEnabled(true);

        EditText initialBalance = findViewById(R.id.editInitialBal);
        EditText interestRate = findViewById(R.id.editInterestRate);
        EditText payment = findViewById(R.id.editPayment);

        initialBalance.setEnabled(false);
        interestRate.setEnabled(false);
        payment.setEnabled(false);
    }
    private void setForEditing() {
        EditText accountNumber = findViewById(R.id.editAccount);
        EditText initialBalance = findViewById(R.id.editInitialBal);
        EditText currentBalance = findViewById(R.id.editCurrentBal);
        EditText interestRate = findViewById(R.id.editInterestRate);
        EditText payment = findViewById(R.id.editPayment);

        accountNumber.setEnabled(false);
        initialBalance.setEnabled(false);
        currentBalance.setEnabled(false);
        interestRate.setEnabled(false);
        payment.setEnabled(false);
    }
}
package com.example.myfinances;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myfinances.database.FinancesDataSource;
import com.example.myfinances.model.CD;
import com.example.myfinances.model.CheckingAccount;
import com.example.myfinances.model.Loans;

public class MainActivity extends AppCompatActivity {


    private CD currentCD;
    private Loans currentLoan;
    private CheckingAccount currentCA;

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

        currentCD = new CD();
        currentLoan = new Loans();
        currentCA = new CheckingAccount();

        setForEditing();
        selectAccountType("CD");
        initSaveButton();
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


    public void initSaveButton() {
        Button btnSave = findViewById(R.id.saveBtn);
        btnSave.setOnClickListener(v -> {
            RadioGroup accountTypeGroup = findViewById(R.id.radioGroup);
            int selectedId = accountTypeGroup.getCheckedRadioButtonId();

            FinancesDataSource ds = new FinancesDataSource(this);

            EditText accountNumber = findViewById(R.id.editAccount);
            EditText initialBalance = findViewById(R.id.editInitialBal);
            EditText currentBalance = findViewById(R.id.editCurrentBal);
            EditText interestRate = findViewById(R.id.editInterestRate);
            EditText payment = findViewById(R.id.editPayment);


            try {
                ds.open();
                //CD
                if (selectedId == R.id.radioCD) {

                    currentCD.setAccount_number(Integer.parseInt(accountNumber.getText().toString()));
                    currentCD.setInitial_balance(Float.parseFloat(initialBalance.getText().toString()));
                    currentCD.setCurrent_balance(Float.parseFloat(currentBalance.getText().toString()));
                    currentCD.setInterest_rate(Float.parseFloat(interestRate.getText().toString()));

                    if (currentCD.getCd_id() == -1) {
                        if (ds.insertCD(currentCD)) {
                            currentCD.setCd_id(ds.getLastCDId());
                        }
                    } else {
                        ds.updateCD(currentCD);
                    }
                //Loans
                } else if (selectedId == R.id.radioLoans) {

                    currentLoan.setAccount_number(Integer.parseInt(accountNumber.getText().toString()));
                    currentLoan.setInitial_balance(Float.parseFloat(initialBalance.getText().toString()));
                    currentLoan.setCurrent_balance(Float.parseFloat(currentBalance.getText().toString()));
                    currentLoan.setInterest_rate(Float.parseFloat(interestRate.getText().toString()));
                    currentLoan.setPayment_amount(Float.parseFloat(payment.getText().toString()));

                    if (currentLoan.getLoan_id() == -1) {
                        if (ds.insertLoans(currentLoan)) {
                            currentLoan.setLoan_id(ds.getLastLoansId());
                        }
                    } else {
                        ds.updateLoans(currentLoan);
                    }
                //Checking Account
                } else if (selectedId == R.id.radioCA) {

                    currentCA.setAccount_number(Integer.parseInt(accountNumber.getText().toString()));
                    currentCA.setCurrent_balance(Float.parseFloat(currentBalance.getText().toString()));

                    if (currentCA.getChecking_id() == -1) {
                        if (ds.insertCheckingAccount(currentCA)) {
                            currentCA.setChecking_id(ds.getLastCAId());
                        }
                    } else {
                        ds.updateCheckingAccount(currentCA);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                ds.close();
            }
        });

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
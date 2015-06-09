package com.salary_calculator.nayeem.nayeem_salary_calculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements View.OnClickListener{

    EditText T_Amount,M_Rate,H_Rent;
    TextView TotalAmount;

    Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }
    private void init() {

        T_Amount=(EditText)findViewById(R.id.T_Amount);
        M_Rate=(EditText)findViewById(R.id.T_Rate);
        H_Rent=(EditText)findViewById(R.id.H_Rent);



        TotalAmount=(TextView)findViewById(R.id.TotalAmount);

        btnCalculate=(Button)findViewById(R.id.btnCalculate);
        btnCalculate.setOnClickListener(this);


    }
    // button click
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnCalculate:

                basicSalary();

                T_Amount.setText("");
                M_Rate.setText("");
                H_Rent.setText("");
                break;
        }
    }



    // equation for interest amount and total amount
    private void basicSalary() {

        String amount = T_Amount.getText().toString();
        double amount1 = Double.parseDouble(amount);

        String m_interest=M_Rate.getText().toString();
        double m_interestRate=Double.parseDouble(m_interest);

        String h_interest=H_Rent.getText().toString();
        double h_interestRate=Double.parseDouble(h_interest);

        double interestAmount_m=(amount1/100)*m_interestRate;

        double interestAmount_h=(amount1/100)*h_interestRate;

        double totalAmount = amount1+interestAmount_m+interestAmount_h;

        TotalAmount.setText(String.valueOf(totalAmount));

    }


}

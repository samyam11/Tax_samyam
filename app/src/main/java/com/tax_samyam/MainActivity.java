package com.tax_samyam;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText Income;
    TextView Tax;
    Button Calcualte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Income= findViewById(R.id.Income);
        Tax= findViewById(R.id.Tax);

        Calcualte= findViewById(R.id.Calculate);

        Calcualte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double income, tax;

                income = Integer.parseInt(Income.getText().toString()) *12;

                Calculator calculator= new Calculator(income);
                tax= calculator.Tax();
                Tax.setText(Double.toString(tax));

                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(Calcualte.getWindowToken(), InputMethodManager.RESULT_UNCHANGED_SHOWN);
            }
        });
    }
}

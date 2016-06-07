package com.example.android.tipcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    EditText billAmount;
    EditText tipAmount;
    EditText totalAmount;
    RadioButton fifteenPercent;
    RadioButton eighteenPercent;
    RadioButton twentyPercent;
    RadioGroup tipPercentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        billAmount = (EditText)findViewById(R.id.editText);
        tipAmount = (EditText)findViewById(R.id.editText2);
        totalAmount = (EditText)findViewById(R.id.editText3);
        fifteenPercent = (RadioButton)findViewById(R.id.radioButton);
        eighteenPercent = (RadioButton)findViewById(R.id.radioButton2);
        twentyPercent = (RadioButton)findViewById(R.id.radioButton3);
        tipPercentage = (RadioGroup)findViewById(R.id.radioGroup);
        tipPercentage.setOnCheckedChangeListener(this);
    }

    public void onCheckedChanged(RadioGroup tipPercentage, int checkedTip) {
        EditText endBill = (EditText) billAmount;
        String enterBill = endBill.getText().toString();

        if (enterBill.equals("")){
            Toast.makeText(this, "Please enter bill amount", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO Auto-generated method stub
        if (checkedTip == fifteenPercent.getId()){
            double bill = Double.parseDouble(billAmount.getText().toString());
            double tip = bill * .15;
            double total = bill + tip;
            DecimalFormat df = new DecimalFormat("#.00");
            tipAmount.setText(df.format(tip));
            totalAmount.setText(df.format(total));
        }
        if (checkedTip == eighteenPercent.getId()){
            double bill = Double.parseDouble(billAmount.getText().toString());
            double tip = bill * .18;
            double total = bill + tip;
            DecimalFormat df = new DecimalFormat("#.00");
            tipAmount.setText(df.format(tip));
            totalAmount.setText(df.format(total));
        }
        if (checkedTip == twentyPercent.getId()){
            double bill = Double.parseDouble(billAmount.getText().toString());
            double tip = bill * .20;
            double total = bill + tip;
            DecimalFormat df = new DecimalFormat("#.00");
            tipAmount.setText(df.format(tip));
            totalAmount.setText(df.format(total));
        }
    }
}

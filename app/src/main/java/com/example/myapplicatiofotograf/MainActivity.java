package com.example.myapplicatiofotograf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private float spongeCakes = 10;
    private int spongeCakesDiscount = 26;
    private float cream = 14;
    private int creamDiscount = 5;
    private float fruits = 3;
    private int fruitsDiscount = 12;
    private float nuts = 5;
    private int nutsDiscount = 55;
    private float berries = 7;
    private float account = 25;
    private TextView possibilityOut;
    private TextView balanceOut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        possibilityOut = findViewById(R.id.possibilityOut);
        balanceOut = findViewById(R.id.balanceOut);

        if (possibility()) {
            possibilityOut.setText("Enough funds");
            balanceOut.setText("Thank you for your purchase" + balance() + "coins");
        } else {
            possibilityOut.setText("Funds aren`t enough");
            balanceOut.setText("you are just stupid human, without money");
        }
    }

    private float calculating() {
       float count = (spongeCakes * (100 - spongeCakesDiscount) + cream * (100 - creamDiscount)
               + fruits * (100 - fruitsDiscount) + nuts * (100 - nutsDiscount)) / 100 + berries;
       return count;
    }

    private boolean possibility() {
        if (calculating() <= account) {
            return true;
        } else {
            return false;
        }
    }

    private float balance() {
        if(possibility()) {
            return account - calculating();
        } else {
            return -1;
        }
    }
}









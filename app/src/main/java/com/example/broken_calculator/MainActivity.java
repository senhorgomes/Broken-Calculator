package com.example.broken_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private boolean isOpPressed = false;

    private double firstNumber = 0;

    private int secondNumberIndex = 0;

    private char currentOp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc_layout);
        final TextView calculatorScreen = findViewById(R.id.calculatorScreen);
        final Button n0 = findViewById(R.id.n0);
        final Button n1 = findViewById(R.id.n1);
        final Button n2 = findViewById(R.id.n2);
        final Button n3 = findViewById(R.id.n3);
        final Button n4 = findViewById(R.id.n4);
        final Button n5 = findViewById(R.id.n5);
        final Button n6 = findViewById(R.id.n6);
        final Button n7 = findViewById(R.id.n7);
        final Button n8 = findViewById(R.id.n8);
        final Button n9 = findViewById(R.id.n9);
        final Button division = findViewById(R.id.division);
        final Button multiplication = findViewById(R.id.multiplication);
        final Button addition = findViewById(R.id.addition);
        final Button subtraction = findViewById(R.id.subtraction);
        final Button dot = findViewById(R.id.dot);
        final Button equals = findViewById(R.id.equals);
        final Button del = findViewById(R.id.del);
        final Button clearEverything = findViewById(R.id.clearEverything);

        final View.OnClickListener calculatorListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final int id = view.getId();
                switch(id) {
                    case R.id.n0:
                        calculatorScreen.append("0");
                        break;
                    case R.id.n1:
                        calculatorScreen.append("1");
                        break;
                    case R.id.n2:
                        calculatorScreen.append("2");
                        break;
                    case R.id.n3:
                        calculatorScreen.append("3");

                        break;
                    case R.id.n4:
                        calculatorScreen.append("4");

                        break;
                    case R.id.n5:
                        calculatorScreen.append("5");

                        break;
                    case R.id.n6:
                        calculatorScreen.append("6");

                        break;
                    case R.id.n7:
                        calculatorScreen.append("7");

                        break;
                    case R.id.n8:
                        calculatorScreen.append("8");

                        break;
                    case R.id.n9:
                        calculatorScreen.append("9");

                        break;
                    case R.id.dot:
                        calculatorScreen.append(".");

                        break;
                    case R.id.equals:
                        if(isOpPressed) {
                            if(currentOp=='+'){
                                String screenContent = calculatorScreen.getText().toString();
                                String secondNumberString = screenContent.substring(secondNumberIndex, screenContent.length());
                                double secondNumber = Double.parseDouble(secondNumberString);
                                double bigNumber = 0;
                                // Determines which number is bigger
                                if(secondNumber > firstNumber){
                                    bigNumber = secondNumber;
                                    System.out.println(bigNumber);
                                } else {
                                    bigNumber = firstNumber;
                                    System.out.println(bigNumber);
                                }
                                //this is where the addition actually happens
                                double result = firstNumber+=secondNumber;
                                //insert broken code command
                                double range = (result - bigNumber) + 1;
                                double brokenResult = (int)(Math.random() * range) + bigNumber;
                                if(brokenResult==result){
                                    brokenResult-=1;
                                    calculatorScreen.setText(String.valueOf(brokenResult));
                                } else {
                                    calculatorScreen.setText(String.valueOf(brokenResult));
                                }
                            }
                            if(currentOp=='-'){
                                String screenContent = calculatorScreen.getText().toString();
                                String secondNumberString = screenContent.substring(secondNumberIndex, screenContent.length());
                                double secondNumber = Double.parseDouble(secondNumberString);
                                //this is where the subtraction actually happens, this variable will be used for conditional check
                                double result = firstNumber-secondNumber;
                                //Broken answer needs to be greater or lesser than result
                                //Make a random number
                                double rangeRandom = (2 - 1) + 1;
                                double randomNumber = (int)(Math.random() * rangeRandom) + result;
                                double range  = 0;
                                double brokenResult = 0;
                                //double range = (firstNumber - result) + 1;
                                //If number is 2 then max is firstNumber and min is result
                                if(randomNumber == 2) {
                                    range = (firstNumber - result) + 1;
                                    brokenResult = (int)(Math.random() * range) + result;
                                } else {
                                //Else max is result and min is secondNumber
                                    range = (result - secondNumber) + 1;
                                    brokenResult = (int)(Math.random() * range) + secondNumber;
                                }
                                //insert broken code command
                                //Randomizes answer
                                if(brokenResult==result){
                                    brokenResult+=1;
                                    calculatorScreen.setText(String.valueOf(brokenResult));
                                } else {
                                    calculatorScreen.setText(String.valueOf(brokenResult));
                                }
                                //Answer needs to be above or below actual result
                            }
                            if(currentOp=='×'){
                                String screenContent = calculatorScreen.getText().toString();
                                String secondNumberString = screenContent.substring(secondNumberIndex, screenContent.length());
                                double secondNumber = Double.parseDouble(secondNumberString);
                                double smallNumber = 0;
                                double bigNumber = 0;
                                // Determines which number is bigger
                                if(secondNumber < firstNumber){
                                    smallNumber = secondNumber;
                                    bigNumber = firstNumber;
                                    System.out.println(smallNumber);
                                } else {
                                    smallNumber = firstNumber;
                                    bigNumber = secondNumber;
                                    System.out.println(smallNumber);
                                }
                                //this is where the multiplication actually happens
                                double result = firstNumber*secondNumber;
                                System.out.println(result);
                                //insert broken code command
                                double range = (smallNumber - 1) + 1;
                                double brokenMultiplier = (int)(Math.random() * range) + 1;
                                double brokenResult = bigNumber*brokenMultiplier;
                                if(brokenResult==result){
                                    brokenResult+=bigNumber;
                                    calculatorScreen.setText(String.valueOf(brokenResult));
                                } else {
                                    calculatorScreen.setText(String.valueOf(brokenResult));
                                }
                            }
                        }
                        break;
                    case R.id.addition:
                        String screenContent = calculatorScreen.getText().toString();
                        secondNumberIndex = screenContent.length() + 1;
                        firstNumber = Double.parseDouble(screenContent);
                        calculatorScreen.append("+");
                        isOpPressed = true;
                        currentOp = '+';
                        break;
                    case R.id.subtraction:
                        screenContent = calculatorScreen.getText().toString();
                        secondNumberIndex = screenContent.length() + 1;
                        firstNumber = Double.parseDouble(screenContent);
                        calculatorScreen.append("-");
                        isOpPressed = true;
                        currentOp = '-';

                        break;
                    case R.id.multiplication:
                        screenContent = calculatorScreen.getText().toString();
                        secondNumberIndex = screenContent.length() + 1;
                        firstNumber = Double.parseDouble(screenContent);
                        calculatorScreen.append("×");
                        isOpPressed = true;
                        currentOp = '×';

                        break;
                    case R.id.division:
                        //calculatorScreen.append("2");

                        break;

                }
            }
        };
        n0.setOnClickListener(calculatorListener);
        n1.setOnClickListener(calculatorListener);
        n2.setOnClickListener(calculatorListener);
        n3.setOnClickListener(calculatorListener);
        n4.setOnClickListener(calculatorListener);
        n5.setOnClickListener(calculatorListener);
        n6.setOnClickListener(calculatorListener);
        n7.setOnClickListener(calculatorListener);
        n8.setOnClickListener(calculatorListener);
        n9.setOnClickListener(calculatorListener);
        addition.setOnClickListener(calculatorListener);
        subtraction.setOnClickListener(calculatorListener);
        division.setOnClickListener(calculatorListener);
        multiplication.setOnClickListener(calculatorListener);
        dot.setOnClickListener(calculatorListener);
        equals.setOnClickListener(calculatorListener);
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String displayedElements = calculatorScreen.getText().toString();
                int screenLength = displayedElements.length();
                if (screenLength > 0) {
                    displayedElements = displayedElements.substring(0, (screenLength - 1));
                    calculatorScreen.setText(displayedElements);
                }
            }
        });
        clearEverything.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculatorScreen.setText("");
            }
        });

    }
}
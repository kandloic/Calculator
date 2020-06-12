package com.example.my_first_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button0, button1, button2, button3, button4, button5, button6,
    button7, button8, button9, buttonAdd, buttonMinus, buttonMul, buttonDiv,
    buttonClear, buttonEqual, buttonDec;
    TextView edttxt;
    float val_one, val_two;
    boolean add, sub, mul, div;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0 = (Button)findViewById(R.id.btn0);
        button1 = (Button)findViewById(R.id.btn1);
        button2 = (Button)findViewById(R.id.btn2);
        button3 = (Button)findViewById(R.id.btn3);
        button4 = (Button)findViewById(R.id.btn4);
        button5 = (Button)findViewById(R.id.btn5);
        button6 = (Button)findViewById(R.id.btn6);
        button7 = (Button)findViewById(R.id.btn7);
        button8 = (Button)findViewById(R.id.btn8);
        button9 = (Button)findViewById(R.id.btn9);
        buttonAdd = (Button)findViewById(R.id.btnadd);
        buttonMinus = (Button)findViewById(R.id.btnminus);
        buttonMul = (Button)findViewById(R.id.btnmultiply);
        buttonDiv = (Button)findViewById(R.id.btndivide);
        buttonClear = (Button)findViewById(R.id.btnclear);
        buttonEqual = (Button)findViewById(R.id.btnequal);
        buttonDec = (Button)findViewById(R.id.btndecimal);

        edttxt = (TextView)findViewById(R.id.screen);

        button0.setOnClickListener((v)-> {
            edttxt.setText(edttxt.getText() + "0");
        });

        button1.setOnClickListener((v)-> {
            edttxt.setText(edttxt.getText() + "1");
        });

        button2.setOnClickListener((v)-> {
            edttxt.setText(edttxt.getText() + "2");
        });

        button3.setOnClickListener((v)-> {
            edttxt.setText(edttxt.getText() + "3");
        });

        button4.setOnClickListener((v)-> {
            edttxt.setText(edttxt.getText() + "4");
        });

        button5.setOnClickListener((v)-> {
            edttxt.setText(edttxt.getText() + "5");
        });

        button6.setOnClickListener((v)-> {
            edttxt.setText(edttxt.getText() + "6");
        });

        button7.setOnClickListener((v)-> {
            edttxt.setText(edttxt.getText() + "7");
        });

        button8.setOnClickListener((v)-> {
            edttxt.setText(edttxt.getText() + "8");
        });

        button9.setOnClickListener((v)-> {
            edttxt.setText(edttxt.getText() + "9");
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val_one = Float.parseFloat(edttxt.getText().toString());
                add = true;
                sub = false;
                mul = false;
                div = false;
                edttxt.setText("");


            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val_one = Float.parseFloat(edttxt.getText().toString());
                sub = true;
                add = false;
                mul = false;
                div = false;
                edttxt.setText("");
            }
        });

        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val_one = Float.parseFloat(edttxt.getText().toString());
                div = true;
                mul = false;
                add = false;
                sub = false;
                edttxt.setText("");
            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val_one = Float.parseFloat(edttxt.getText().toString());
                mul = true;
                div = false;
                add = false;
                sub = false;
                edttxt.setText("");
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edttxt.setText("");
            }
        });

        buttonDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String input = edttxt.getText().toString();
                for(int i=0; i<input.length(); i++){
                    if (input.charAt(i)=='.'){
                        edttxt.setText("Invalid input");
                        return;
                    }
                }
                edttxt.setText(edttxt.getText() + ".");
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    float res = 0;
                    val_two = Float.parseFloat(edttxt.getText().toString());
                    if (add) { res = val_one + val_two; }
                    else if (sub) { res = val_one - Float.parseFloat(edttxt.getText().toString()); }
                    else if (mul) { res = val_one * Float.parseFloat(edttxt.getText().toString());}
                    else if (div) { res = val_one / Float.parseFloat(edttxt.getText().toString()); }
                    else { throw new NullPointerException(); }

                    edttxt.setText(Float.toString(res));
                    val_one = res;

                }
                catch (Exception e) {
                    edttxt.setText("");
                    edttxt.setText("Invalid operation");
                }
            }
        });





    }
}
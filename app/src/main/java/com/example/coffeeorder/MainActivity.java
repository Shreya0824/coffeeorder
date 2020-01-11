package com.example.coffeeorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    Button btndec,btninc,btnorder,btnmail,btnres;
    EditText ed2,ed1;
    TextView ed3;
    private CheckBox btnchc,btnchw;
    int counter=0,coffee_price;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent =new Intent(Intent.ACTION_SEND);
                emailIntent.putExtra(Intent.EXTRA_EMAIL,new String[]{"abc@xyz.com"});
                emailIntent.putExtra(Intent.EXTRA_TEXT,"body");
                emailIntent.setType("message/rfc822");
                startActivity(Intent.createChooser(emailIntent,"choose one application"));
            }
        });

        btnchw=(CheckBox) findViewById(R.id.btnchw);
        btnchc=(CheckBox) findViewById(R.id.btnchc);
        btndec=(Button)findViewById(R.id.btndec);
        btninc=(Button)findViewById(R.id.btninc);
        btnorder=(Button)findViewById(R.id.btnorder);
        btnmail=(Button)findViewById(R.id.btnmail);
        btnres=(Button)findViewById(R.id.btnres);
        ed3=(TextView) findViewById(R.id.ed3);
        ed2=(EditText)findViewById(R.id.ed2);
        ed1=(EditText)findViewById(R.id.ed1);
        btnres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed1.setText("");

                ed3.setText("");
                btnchc.setChecked(false);
                btnchw.setChecked(false);
                ed2.setText(null);
counter=0;
            }
        });



        ed2.setText("0");
        btninc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter=counter+1;
                ed2.setText(String.valueOf(counter));
            }
        });

        btndec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(counter>0) {
                    counter = counter - 1;
                    ed2.setText(String.valueOf(counter));
                }
            }});


        btnorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int coffee_price = 50;
                if (btnchc.isChecked() && !(btnchw.isChecked())) {
                    ed3.setText("toppings:chocolate" +"\n "+
                            "total expense="+(counter*(50+5)));
                } else if (btnchw.isChecked() && !(btnchc.isChecked())) {
                    ed3.setText("toppings:whipped cream" +"\n"+
                            "total expense="+(counter*(50+10)));
                } else if (btnchc.isChecked() && btnchw.isChecked()) {
                    ed3.setText("toppings:chocolate and whipped cream" +"\n"+
                            "total expense="+(counter*(50+10+5)));
                } else {
                    ed3.setText("toppings:none" +"\n"+
                            "total expense=" +(counter*50));
                }
            }

        });
        }}


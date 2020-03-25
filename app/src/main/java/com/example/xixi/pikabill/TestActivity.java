package com.example.xixi.pikabill;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class TestActivity extends AppCompatActivity {
    Button b1 = null;
    Button b2 = null;
    Button b3 = null;
    Button b4 =null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        b1 =(Button)findViewById(R.id.button7);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(TestActivity.this, home.class);
                startActivity(intent);
            }
        });
        b2 =(Button)findViewById(R.id.button8);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(TestActivity.this, newbill.class);
                startActivity(intent);
            }
        });
        b3 =(Button)findViewById(R.id.button9);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(TestActivity.this, setting.class);
                startActivity(intent);
            }
        });
        b4 =(Button)findViewById(R.id.button20);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(TestActivity.this,BudgetActivity.class);
                startActivity(intent);
            }
        });
    }

}

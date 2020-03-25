package com.example.xixi.pikabill;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class newbill extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_fragment);
        Button goSecondActivityButton = (Button) findViewById(R.id.but1);
        Button resettingButton = (Button) findViewById(R.id.but2);
        final EditText L = (EditText)findViewById(R.id.newsty);
        final EditText money = (EditText)findViewById(R.id.mon);
        final EditText time = (EditText)findViewById(R.id.da);
        final EditText B = (EditText)findViewById(R.id.mo);
        goSecondActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1 =L.getText().toString();
                if(str1!=null){
                    //新建一个Intent(当前Activity, SecondActivity)=====显示Intent
                    Intent intent = new Intent(newbill.this, home.class);
                    //传值给下一个Activity
                    String str_1 =L.getText().toString();
                    String str2 = money.getText().toString();
                    String str3 = time.getText().toString();
                    String str4 = B.getText().toString();


                    Bill bl=new Bill();
                    bl.setB(str4);
                    bl.setMoney(Double.parseDouble(str2));
                    bl.setTime(Integer.parseInt(str3));
                    bl.setL(str_1);

                    MainActivity.Al.add(bl);

                    intent.putExtra("L",str_1);
                    intent.putExtra("money",str2);
                    intent.putExtra("time",str3);
                    intent.putExtra("B",str4);
                    //启动Intent
                    startActivity(intent);
                }

            }
        });
        resettingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L.setText("");
                money.setText("");
                time.setText("");
                B.setText("");
            }
        });

    }

}
package com.example.xixi.pikabill;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BudgetActivity extends AppCompatActivity{
    private Button set_budget = null;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);
        set_budget =(Button)findViewById(R.id.set_button);
        set_budget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText set_time=(EditText) findViewById(R.id.set_time);
                EditText set_money=(EditText) findViewById(R.id.set_money);
                String str1 = set_time.getText().toString();
                String str2 = set_money.getText().toString();
                String heng = str1.substring(0,4);   //年份
                String zong = str1.substring(4);
                int he = Integer.parseInt(heng)-2000;
                int zo = Integer.parseInt(zong);
                MainActivity.Budget[zo][he] = str2;
              /*
                int a=0;
                int b =0;
                for(a=0;a<13;a++){
                    for(b=0;b<2050;b++){
                        MainActivity.Budget[a][b]=" ";
                    }
                }
                */
                //te.setText(MainActivity.Budget[zo][he]);        //测试输出
                set_time.setText("");
                set_money.setText("");

            }
        });
    }
}

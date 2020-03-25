package com.example.xixi.pikabill;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class BalanceActivity extends AppCompatActivity {
    private Button get_money = null;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance);
        get_money =(Button)findViewById(R.id.gettime_ok);
        get_money.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText get_time=(EditText) findViewById(R.id.get_time);
                EditText balance_money=(EditText) findViewById(R.id.balance_money);
                EditText own_money=(EditText) findViewById(R.id.own_money);
                String str1 = get_time.getText().toString();
                String hen = str1.substring(0,4);   //年份
                String zon = str1.substring(4);
                int h = Integer.parseInt(hen)-2000;
                int z = Integer.parseInt(zon);
                int ti = Integer.parseInt(str1);
                own_money.setText(MainActivity.Budget[z][h]);
                ArrayList<Bill> A4 =new ArrayList<>();
                MainActivity.sortYear(MainActivity.Al,A4,ti,ti);
               // String[] bill = new String[]{" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "};
                double[] cnt = new double[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
                for (int i = 0; i < A4.size(); i++) {        //
                   // bill[i] = "\t类型："+A4.get(i).getL()+"   时间："+A4.get(i).getTime()+"   金额："+A4.get(i).getMoney()+"元";
                    cnt[i] =A4.get(i).getMoney();
                }
                double result =Double.parseDouble(MainActivity.Budget[z][h]);
                for(int i=0;i<cnt.length;i++){
                    result =result-cnt[i];
                }
                String yue=String.valueOf(result);
                balance_money.setText(yue);
                own_money.setText(MainActivity.Budget[z][h]);
            }
        });
    }
}

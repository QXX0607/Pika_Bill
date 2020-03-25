package com.example.xixi.pikabill;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class TimeActivity extends AppCompatActivity {
    private Button bu1 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        bu1 = (Button) findViewById(R.id.bu1);
        bu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText begintime=(EditText) findViewById(R.id.begintime);
                EditText endtime=(EditText) findViewById(R.id.endtime);
                String str1 = begintime.getText().toString();
                String str2 = endtime.getText().toString();
                int time1 = Integer.parseInt(str1);
                int time2 = Integer.parseInt(str2);

                ArrayList<Bill> A2 =new ArrayList<>();
                MainActivity.sortBill(MainActivity.Al,A2,time1,time2);
                String[] bill = new String[]{" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "};
                for (int i = 0; i < A2.size(); i++) {        //
//                        String a1 = A2.get(i).L;
//                        double a2 = A2.get(i).money;
//                        int a3 = A2.get(i).time;
//                        String a4 = A2.get(i).B;
//                        String a_3=String.valueOf(a3);
//                        String a_2=String.valueOf(a2);
                    bill[i] = "\t类型："+A2.get(i).getL()+"   时间："+A2.get(i).getTime()+"   金额："+A2.get(i).getMoney()+"元";
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(TimeActivity.this, android.R.layout.simple_list_item_1,bill);
                ListView listView = (ListView) findViewById(R.id.lv1);
                listView.setAdapter(adapter);

            }

        });

    }
}
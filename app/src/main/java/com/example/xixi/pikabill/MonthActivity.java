package com.example.xixi.pikabill;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MonthActivity extends AppCompatActivity {
    private Button bu3 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sortmonth);
        bu3 = (Button) findViewById(R.id.bu3);
        bu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText begintime=(EditText) findViewById(R.id.beginmonth);
                EditText endtime=(EditText) findViewById(R.id.endmonth);
                String str1 = begintime.getText().toString();
                String str2 = endtime.getText().toString();
                int time3 = Integer.parseInt(str1);
                int time4 = Integer.parseInt(str2);

                ArrayList<Bill> A2 =new ArrayList<>();
                MainActivity.sortYear(MainActivity.Al,A2,time3,time4);
                String[] bill = new String[]{" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "};
                for (int i = 0; i < A2.size(); i++) {        //
                    bill[i] = "\t类型："+A2.get(i).getL()+"   时间："+A2.get(i).getTime()+"   金额："+A2.get(i).getMoney()+"元";
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MonthActivity.this, android.R.layout.simple_list_item_1,bill);
                ListView listView = (ListView) findViewById(R.id.lv3);
                listView.setAdapter(adapter);

            }

        });

    }
}
package com.example.xixi.pikabill;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class StyleActivity extends AppCompatActivity {
    private Button bu2 = null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_style);
        bu2 =(Button)findViewById(R.id.bu2);
        bu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
                */

                EditText inputstyle=(EditText) findViewById(R.id.inputstyle);
                String str1 = inputstyle.getText().toString();

                ArrayList<Bill> A3 =new ArrayList<>();
                A3=MainActivity.sortStyle(MainActivity.Al,str1);
                String[] bill = new String[]{" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "};
                for (int i = 0; i < A3.size(); i++) {       //
//                    String a1 = A3.get(i).L;
//                    double a2 = A3.get(i).money;
//                    int a3 = A3.get(i).time;
//                    String a4 = A3.get(i).B;
//                    String a_3=String.valueOf(a3);
//                    String a_2=String.valueOf(a2);
                    bill[i] = "类型："+A3.get(i).getL()+"   时间："+A3.get(i).getTime()+"   金额："+A3.get(i).getMoney()+"元";

                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(StyleActivity.this, android.R.layout.simple_list_item_1,bill);
                ListView listView = (ListView) findViewById(R.id.lv2);
                listView.setAdapter(adapter);
            }
        });
    }
}
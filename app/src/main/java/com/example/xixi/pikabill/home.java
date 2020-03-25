package com.example.xixi.pikabill;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


public class home extends Activity {
    private Button ok1 = null;
    private Button ok2 = null;
    private Button ok3 = null;
    private Button ok4 = null;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_fragment);
        //获取上一个Activity传过来的值
        Intent intent = getIntent();
        String L = intent.getStringExtra("L");
        if(L!=null) {
            String B = intent.getStringExtra("B");
            String money = intent.getStringExtra("money");
            String time = intent.getStringExtra("time");

            //将获取的值显示在TextView上---未修改

            MainActivity.data[MainActivity.i] = "\t类型："+L + "   时间：" + time + "   金额：" + money+"元";
//        TextView dataTextView = (TextView) findViewById(R.id.data_text_view);//测试传到home账单的新建入值
//        dataTextView.setText(MainActivity.data[MainActivity.i]);
            MainActivity.i++;
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(home.this, android.R.layout.simple_list_item_1,MainActivity.data);

        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);
        ok1 =(Button)findViewById(R.id.ok1);
        ok1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(home.this,TimeActivity.class);
                startActivity(intent);
            }
        });
        ok2 =(Button)findViewById(R.id.ok2);
        ok2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(home.this,StyleActivity.class);
                startActivity(intent);
            }
        });
        ok3 =(Button)findViewById(R.id.ok3);
        ok3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(home.this,MonthActivity.class);
                startActivity(intent);
            }
        });
        /*
        ok4 =(Button)findViewById(R.id.ok4);
        ok4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(home.this,BudgetActivity.class);
                startActivity(intent);
            }
        });*/
    }

}

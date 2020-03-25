package com.example.xixi.pikabill;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class us extends AppCompatActivity {
    private Tree root = new Tree();
    private Bill data = new Bill();
    private Cline T = new Cline();
    int t1=20190601;
    int t2 = 20190620;
    String L ="购物";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_fragment);
        data.setB("hh");
        data.setL("购物");
        data.setMoney(100);
        data.setTime(20190614);
        MainActivity.was.add(root,data);
        MainActivity.was.inOrder(root,T);
        MainActivity.was.inOrder(root,t1,t2,T);
        MainActivity.was.LinOrder(root,L,T);
    }
}

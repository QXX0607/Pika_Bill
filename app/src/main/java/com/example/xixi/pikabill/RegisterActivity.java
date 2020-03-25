package com.example.xixi.pikabill;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class RegisterActivity extends Activity implements View.OnClickListener {
    public static int pd=0;
    public static final String TAG = RegisterActivity.class.getName();
    private ImageView iv_showCode;
    private EditText et_phoneCode;
    private EditText et_phoneNum;
    //产生的验证码
    private String realCode;
    private Button b=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);

        et_phoneCode = (EditText) findViewById(R.id.et_phoneCodes);
        Button but_toSetCode = (Button) findViewById(R.id.but_forgetpass_toSetCodes);
        but_toSetCode.setOnClickListener(this);
        iv_showCode = (ImageView) findViewById(R.id.iv_showCode);
        //将验证码用图片的形式显示出来
        iv_showCode.setImageBitmap(IdentifyingCode.getInstance().createBitmap());
        realCode = IdentifyingCode.getInstance().getCode().toLowerCase();
        iv_showCode.setOnClickListener(this);

        b =(Button)findViewById(R.id.ok);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //判断验证码
                if (pd==1){
                    EditText username=(EditText) findViewById(R.id.et_forgetPass_PhoneNum);
                    EditText password=(EditText) findViewById(R.id.editText4);
                    String str1 = username.getText().toString();
                    String str2 = password.getText().toString();

                    MainActivity.username = str1;
                    MainActivity.password = str2;
                    MainActivity.message[MainActivity.m]=MainActivity.username+"#"+MainActivity.password;
                    MainActivity.m++;

                    Intent intent = new Intent();
                    intent.setClass(RegisterActivity.this,MainActivity.class);
                    startActivity(intent);
                }

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_showCode:
                iv_showCode.setImageBitmap(IdentifyingCode.getInstance().createBitmap());
                realCode = IdentifyingCode.getInstance().getCode().toLowerCase();
                Log.v(TAG,"realCode"+realCode);
                break;
            case R.id.but_forgetpass_toSetCodes:
                String phoneCode = et_phoneCode.getText().toString().toLowerCase();
                String msg = "生成的验证码："+realCode+"输入的验证码:"+phoneCode;
                Toast.makeText(RegisterActivity.this,msg,Toast.LENGTH_LONG).show();
                if (phoneCode.equals(realCode)) {
                    pd=1;
                    Toast.makeText(RegisterActivity.this, phoneCode + "验证码正确", Toast.LENGTH_SHORT).show();
                } else {
                    pd=0;
                    Toast.makeText(RegisterActivity.this, phoneCode + "验证码错误", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}

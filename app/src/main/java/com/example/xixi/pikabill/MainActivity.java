package com.example.xixi.pikabill;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tencent.connect.UserInfo;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    public static String[][] Budget = new String[13][53];
    public static Tree was = new Tree();
    public static ArrayList<Bill> Al = new ArrayList<>();
    public static String[] data =new String[]{" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "};
    //        public  static String[] bill = new String[]{" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "};
    public static int i =0;        //控制data的下标移动，添加data[]中元素
    public static int m =0;
    public static int bill1=0;
    public static int bill2 =0;
    public static String username=" ";
    public static String password=" ";
    public static String[] message = new String[]{" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "};
    //24个
    public static boolean bl=false;
    public static String[] Username = new String[]{" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "};
    public static String[] Password = new String[]{" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "};
    private static final String TAG = "MainActivity";
    private static final String APP_ID = "1109312570";//官方获取的APPID
    private Tencent mTencent;
    private BaseUiListener mIUiListener;
    private UserInfo mUserInfo;
    private Button b1 = null;
    private Button b2 = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //传入参数APPID和全局Context上下文
        mTencent = Tencent.createInstance(APP_ID, MainActivity.this.getApplicationContext());
        b1 =(Button)findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    /*
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this,TestActivity.class);
                    startActivity(intent);*/

                EditText user=(EditText) findViewById(R.id.editText3);
                EditText code=(EditText) findViewById(R.id.editText);
                String str1 = user.getText().toString();
                String str2 = code.getText().toString();

                //  TextView dataTextView = (TextView) findViewById(R.id.textView14);//测试传到home账单的新建入值
                //dataTextView.setText(username);
                AES aes=new AES();
                boolean a=false,b=false;
                a=username.equals(str1)&&password.equals(str2)&&Arrays.equals(aes.jiami(password),aes.jiami(str2));
                b=username.equals("666")&&password.equals("666");
                if(a||b){
                    Intent intent1 = new Intent();
                    intent1.setClass(MainActivity.this,TestActivity.class);
                    startActivity(intent1);
                }
                else{
                    initEvent();
                }
            }
        });
        b2 =(Button)findViewById(R.id.button3);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
        Button goSecondActivityButton = (Button) findViewById(R.id.but1);
    }

    public void blogin(View v) {
        /**通过这句代码，SDK实现了QQ的登录，这个方法有三个参数，第一个参数是context上下文，第二个参数SCOPO 是一个String类型的字符串，表示一些权限
         官方文档中的说明：应用需要获得哪些API的权限，由“，”分隔。例如：SCOPE = “get_user_info,add_t”；所有权限用“all”
         第三个参数，是一个事件监听器，IUiListener接口的实例，这里用的是该接口的实现类 */
        mIUiListener = new BaseUiListener();
        //all表示获取所有权限
        mTencent.login(MainActivity.this, "all", mIUiListener);
    }

    /**
     * 自定义监听器实现IUiListener接口后，需要实现的3个方法
     * onComplete完成 onError错误 onCancel取消
     */
    private class BaseUiListener implements IUiListener {

        @Override
        public void onComplete(Object response) {
            Toast.makeText(MainActivity.this, "授权成功", Toast.LENGTH_SHORT).show();
            Log.e(TAG, "response:" + response);
            JSONObject obj = (JSONObject) response;

            try {
                String openID = obj.getString("openid");
                String accessToken = obj.getString("access_token");
                String expires = obj.getString("expires_in");
                mTencent.setOpenId(openID);
                mTencent.setAccessToken(accessToken, expires);
                QQToken qqToken = mTencent.getQQToken();
                mUserInfo = new UserInfo(getApplicationContext(), qqToken);
                mUserInfo.getUserInfo(new IUiListener() {
                    @Override
                    public void onComplete(Object response) {
                        //是一个json串response.tostring，直接使用gson解析就好
                        Log.e(TAG, "登录成功" + response.toString());

                        //登录成功后进行Gson解析即可获得你需要的QQ头像和昵称
                        // Nickname  昵称
                        //Figureurl_qq_1 //头像

                    }

                    @Override
                    public void onError(UiError uiError) {
                        Log.e(TAG, "登录失败" + uiError.toString());
                        bl=true;
                    }

                    @Override
                    public void onCancel() {
                        Log.e(TAG, "登录取消");
                        bl=true;

                    }
                });
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if(!bl){
                Intent intent1 = new Intent();
                intent1.setClass(MainActivity.this,TestActivity.class);
                startActivity(intent1);
            }
            else{
                initEvent();
            }
        }

        @Override
        public void onError(UiError uiError) {
            Toast.makeText(MainActivity.this, "授权失败", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onCancel() {
            Toast.makeText(MainActivity.this, "授权取消", Toast.LENGTH_SHORT).show();

        }

    }

    /**
     * 在调用Login的Activity或者Fragment中重写onActivityResult方法
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Constants.REQUEST_LOGIN) {
            Tencent.onActivityResultData(requestCode, resultCode, data, mIUiListener);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public static void sortb(Bill B1[],Bill B2[],int t1,int t2){//输入账单B1 和 空B2 以及时间段t1，t2.则B2为结果。
        int i=0,t=0;
        while(B1[i]!=null){
            if (B1[i].getTime()>=t1&&B1[i].getTime()<=t2){
                B2[t]=B1[i];
                t++;
            }
            i++;
        }
    }
    public static void sorts(Bill B1[],Bill B2[],String str){//输入账单B1 和 空B2 以及时间段t1，t2.则B2为结果。
        int i=0,t=0;
        while(B1[i]!=null){
            if (B1[i].getL().equals(str)){
                B2[t]=B1[i];
                t++;
            }
            i++;
        }
    }

    public static void sortBill(ArrayList<Bill> A1,ArrayList<Bill> A2,int t1,int t2) {
        for (int i = 0; i < A1.size(); i++) {
            int a3 = Al.get(i).getTime();
            if (a3>= t1 && a3 <= t2) {  //
                Bill a = new Bill();
                a=Al.get(i);
                A2.add(a);
            }
        }
    }
    public static ArrayList < Bill > sortStyle(ArrayList < Bill > A1, String str){
        ArrayList < Bill > A2=new ArrayList<Bill>();
        for (int i = 0; i < A1.size(); i++) {
            if (Al.get(i).getL().equals(str)) {  //
                Bill a = new Bill();
                a=Al.get(i);
                A2.add(a);
            }
        }
        return A2;
    }

    public static void sortYear(ArrayList<Bill> A1,ArrayList<Bill> A2,int t1,int t2) {
        for (int i = 0; i < A1.size(); i++) {
            int a3 = Al.get(i).getTime();
            if (a3>= t1*100 && a3 <= t2*100+32) {  //
                Bill a = new Bill();
                a=Al.get(i);
                A2.add(a);
            }
        }
    }





    private void initEvent() {
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
    }

    private void showDialog(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.ic_ideas);
        builder.setTitle("提示");
        builder.setMessage("用户名或密码错误");
        builder.setPositiveButton("我知道了",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        AlertDialog dialog=builder.create();
        dialog.show();

    }
}

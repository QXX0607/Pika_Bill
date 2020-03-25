package com.example.xixi.pikabill;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class WelcomeActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        imageView = (ImageView) findViewById(R.id.img);

//        平移
        ObjectAnimator translationY = ObjectAnimator.ofFloat(imageView, "translationY", 0, 500f);
        ObjectAnimator alpha = ObjectAnimator.ofFloat(imageView, "alpha", 0f, 1f);
        ObjectAnimator rotation = ObjectAnimator.ofFloat(imageView, "rotation", 0f, 360f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(imageView, "scaleY", 2f, 1f);
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(imageView, "scaleX", 2f, 1f);

        AnimatorSet animSet = new AnimatorSet();
        animSet.playTogether(translationY, alpha, rotation, scaleY, scaleX);

        animSet.setDuration(3000);
        animSet.start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                finish();
            }
        }, 3000);
    }
}

/*
public class WelcomeActivity extends AppCompatActivity {
    private int time=3;

    final Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    time--;
                    Log.e("TAG",time+"");
                    if (time>0){
                        tv.setText(time+"s");
                        handler.sendMessageDelayed(handler.obtainMessage(1),1000);
                    }
//                    else {
//                        //启动页面
//                        startMainActivity();
//                    }
                    break;
            }
            super.handleMessage(msg);

        }
    };
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        tv= (TextView) findViewById(R.id.Welcome_tv);
        //每隔一秒发送消息
        handler.sendMessageDelayed(handler.obtainMessage(1), 1000);

        //延迟3秒后进入主界面
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //执行在主线程
                //启动页面
                startMainActivity();
            }
        },3000);

    }

    private void startMainActivity() {
        startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
        //关闭当前页面
        finish();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //点击快速进入主界面
        if (event.getAction()==MotionEvent.ACTION_DOWN){
            startMainActivity();
            return true;
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //移除消息
        handler.removeCallbacksAndMessages(null);
    }
}
*/
/*
public class WelcomeActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_welcome);

        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(intent);
                WelcomeActivity.this.finish();
            }
        }, 3000);
    }
}
*/

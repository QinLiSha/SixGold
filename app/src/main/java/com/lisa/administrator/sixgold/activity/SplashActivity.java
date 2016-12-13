package com.lisa.administrator.sixgold.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lisa.administrator.sixgold.R;
import com.lisa.administrator.sixgold.base.MyBaseActivity;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 闪屏页面
 */
public class SplashActivity extends MyBaseActivity {
    private ImageView iv_splash;
    private TextView tv_splash;
    private RelativeLayout relativeLayout;
    private static final String TAG = "SplashActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
//        init();
        //方法一：开启一个子线程执行跳转任务
//        new Thread(){
//            @Override
//            public void run() {
//                super.run();
//                try {
//                    Thread.sleep(2000);
//                    Intent intent = new Intent(SplashActivity.this,HomeActivity.class);
//                    startActivity(intent);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }.start();
        //方法二：使用Handler发送延迟消息
//        new Handler(new Handler.Callback() {
//            @Override
//            public boolean handleMessage(Message msg) {
//                Intent intent = new Intent(SplashActivity.this,HomeActivity.class);
//                startActivity(intent);
//                return false;
//            }
//        }).sendEmptyMessageDelayed(0,2000);
        //方法三：使用Java计时器
        Timer timer = new Timer();
        timer.schedule(new MyTask(), 3000);//定时器延时执行任务的方法
    }

    //方法三：使用Java计时器
    class MyTask extends TimerTask {
        @Override
        public void run() {
            Intent intent = new Intent(SplashActivity.this, GuidePageActivity.class);
            startActivity(intent);
        }
    }

    /**
     * 增加补间动画，从透明到渐渐清晰，不过没有引用
     */
    private void init() {
        iv_splash = (ImageView) findViewById(R.id.iv_splash);
        tv_splash = (TextView) findViewById(R.id.tv_splash);
        AlphaAnimation alp = new AlphaAnimation(0, 1);
        alp.setDuration(2000);
        alp.setFillAfter(true);//????????
        iv_splash.setAnimation(alp);
        tv_splash.setAnimation(alp);
        alp.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                openActivity(GuidePageActivity.class);
                finish();
            }
        });
    }
}

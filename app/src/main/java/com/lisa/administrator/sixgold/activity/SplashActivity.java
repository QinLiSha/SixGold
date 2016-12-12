package com.lisa.administrator.sixgold.activity;

import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import com.lisa.administrator.sixgold.R;
import com.lisa.administrator.sixgold.base.MyBaseActivity;

/**
 * 闪屏页面
 */
public class SplashActivity extends MyBaseActivity {
    private ImageView iv_splash;
    private TextView tv_splash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
init();
    }

    private void init() {
        iv_splash = (ImageView) findViewById(R.id.iv_splash);
        tv_splash = (TextView)findViewById(R.id.tv_splash);
        AlphaAnimation alp = new AlphaAnimation(0, 1);
        alp.setDuration(1500);
        iv_splash.setAnimation(alp);
        tv_splash.setAnimation(alp);
        alp.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {  }
            @Override
            public void onAnimationRepeat(Animation animation) {   }
            @Override
            public void onAnimationEnd(Animation animation) {
                openActivity(GuidePageActivity.class);
                finish();
            }
        });
    }
}

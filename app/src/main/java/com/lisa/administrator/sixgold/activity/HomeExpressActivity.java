package com.lisa.administrator.sixgold.activity;

import android.os.Bundle;

import com.lisa.administrator.sixgold.R;
import com.lisa.administrator.sixgold.base.MyBaseActivity;

/**
 * 从主页面跳转到的发快递的页面
 */
public class HomeExpressActivity extends MyBaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_express);
        initActionBarOneImg(R.drawable.ic_chevron_left_grey_24dp, "快递", "收费详情", null);
    }

}

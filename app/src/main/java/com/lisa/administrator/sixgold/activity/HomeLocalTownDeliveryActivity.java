package com.lisa.administrator.sixgold.activity;

import android.os.Bundle;

import com.lisa.administrator.sixgold.R;
import com.lisa.administrator.sixgold.base.MyBaseActivity;

/**
 * 从主页面跳转到同城，跑腿，货运的页面
 */
public class HomeLocalTownDeliveryActivity extends MyBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_local_town_delivery);
        initActionBarOneImg(R.drawable.ic_chevron_left_grey_24dp, "同城配送", "收费详情", null);

    }

}

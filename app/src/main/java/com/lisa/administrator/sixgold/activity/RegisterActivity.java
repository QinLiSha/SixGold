package com.lisa.administrator.sixgold.activity;

import android.os.Bundle;

import com.lisa.administrator.sixgold.R;
import com.lisa.administrator.sixgold.base.MyBaseActivity;

/**
 * 注册界面
 */

public class RegisterActivity extends MyBaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initActionBarTwoImg(R.drawable.ic_chevron_left_grey_24dp, "注册", -1, null);
    }

}

package com.lisa.administrator.sixgold.activity.address;

import android.os.Bundle;

import com.lisa.administrator.sixgold.R;
import com.lisa.administrator.sixgold.base.MyBaseActivity;

/**
 * 选择区域
 */
public class ChooseDistrictActivity extends MyBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_district);
        initActionBarTwoImg(R.drawable.ic_chevron_left_grey_24dp, "选择区", -1, null);
    }
}

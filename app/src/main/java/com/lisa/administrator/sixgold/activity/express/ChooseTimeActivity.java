package com.lisa.administrator.sixgold.activity.express;

import android.os.Bundle;

import com.lisa.administrator.sixgold.R;
import com.lisa.administrator.sixgold.base.MyBaseActivity;

public class ChooseTimeActivity extends MyBaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_time);
        initActionBarTwoImg(R.drawable.ic_chevron_left_grey_24dp, "选择时间", -1, null);
    }
}

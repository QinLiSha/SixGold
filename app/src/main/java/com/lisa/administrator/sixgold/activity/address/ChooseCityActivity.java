package com.lisa.administrator.sixgold.activity.address;

import android.os.Bundle;

import com.lisa.administrator.sixgold.R;
import com.lisa.administrator.sixgold.base.MyBaseActivity;

/**
 * 选择市
 */
public class ChooseCityActivity extends MyBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_city);
        initActionBarTwoImg(R.drawable.ic_chevron_left_grey_24dp,"选择市",-1,null);
    }
}

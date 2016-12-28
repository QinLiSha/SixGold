package com.lisa.administrator.sixgold.activity.express;

import android.os.Bundle;

import com.lisa.administrator.sixgold.R;
import com.lisa.administrator.sixgold.base.MyBaseActivity;

public class DetailsForChargesActivity extends MyBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_for_charges);
        initActionBarTwoImg(R.drawable.ic_chevron_left_grey_24dp, "快递收费详情", -1, null);
    }
}

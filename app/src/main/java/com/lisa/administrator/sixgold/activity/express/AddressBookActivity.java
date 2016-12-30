package com.lisa.administrator.sixgold.activity.express;

import android.os.Bundle;

import com.lisa.administrator.sixgold.R;
import com.lisa.administrator.sixgold.base.MyBaseActivity;

public class AddressBookActivity extends MyBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_book);
        initActionBarOneImg(R.drawable.ic_chevron_left_grey_24dp, "添加地址", "地址簿", null);
    }
}

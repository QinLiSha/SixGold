package com.lisa.administrator.sixgold.fragment.myorder;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lisa.administrator.sixgold.R;

/**
 * 我的订单
 */
public class HistoryOrderFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_historyorder, container, false);
        return view;
    }
}

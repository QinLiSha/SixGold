package com.lisa.administrator.sixgold.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lisa.administrator.sixgold.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class HomeFragment extends Fragment {
    private Unbinder binder;

    @BindView(R.id.iv_homefragment_express)
    ImageView ivHomefragmentExpress;
    @BindView(R.id.iv_homefragment_local_town_delivery)
    ImageView ivHomefragmentLocalTownDelivery;
    @BindView(R.id.iv_homefragment_online_store)
    ImageView ivHomefragmentOnlineStore;
    @BindView(R.id.iv_homefragment_long_distance_freight)
    ImageView ivHomefragmentLongDistanceFreight;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        binder = ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binder.unbind();
    }

    @OnClick({R.id.iv_homefragment_express, R.id.iv_homefragment_local_town_delivery, R.id.iv_homefragment_online_store, R.id.iv_homefragment_long_distance_freight})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_homefragment_express:
                break;
            case R.id.iv_homefragment_local_town_delivery:
                break;
            case R.id.iv_homefragment_online_store:
//                Toast.makeText().show();
                break;
            case R.id.iv_homefragment_long_distance_freight:
                break;
        }
    }
}

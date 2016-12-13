package com.lisa.administrator.sixgold.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.lisa.administrator.sixgold.R;
import com.lisa.administrator.sixgold.activity.HomeActivity;
import com.lisa.administrator.sixgold.activity.HomeExpressActivity;
import com.lisa.administrator.sixgold.activity.HomeLocalTownDeliveryActivity;
import com.lisa.administrator.sixgold.activity.HomeLongDistanceFreightActivity;
import com.lisa.administrator.sixgold.adapter.MyPagerAdapter;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * create by Lisa in2016/12/13
 */
public class HomeFragment extends Fragment implements ViewPager.OnPageChangeListener, View.OnTouchListener {
    public static final int VIEW_PAGER_DELAY = 2000;
    private MyPagerAdapter mAdapter;
    private List<ImageView> mItems;
    private ImageView[] mBottomImages;
    //    private LinearLayout mBottomLiner;
    private int currentViewPagerItem;

    private boolean isAutoPlay;    //是否自动播放
    private boolean isHomeFragment;//是不是Fragment


    private MyHandler mHandler;
    private Thread mThread;
    private Unbinder binder;
    @BindView(R.id.iv_homefragment_express)
    ImageView ivHomefragmentExpress;
    @BindView(R.id.iv_homefragment_local_town_delivery)
    ImageView ivHomefragmentLocalTownDelivery;
    @BindView(R.id.iv_homefragment_online_store)
    ImageView ivHomefragmentOnlineStore;
    @BindView(R.id.iv_homefragment_long_distance_freight)
    ImageView ivHomefragmentLongDistanceFreight;
    @BindView(R.id.live_view_pager)
    ViewPager mViewPager;
    @BindView(R.id.live_indicator)
    LinearLayout mBottomLiner;////获取指示器(下面三个小点)

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        binder = ButterKnife.bind(this, view);
        init();
        return view;
    }


    /**
     * 初始化
     */
    private void init() {
        mHandler = new MyHandler(this);
        //配置轮播图ViewPager
        mItems = new ArrayList<>();
        mAdapter = new MyPagerAdapter(mItems, getContext());
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOnTouchListener(this);
        mViewPager.addOnPageChangeListener(this);
        isAutoPlay = true;
        isHomeFragment = true;
        //TODO: 添加ImageView
        addImageView();
        mAdapter.notifyDataSetChanged();
        //设置底部几个小点
        setBottomIndicator();
    }


    /**
     * 添加轮播图图片
     */
    private void addImageView() {
        ImageView view0 = new ImageView(getContext());
        view0.setImageResource(R.mipmap.pic0);
        ImageView view1 = new ImageView(getContext());
        view1.setImageResource(R.mipmap.pic1);
        ImageView view2 = new ImageView(getContext());
        view2.setImageResource(R.mipmap.pic2);

        view0.setScaleType(ImageView.ScaleType.CENTER_CROP);
        view1.setScaleType(ImageView.ScaleType.CENTER_CROP);
        view2.setScaleType(ImageView.ScaleType.CENTER_CROP);

        mItems.add(view0);
        mItems.add(view1);
        mItems.add(view2);

    }

    /**
     * 添加小圆点，及设置小圆点的状态
     */
    private void setBottomIndicator() {
        //右下方小圆点
        mBottomImages = new ImageView[mItems.size()];
        for (int i = 0; i < mBottomImages.length; i++) {
            ImageView imageView = new ImageView(getContext());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(20, 20);
            params.setMargins(5, 0, 5, 0);
            imageView.setLayoutParams(params);
            //如果当前是第一个 设置为选中状态
            if (i == 0) {
                imageView.setImageResource(R.drawable.indicator_select);
            } else {
                imageView.setImageResource(R.drawable.indicator_no_select);
            }
            mBottomImages[i] = imageView;
            //添加到父容器
            mBottomLiner.addView(imageView);
        }

        //让其在最大值的中间开始滑动, 一定要在 mBottomImages初始化之前完成
        int mid = MyPagerAdapter.MAX_SCROLL_VALUE / 2;
        mViewPager.setCurrentItem(mid);
        currentViewPagerItem = mid;

        //定时发送消息
        mThread = new Thread() {
            @Override
            public void run() {
                super.run();
                while (isHomeFragment) {//只有在页面是honeFragment时，才发送消息
                    mHandler.sendEmptyMessage(0);
                    try {
                        Thread.sleep(HomeFragment.VIEW_PAGER_DELAY);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };
        mThread.start();
    }

    ///////////////////////////////////////////////////////////////////////////
    // ViewPager的监听事件
    ///////////////////////////////////////////////////////////////////////////
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {

        currentViewPagerItem = position;
        if (mItems != null) {
            position %= mBottomImages.length;
            int total = mBottomImages.length;

            for (int i = 0; i < total; i++) {
                if (i == position) {
                    mBottomImages[i].setImageResource(R.drawable.indicator_select);
                } else {
                    mBottomImages[i].setImageResource(R.drawable.indicator_no_select);
                }
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                isAutoPlay = false;
                break;
            case MotionEvent.ACTION_UP:
                isAutoPlay = true;
                break;
        }
        return false;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binder.unbind();
        isAutoPlay = false;//刚开始没有在这里加上这句话，然后跳转到其他的fragment时，空指针
        // homeFragment.mViewPager.setCurrentItem(++homeFragment.currentViewPagerItem);报空指针的错误；
        isHomeFragment = false;
    }

    @OnClick({R.id.iv_homefragment_express, R.id.iv_homefragment_local_town_delivery, R.id.iv_homefragment_online_store, R.id.iv_homefragment_long_distance_freight})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_homefragment_express:
                ((HomeActivity) getActivity()).openActivity(HomeExpressActivity.class);
                break;
            case R.id.iv_homefragment_local_town_delivery:
                ((HomeActivity) getActivity()).openActivity(HomeLocalTownDeliveryActivity.class);
                break;
            case R.id.iv_homefragment_online_store:
                ((HomeActivity) getActivity()).showToast("商城正在紧急开发中，请期待。。。");
                break;
            case R.id.iv_homefragment_long_distance_freight:
                ((HomeActivity)getActivity()).openActivity(HomeLongDistanceFreightActivity.class);
                break;
        }
    }

    private static class MyHandler extends Handler {
        private WeakReference<HomeFragment> mWeakReference;

        public MyHandler(HomeFragment homeFragment) {
            mWeakReference = new WeakReference<HomeFragment>(homeFragment);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    HomeFragment homeFragment = mWeakReference.get();
                    if (homeFragment.isAutoPlay) {
                        homeFragment.mViewPager.setCurrentItem(++homeFragment.currentViewPagerItem);
                    }
                    break;
            }
        }
    }
}

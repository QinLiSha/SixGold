package com.lisa.administrator.sixgold.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lisa.administrator.sixgold.R;
import com.lisa.administrator.sixgold.base.MyBaseActivity;
import com.lisa.administrator.sixgold.fragment.myorder.HistoryOrderFragment;
import com.lisa.administrator.sixgold.fragment.myorder.NewestFragment;
import com.lisa.administrator.sixgold.fragment.myorder.OrderingFragment;
import com.lisa.administrator.sixgold.fragment.myorder.TosureFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.lisa.administrator.sixgold.R.color.defaultTextViewColor;
import static com.lisa.administrator.sixgold.R.color.themeBlue;

public class MyOrderActivity extends MyBaseActivity {

    @BindView(R.id.tv_newest)
    TextView tvNewest;
    @BindView(R.id.view_newest)
    View viewNewest;
    @BindView(R.id.rl_newest)
    RelativeLayout rlNewest;
    @BindView(R.id.tv_ing)
    TextView tvIng;
    @BindView(R.id.view_ing)
    View viewIng;
    @BindView(R.id.rl_ing)
    RelativeLayout rlIng;
    @BindView(R.id.tv_toSure)
    TextView tvToSure;
    @BindView(R.id.view_toSure)
    View viewToSure;
    @BindView(R.id.rl_tosure)
    RelativeLayout rlTosure;
    @BindView(R.id.tv_historyOrder)
    TextView tvHistoryOrder;
    @BindView(R.id.view_history)
    View viewHistory;
    @BindView(R.id.rl_historyOrder)
    RelativeLayout rlHistoryOrder;
    @BindView(R.id.contianer)
    RelativeLayout contianer;
    @BindView(R.id.activity_my_order)
    LinearLayout activityMyOrder;
    private HistoryOrderFragment historyOrderFragment;
    private NewestFragment newestFragment;
    private OrderingFragment orderingFragment;
    private TosureFragment tosureFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);
        ButterKnife.bind(this);
        initActionBarTwoImg(R.drawable.ic_chevron_left_grey_24dp, "我的订单", -1, onClickListener);
        loadNewestFragment();

    }

    /**
     * 点击返回到主页面
     */
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            openActivity(HomeActivity.class);
            finish();
        }
    };

    /**
     * 加载最新订单的fragment
     */
    private void loadNewestFragment() {
        newestFragment = new NewestFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.contianer, newestFragment).commit();
    }

    /**
     * 点击替换成最新订单的fragment
     */
    @OnClick({R.id.tv_newest, R.id.view_newest, R.id.rl_newest})
    protected void showNewestFragment() {
        if (newestFragment == null) {
            newestFragment = new NewestFragment();
        }
        setDefaultColorAndView();
        tvNewest.setTextColor(getPressTextColor());
        viewNewest.setVisibility(View.VISIBLE);
        getSupportFragmentManager().beginTransaction().replace(R.id.contianer, newestFragment).commit();
    }

    /**
     * 点击替换成进行中订单的fragment
     */
    @OnClick({R.id.tv_ing, R.id.view_ing, R.id.rl_ing})
    protected void showOrderingFragment() {
        if (orderingFragment == null) {
            orderingFragment = new OrderingFragment();
        }
        setDefaultColorAndView();
        tvIng.setTextColor(getPressTextColor());
        viewIng.setVisibility(View.VISIBLE);
        getSupportFragmentManager().beginTransaction().replace(R.id.contianer, orderingFragment).commit();
    }

    /**
     * 点击替换成待确认订单的fragment
     */
    @OnClick({R.id.tv_toSure, R.id.view_toSure, R.id.rl_tosure})
    protected void showToSureFragment() {
        if (tosureFragment == null) {
            tosureFragment = new TosureFragment();
        }
        setDefaultColorAndView();
        tvToSure.setTextColor(getPressTextColor());
        viewToSure.setVisibility(View.VISIBLE);
        getSupportFragmentManager().beginTransaction().replace(R.id.contianer, tosureFragment).commit();
    }

    /**
     * 点击替换成历史订单的fragment
     */
    @OnClick({R.id.tv_historyOrder, R.id.view_history, R.id.rl_historyOrder})
    protected void showHistoryOrderFragment() {
        if (historyOrderFragment == null) {
            historyOrderFragment = new HistoryOrderFragment();
        }
        setDefaultColorAndView();
        tvHistoryOrder.setTextColor(getPressTextColor());
        viewHistory.setVisibility(View.VISIBLE);
        getSupportFragmentManager().beginTransaction().replace(R.id.contianer, historyOrderFragment).commit();
    }

    private void setDefaultColorAndView() {
        tvHistoryOrder.setTextColor(getDefaultCorlor());
        tvIng.setTextColor(getDefaultCorlor());
        tvNewest.setTextColor(getDefaultCorlor());
        tvToSure.setTextColor(getDefaultCorlor());
        viewHistory.setVisibility(View.INVISIBLE);
        viewIng.setVisibility(View.INVISIBLE);
        viewNewest.setVisibility(View.INVISIBLE);
        viewToSure.setVisibility(View.INVISIBLE);
    }


    private int getPressTextColor() {
        return getResources().getColor(themeBlue);
    }

    private int getDefaultCorlor() {
        return getResources().getColor(defaultTextViewColor);
    }
//    @OnClick({R.id.tv_newest, R.id.view_newest, R.id.rl_newest, R.id.tv_ing, R.id.view_ing, R.id.rl_ing, R.id.tv_toSure, R.id.view_toSure, R.id.rl_tosure, R.id.tv_historyOrder, R.id.view_history, R.id.rl_historyOrder, R.id.contianer, R.id.activity_my_order})
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.tv_newest:
//                break;
//            case R.id.view_newest:
//                break;
//            case R.id.rl_newest:
//                break;
//            case R.id.tv_ing:
//                break;
//            case R.id.view_ing:
//                break;
//            case R.id.rl_ing:
//                break;
//            case R.id.tv_toSure:
//                break;
//            case R.id.view_toSure:
//                break;
//            case R.id.rl_tosure:
//                break;
//            case R.id.tv_historyOrder:
//                break;
//            case R.id.view_history:
//                break;
//            case R.id.rl_historyOrder:
//                break;
//            case R.id.contianer:
//                break;
//            case R.id.activity_my_order:
//                break;
//        }
//    }
}

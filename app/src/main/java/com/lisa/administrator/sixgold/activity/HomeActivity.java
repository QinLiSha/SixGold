package com.lisa.administrator.sixgold.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lisa.administrator.sixgold.R;
import com.lisa.administrator.sixgold.activity.express.ChooseTimeActivity;
import com.lisa.administrator.sixgold.base.MyBaseActivity;
import com.lisa.administrator.sixgold.fragment.HomeFragment;
import com.lisa.administrator.sixgold.fragment.MineFragment;
import com.lisa.administrator.sixgold.fragment.NearbyFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.lisa.administrator.sixgold.R.color.lightgray;
import static com.lisa.administrator.sixgold.R.color.themeBlue;
import static com.lisa.administrator.sixgold.R.id.tv_home_title;

/**
 * 主页面
 */
public class HomeActivity extends MyBaseActivity {
    @BindView(R.id.iv_home_left)
    ImageView ivHomeLeft;
    @BindView(tv_home_title)
    TextView tvHomeTitle;
    @BindView(R.id.iv_home_right)
    ImageView ivHomeRight;
    @BindView(R.id.contianer)
    RelativeLayout contianer;
    @BindView(R.id.iv_home_homepage)
    ImageView ivHomeHomepage;
    @BindView(R.id.tv_home_homepage)
    TextView tvHomeHomepage;
    @BindView(R.id.ll_home_homepage)
    LinearLayout llHomeHomepage;
    @BindView(R.id.iv_home_individual_order)
    ImageView ivHomeIndividualOrder;
    @BindView(R.id.tv_home_individual_order)
    TextView tvHomeIndividualOrder;
    @BindView(R.id.ll_home_individual_order)
    LinearLayout llHomeIndividualOrder;
    @BindView(R.id.iv_home_nearby)
    ImageView ivHomeNearby;
    @BindView(R.id.tv_home_nearby)
    TextView tvHomeNearby;
    @BindView(R.id.ll_home_nearby)
    LinearLayout llHomeNearby;
    @BindView(R.id.iv_home_I)
    ImageView ivHomeI;
    @BindView(R.id.tv_home_I)
    TextView tvHomeI;
    @BindView(R.id.ll_home_I)
    LinearLayout llHomeI;
    @BindView(R.id.ll_home_bottom_item)
    LinearLayout llHomeBottomItem;
    @BindView(R.id.activity_home)
    LinearLayout activityHome;
    private HomeFragment homeFragment;
    private MineFragment mineFragment;
    private NearbyFragment nearbyFragment;
    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        unbinder = ButterKnife.bind(this);
        loadHomeFragment();
    }

    /**
     * 加载主界面的方法
     */
    private void loadHomeFragment() {
        homeFragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.contianer, homeFragment).commit();
        ivHomeRight.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    /**
     * 显示主页的fragment的点击事件
     */
    @OnClick({R.id.ll_home_homepage, R.id.iv_home_homepage, R.id.tv_home_homepage})
    public void showHomeFragment() {
        setTitle("鑫鑫快运");
        if (homeFragment == null) {
            homeFragment = new HomeFragment();
        }
        setDefaultColor();
        ivHomeRight.setVisibility(View.VISIBLE);
        tvHomeHomepage.setTextColor(getPressTextColor());
        ivHomeHomepage.setImageResource(R.drawable.ic_person_outline_blue_24dp);
        getSupportFragmentManager().beginTransaction().replace(R.id.contianer, homeFragment)
                .commit();
    }

    /**
     * 显示个人订单的页面的点击事件
     */
    @OnClick({R.id.ll_home_individual_order, R.id.iv_home_individual_order, R.id.tv_home_individual_order})
    public void showorder() {
        openActivity(MyOrderActivity.class);
        finish();
    }
//TODO.....................个人订单

    /**
     * 显示附近的fragment的点击事件
     */
    @OnClick({R.id.ll_home_nearby, R.id.iv_home_nearby, R.id.tv_home_nearby})
    public void showNearbyFragment() {
        setTitle("附近");
        if (nearbyFragment == null) {
            nearbyFragment = new NearbyFragment();
        }
        ivHomeRight.setVisibility(View.INVISIBLE);
        setDefaultColor();
        tvHomeNearby.setTextColor(getPressTextColor());
        ivHomeNearby.setImageResource(R.drawable.ic_person_outline_blue_24dp);
        getSupportFragmentManager().beginTransaction().replace(R.id.contianer, nearbyFragment)
                .commit();
    }

    /**
     * 显示我的fragment的点击事件
     */
    @OnClick({R.id.ll_home_I, R.id.iv_home_I, R.id.tv_home_I})
    // TODO: 2016/12/27 如果没有登录需要跳转到登录界面

    public void show() {
        openActivity(LoginActivity.class);
        openActivity(ChooseTimeActivity.class);
        finish();
    }

    //    public void showMineFragment() {
//        setTitle("个人中心");
//        if (mineFragment == null) {
//            mineFragment = new MineFragment();
//        }
//                ivHomeRight.setVisibility(View.INVISIBLE);
//    setDefaultColor();
//        tvHomeI.setTextColor(getPressTextColor());
//        ivHomeI.setImageResource(R.drawable.ic_person_outline_blue_24dp);
//        getSupportFragmentManager().beginTransaction().replace(R.id.contianer, mineFragment)
//                .commit();
//    }

    /**
     * 设置标题栏中显示的内容
     * @param name
     */
    public void setTitle(String name) {
        tvHomeTitle.setText(name);
    }

    private void setDefaultColor() {
        tvHomeHomepage.setTextColor(getDefaultCorlor());
        tvHomeI.setTextColor(getDefaultCorlor());
        tvHomeNearby.setTextColor(getDefaultCorlor());
        ivHomeHomepage.setImageResource(R.drawable.ic_person_outline_black_24dp);
        ivHomeI.setImageResource(R.drawable.ic_person_outline_black_24dp);
        ivHomeNearby.setImageResource(R.drawable.ic_person_outline_black_24dp);
    }

    private int getPressTextColor() {
        return getResources().getColor(themeBlue);
    }

    private int getDefaultCorlor() {
        return getResources().getColor(lightgray);
    }


}

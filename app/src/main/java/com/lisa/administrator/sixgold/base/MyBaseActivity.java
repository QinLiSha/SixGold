package com.lisa.administrator.sixgold.base;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lisa.administrator.sixgold.R;
import com.lisa.administrator.sixgold.view.ActionBarOneImg;
import com.lisa.administrator.sixgold.view.ActionBarTwoImg;
import com.zhy.autolayout.AutoLayoutActivity;

import butterknife.Unbinder;

/**
 * Created by One Of A Kind Lisa on 2016/12/10
 */

public class MyBaseActivity<T> extends AutoLayoutActivity {
    private static final String TAG = "MyBaseActivity";
    private Toast toast;
    private static int screenW, screenH;
    private Dialog dialog;
    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        unbinder = ButterKnife.bind(this);
        screenW = getWindowManager().getDefaultDisplay().getWidth();
        screenH = getWindowManager().getDefaultDisplay().getWidth();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        unbinder.unbind();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    /**
     * =========================
     * 公共功能的封装
     * =========================
     */
    public void showToast(String msg) {
        if (toast == null)
            toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setText(msg);
        toast.show();

    }

    public void openActivity(Class<?> pClass) {
        openActivity(pClass, null, null);
    }

    public void openActivity(Class<?> pClass, Bundle bundle) {
        openActivity(pClass, bundle, null);
    }

    public void openActivity(Class<?> pClass, Bundle bundle, Uri uri) {
        Intent intent = new Intent(this, pClass);
        if (bundle != null)
            intent.putExtras(bundle);
        if (uri != null)
            intent.setData(uri);
        startActivity(intent);
        //增加动画
//        overridePendingTransition(R.anim.anim_activity_bottom_in, R.anim.anim_activity_botton_out);
//        overridePendingTransition(R.anim.anim_activity_right_in, R.anim.anim_activity_right_out);
    }

    public void showLoadingDialog(Context context, String msg, boolean cancel) {
        View view = LayoutInflater.from(context).inflate(R.layout.loading_dialog, null);//加载一个自定义的布局
        LinearLayout layout = (LinearLayout) view.findViewById(R.id.ll_dialog_view);
        ImageView iv = (ImageView) view.findViewById(R.id.iv_loading_img);
        TextView tv = (TextView) view.findViewById(R.id.tv_loading_msg);
        Animation roatAnim = AnimationUtils.loadAnimation(context, R.anim.loading_animation);//设置一个动画
        iv.setAnimation(roatAnim);
        if (null != msg) {
            tv.setText(msg);
        }
        dialog = new Dialog(context, R.style.loading_dialog);//设置dialog的样式
        dialog.setContentView(layout, new LinearLayout.LayoutParams(ViewGroup.LayoutParams
                .MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        dialog.show();
    }

    /**
     * 有2个ImageView的ActionBar
     *
     * @param leftId
     * @param title
     * @param rightId
     * @param onClickListener
     */
    public void initActionBarTwoImg(int leftId, String title, int rightId, View.OnClickListener onClickListener) {
        ActionBarTwoImg actionBarTwoImg = (ActionBarTwoImg) findViewById(R.id.actionbarView_twoImg);
        actionBarTwoImg.initActionBarTwoImg(leftId, title, rightId, onClickListener);//调用ActionBarTwoImg里面的initActionBarTwoImg方法
//        ActionBarViewOneImg actionBarViewOneImg = findViewById(R.id.action)
//        imageview_left_twoImg = (ImageView) findViewById(R.id.iv_left_actionbar_two_img);
//        imageview_right_twoImg = (ImageView) findViewById(R.id.iv_right_actionbar_two_img);
//        textview_title_twoImg = (TextView) findViewById(R.id.tv_title_actionbar_two_img);
//
//        if (leftId == -1) {
//            imageview_left_twoImg.setVisibility(View.INVISIBLE);
//        } else {
//            imageview_left_twoImg.setVisibility(View.VISIBLE);
//            imageview_left_twoImg.setImageResource(leftId);
//        }
//        if (TextUtils.isEmpty(title)) {
//            textview_title_twoImg.setVisibility(View.INVISIBLE);
//        } else {
//            textview_title_twoImg.setVisibility(View.VISIBLE);
//            textview_title_twoImg.setText(title);
//        }
//        if (rightId == -1) {
//            imageview_right_twoImg.setVisibility(View.INVISIBLE);
//        } else {
//            imageview_right_twoImg.setVisibility(View.VISIBLE);
//            imageview_right_twoImg.setImageResource(rightId);
//        }
    }


    /**
     * 有一个ImageView和一个TextView的ActionBar
     *
     * @param leftId
     * @param title
     * @param rightString
     * @param onClickListener
     */
    public void initActionBarOneImg(int leftId, String title, String rightString, View.OnClickListener onClickListener) {
        ActionBarOneImg actionBarOneImg = (ActionBarOneImg) findViewById(R.id.actionbarView_oneImg);
        actionBarOneImg.initActionBarOneImg(leftId, title, rightString, onClickListener);//调用ActionBarOneImg里面的initActionBarOneImg方法
//        imageview_left_oneImg = (ImageView) findViewById(R.id.iv_left_actionbar_one_img);
//        textview_right_oneImg = (TextView) findViewById(R.id.tv_right_actionbar_one_img);
//        textview_title_oneImg = (TextView) findViewById(R.id.tv_title_actionbar_one_img);
//        //左边的Img
//        if (leftId == -1) {
//            imageview_left_oneImg.setVisibility(View.INVISIBLE);
//        } else {
//            imageview_left_oneImg.setVisibility(View.VISIBLE);
//            imageview_left_oneImg.setImageResource(leftId);
//        }
//        //中间的标题title
//        if (TextUtils.isEmpty(title)) {
//            textview_title_oneImg.setVisibility(View.INVISIBLE);
//        } else {
//            textview_title_oneImg.setVisibility(View.VISIBLE);
//            textview_title_oneImg.setText(title);
//        }
//        //右边的文字
//        if (TextUtils.isEmpty(rightString)) {
//            textview_right_oneImg.setVisibility(View.INVISIBLE);
//        } else {
//            textview_right_oneImg.setVisibility(View.VISIBLE);
//            textview_right_oneImg.setText(title);
//        }
    }
}

package com.lisa.administrator.sixgold.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lisa.administrator.sixgold.R;
import com.zhy.autolayout.AutoLinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *两边都是ImageView的ActionBar
 * Created by One Of A Kind Lisa on 2016/12/24
 */

public class ActionBarTwoImg extends AutoLinearLayout {
    @BindView(R.id.iv_left_two_img)
    ImageView ivLeftTwoImg;
    @BindView(R.id.tv_title_two_img)
    TextView tvTitleTwoImg;
    @BindView(R.id.iv_right_two_img)
    ImageView ivRightTwoImg;

    public ActionBarTwoImg(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.actionbar_img_and_img, this);
        ButterKnife.bind(this);
        // TODO: 2016/12/24 这里的ButterKnife没有解绑会不会有影响
    }

    public void initActionBarTwoImg(int leftImgId, String title, int rightImgId, View.OnClickListener onClickListener) {
        tvTitleTwoImg.setText(title);
        if (leftImgId != -1) {
            ivLeftTwoImg.setImageResource(leftImgId);
            ivLeftTwoImg.setOnClickListener(onClickListener);
        } else {
            ivLeftTwoImg.setVisibility(INVISIBLE);
        }
        if (rightImgId != -1) {
            ivRightTwoImg.setImageResource(leftImgId);
            ivRightTwoImg.setOnClickListener(onClickListener);
        } else {
            ivRightTwoImg.setVisibility(INVISIBLE);
        }
    }
}

package com.lisa.administrator.sixgold.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

import com.lisa.administrator.sixgold.R;
import com.zhy.autolayout.AutoLinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by One Of A Kind Lisa on 2016/12/24
 */

public class ActionBarOneImg extends AutoLinearLayout {

    @BindView(R.id.iv_left_one_img)
    ImageView ivLeftOneImg;
    @BindView(R.id.tv_title_one_img)
    TextView tvTitleOneImg;
    @BindView(R.id.tv_right_one_img)
    TextView tvRightOneImg;
    private Unbinder unbinder;

    public ActionBarOneImg(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.actionbar_img_and_text, this);
        unbinder = ButterKnife.bind(this);
    }

    public void initActionBarOneImg(int leftImgId, String title, String rightTile, OnClickListener onClickListener) {
        tvTitleOneImg.setText(title);
        tvRightOneImg.setText(rightTile);
        if (leftImgId != -1) {
            ivLeftOneImg.setImageResource(leftImgId);
            ivLeftOneImg.setOnClickListener(onClickListener);
        } else {
            ivLeftOneImg.setVisibility(INVISIBLE);
        }
    }
}

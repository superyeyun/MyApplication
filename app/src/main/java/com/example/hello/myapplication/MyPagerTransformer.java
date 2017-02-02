package com.example.hello.myapplication;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by Administrator on 2017/2/2.
 */

public class MyPagerTransformer implements ViewPager.PageTransformer{
    @Override
    public void transformPage(View page, float position) {
        //左边0~-90度,右边90~0度,
        //左边x 0~-width，右边x width~0；
        if(position < -1){

        }else if(position <= 1){//a页滑动至b页；a页从 0.0 ~ -1 ；b页从1 ~ 0.0
            //  [-1,1];
            if(position < 0){//滑动中左边页面
                page.setPivotX(page.getMeasuredWidth());
                page.setRotationY(position*90);
            }else {//滑动中右边页面
                page.setPivotX(0);
                page.setRotationY(position*90);
            }
        }else{

        }
    }
}

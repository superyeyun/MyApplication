package com.example.hello.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;

import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Transformer;

public class MainActivity extends AppCompatActivity {
    private ConvenientBanner convenientBanner;
    private List<Integer> imgs=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgs.add(R.mipmap.timg01);
        imgs.add(R.mipmap.timg02);
        imgs.add(R.mipmap.timg03);

        //找控件
        convenientBanner = (ConvenientBanner) findViewById(R.id.convenientBanner);
        convenientBanner.setPages(new CBViewHolderCreator() {
            @Override
            public Object createHolder() {
                return new LocalImageHolderView();
            }
        },imgs) //设置需要切换的View
                .setPointViewVisible(true)    //设置指示器是否可见
                //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
                .setPageIndicator(new int[]{R.mipmap.ic_page_indicator,R.mipmap.ic_page_indicator_focused})
                //设置指示器位置（左、中、右）
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                .startTurning(5000)     //设置自动切换（同时设置了切换时间间隔）
                .setManualPageable(true); //设置手动影响（设置了该项无法手动切换）

        //设置翻页的效果，不需要翻页效果可用不设


//       .setPageTransformer(Transformer.DefaultTransformer);
//        convenientBanner.setManualPageable(false);//设置不能手动影响

    }

    public class LocalImageHolderView implements Holder<Integer> {

        private ImageView imageView;
        @Override
        public View createView(Context context) {
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context, final int position, Integer data) {
            imageView.setImageResource(data);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //点击事件
                    Toast.makeText(view.getContext(),"点击了第"+(position+1)+"图片",Toast.LENGTH_SHORT).show();
                }
            });

            convenientBanner.setPageTransformer(new MyPagerTransformer());

        }

    }}


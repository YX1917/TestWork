package com.yx.testwork.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yx.testwork.Banner.BannerLayout;
import com.yx.testwork.R;

import java.util.ArrayList;
import java.util.List;

public class BannerActivity extends AppCompatActivity {
    private BannerLayout bannerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);
        initView();
    }

    private void initView() {
        bannerLayout = (BannerLayout) findViewById(R.id.banner);
        List<Integer> resIds = new ArrayList<>();
        // 模拟几张图片
        resIds.add(R.drawable.grid_alerm);
        resIds.add(R.drawable.grid_bed);
        resIds.add(R.drawable.grid_clinic);
        resIds.add(R.drawable.grid_leader);
        bannerLayout.setViewRes(resIds, null);

    }
}

package com.yx.testwork.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ScrollView;

import com.yx.testwork.R;

public class ListViewActivity extends AppCompatActivity {
    private String[] date = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    private ListView mListView;
    private ScrollView scrollView;

    //手指按下的点为(x1, y1)手指离开屏幕的点为(x2, y2)
    float x1 = 0;
    float x2 = 0;
    float y1 = 0;
    float y2 = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        initView();

    }


    private void initView() {
        scrollView = (ScrollView) findViewById(R.id.scrollView);
        mListView = (ListView) findViewById(R.id.listView);
        mListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, date));
        mListView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    //当手指按下的时候
                    x1 = event.getX();
                    y1 = event.getY();
                }
                if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    //当手指离开的时候
                    x2 = event.getX();
                    y2 = event.getY();
                    if (y1 > y2) {
                        Log.e("TAG", "向上滑动");
                        //判断向上滑动时，listView最后可见项是否为走后一项，如果是则scrollView拦截滑动事件
                        if (mListView.getLastVisiblePosition() == (mListView.getCount() - 1)) {
                            scrollView.requestDisallowInterceptTouchEvent(false);
                        } else {
                            scrollView.requestDisallowInterceptTouchEvent(true);
                        }
                    } else if (y1 < y2) {
                        Log.e("TAG", "向下滑动");
                        if (mListView.getFirstVisiblePosition() == 0) {
                            scrollView.requestDisallowInterceptTouchEvent(false);
                        } else {
                            scrollView.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }


                return false;
            }
        });

    }

}

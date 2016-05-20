package com.yx.testwork.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ScrollView;

import com.yx.testwork.R;

/**
 * 解决ScrollView嵌套ListView事件冲突问题
 */
public class MainActivity extends AppCompatActivity {
    private String[] date = {"1","2","3","4","5","6","7","8","9","10"};
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
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_listView:
                startActivity(new Intent(MainActivity.this,ListViewActivity.class));
                break;
            case R.id.item_banner:
                startActivity(new Intent(MainActivity.this,BannerActivity.class));
                break;

        }
        return super.onOptionsItemSelected(item);

    }


}

package com.cumulus.jcy.lrucache;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView mImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        /*
          使用三级缓存加载图片
        */
        CacheUtils utils = new CacheUtils();
        utils.diaplay(mImg,"http://ww1.sinaimg.cn/large/7a8aed7bjw1ezysj9ytj5j20f00m8wh0.jpg");

    }

    private void initView() {
        mImg = (ImageView) findViewById(R.id.img);
    }
}

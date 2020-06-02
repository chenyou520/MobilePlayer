package com.chenyou.mobileplayer.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.chenyou.mobileplayer.R;
import com.chenyou.mobileplayer.base.BasePager;
import com.chenyou.mobileplayer.pager.AudioPager;
import com.chenyou.mobileplayer.pager.NetAudioPager;
import com.chenyou.mobileplayer.pager.NetVideoPager;
import com.chenyou.mobileplayer.pager.ReplaceFragment;
import com.chenyou.mobileplayer.pager.VideoPager;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 主页面
 */
public class MainActivity extends FragmentActivity {

    @BindView(R.id.rg_main)
    RadioGroup rgMain;

    /**
     * 页面对应的位置
     */
    private int position;

    private ArrayList<BasePager> mBasePagers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initData();

        rgMain.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
        rgMain.check(R.id.rb_video);
    }

    private void initData() {
        mBasePagers = new ArrayList<BasePager>();
        mBasePagers.add(new VideoPager(this));//本地视频
        mBasePagers.add(new AudioPager(this));//本地音乐
        mBasePagers.add(new NetVideoPager(this));//网络视频
        mBasePagers.add(new NetAudioPager(this));//网络音乐
    }

    class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                default://本地视频
                    position = 0;
                    break;
                case R.id.rb_audio://本地音乐
                    position = 1;
                    break;
                case R.id.rb_net_video://网络视频
                    position = 2;
                    break;
                case R.id.rb_net_audio://网络音乐
                    position = 3;
                    break;
            }
            setFragment();
        }
    }

    private void setFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();//开启事务
        ft.replace(R.id.fl_main, new ReplaceFragment(getBasePager()));
        ft.commit();
    }

    private BasePager getBasePager() {
        BasePager basePager = mBasePagers.get(position);
        if (basePager != null && basePager.isInitData) {
            basePager.isInitData = true;
            basePager.initData();
        }
        return basePager;
    }

    private long startTime;

    @Override
    public void onBackPressed() {
        if (position != 0) {
            rgMain.check(R.id.rb_video);
            return;
        }
        if (System.currentTimeMillis() - startTime > 2000) {
            startTime=System.currentTimeMillis();
            Toast.makeText(MainActivity.this, "再点一次退出", Toast.LENGTH_SHORT).show();
            return;
        }
        super.onBackPressed();
    }
}

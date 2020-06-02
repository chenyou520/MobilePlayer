package com.chenyou.mobileplayer.pager;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
/**
 * 本地音乐
 */
import com.chenyou.mobileplayer.base.BasePager;

public class AudioPager extends BasePager {
    public AudioPager(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        TextView textView = new TextView(mContext);
        textView.setText("本地音乐");
        return textView;
    }
}

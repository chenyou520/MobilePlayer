package com.chenyou.mobileplayer.pager;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

/**
 * 网络音乐
 */
import com.chenyou.mobileplayer.base.BasePager;

public class NetAudioPager extends BasePager {
    public NetAudioPager(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        TextView textView = new TextView(mContext);
        textView.setText("网络音乐");
        return textView;
    }
}

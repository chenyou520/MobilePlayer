package com.chenyou.mobileplayer.pager;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

/**
 * 网络视频
 */
import com.chenyou.mobileplayer.base.BasePager;

public class NetVideoPager extends BasePager {
    public NetVideoPager(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        TextView textView = new TextView(mContext);
        textView.setText("网络视频");
        return textView;
    }
}

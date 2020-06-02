package com.chenyou.mobileplayer.pager;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

/**
 * 本地视频
 */
import com.chenyou.mobileplayer.base.BasePager;

public class VideoPager extends BasePager {
    public VideoPager(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        TextView textView = new TextView(mContext);
        textView.setText("本地视频");
        return textView;
    }
}

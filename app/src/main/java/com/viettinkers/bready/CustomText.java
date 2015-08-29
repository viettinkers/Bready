package com.viettinkers.bready;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Anh on 8/29/2015.
 */
public class CustomText extends TextView {
    public CustomText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onFinishInflate() {
        //this.setText("Hello");
        super.onFinishInflate();
    }
}

package com.viettinkers.bready;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Step view.
 */
public class StepView extends LinearLayout {
    private TextView mStartTimeText;
    private TextView mEndTimeText;
    private TextView mNameText;
    private TextView mTimeLeftText;
    private Step mStepModel;

    public StepView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onFinishInflate() {
        mStartTimeText = (TextView) findViewById(R.id.start_time);
        mEndTimeText = (TextView) findViewById(R.id.end_time);
        mNameText = (TextView) findViewById(R.id.step_name);
        mTimeLeftText = (TextView) findViewById(R.id.time_left);
        super.onFinishInflate();
    }

    public void bindModel(Step stepModel) {
        mStepModel = stepModel;
        mNameText.setText(mStepModel.getTitle());
        //updateTimeTexts();
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public void updateTimeTexts() {
        mStartTimeText.setText(mStepModel.getStartTime());
        mEndTimeText.setText(mStepModel.getEndTime());
        mTimeLeftText.setText(mStepModel.getTimeLeft());
    }
}

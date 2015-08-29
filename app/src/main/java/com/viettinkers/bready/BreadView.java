package com.viettinkers.bready;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.List;

/**
 * Main bread view.
 */
public class BreadView extends LinearLayout implements Step.StepListener {
    private BreadModel mModel;
    private Context mContext;

    private LinearLayout mStepsContainer;
    private View mStartButton;
    private View mInformDone;

    public BreadView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    @Override
    public void onFinishInflate() {
        mStepsContainer = (LinearLayout) findViewById(R.id.steps_container);
        mInformDone = findViewById(R.id.inform_done);
        mStartButton = findViewById(R.id.start_button);
        mStartButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startMakingBread();
            }
        });
        super.onFinishInflate();
    }

    public void bindModel(List<Step> steps) {
        mModel = new BreadModel(this, steps);
        for (Step step : mModel.getSteps()) {
            StepView stepView = (StepView) inflate(mContext, R.layout.bake_step, this);
            stepView.bindModel(step);
        }
    }

    public void startMakingBread() {
        mStartButton.setVisibility(GONE);
        mStepsContainer.setVisibility(VISIBLE);
        mInformDone.setVisibility(VISIBLE);
    }

    public void onTick() {

    }

    @Override
    public void stepDone() {

    }
}

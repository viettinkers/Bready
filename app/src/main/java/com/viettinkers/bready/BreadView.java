package com.viettinkers.bready;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import java.util.List;

/**
 * Main bread view.
 */
public class BreadView extends LinearLayout implements Step.StepListener {
    private BreadModel mModel;
    private LayoutInflater mLayoutInflater;
    private LinearLayout mStepsContainer;
    private View mStartButton;
    private View mInformDone;

    public BreadView(Context context, LayoutInflater layoutInflater) {
        super(context, null);
        mLayoutInflater = layoutInflater;
        init();
    }

    public void init() {
        inflate(getContext(), R.layout.bread, this);
        mStepsContainer = (LinearLayout) findViewById(R.id.steps_container);
        mInformDone = findViewById(R.id.inform_done);
        mStartButton = findViewById(R.id.start_button);
        mStartButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startMakingBread();
            }
        });
    }

    public void bindModel(List<Step> steps) {
        mModel = new BreadModel(this, steps);
        for (Step step : mModel.getSteps()) {
            StepView stepView = new StepView(getContext(), mLayoutInflater, step);
            mStepsContainer.addView(stepView);
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

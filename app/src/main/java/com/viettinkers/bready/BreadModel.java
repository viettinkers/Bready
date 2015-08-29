package com.viettinkers.bready;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Model for a bread batch.
 */
public class BreadModel {
    private List<Step> mSteps;
    private Step.StepListener mStepListener;

    public BreadModel(Step.StepListener listener, List<Step> steps) {
        mStepListener = listener;
        mSteps = steps;
    }

    private void createDefaultSteps() {
        mSteps = new ArrayList<>();
        mSteps.add(new Step("Prepare flour", 30000L, mStepListener, null));
        mSteps.add(new Step("Mix flour", 30000L, mStepListener, null));
        mSteps.add(new Step("Wait for the dough", 30000L, mStepListener, null));
        mSteps.add(new Step("Prepare flour", 30000L, mStepListener, null));
    }

    public List<Step> getSteps() {
        if (mSteps == null) {
            createDefaultSteps();
        }
        return mSteps;
    }
}

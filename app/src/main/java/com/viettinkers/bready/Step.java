package com.viettinkers.bready;

import android.os.CountDownTimer;
import android.support.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A step of baking bread.
 */
public class Step extends CountDownTimer {
    public interface StepListener {
        public void onTick();
        public void stepDone();
    }
    private static SimpleDateFormat TIMESTAMP_FORMAT = new SimpleDateFormat("h:m");
    private static long COUNT_INTERVAL_MS = 1000L;

    private String mTitle;
    private long mDurationMs;
    private Date mStartTime;
    private Date mEndTime;
    private StepListener mListener;
    private CountDownTimer mTimer;

    public Step(String title, long durationMs, StepListener listener, @Nullable Date startTime) {
        super(durationMs, COUNT_INTERVAL_MS);
        mTitle = title;
        mDurationMs = durationMs;
        mListener = listener;
        if (startTime != null) {
            setStartTime(startTime);
        }
    }

    public String getTitle() {
        return mTitle;
    }

    public void setStartTime(Date startStep) {
        mStartTime = startStep;
        mEndTime = new Date(mStartTime.getTime() + mDurationMs);
    }

    public String getStartTime() {
        if (mStartTime == null) {
            return "";
        }
        return TIMESTAMP_FORMAT.format(mStartTime);
    }

    public String getEndTime() {
        if (mEndTime == null) {
            return "";
        }
        return TIMESTAMP_FORMAT.format(mEndTime);
    }


    @Override
    public void onTick(long millisUntilFinished) {
        mListener.onTick();
    }

    @Override
    public void onFinish() {
        mListener.stepDone();
        onDestroy();
    }

    public void startCounting() {
        setStartTime(new Date());
        this.start();
    }

    public boolean isDone() {
        if (mStartTime == null || mEndTime == null) {
            return false;
        }
        if (mStartTime.after(mEndTime)) {
            return true;
        }
        if (new Date().after(mEndTime)) {
            return true;
        }
        return false;
    }

    public String getTimeLeft() {
        String timeLeft = "";
        Date now = new Date();
        if (now.after(mEndTime)) {
            return "Done";
        }
        long seconds = (mEndTime.getTime() - now.getTime()) / 1000;
        long minutes = seconds / 60;
        seconds = seconds % 60;
        long hours = minutes / 60;
        hours = hours % 60;
        if (hours > 0) {
            timeLeft = String.valueOf(hours) + "h";
        }
        if (minutes > 0) {
            if (seconds > 0) {
                timeLeft = String.valueOf(minutes) + ":" + String.valueOf(seconds);
            } else {
                timeLeft = String.valueOf(minutes) + " minutes";
            }
        }
        return timeLeft;
    }

    public void onDestroy() {
        mTimer = null;
        mListener = null;
    }
}
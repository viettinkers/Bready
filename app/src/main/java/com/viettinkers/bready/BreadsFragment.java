package com.viettinkers.bready;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class BreadsFragment extends Fragment {
    private LayoutInflater mLayoutInflater;
    private ViewGroup mBreadsContainer;

    public BreadsFragment() {
    }

    private void loadBreads() {
        BreadView breadView = new BreadView(getContext(), mLayoutInflater);
        breadView.bindModel(null);
        mBreadsContainer.addView(breadView);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.breads_fragment, container, false);
        mBreadsContainer = (ViewGroup) view.findViewById(R.id.breads_container);
        mLayoutInflater = getLayoutInflater(savedInstanceState);
        return view;
    }

    @Override
    public void onActivityCreated (Bundle savedInstanceState) {
        loadBreads();
        super.onActivityCreated(savedInstanceState);
    }
}

package kpk.dev.ui.fragments.impl;

import android.os.Bundle;
import android.view.View;

import kpk.dev.R;
import kpk.dev.ui.fragments.BaseFragment;

public class WorkersFragment extends BaseFragment {

    public static WorkersFragment getInstance(Bundle args) {
        WorkersFragment fragment = new WorkersFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_workers_layout;
    }

    @Override
    protected void initComponents(View rootView) {

    }
}

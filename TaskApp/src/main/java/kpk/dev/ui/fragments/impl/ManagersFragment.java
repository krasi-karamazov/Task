package kpk.dev.ui.fragments.impl;

import android.os.Bundle;
import android.view.View;

import kpk.dev.R;
import kpk.dev.ui.fragments.BaseFragment;

public class ManagersFragment extends BaseFragment {

    public static ManagersFragment getInstance(Bundle args) {
        ManagersFragment fragment = new ManagersFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_managers_layout;
    }

    @Override
    protected void initComponents(View rootView) {

    }
}
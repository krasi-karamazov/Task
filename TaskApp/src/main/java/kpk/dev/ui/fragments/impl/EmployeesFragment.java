package kpk.dev.ui.fragments.impl;

import android.os.Bundle;
import android.view.View;

import kpk.dev.R;
import kpk.dev.ui.fragments.BaseFragment;

public class EmployeesFragment extends BaseFragment {

    public static EmployeesFragment getInstance(Bundle args) {
        EmployeesFragment fragment = new EmployeesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_employees_layout;
    }

    @Override
    protected void initComponents(View rootView) {

    }
}

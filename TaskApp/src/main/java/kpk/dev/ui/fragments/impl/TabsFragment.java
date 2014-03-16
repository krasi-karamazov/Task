package kpk.dev.ui.fragments.impl;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TabWidget;

import kpk.dev.R;
import kpk.dev.ui.activities.NavigationListener;

public class TabsFragment extends Fragment implements TabHost.OnTabChangeListener {

    public static final int TAB_INDEX_ALL_EMPLOYEES = 0;
    public static final int TAB_INDEX_MANAGERS = 1;
    public static final int TAB_INDEX_WORKERS = 2;


    public static final String SELECTED_TAB_INDEX_KEY = "selected_tab";

    public static final String TAG = TabsFragment.class.getSimpleName();

    private FragmentTabHost mTabHost;

    private NavigationListener mNavListener;

    public static TabsFragment getInstance(Bundle args) {
        TabsFragment fragment = new TabsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(!(activity instanceof NavigationListener)) {
            throw new IllegalStateException("Activity must implement NavigationListener");
        }
        mNavListener = (NavigationListener)activity;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_tabs,container, false);

        mTabHost = (FragmentTabHost)rootView.findViewById(android.R.id.tabhost);

        mTabHost.setup(getActivity(), getChildFragmentManager(), R.id.fl_tab_content);
        mTabHost.addTab(mTabHost.newTabSpec(getString(R.string.nav_title_employees)).setIndicator(getString(R.string.nav_title_employees)), DummyFragment.class, null);

        mTabHost.addTab(mTabHost.newTabSpec(getString(R.string.nav_title_managers)).setIndicator(getString(R.string.nav_title_managers)), DummyFragment.class, null);

        mTabHost.addTab(mTabHost.newTabSpec(getString(R.string.nav_title_workers)).setIndicator(getString(R.string.nav_title_workers)), DummyFragment.class, null);

        mTabHost.setOnTabChangedListener(this);

        mTabHost.getTabWidget().setDividerDrawable(null);
        for(int i = 0; i < mTabHost.getTabWidget().getChildCount(); i++) {
            mTabHost.getTabWidget().getChildAt(i).setBackgroundDrawable(getResources().getDrawable(R.drawable.tab_background_selector));
        }


        if(getArguments() != null) {
            mTabHost.setCurrentTab(getArguments().getInt(SELECTED_TAB_INDEX_KEY));
        }

        return rootView;
    }


    @Override
    public void onTabChanged(String s) {
        int index = mTabHost.getCurrentTab();
        mNavListener.onNavigationEvent(index);
    }
}

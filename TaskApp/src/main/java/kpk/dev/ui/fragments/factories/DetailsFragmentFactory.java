package kpk.dev.ui.fragments.factories;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import kpk.dev.ui.fragments.BaseFragment;
import kpk.dev.ui.fragments.impl.EmployeesFragment;
import kpk.dev.ui.fragments.impl.ManagersFragment;
import kpk.dev.ui.fragments.impl.TabsFragment;
import kpk.dev.ui.fragments.impl.WorkersFragment;

public class DetailsFragmentFactory {

    public static Fragment getFragment(int navIndex, Bundle args) {
        BaseFragment fragment = null;
        switch (navIndex){
            case TabsFragment.TAB_INDEX_ALL_EMPLOYEES:
                fragment = EmployeesFragment.getInstance(args);
                break;
            case TabsFragment.TAB_INDEX_MANAGERS:
                fragment = ManagersFragment.getInstance(args);
                break;
            case TabsFragment.TAB_INDEX_WORKERS:
                fragment = WorkersFragment.getInstance(args);
                break;
        }
        return fragment;
    }
}

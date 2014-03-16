package kpk.dev.ui.fragments.impl;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import kpk.dev.adapters.PeopleAdapter;
import kpk.dev.data.DataHolder;
import kpk.dev.models.EmployeeDecorator;

public class PeopleListFragment extends ListFragment {

    public static final String TAG = PeopleListFragment.class.getSimpleName();

    private boolean mViewCreated;
    private PeopleAdapter mAdapter;
    private List<EmployeeDecorator> mData = new ArrayList<EmployeeDecorator>();

    public static PeopleListFragment getInstance(Bundle args) {
        PeopleListFragment fragment = new PeopleListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        mAdapter = new PeopleAdapter(activity, mData);
        setListAdapter(mAdapter);

        if(getArguments() != null) {
            int index = getArguments().getInt(TabsFragment.SELECTED_TAB_INDEX_KEY, 0);
            showRequiredList(index);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mViewCreated = true;

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void showRequiredList(int index) {
        mData.clear();
        switch(index){
            case TabsFragment.TAB_INDEX_WORKERS:
                mData.addAll(DataHolder.getInstance().getAllWorkers());
                break;
            case TabsFragment.TAB_INDEX_MANAGERS:
                mData.addAll(DataHolder.getInstance().getManagers());
                break;
            case TabsFragment.TAB_INDEX_ALL_EMPLOYEES:
                mData.addAll(DataHolder.getInstance().getAllEmployees());
                break;
        }

        mAdapter.notifyDataSetChanged();

        if(mViewCreated){
            getListView().setSelection(0);
        }
    }
}

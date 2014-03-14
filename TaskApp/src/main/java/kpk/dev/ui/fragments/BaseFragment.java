package kpk.dev.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by krasimir.karamazov on 3/14/14.
 */
public abstract class BaseFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(getLayout(), container, false);
        initComponents(rootView);
        return rootView;
    }


    protected abstract int getLayout();
    protected abstract void initComponents(View rootView);
}

package kpk.dev.ui.activities;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import kpk.dev.R;
import kpk.dev.ui.fragments.factories.DetailsFragmentFactory;
import kpk.dev.ui.fragments.impl.PeopleListFragment;
import kpk.dev.ui.fragments.impl.TabsFragment;

public class MainActivity extends ActionBarActivity implements NavigationListener {

    private int mSelectedNavIndex = 0;
    private static final String CURRENT_NAVIGATION_ITEM_INDEX_KEY = "nav_item_index";
    private boolean mDualPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null) {
            if(savedInstanceState.containsKey(CURRENT_NAVIGATION_ITEM_INDEX_KEY)) {
                mSelectedNavIndex = savedInstanceState.getInt(CURRENT_NAVIGATION_ITEM_INDEX_KEY);
            }
        }
        if(findViewById(R.id.fl_details_container) != null){
            mDualPane = true;
        }

        setupNavigation();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(CURRENT_NAVIGATION_ITEM_INDEX_KEY, mSelectedNavIndex);
        super.onSaveInstanceState(outState);
    }

    private void setupNavigation() {
        Bundle args = new Bundle();
        args.putInt(TabsFragment.SELECTED_TAB_INDEX_KEY, mSelectedNavIndex);
        getSupportFragmentManager()
                .beginTransaction().replace(R.id.fl_tab_container, TabsFragment.getInstance(args), TabsFragment.TAG)
                .commit();

        getSupportFragmentManager()
                .beginTransaction().replace(R.id.fl_list_container, PeopleListFragment.getInstance(args), PeopleListFragment.TAG)
                .commit();

        if(mDualPane){
            getSupportFragmentManager()
                    .beginTransaction().replace(R.id.fl_details_container, DetailsFragmentFactory.getFragment(mSelectedNavIndex, new Bundle()))
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onNavigationEvent(int navIndex) {

        PeopleListFragment fragment = (PeopleListFragment)getSupportFragmentManager().findFragmentByTag(PeopleListFragment.TAG);
        if(fragment != null) {
            mSelectedNavIndex = navIndex;
            fragment.showRequiredList(navIndex);

            if(mDualPane){
                getSupportFragmentManager()
                        .beginTransaction().replace(R.id.fl_details_container, DetailsFragmentFactory.getFragment(mSelectedNavIndex, new Bundle()))
                        .commit();
            }
        }
    }
}

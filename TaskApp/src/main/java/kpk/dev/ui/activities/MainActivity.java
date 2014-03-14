package kpk.dev.ui.activities;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import kpk.dev.R;


public class MainActivity extends ActionBarActivity implements ActionBar.TabListener {
    private int mSelectedNavIndex = 0;
    private static final String CURRENT_NAVIGATION_ITEM_INDEX_KEY = "nav_item_index";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null) {
            if(savedInstanceState.containsKey(CURRENT_NAVIGATION_ITEM_INDEX_KEY)) {
                mSelectedNavIndex = savedInstanceState.getInt(CURRENT_NAVIGATION_ITEM_INDEX_KEY, 0);
            }
        }
        setupNavigation();
    }

    private void setupNavigation() {
        getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        final String[] navItems = getResources().getStringArray(R.array.nav_titles);

        for(String item : navItems) {
            ActionBar.Tab tab = getSupportActionBar().newTab();
            tab.setText(item);
            tab.setTabListener(this);
            getSupportActionBar().addTab(tab);
        }
        getSupportActionBar().setSelectedNavigationItem(mSelectedNavIndex);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(CURRENT_NAVIGATION_ITEM_INDEX_KEY, getSupportActionBar().getSelectedNavigationIndex());
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
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }
}

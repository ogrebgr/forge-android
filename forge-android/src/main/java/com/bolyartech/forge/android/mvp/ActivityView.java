package com.bolyartech.forge.android.mvp;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;


public interface ActivityView {
    void onCreate(View rootView);
    boolean onCreateOptionsMenu(MenuInflater inflater, Menu menu);
    boolean onOptionsItemSelected(MenuItem item);
    void onDestroy();
}

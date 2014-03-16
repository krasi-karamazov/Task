package kpk.dev.application;

import android.app.Application;

import kpk.dev.data.DataHolder;

public class TaskApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DataHolder.getInstance();
    }
}

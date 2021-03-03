package io.github.jonzarate.bloomwild;

import android.app.Application;

public class BloomWildApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Injector.INSTANCE.setTablet(
                getResources().getBoolean(R.bool.isTablet)
        );
    }
}

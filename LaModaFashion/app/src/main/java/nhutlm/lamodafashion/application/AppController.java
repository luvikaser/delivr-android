package nhutlm.lamodafashion.application;

import android.app.Application;

import nhutlm.lamodafashion.application.builder.AppComponent;
import nhutlm.lamodafashion.application.builder.AppContextModule;
import nhutlm.lamodafashion.application.builder.DaggerAppComponent;

/**
 * Created by cpu1-216-local on 22/05/2017.
 */

public class AppController extends Application {
    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initAppComponent();
    }


    private void initAppComponent() {
        appComponent = DaggerAppComponent.builder().appContextModule(new AppContextModule(this)).build();
    }

    public static AppComponent getNetComponent() {
        return appComponent;
    }
}

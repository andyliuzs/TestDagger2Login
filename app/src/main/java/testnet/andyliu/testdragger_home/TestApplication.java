package testnet.andyliu.testdragger_home;

import android.app.Application;
import android.content.Context;

import testnet.andyliu.testdragger_home.component.AppComponent;
import testnet.andyliu.testdragger_home.component.DaggerAppComponent;
import testnet.andyliu.testdragger_home.module.AppModule;

/**
 * Created by Administrator on 2016/7/19.
 */
public class TestApplication extends Application {
    AppComponent appComponent;

    public static TestApplication get(Context context) {
        return (TestApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        initComponent();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    private void initComponent() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }
}

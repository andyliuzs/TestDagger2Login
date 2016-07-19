package testnet.andyliu.testdragger_home.module;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import testnet.andyliu.testdragger_home.utils.Validator;

/**
 * Created by Administrator on 2016/7/19.
 */
@Module
public class AppModule {
    private Application application;


    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Application providerApplication() {
        return application;
    }

    @Provides
    @Singleton
    Validator providerValidator() {
        return new Validator();
    }

}

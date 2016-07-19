package testnet.andyliu.testdragger_home.component;

import javax.inject.Singleton;

import dagger.Component;
import testnet.andyliu.testdragger_home.module.AppModule;
import testnet.andyliu.testdragger_home.ui.component.MainActivityCommponent;
import testnet.andyliu.testdragger_home.ui.module.MainActivityModule;

/**
 * Created by Administrator on 2016/7/19.
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    MainActivityCommponent plus(MainActivityModule mainActivityModule);
}

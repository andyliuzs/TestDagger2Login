package testnet.andyliu.testdragger_home.ui.component;

import dagger.Component;
import dagger.Subcomponent;
import testnet.andyliu.testdragger_home.scope.ActivityScope;
import testnet.andyliu.testdragger_home.ui.MainActivity;
import testnet.andyliu.testdragger_home.ui.module.MainActivityModule;

/**
 * Created by Administrator on 2016/7/19.
 */
@ActivityScope
@Subcomponent(modules = {MainActivityModule.class})
public interface MainActivityCommponent {
    MainActivity inject(MainActivity mainActivity);
}

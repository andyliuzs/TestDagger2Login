package testnet.andyliu.testdragger_home.ui.module;

import dagger.Module;
import dagger.Provides;
import testnet.andyliu.testdragger_home.scope.ActivityScope;
import testnet.andyliu.testdragger_home.ui.MainActivity;
import testnet.andyliu.testdragger_home.ui.presenter.MainActivityPresenter;
import testnet.andyliu.testdragger_home.utils.Validator;

/**
 * Created by Administrator on 2016/7/19.
 */
@Module
public class MainActivityModule {
    private MainActivity mainActivity;

    public MainActivityModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Provides
    @ActivityScope
    MainActivity providerMainActivity() {
        return mainActivity;
    }

    @Provides
    @ActivityScope
    MainActivityPresenter providerMainActivityPresenter(Validator validator) {
        return new MainActivityPresenter(mainActivity, validator);
    }

}

package testnet.andyliu.testdragger_home.utils;

import android.text.TextUtils;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Miroslaw Stanek on 23.04.15.
 */
public class Validator {

    public Validator() {
    }

    public boolean validUsername(String username) {
        return !TextUtils.isEmpty(username);
    }

    public boolean validPassword(String password) {
        return !TextUtils.isEmpty(password);
    }
}

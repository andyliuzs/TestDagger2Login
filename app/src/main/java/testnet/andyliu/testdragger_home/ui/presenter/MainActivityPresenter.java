package testnet.andyliu.testdragger_home.ui.presenter;

import android.os.Handler;
import android.os.Message;

import java.util.Timer;
import java.util.TimerTask;

import testnet.andyliu.testdragger_home.bean.User;
import testnet.andyliu.testdragger_home.ui.MainActivity;
import testnet.andyliu.testdragger_home.utils.Validator;

/**
 * Created by Administrator on 2016/7/19.
 */
public class MainActivityPresenter {
    private static final String USER_NAME = "andyliu";
    private static final String PASSWORD = "123456";
    public User user;
    private MainActivity mainActivity;
    private Validator validator;

    public MainActivityPresenter(MainActivity mainActivity, Validator validator) {
        this.mainActivity = mainActivity;
        this.validator = validator;
        user = new User();
    }

    public void onBtnClick() {
        boolean checkOk = true;
        if (validator.validUsername(user.getUserName())) {

        } else {
            checkOk = false;
            mainActivity.showValidationError(mainActivity.USER_NAME_ERROR);
        }

        if (validator.validUsername(user.getPassword())) {

        } else {
            checkOk = false;
            mainActivity.showValidationError(mainActivity.PASSWORD_ERROR);
        }

        if (checkOk) {

            mainActivity.showLoading(true);
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        mainActivity.showLoading(false);
                    }
                    handler.sendEmptyMessage(1);
                }
            }, 0);
        } else {
            mainActivity.showLoading(false);
        }
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                boolean checkOk = true;
                if (USER_NAME.equals(user.getUserName())) {

                } else {
                    checkOk = false;
                    mainActivity.showValidationError(mainActivity.USER_NAME_ERROR);
                }

                if (PASSWORD.equals(user.getPassword())) {

                } else {
                    checkOk = false;
                    mainActivity.showValidationError(mainActivity.PASSWORD_ERROR);
                }
                mainActivity.showLoading(false);
                if (checkOk)
                    mainActivity.goNextPage(user);
            }
        }
    };

}

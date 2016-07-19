package testnet.andyliu.testdragger_home.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.jakewharton.rxbinding.widget.RxTextView;
import com.jakewharton.rxbinding.widget.TextViewTextChangeEvent;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscription;
import rx.functions.Action1;
import testnet.andyliu.testdragger_home.R;
import testnet.andyliu.testdragger_home.TestApplication;
import testnet.andyliu.testdragger_home.bean.User;
import testnet.andyliu.testdragger_home.component.DaggerAppComponent;
import testnet.andyliu.testdragger_home.ui.module.MainActivityModule;
import testnet.andyliu.testdragger_home.ui.presenter.MainActivityPresenter;

public class MainActivity extends BaseActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    @Bind(R.id.btn_login)
    Button btnLogin;
    @Bind(R.id.et_username)
    EditText etUserName;
    @Bind(R.id.et_password)
    EditText etPassword;
    @Bind(R.id.pbLoading)
    ProgressBar pbLoading;
    @Inject
    MainActivityPresenter presenter;

    private Subscription userNameChangeSubscription;
    private Subscription passwordChangeSubscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        setupActivityComponent();
        Log.v(TAG, "oncreate");
        initView();
    }

    private void initView() {
        userNameChangeSubscription = RxTextView.textChangeEvents(etUserName).subscribe(new Action1<TextViewTextChangeEvent>() {
            @Override
            public void call(TextViewTextChangeEvent textViewTextChangeEvent) {
                presenter.user.setUserName(textViewTextChangeEvent.text().toString());
            }
        });
        passwordChangeSubscription = RxTextView.textChangeEvents(etPassword).subscribe(new Action1<TextViewTextChangeEvent>() {
            @Override
            public void call(TextViewTextChangeEvent textViewTextChangeEvent) {
                presenter.user.setPassword(textViewTextChangeEvent.text().toString());
            }
        });
    }

    @OnClick({R.id.btn_login})
    public void onBtnClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                presenter.onBtnClick();
                break;
        }
    }

    @Override
    protected void setupActivityComponent() {
        Log.v(TAG, "开始注入依赖--");
        TestApplication.get(this)
                .getAppComponent()
                .plus(new MainActivityModule(this))
                .inject(this);
        Log.v(TAG, "已经注入依赖--");
    }

    public static final int USER_NAME_ERROR = 1;
    public static final int PASSWORD_ERROR = 2;

    public void showValidationError(int flags) {
        if (flags == USER_NAME_ERROR) {
            etUserName.setError("用户名错误!");
        } else if (flags == PASSWORD_ERROR) {
            etPassword.setError("密码错误!");
        }
    }

    public void goNextPage(User user) {
        Toast.makeText(MainActivity.this, "登录成功," + user.toString(), Toast.LENGTH_SHORT).show();
    }

    public void showLoading(boolean show) {
        btnLogin.setVisibility(show ? View.GONE : View.VISIBLE);
        pbLoading.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        userNameChangeSubscription.unsubscribe();
        passwordChangeSubscription.unsubscribe();
    }
}

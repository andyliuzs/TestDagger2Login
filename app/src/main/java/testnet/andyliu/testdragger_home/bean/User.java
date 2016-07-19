package testnet.andyliu.testdragger_home.bean;

/**
 * Created by Administrator on 2016/7/19.
 */
public class User {
    private String userName;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "用户名:" + userName + ",密码:" + password;
    }
}

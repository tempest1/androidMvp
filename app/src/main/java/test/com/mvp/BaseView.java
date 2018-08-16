package test.com.mvp;

/**
 * Created by zd on 2018/8/16.
 */

public interface BaseView {

    void showProgress();

    void hideProgress();

    void setUsernameError();

    void setPasswordError();

    void setError(String error);

    void success(String way, String result);

}

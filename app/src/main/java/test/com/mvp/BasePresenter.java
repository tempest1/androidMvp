package test.com.mvp;

/**
 * Created by zd on 2018/8/16.
 */

public interface BasePresenter {

    void login(String username, String password);

    void exit();

    void onDestroy();
}

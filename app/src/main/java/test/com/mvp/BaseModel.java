package test.com.mvp;

/**
 * Created by zd on 2018/8/16.
 */

public interface  BaseModel {
    //这里写http请求的接口
    void login(String username, String password, onFinishedListener listener);

    void exit( onFinishedListener listener);
}

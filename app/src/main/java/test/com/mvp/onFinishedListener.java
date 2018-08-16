package test.com.mvp;

/**
 * Created by zd on 2018/8/16.
 * 此接口是将BaseModelImpl返回的果分类处理
 */

public interface onFinishedListener {

    //通用错误提示
    void onError(String error);

    //需要特殊处理的错误提示
    void onUsernameError();

    void onPasswordError();


    //http返回成功
    void onSuccess(String way,String result);
}

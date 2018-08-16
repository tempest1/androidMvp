package test.com.mvp;

import android.os.Handler;
import android.text.TextUtils;

/**
 * Created by zd on 2018/8/16.
 *
 * 这里模拟了一个耗时的操作并回调接口onFinishedListener
 */

public class BaseModelImpl implements BaseModel {

    //这里写http请求
    @Override
    public void login(final String username,final String password,final onFinishedListener listener) {

        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                boolean error = false;
                if (TextUtils.isEmpty(username)){
                    listener.onError("用户名不存在");//model层里面回调listener
                    error = true;
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    listener.onPasswordError();
                    error = true;
                    return;
                }
                if (!error){
                    // 返回方法名和http请求的结果
                    listener.onSuccess("login","{}");
                }
            }
        }, 2000);
    }

    @Override
    public void exit(final onFinishedListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                // 返回方法名和http请求的结果
                listener.onSuccess("exit","{}");

            }
        }, 2000);
    }
}

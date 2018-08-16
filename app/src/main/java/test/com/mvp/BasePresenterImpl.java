package test.com.mvp;

/**
 * Created by zd on 2018/8/16.
 * 1 完成presenter的实现。这里面主要是Model层和View层的交互和操作。
 * 2  presenter里面还有个onFinishedListener，
 * 其在Presenter层实现，给Model层回调，更改View层的状态，
 * 确保 Model层不直接操作View层。如果没有这一接口在BasePresenterImpl实现的话，
 */

public class BasePresenterImpl implements BasePresenter, onFinishedListener {


    private BaseView baseView;
    private BaseModel baseModel;


    public BasePresenterImpl(BaseView baseView){
        this.baseView = baseView;
        this.baseModel = new BaseModelImpl();
    }

    @Override
    public void login(String username, String password) {
        if (baseView != null) {
            baseView.showProgress();
        }
        baseModel.login(username, password, this);
    }

    @Override
    public void exit() {
        if (baseView != null) {
            baseView.showProgress();
        }
        baseModel.exit(this);
    }

    @Override
    public void onDestroy() {
        baseView = null;
    }

    @Override
    public void onError(String error) {
        if (baseView != null) {
            baseView.setError(error);
            baseView.hideProgress();
        }
    }

    @Override
    public void onUsernameError() {
        if (baseView != null) {
            baseView.setUsernameError();
            baseView.hideProgress();
        }
    }

    @Override
    public void onPasswordError() {
        if (baseView != null) {
            baseView.setPasswordError();
            baseView.hideProgress();
        }
    }

    @Override
    public void onSuccess(String way, String result) {
        if (baseView != null) {
            baseView.success(way,result);
            baseView.hideProgress();
        }
    }

}

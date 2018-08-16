package test.com.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements BaseView,View.OnClickListener {


    private ProgressBar progress;
    private BasePresenter presenter;
    private Button button;
    private EditText username;
    private EditText password;
    private Button exit;

    private CustomDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new CustomDialog(this, R.style.CustomDialog);
        progress = (ProgressBar)findViewById(R.id.progress);
        presenter = new BasePresenterImpl(this);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(this);
        exit = (Button)findViewById(R.id.exit);
        exit.setOnClickListener(this);
    }


    @Override
    public void showProgress() {
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.cancel();
    }

    @Override
    public void setUsernameError() {
        username.setError(getString(R.string.username_error));
    }

    @Override
    public void setPasswordError() {
        password.setError(getString(R.string.password_error));
    }

    @Override
    public void setError(String error) {
        Toast.makeText(this,error,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void success(String way, String result) {
        Toast.makeText(this,way,Toast.LENGTH_SHORT).show();
        //根据调用的接口，更新成功的ui

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                presenter.login(username.getText().toString(), password.getText().toString());
                break;
            case R.id.exit:
                presenter.exit();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }
}

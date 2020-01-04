package zhj.viewpagerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText accountRegisterName;
    private EditText accountRegisterPassword;
    private Button registerBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        initData();
        initListener();
    }

    private void initView() {
        accountRegisterName = (EditText) findViewById(R.id.i8_accountRegister_name);
        accountRegisterPassword = (EditText) findViewById(R.id.i8_accountRegister_password);
        registerBtn = (Button) findViewById(R.id.i8_accountRegistern_toRegister);
    }

    private void initData() {

    }

    private void initListener() {
        registerBtn.setOnClickListener(RegisterActivity.this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.i8_accountRegistern_toRegister:
                //registerAccount();//owner
                bmobRegisterAccount();//Bmob
                break;
            default:
                break;
        }
    }

    private void bmobRegisterAccount() {
        final String registerName = accountRegisterName.getText().toString().trim();//账号
        final String registerPassword = accountRegisterPassword.getText().toString().trim();//密码

        if (TextUtils.isEmpty(registerName) || TextUtils.isEmpty(registerPassword)) {
            showToast("注册账号或密码为空");
            return;
        }
        RegisterUser registerUser=new RegisterUser();
        BmobUser bmobUser = new BmobUser();
        registerUser.setRegisterName(registerName);
        registerUser.setRegisterPassword(registerPassword);
        registerUser.setXinyong(100);
        registerUser.setMoney(100);
        registerUser.setLingyu("美妆");
        /*String picPath = "/drawable/five.png";
        BmobFile bmobFile = new BmobFile(new File(picPath));
        registerUser.setPicture(bmobFile);*/
        registerUser.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if (e == null) {
                    showToast("恭喜，注册账号成功");
                    finish();
                } else {
                    showToast("register fail:" + e.getMessage());
                }
            }
        });
    }
    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}


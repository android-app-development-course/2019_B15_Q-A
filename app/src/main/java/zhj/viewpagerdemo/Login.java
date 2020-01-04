package zhj.viewpagerdemo;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

//import androidx.appcompat.app.AppCompatActivity;

//import com.showly.bmobdemo.bean.RegisterUser;

import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

public class Login extends AppCompatActivity implements View.OnClickListener {
    Button button;
    private EditText accountLoginName;
    private EditText accountLoginPassword;
    private Button loginBtn;
    private TextView registerAccountBtn;
    private ProgressBar progressBar;
    private LinearLayout llLogin;

    public static String accountName;// = accountLoginName.getText().toString().trim();//账号
    public static String accountPassword;// = accountLoginPassword.getText().toString().trim();//密码

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Bmob.initialize(this, "fd7b955caa726688d9dd2405eb457449");

        initView();
        initData();
        initListener();
    }

    private void initView() {
        accountLoginName = (EditText) findViewById(R.id.i8_accountLogin_name);
        accountLoginPassword = (EditText) findViewById(R.id.i8_accountLogin_password);
        loginBtn = (Button) findViewById(R.id.i8_accountLogin_toLogin);
        registerAccountBtn = (TextView) findViewById(R.id.register_account_btn);
        progressBar = (ProgressBar) findViewById(R.id.pb);
        llLogin = (LinearLayout) findViewById(R.id.ll_login);
    }

    private void initData() {

    }

    private void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
        llLogin.setVisibility(View.GONE);
    }

    private void hiddenProgressBar() {
        progressBar.setVisibility(View.GONE);
        llLogin.setVisibility(View.VISIBLE);
    }

    private void initListener() {
        loginBtn.setOnClickListener(this);
        registerAccountBtn.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.i8_accountLogin_toLogin:
                //userAccountLogin();//账号登录 owner
                bmobUserAccountLogin();//bmob登录
                break;
            case R.id.register_account_btn:
                //跳转到注册界面
                Intent intent = new Intent(Login.this, RegisterActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    private void bmobUserAccountLogin() {
        accountName = accountLoginName.getText().toString().trim();//账号
        accountPassword = accountLoginPassword.getText().toString().trim();//密码

        if (TextUtils.isEmpty(accountName)) {
            Toast.makeText(Login.this,"账号不能为空",Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(accountPassword)) {
            Toast.makeText(Login.this,"密码不能为空",Toast.LENGTH_LONG).show();
            return;
        }

        //登录过程
        showProgressBar();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //BmobUser类为Bmob后端云提供类
                RegisterUser registerUser=new RegisterUser();
                registerUser.setRegisterName(accountName);
                registerUser.setRegisterPassword(accountPassword);
                userAccountLogin();
                /*registerUser.login(new SaveListener<BmobUser>() {
                    @Override
                    public void done(BmobUser bmobUser, BmobException e) {
                        //if (e == null) {
                            //登录成功后进入主界面
                            Intent intent = new Intent(MainActivity.this, success.class);
                            startActivity(intent);
                            finish();
                        /*} else {
                            Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
                            hiddenProgressBar();//隐藏
                        }
                    }
                });*/
            }
        }, 3000);
    }

    private void userAccountLogin() {
        final String accountName = accountLoginName.getText().toString().trim();
        final String accountPassword = accountLoginPassword.getText().toString().trim();

        if (TextUtils.isEmpty(accountName)) {
            Toast.makeText(Login.this,"账号不能为空",Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(accountPassword)) {
            Toast.makeText(Login.this,"密码不能为空",Toast.LENGTH_LONG).show();
            return;
        }

        //showProgressBar();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //查询用户有登录
                BmobQuery<RegisterUser> userBmobQuery = new BmobQuery<>();
                userBmobQuery.order("-createdAt");//按时间排序
                userBmobQuery.findObjects(new FindListener<RegisterUser>() {
                    @Override
                    public void done(List<RegisterUser> lists, BmobException e) {
                        if (e == null) {
                            for (RegisterUser list : lists) {
                                if (accountName.equals(list.getRegisterName())) {
                                    if (accountPassword.equals(list.getRegisterPassword())) {
                                        Toast.makeText(Login.this,"登录成功",Toast.LENGTH_LONG).show();

                                        Intent intent = new Intent(Login.this, MainActivity.class);
                                        startActivity(intent);
                                        finish();
                                        return;
                                    } else {
                                        Toast.makeText(Login.this,"密码错误",Toast.LENGTH_LONG).show();
                                        hiddenProgressBar();
                                        return;
                                    }
                                }
                            }
                            Toast.makeText(Login.this,"账号未注册",Toast.LENGTH_LONG).show();
                            hiddenProgressBar();
                        }
                    }
                });
            }
        }, 3000);
    }
}



package zhj.viewpagerdemo;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

public class AskingActivity extends AppCompatActivity{
    private ImageButton btn_mark;
    private Button m1;
    private Button m5;
    private Button m10;
    private Button m20;
    private Button m50;
    private Button m100;
    private Button m200;
    private Button m500;
    private Button btnSubmit;
    private EditText mTitle;
    private EditText mDetail;
    private TextView realMoney;
    private TextView mCategory;
    private PopupWindow mPopWindow;
    private int money=0;
    private Boolean flag=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asking);
        Bmob.initialize(this, "fd7b955caa726688d9dd2405eb457449");
        m1=(Button) findViewById(R.id.mark1);
        m5=(Button) findViewById(R.id.mark5);
        m10=(Button) findViewById(R.id.mark10);
        m20=(Button) findViewById(R.id.mark20);
        m50=(Button) findViewById(R.id.mark50);
        m100=(Button) findViewById(R.id.mark100);
        m200=(Button) findViewById(R.id.mark200);
        m500=(Button) findViewById(R.id.mark500);
        btn_mark=(ImageButton) findViewById(R.id.money_btn);
        btnSubmit=(Button) findViewById(R.id.submit_question);
        realMoney=(TextView) findViewById(R.id.real_money);
        mTitle=(EditText) findViewById(R.id.title_et);
        mDetail=(EditText) findViewById(R.id.question_et);
        mCategory=(TextView) findViewById(R.id.category);

        mCategory.setText(MainActivity.category);











        btn_mark.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v1){
                showMark(v1);
            }
        });
        //final int tv_category_id=R.id.category;

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //将数据上传到数据库
                //String userId= //获取用户ID
                String Qcategory=mCategory.getText().toString();
                String title=mTitle.getText().toString();

                String detail=mDetail.getText().toString();
                int persons=5;
                String accept="0";//0为未采纳
                int mark=money;


                questionData question=new questionData();
                /*question.setMark(1);
                question.setCategory("美妆");
                question.setTitle("第一条");
                question.setDetail("我也不知道");
                //Date date =new Date(System.currentTimeMillis());
                //String time=date.toString();
                question.setQuestioner("123456");
                question.setPersons(4);
                question.setAccept(false);*/

                question.setMark(mark);
                question.setCategory(Qcategory);
                question.setTitle(title);
                question.setDetail(detail);
                //Date date =new Date(System.currentTimeMillis());
                //String time=date.toString();

                question.setQuestioner("123456");
                question.setPersons(persons);
                question.setAccept(accept);

                /*question.setMark(1);
                question.setCategory("美妆");
                question.setTitle("第一条");
                question.setDetail("我也不知道");
                //Date date =new Date(System.currentTimeMillis());
                //String time=date.toString();
                question.setQuestioner("123456");
                question.setPersons(4);
                question.setAccept(false);*/


                question.save(new SaveListener<String>() {
                    @Override
                    public void done(String s, BmobException e) {
                        if(e==null)
                        {
                            Toast.makeText(AskingActivity.this,"提问成功！",Toast.LENGTH_LONG).show();
                            Intent intent=new Intent();
                            intent.setClass(AskingActivity.this,MainActivity.class);
                            startActivity(intent);

                        }
                        else
                        {
                            Toast.makeText(AskingActivity.this,"提问失败，请重新提交问题",Toast.LENGTH_LONG).show();

                            //one.setText(e.getMessage());
                            //Toast.makeText(AskingActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
                        }
                    }
                });

            }
        });

       // mCategory.setText(MainActivity.category);

    }

    public void showMark(View view){
        final AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("悬赏积分");

        final View v=getLayoutInflater().inflate(R.layout.money,null);
        builder.setView(v);
        m1=(Button)v.findViewById(R.id.mark1);
        m5=(Button) v.findViewById(R.id.mark5);
        m10=(Button) v.findViewById(R.id.mark10);
        m20=(Button) v.findViewById(R.id.mark20);
        m50=(Button) v.findViewById(R.id.mark50);
        m100=(Button) v.findViewById(R.id.mark100);
        m200=(Button) v.findViewById(R.id.mark200);
        m500=(Button) v.findViewById(R.id.mark500);

        final AlertDialog dialog=builder.show();

        m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                money=1;
                realMoney.setText(money+"积分");
                Toast.makeText(AskingActivity.this, "1积分", Toast.LENGTH_SHORT).show();
                dialog.dismiss();


            }
        });

        m5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                money=5;
                realMoney.setText(money+"积分");
                Toast.makeText(AskingActivity.this, "5积分", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        m10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                money=10;
                realMoney.setText(money+"积分");
                Toast.makeText(AskingActivity.this, "10积分", Toast.LENGTH_SHORT).show();
                dialog.dismiss();


            }
        });
        m20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                money=20;
                realMoney.setText(money+"积分");
                Toast.makeText(AskingActivity.this, "20积分", Toast.LENGTH_SHORT).show();
                dialog.dismiss();


            }
        });
        m50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                money=50;
                realMoney.setText(money+"积分");
                Toast.makeText(AskingActivity.this, "50积分", Toast.LENGTH_SHORT).show();
                dialog.dismiss();


            }
        });
        m100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                money=100;
                realMoney.setText(money+"积分");
                Toast.makeText(AskingActivity.this, "100积分", Toast.LENGTH_SHORT).show();
                dialog.dismiss();


            }
        });
        m200.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                money=200;
                realMoney.setText(money+"积分");
                Toast.makeText(AskingActivity.this, "200积分", Toast.LENGTH_SHORT).show();
                dialog.dismiss();


            }
        });
        m500.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                money=500;
                realMoney.setText(money+"积分");
                Toast.makeText(AskingActivity.this, "500积分", Toast.LENGTH_SHORT).show();
                dialog.dismiss();

                //     mPopWindow.dismiss();
            }
        });

    }
}

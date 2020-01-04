



package zhj.viewpagerdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by HongJay on 2016/8/11.
 */
public class Fragment4 extends Fragment {
    private Button btn1,btn2,btn3;
    private View view;
    TextView userId;
    TextView userName;
    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment4, container, false);
        btn1=(Button) view.findViewById(R.id.user_integral);     //积分  点击Button跳转到integral.xml
        btn2=(Button)view.findViewById(R.id.user_credict);      //信用  点击Button跳转到credict.xml
        btn3=(Button)view.findViewById(R.id.user_set);          //设置  点击Button跳转到set.xml

        userId=(TextView)view.findViewById(R.id.user_id);
        userName=(TextView)view.findViewById(R.id.user_name);

        userId.setText(Login.accountName);

        return view;
    }


    public void  onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showIntergral(view); //积分弹窗
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCredit(view);//信用弹窗
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSet(view);
            }
        });



    }

    public void showIntergral(View view){
        final AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        //builder.setTitle("我的信用");

        final View v=getLayoutInflater().inflate(R.layout.integral,null);
        builder.setView(v);
        builder.show();


    }

    public void showCredit(View view){
        final AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        //builder.setTitle("我的积分");

        final View v=getLayoutInflater().inflate(R.layout.credict,null);
        builder.setView(v);
        builder.show();

    }

    public void showSet(View view){
        final AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setTitle("设置");

        final View v=getLayoutInflater().inflate(R.layout.set,null);
        builder.setView(v);
        builder.show();


    }
}






package zhj.viewpagerdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

/**
 * Created by HongJay on 2016/8/11.
 */
public class Fragment3 extends Fragment {
    private Button btn_it;
    private Button btn_makeup;
    private Button btn_health;
    private Button btn_camera;
    private Button btn_emotion;
    private Button btn_study;
    //public String category;
    public int Q;
    public View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment3, container, false);
        btn_it=(Button)view.findViewById(R.id.it_btn);
        btn_camera=(Button) view.findViewById(R.id.camera_btn);
        btn_emotion=(Button) view.findViewById(R.id.emotion_btn);
        btn_health=(Button) view.findViewById(R.id.health_btn);
        btn_makeup=(Button) view.findViewById(R.id.makeup_btn);
        btn_study=(Button) view.findViewById(R.id.study_btn);
        return view;
    }
    public void  onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
        btn_it.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.category = "IT";
                Q = 0;
                Intent intent=new Intent();
                intent.setClass(getActivity(),AskingActivity.class);
                startActivity(intent);
            }
        });
        btn_makeup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.category = "美妆";
                Q = 1;
                Intent intent=new Intent();
                intent.setClass(getActivity(),AskingActivity.class);
                startActivity(intent);
            }
        });
        btn_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.category = "摄影";
                Q = 2;
                Intent intent=new Intent();
                intent.setClass(getActivity(),AskingActivity.class);
                startActivity(intent);
            }
        });
        btn_emotion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.category = "情感";
                Q = 3;
                Intent intent=new Intent();
                intent.setClass(getActivity(),AskingActivity.class);
                startActivity(intent);
            }
        });
        btn_health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.category = "健康";
                Q = 4;
                Intent intent=new Intent();
                intent.setClass(getActivity(),AskingActivity.class);
                startActivity(intent);
            }
        });
        btn_study.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.category="学习";
                Q=5;
                Intent intent=new Intent();
                intent.setClass(getActivity(),AskingActivity.class);
                startActivity(intent);
            }
        });



    }



}

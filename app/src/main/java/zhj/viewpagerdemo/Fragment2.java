package zhj.viewpagerdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 * Created by HongJay on 2016/8/11.
 */
public class Fragment2 extends Fragment {
    private ImageButton imageButton;
    private View view,view2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view= inflater.inflate(R.layout.fragment2, container, false);
        imageButton=(ImageButton)view.findViewById(R.id.infrom1);
        return view;
    }
    @Override
    public void  onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(getActivity(),Main_Msg.class);
                startActivity(intent);
            }
        });
    }

}

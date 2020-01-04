package zhj.viewpagerdemo;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;
import zhj.viewpagerdemo.MainActivity;
import zhj.viewpagerdemo.R;
import zhj.viewpagerdemo.question;

/**
 * Created by HongJay on 2016/8/11.
 */
public class Fragment1 extends Fragment {
    private RecyclerView mRecyclerView;
    private List<String> mDatas;
    private List<String> mnames;
    private List<String> mtitles;
    private List<String> mcontents;
    private ArrayList<ImageView> imageList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment1, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycle);//添加Android自带的分割线
        //mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));


        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        initdata();//初始化数据
        MyAdapter adapter=new MyAdapter(mDatas,mnames,mtitles,mcontents);

        mRecyclerView.setAdapter(adapter);
        return view;
    }





    private void initdata() {
        mDatas = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            mDatas.add("问题为6金币");
        }
        mnames = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            mnames.add("Liujay");
        }
        mtitles = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            mtitles.add("六级快要来了，我的听力依然很糟糕怎么办？");
        }
        mcontents = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            mcontents.add("从小到大，我的英语听力就不好，怎么办呢，六级就要来了，有没有可以快速提升英语听力的方法呢？" );
        }
        //初始化viewpager的数据
        int[] imageResIDs = {R.drawable.a, R.drawable.b, R.drawable.c};
        imageList = new ArrayList<ImageView>();
        for (int i = 0; i < imageResIDs.length; i++) {
            ImageView image = new ImageView(getActivity());
            image.setBackgroundResource(imageResIDs[i]);
            imageList.add(image);
        }
    }

    class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private List<String> mDatas;
        private List<String> mData1;
        private List<String> mData2;
        private List<String> mData3;
        private static final int HEAD_VIEW = 0;//头布局
        private static final int BODY_VIEW = 1;//内容布局
        private MyPagerAdapter mPagerAdapter = new MyPagerAdapter();

        //创建构造参数，用来接受数据集
        public MyAdapter(List<String> datas,List<String> Data1,List<String> Data2,List<String> Data3) {
            this.mDatas = datas;
            this.mData1=Data1;
            this.mData2=Data2;
            this.mData3=Data3;
        }

        //创建ViewHolder
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            if (viewType == HEAD_VIEW) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.headview_recycleview, parent, false);
                MyHeadViewHolder viewHolder = new MyHeadViewHolder(view);
                return viewHolder;
            }
            if (viewType == BODY_VIEW) {
                //加载布局文件
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_recycle, parent, false);
                final MyBodyViewHolder viewHolder = new MyBodyViewHolder(view);
                viewHolder.tv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int position = viewHolder.getAdapterPosition();
                        Intent intent2 = new Intent(getActivity(), question.class);
                        intent2.putExtra("name", viewHolder.name.getText());
                        intent2.putExtra("title", viewHolder.title.getText());
                        intent2.putExtra("content", viewHolder.content.getText());
                        intent2.putExtra("caozuo", viewHolder.tv.getText());
                        startActivity(intent2);
                        //Toast.makeText(v.getContext(), "新闻标题点击：你点击了新闻：" + position, Toast.LENGTH_SHORT).show();
                    }
                });
                viewHolder.title.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int position = viewHolder.getAdapterPosition();
                        Intent intent2 = new Intent(getActivity(), question.class);
                        intent2.putExtra("name", viewHolder.name.getText());
                        intent2.putExtra("title", viewHolder.title.getText());
                        intent2.putExtra("content", viewHolder.content.getText());
                        intent2.putExtra("caozuo", viewHolder.tv.getText());
                        startActivity(intent2);
                        //Toast.makeText(v.getContext(), "新闻标题点击：你点击了新闻：" + position, Toast.LENGTH_SHORT).show();
                    }
                });
                //点击事件
                viewHolder.content.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int position = viewHolder.getAdapterPosition();
                        Intent intent2 = new Intent(getActivity(), question.class);
                        intent2.putExtra("name", viewHolder.name.getText());
                        intent2.putExtra("title", viewHolder.title.getText());
                        intent2.putExtra("content", viewHolder.content.getText());
                        intent2.putExtra("caozuo", viewHolder.tv.getText());
                        startActivity(intent2);
                        //Toast.makeText(v.getContext(), "新闻标题点击：你点击了新闻：" + position, Toast.LENGTH_SHORT).show();
                    }
                });

                viewHolder.name.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int position = viewHolder.getAdapterPosition();
                        Intent intent2 = new Intent(getActivity(), question.class);
                        intent2.putExtra("name", viewHolder.name.getText());
                        intent2.putExtra("title", viewHolder.title.getText());
                        intent2.putExtra("content", viewHolder.content.getText());
                        intent2.putExtra("caozuo", viewHolder.tv.getText());
                        startActivity(intent2);
                        //Toast.makeText(v.getContext(), "新闻标题点击：你点击了新闻：" + position, Toast.LENGTH_SHORT).show();
                    }
                });
                return viewHolder;
            }
            return null;
        }

        //绑定ViewHolder
        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
            //将数据填充到具体的view中

            if (holder instanceof MyHeadViewHolder) {
                ((MyHeadViewHolder) holder).mViewPager.setAdapter(mPagerAdapter);
                ((MyHeadViewHolder) holder).indicator.onPageSelected(0);
                ((MyHeadViewHolder) holder).indicator.setViewPager(((MyHeadViewHolder) holder).mViewPager);
                ((MyHeadViewHolder) holder).indicator.setSnap(true);
            }

            if (holder instanceof MyBodyViewHolder) {
                ((MyBodyViewHolder) holder).tv.setText(mDatas.get(position-1));
                ((MyBodyViewHolder) holder).name.setText(mnames.get(position-1));
                ((MyBodyViewHolder) holder).title.setText(mtitles.get(position-1));
                ((MyBodyViewHolder) holder).content.setText(mcontents.get(position-1));


            }

        }

        @Override
        public int getItemCount() {
            return mDatas.size() + 1;
        }

        //如果是第一项，则加载头布局
        @Override
        public int getItemViewType(int position) {
            if (position == 0) {
                return HEAD_VIEW;
            } else {
                return BODY_VIEW;
            }
        }
    }

    //头布局的viewholder
    class MyHeadViewHolder extends RecyclerView.ViewHolder {
        ViewPager mViewPager;
        CirclePageIndicator indicator;

        public MyHeadViewHolder(View itemView) {
            super(itemView);
            mViewPager = (ViewPager) itemView.findViewById(R.id.vp_tab_headview);
            indicator = (CirclePageIndicator) itemView.findViewById(R.id.indicator);
        }
    }

    class MyBodyViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        TextView name;
        TextView title;
        TextView content;

        public MyBodyViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.recycle_tv);
            name = (TextView) itemView.findViewById(R.id.name);
            title = (TextView) itemView.findViewById(R.id.title);
            content = (TextView) itemView.findViewById(R.id.content);
        }


    }

    //viewpager的adapter
    class MyPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return imageList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(imageList.get(position));
            return imageList.get(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return Integer.toString(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
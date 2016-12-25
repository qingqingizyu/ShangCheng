package com.example.chenjunmei.shoppingguide.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.chenjunmei.shoppingguide.R;
import com.example.chenjunmei.shoppingguide.adapter.HomeRecycleViewAdapter;
import com.example.chenjunmei.shoppingguide.bean.WomenBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import butterknife.Bind;

import static com.alibaba.fastjson.JSON.parseArray;
import static com.example.chenjunmei.shoppingguide.R.id.ib_top;
import static com.example.chenjunmei.shoppingguide.R.id.tv_message_home;
import static com.example.chenjunmei.shoppingguide.R.id.tv_search_home;

/**
 * Created by ChenJunMei on 2016/11/23.
 */

public class HomeFragment extends BaseFragment {
    @Bind(tv_search_home)
    TextView tvSearchHome;
    @Bind(tv_message_home)
    TextView tvMessageHome;
    @Bind(R.id.rv_home)
    android.support.v7.widget.RecyclerView rvHome;
    @Bind(ib_top)
    ImageButton ibTop;
    private HomeRecycleViewAdapter homeRecycleAdapter;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_home, null);
        rvHome = (RecyclerView) view.findViewById(R.id.rv_home);
        ibTop = (ImageButton) view.findViewById(R.id.ib_top);
        tvSearchHome = (TextView) view.findViewById(R.id.tv_search_home);
        tvMessageHome = (TextView) view.findViewById(R.id.tv_message_home);

        //设置点击事件
        initListener();

        return view;
    }


    @Override
    public void initData() {
        super.initData();
        //联网请求
        getDataFromNet();
    }


    /**
     * 使用okhttpUtils进行联网请求数据
     */
    private void getDataFromNet() {
        String url = "http://api.funwear.com/mbfun_server/index.php?m=Home&a=getAppLayoutV2&page=home&cid=2&deviceCode=00000000-6469-5d7a-ffff-ffff99d603a9&osCode=android&osVersion=19&deviceId=00000000-6469-5d7a-ffff-ffff99d603a9&token=&source=android&version=v4.2.2&osName=HTC+M8t&appName=youfanguanfang";
        OkHttpUtils.
                get()
                .url(url)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(okhttp3.Call call, Exception e, int id) {
                        Log.e("TAG", "联网失败" + e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.e("TAG", "联网成功==" + response);

                        //联网成功后使用fastjson解析
                        processData(response);
                    }
                });
    }


    // fastjson解析数据
    private void processData(String json) {
        JSONObject jsonObject = JSON.parseObject(json);

        String data = jsonObject.getString("data");
        JSONObject jsonData = JSON.parseObject(data);

        String module = jsonData.getString("module");
        List<WomenBean.WomenData.ModuleBean> moduleBeanList = parseArray(module, WomenBean.WomenData.ModuleBean.class);
        //测试是否解析数据成功
        //String strTest=moduleBeanList.get(0).getC_title();
        //Log.e("TAG",strTest);

        if (moduleBeanList != null) {
            //有数据
            //设置适配器
            homeRecycleAdapter = new HomeRecycleViewAdapter(mContext, moduleBeanList);
            rvHome.setAdapter(homeRecycleAdapter);

            //recycleView不仅要设置适配器还要设置布局管理者,否则图片不显示
            //第一个参数是上下文，第二个参数是只有一列
            GridLayoutManager manager = new GridLayoutManager(getActivity(), 1);
            rvHome.setLayoutManager(manager);
        }
    }


    private void initListener() {
        //置顶的监听
        ibTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //recyclerView回到顶部
                rvHome.scrollToPosition(0);
            }
        });

        //搜素的监听
        tvSearchHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "搜索", Toast.LENGTH_SHORT).show();
            }
        });

        //消息的监听
        tvMessageHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "进入消息中心", Toast.LENGTH_SHORT).show();
            }
        });

    }


}

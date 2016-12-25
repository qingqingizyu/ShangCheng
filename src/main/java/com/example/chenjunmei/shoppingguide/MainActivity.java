package com.example.chenjunmei.shoppingguide;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.chenjunmei.shoppingguide.fragment.BaseFragment;
import com.example.chenjunmei.shoppingguide.fragment.CommunityFragment;
import com.example.chenjunmei.shoppingguide.fragment.HomeFragment;
import com.example.chenjunmei.shoppingguide.fragment.ShoppingCartFragment;
import com.example.chenjunmei.shoppingguide.fragment.TypeFragment;
import com.example.chenjunmei.shoppingguide.fragment.UserFragment;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends FragmentActivity {

    @Bind(R.id.frameLayout)
    FrameLayout frameLayout;
    @Bind(R.id.rb_home)
    RadioButton rbHome;
    @Bind(R.id.rb_type)
    RadioButton rbType;
    @Bind(R.id.rb_community)
    RadioButton rbCommunity;
    @Bind(R.id.rb_cart)
    RadioButton rbCart;
    @Bind(R.id.rb_user)
    RadioButton rbUser;
    @Bind(R.id.rg_main)
    RadioGroup rgMain;

    private ArrayList<BaseFragment> fragments;

    private int position=0;  //当前的页面位置
    private BaseFragment mFragment;  //原来的页面

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initFragment();
        initListener();
    }

    //初始化Fragment
    private void initFragment() {
        fragments = new ArrayList<>();
        //添加时要注意顺序
        fragments.add(new HomeFragment());
        fragments.add(new TypeFragment());
        fragments.add(new CommunityFragment());
        fragments.add(new ShoppingCartFragment());
        fragments.add(new UserFragment());
    }

    private void initListener() {
        rgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_home:
                        position = 0;
                        break;
                    case R.id.rb_type:

                        position = 1;
                        break;
                    case R.id.rb_community:
                        position = 2;

                        break;
                    case R.id.rb_cart:
                        position = 3;
                        break;
                    case R.id.rb_user:
                        position = 4;
                        break;
                }
                BaseFragment baseFragment = getFragment(position);
                switchFragment(mFragment, baseFragment);
            }
        });

        //默认设置首页
        rgMain.check(R.id.rb_home);
    }

    /**
     * 根据位置得到对应的fragment
     * @param position
     * @return
     */
    private BaseFragment getFragment(int position) {
        if (fragments != null && fragments.size() > 0) {
            BaseFragment baseFragment = fragments.get(position);
            return baseFragment;
        }
        return null;
    }

    /**
     * 把对应的fragment绑定到acticity中
     *
     * @param fromFragment 原页面
     * @param nextFragment   现在点击的页面
     */
    private void switchFragment(Fragment fromFragment, BaseFragment nextFragment) {
        //如果原页面不是现在点击即将进入的页面
        if (mFragment != nextFragment) {
            mFragment = nextFragment;     //防止多次点击进入
            if (nextFragment != null) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                //判断nextFragment是否添加
                if (!nextFragment.isAdded()) { //没有添加

                    if (fromFragment != null) {
                        transaction.hide(fromFragment); //隐藏当前Fragment
                    }
                    transaction.add(R.id.frameLayout, nextFragment).commit(); //添加显示
                } else {
                    //隐藏当前Fragment
                    if (fromFragment != null) {
                        transaction.hide(fromFragment);
                    }
                    //显示点击的fragment
                    transaction.show(nextFragment).commit();
                }
            }
        }
    }



}

package com.example.lyw.mymainapplication.ui.activity;

import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.lyw.mymainapplication.R;
import com.example.lyw.mymainapplication.bean.Tab;
import com.example.lyw.mymainapplication.ui.fragment.CartFragment;
import com.example.lyw.mymainapplication.ui.fragment.CategoryFragment;
import com.example.lyw.mymainapplication.ui.fragment.HomeFragment;
import com.example.lyw.mymainapplication.ui.fragment.HotFragment;
import com.example.lyw.mymainapplication.ui.fragment.MineFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    private LayoutInflater mInflater;

    private FragmentTabHost mTabhost;

    private CartFragment cartFragment;

    private List<Tab> mTabs = new ArrayList<>(5);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initTab();

    }



    private void initTab() {


        Tab tab_home = new Tab(HomeFragment.class,R.string.home,R.mipmap.ic_launcher);
        Tab tab_hot = new Tab(HotFragment.class,R.string.hot,R.mipmap.ic_launcher_round);
        Tab tab_category = new Tab(CategoryFragment.class,R.string.catagory,R.mipmap.ic_launcher);
        Tab tab_cart = new Tab(CartFragment.class,R.string.cart,R.mipmap.ic_launcher_round);
        Tab tab_mine = new Tab(MineFragment.class,R.string.mine,R.mipmap.ic_launcher);

        mTabs.add(tab_home);
        mTabs.add(tab_hot);
        mTabs.add(tab_category);
        mTabs.add(tab_cart);
        mTabs.add(tab_mine);



        mInflater = LayoutInflater.from(this);
        mTabhost = (FragmentTabHost) this.findViewById(android.R.id.tabhost);
        mTabhost.setup(this,getSupportFragmentManager(),R.id.realtabcontent);

        for (Tab tab : mTabs){

            TabHost.TabSpec tabSpec = mTabhost.newTabSpec(getString(tab.getTitle()));

            tabSpec.setIndicator(buildIndicator(tab));

            mTabhost.addTab(tabSpec,tab.getFragment(),null);

        }



        mTabhost.setCurrentTab(0);


    }





    private View buildIndicator(Tab tab){


        View view =mInflater.inflate(R.layout.tab_indicator,null);
        ImageView img = (ImageView) view.findViewById(R.id.icon_tab);
        TextView text = (TextView) view.findViewById(R.id.txt_indicator);

        img.setBackgroundResource(tab.getIcon());
        text.setText(tab.getTitle());

        return  view;
    }


}

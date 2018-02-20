package com.projects.shrungbhatt.photography;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fragments.Fragment_Favourite;
import fragments.Fragment_Home;
import fragments.Fragment_Profile;
import fragments.Fragment_Search;
import model.BaseModel;

/**
 * Created by jigsaw on 18/2/18.
 */

public class Activity_HomeScreen extends BaseActivity implements
        TabLayout.OnTabSelectedListener {


    @BindView(R.id.homescreen_fragment_container)
    FrameLayout homescreenFragmentContainer;

    @BindView(R.id.homescreen_tab_layout)
    TabLayout homescreenTabLayout;
    FragmentManager mFragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);
        ButterKnife.bind(this);

        mFragmentManager = getSupportFragmentManager();

        setUpTabLayout();
    }


    private void setUpTabLayout() {
        homescreenTabLayout.addTab(homescreenTabLayout.newTab().setIcon(R.drawable.home));
        homescreenTabLayout.addTab(homescreenTabLayout.newTab().setIcon(R.drawable.search));
        homescreenTabLayout.addTab(homescreenTabLayout.newTab().setIcon(R.drawable.favourite));
        homescreenTabLayout.addTab(homescreenTabLayout.newTab().setIcon(R.drawable.profile));
        homescreenTabLayout.setOnTabSelectedListener(this);

        mFragmentManager.beginTransaction().replace(R.id.homescreen_fragment_container,
                new Fragment_Home()).commit();
    }


    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        int fragmentContainer = R.id.homescreen_fragment_container;


        switch (tab.getPosition()) {

            case 0:
                mFragmentManager.beginTransaction().replace(fragmentContainer,
                        new Fragment_Home()).commit();
                break;

            case 1:
                mFragmentManager.beginTransaction().replace(fragmentContainer,
                        new Fragment_Search()).commit();
                break;
            case 2:
                mFragmentManager.beginTransaction().replace(fragmentContainer,
                        new Fragment_Favourite()).commit();
                break;

            case 3:
                mFragmentManager.beginTransaction().replace(fragmentContainer,
                        new Fragment_Profile()).commit();
                break;


        }


    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public void handleSuccessData(BaseModel resModel) {

    }

    @Override
    public void handleZeroData(BaseModel reqModel) {

    }
}

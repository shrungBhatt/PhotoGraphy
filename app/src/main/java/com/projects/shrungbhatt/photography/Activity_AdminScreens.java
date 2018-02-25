package com.projects.shrungbhatt.photography;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import fragments.Fragment_AddCategories;
import fragments.Fragment_Inquires;
import fragments.Fragment_Search;
import model.BaseModel;

/**
 * Created by jigsaw on 25/2/18.
 */

public class Activity_AdminScreens extends BaseActivity {

    public static final String EXTRA_FRAGMENT_ID = "fragment_id";

    @BindView(R.id.activity_admin_screens_fragment_container)
    FrameLayout activityAdminScreensFragmentContainer;

    private FragmentManager mFragmentManager;

    public static Intent newIntent(Context context,String fragmentId){
        Intent intent = new Intent(context,Activity_AdminScreens.class);
        intent.putExtra(EXTRA_FRAGMENT_ID,fragmentId);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_screens);
        ButterKnife.bind(this);

        String fragmentId = getIntent().getStringExtra(EXTRA_FRAGMENT_ID);

        mFragmentManager = getSupportFragmentManager();

        inflateFragment(fragmentId);
    }


    private void inflateFragment(String fragmentId){

        int fragmentContainer = R.id.activity_admin_screens_fragment_container;

        switch (fragmentId){

            case "All Photos":
                mFragmentManager.beginTransaction().replace(fragmentContainer,
                        new Fragment_Search()).commit();
                break;

            case "Add Categories":
                mFragmentManager.beginTransaction().replace(fragmentContainer,
                        new Fragment_AddCategories()).commit();
                break;

            case "Inquires":
                mFragmentManager.beginTransaction().replace(fragmentContainer,
                        new Fragment_Inquires()).commit();
                break;

        }

    }

    @Override
    public void handleSuccessData(BaseModel resModel) {

    }

    @Override
    public void handleZeroData(BaseModel reqModel) {

    }
}

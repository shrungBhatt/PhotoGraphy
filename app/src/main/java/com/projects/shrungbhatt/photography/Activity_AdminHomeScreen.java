package com.projects.shrungbhatt.photography;

import android.os.Bundle;
import android.support.annotation.Nullable;

import model.BaseModel;

/**
 * Created by jigsaw on 25/2/18.
 */

public class Activity_AdminHomeScreen extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_homescreen);



    }

    @Override
    public void handleSuccessData(BaseModel resModel) {

    }

    @Override
    public void handleZeroData(BaseModel reqModel) {

    }
}

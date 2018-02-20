package com.projects.shrungbhatt.photography;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import controller.CallBackListner;
import model.BaseModel;

/**
 * Created by admin on 03/01/2018.
 */

public abstract class BaseActivity extends AppCompatActivity implements CallBackListner {
    @Override
    public abstract void handleSuccessData(BaseModel resModel);

    @Override
    public abstract void handleZeroData(BaseModel reqModel);

    @Override
    public void handleErrorDataFromServer(BaseModel errorModel) {

    }

    @Override
    public void networkConnectionError() {

    }

    @Override
    public void handleInvalidData(BaseModel reqModel) {

    }
    public void showToastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
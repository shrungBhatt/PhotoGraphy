package com.projects.shrungbhatt.photography;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import controller.CallBackListner;
import model.BaseModel;
import utils.MySharedPreferences;

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

    public void backPress(View view) {
        onBackPressed();
    }

    private boolean isNetworkAvailableAndConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);

        boolean isNetworkAvailable = cm.getActiveNetworkInfo() != null;

        return isNetworkAvailable &&
                cm.getActiveNetworkInfo().isConnected();
    }

    public void logOut(View view) {

        if(isNetworkAvailableAndConnected()) {
            MySharedPreferences.setStoredLoginStatus(this, false);
            startActivity(new Intent(this, Activity_Login.class));
            Toast.makeText(this, "Logged Out", Toast.LENGTH_SHORT).show();
            finish();
        }else{
            showToastMessage("No Internet Connection");
        }
    }

    public void logOutAdmin(View view){
        if(isNetworkAvailableAndConnected()){
            MySharedPreferences.setStoredLoginStatus(this,false);
            MySharedPreferences.setIsAdminLoggedOn(this,false);
            Intent i = new Intent(this, Activity_Login.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);
            Toast.makeText(this, "Logged Out", Toast.LENGTH_SHORT).show();
            finish();
        }else {
            Toast.makeText(this,"No Internet Connection",Toast.LENGTH_SHORT).show();
        }
    }


}

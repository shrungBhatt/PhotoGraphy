package fragments;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;

import com.projects.shrungbhatt.photography.Activity_Login;

import controller.CallBackListner;
import model.BaseModel;
import utils.MySharedPreferences;

/**
 * Created by admin on 03/01/2018.
 */

public abstract class BaseFragment extends Fragment implements CallBackListner {
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


}

package controller;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.util.Log;
import android.view.Gravity;
import android.view.Window;

import com.google.gson.Gson;
import com.projects.shrungbhatt.photography.BaseActivity;
import com.projects.shrungbhatt.photography.R;

import org.json.JSONException;
import org.json.JSONObject;

import fragments.BaseFragment;
import model.BaseModel;
import model.ErrorModel;
import parser.BaseParser;
import retrofit.APIManager;
import retrofit.RetrofitAdapter;
import utils.MyEnum;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


/**
 * Created by admin on 28/12/2017.
 */

public abstract class BaseController {

    public static final int VALID_CODE = 1;
    public static final int ERROR_CODE = -1;
    public static final int FAILURE_CODE = -2;
    public static final String STATUS = "success";
    public static final String DATA = "data";
    public static String TAG = "BaseController";
    private static String OUTPUT = "OUTPUT";
    protected MyEnum.ShowProgressbar showProgress = MyEnum.ShowProgressbar.show;
    CallBackListner callBackListner;
    RetrofitAdapter retrofitAdapter;
    BaseModel reqModel;
    BaseParser baseParser;
    APIManager apiManager;
    Context context;
    Dialog mProgressDialog;



    Callback<String> callback = new Callback<String>() {
        @Override
        public void success(String responseData, Response response) {
            hideProgressBar();
            Log.e(TAG, "Response: " + responseData);
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put(OUTPUT, new JSONObject(responseData.toString()));
                parseResponse(jsonObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void failure(RetrofitError error) {
            hideProgressBar();
            callBackListner.networkConnectionError();
            Log.e(TAG, "Error " + error.getMessage());
        }
    };

    public void startFetching(CallBackListner callBackListner, BaseModel model) {
        this.callBackListner = callBackListner;
        retrofitAdapter = new RetrofitAdapter();
        if (showProgress == MyEnum.ShowProgressbar.show) {
            showProgressBar();
        }
        apiManager = retrofitAdapter.getApiManager();

    }

    public abstract void onPopulate(JSONObject objJson, BaseParser baseParser);

    private void parseResponse(JSONObject jsonObject) {
        if (jsonObject != null) {
            if (!jsonObject.isNull(OUTPUT)) {
                JSONObject jsonObjectOutput = null;
                try {
                    jsonObjectOutput = jsonObject.getJSONObject(OUTPUT);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (jsonObjectOutput != null) {
                    JSONObject objectData = null;
                    try {
                        objectData = jsonObjectOutput.getJSONObject(DATA);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    onPopulate(objectData, baseParser);
                }
            } else {
                showInvalidData(reqModel);
            }
        }
    }

    private void showErrorFromResponse(JSONObject jsonObject) {
        ErrorModel errorModel;
        Gson gson = new Gson();
        errorModel = gson.fromJson(jsonObject.toString(), ErrorModel.class);
        callBackListner.handleErrorDataFromServer(errorModel);
    }

    protected void showProgressBar() {
        if (callBackListner instanceof BaseActivity) {
            BaseActivity baseActivity = (BaseActivity) callBackListner;
            context = baseActivity.getApplicationContext();
            this.mProgressDialog = new Dialog(baseActivity);
        } else if (callBackListner instanceof BaseFragment) {
            BaseFragment baseFragment = (BaseFragment) callBackListner;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                context = baseFragment.getContext();
                this.mProgressDialog = new Dialog(baseFragment.getActivity());
            }
        }
        mProgressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mProgressDialog.setContentView(R.layout.circleprogress);
        mProgressDialog.setCancelable(false);

        mProgressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        mProgressDialog.getWindow().setGravity(Gravity.CENTER);
        try {
            mProgressDialog.show();
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
    }

    public void hideProgressBar() {
        try {
            if (mProgressDialog != null) {
                if (mProgressDialog.isShowing()) {
                    mProgressDialog.dismiss();
                }
            }
        } catch (Exception e) {
            Log.e("BaseClassForInterface", "Error in hideProgressBar");
        }
    }

    public void showInvalidData(BaseModel reqModel) {
        callBackListner.handleInvalidData(reqModel);
    }
}

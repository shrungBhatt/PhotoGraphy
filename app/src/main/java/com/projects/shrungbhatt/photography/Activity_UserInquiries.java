package com.projects.shrungbhatt.photography;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import adapter.Adapter_UserInquiry;
import butterknife.BindView;
import butterknife.ButterKnife;
import controller.Controller_FetchUserInquires;
import model.BaseModel;
import model.Req_FetchUserInquiries;
import model.Res_Photos;
import utils.MySharedPreferences;

public class Activity_UserInquiries extends BaseActivity {


    @BindView(R.id.activity_user_inquiries_rcv)
    RecyclerView mActivityUserInquiriesRcv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_inquiries);
        ButterKnife.bind(this);



        mActivityUserInquiriesRcv.setLayoutManager(new LinearLayoutManager(this));

        fetchUserInquiries();
    }

    private void fetchUserInquiries(){
        Controller_FetchUserInquires controllerFetchUserInquires = new Controller_FetchUserInquires();
        Req_FetchUserInquiries reqFetchUserInquiries = new Req_FetchUserInquiries();
        reqFetchUserInquiries.setUsername(MySharedPreferences.getStoredUsername(this));
        controllerFetchUserInquires.startFetching(this,reqFetchUserInquiries);
    }

    @Override
    public void handleSuccessData(BaseModel resModel) {

        if(resModel != null){
            if(resModel instanceof Res_Photos){
                Res_Photos res_photos = (Res_Photos) resModel;
                mActivityUserInquiriesRcv.setAdapter(new Adapter_UserInquiry(this,
                        res_photos.getList()));
            }
        }
    }

    @Override
    public void handleZeroData(BaseModel reqModel) {



    }
}

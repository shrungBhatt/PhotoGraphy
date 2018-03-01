package com.projects.shrungbhatt.photography;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fragments.Dialog_Add_Category;
import model.BaseModel;
import model.Res_Result;

/**
 * Created by jigsaw on 25/2/18.
 */

public class Activity_AdminHomeScreen extends BaseActivity {

    @BindView(R.id.admin_all_photos)
    CardView mAdminAllPhotos;
    @BindView(R.id.admin_add_category)
    CardView mAdminAddCategory;
    @BindView(R.id.admin_inquires)
    CardView mAdminInquires;

    Dialog_Add_Category mDialogAddCategory;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_homescreen);
        ButterKnife.bind(this);

        mDialogAddCategory = new Dialog_Add_Category(this);
    }

    @Override
    public void handleSuccessData(BaseModel resModel) {
        if (resModel != null) {
            if (resModel instanceof Res_Result) {
                Res_Result res_result = (Res_Result) resModel;
                if (res_result.getResult().
                        equalsIgnoreCase("Insert Successful")) {
                    Toast.makeText(this, "Successful", Toast.LENGTH_SHORT).show();
                    if(mDialogAddCategory.isShowing()){
                        mDialogAddCategory.dismiss();
                    }

                } else {
                    Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
                }
            }
        }

    }

    @Override
    public void handleZeroData(BaseModel reqModel) {

    }

    @OnClick({R.id.admin_all_photos, R.id.admin_add_category, R.id.admin_inquires})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.admin_all_photos:
                startActivity(Activity_AdminScreens.newIntent(this, "All Photos"));
                break;
            case R.id.admin_add_category:
                mDialogAddCategory.show();

//                startActivity(Activity_AdminScreens.newIntent(this,"Add Categories"));
                break;
            case R.id.admin_inquires:
                startActivity(Activity_AdminScreens.newIntent(this, "Inquires"));
                break;
        }
    }
}

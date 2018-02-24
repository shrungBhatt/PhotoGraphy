package com.projects.shrungbhatt.photography;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import assets_bank.PhotosBank;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import controller.Contoller_AddSaveAndFavrt;
import de.hdodenhof.circleimageview.CircleImageView;
import listeners.Listener_PhotoSelected;
import model.BaseModel;
import model.Req_AddSaveAndFavrt;
import model.Res_Result;
import model.Res_Photos;

/**
 * Created by jigsaw on 20/2/18.
 */

public class Activity_PhotoDetails extends BaseActivity implements Listener_PhotoSelected {

    private static final String EXTRA_ARRAY = "photo_array";
    private static final String EXTRA_POSITION = "array_position";

    @BindView(R.id.photo_detail_img_profile)
    CircleImageView photoDetailImgProfile;
    @BindView(R.id.photo_detail_author)
    TextView photoDetailAuthor;
    @BindView(R.id.photo_detail_image_View)
    ImageView photoDetailImageView;
    @BindView(R.id.photo_details_save_btn)
    ImageView photoDetailsSaveBtn;
    @BindView(R.id.photo_details_favourite)
    ImageView photoDetailsFavourite;
    @BindView(R.id.photo_details_description_tv)
    TextView photoDetailsDescriptionTv;
    @BindView(R.id.photo_detail_photo_name)
    TextView photoDetailPhotoName;

    private PhotosBank photosBank;
    private int mArrayPosition;
    private ArrayList<Res_Photos.List> mPhotosList;

    public static Intent newIntent(Context context, ArrayList<Res_Photos.List> arrayList,
                                   int position) {
        Intent intent = new Intent(context, Activity_PhotoDetails.class);
        intent.putExtra(EXTRA_ARRAY, arrayList);
        intent.putExtra(EXTRA_POSITION, position);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_details);
        ButterKnife.bind(this);

        photosBank = new PhotosBank(this);

        mPhotosList = (ArrayList<Res_Photos.List>) getIntent().getSerializableExtra(EXTRA_ARRAY);
        mArrayPosition = getIntent().getIntExtra(EXTRA_POSITION, 0);

        Bitmap bitmap = photosBank.loadDrawable(mPhotosList.get(mArrayPosition).getPhotoUrl());
        photoDetailImageView.setImageBitmap(bitmap);

        photoDetailAuthor.setText(mPhotosList.get(mArrayPosition).getPhotoAuthor());

        photoDetailPhotoName.setText(mPhotosList.get(mArrayPosition).getPhotoName());


    }


    private void saveAndLikePhoto(String fragmentCallBack){
        Contoller_AddSaveAndFavrt contoller_addSaveAndFavrt = new Contoller_AddSaveAndFavrt();

        Req_AddSaveAndFavrt req_AddSaveAndFavrt = new Req_AddSaveAndFavrt();
        req_AddSaveAndFavrt.setmFragmentCallBack(fragmentCallBack);
        req_AddSaveAndFavrt.setmUserName("shrung");
        req_AddSaveAndFavrt.setmPhotoName(mPhotosList.get(mArrayPosition).getPhotoName());
        req_AddSaveAndFavrt.setmPhotoUrl(mPhotosList.get(mArrayPosition).getPhotoUrl());
        req_AddSaveAndFavrt.setmPhotoDesc(mPhotosList.get(mArrayPosition).getPhotoDescription());
        req_AddSaveAndFavrt.setmPhotoTagged(mPhotosList.get(mArrayPosition).getPhotoTagged());
        req_AddSaveAndFavrt.setmPhotoLikes(mPhotosList.get(mArrayPosition).getPhotoLikes());
        req_AddSaveAndFavrt.setmPhotoCategory(mPhotosList.get(mArrayPosition).getPhotoCategory());
        req_AddSaveAndFavrt.setmPhotoAuthor(mPhotosList.get(mArrayPosition).getPhotoAuthor());
        req_AddSaveAndFavrt.setmPhotoDate(mPhotosList.get(mArrayPosition).getPhotoDate());

        contoller_addSaveAndFavrt.startFetching(this,req_AddSaveAndFavrt);
    }

    @Override
    public void handleSuccessData(BaseModel resModel) {

        if(resModel!=null){
            if(resModel instanceof Res_Result){
                Res_Result res_result = (Res_Result) resModel;
                if(res_result.getResult().
                        equalsIgnoreCase("Insert Successful")){
                    Toast.makeText(this,"Successful",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this,"Something went wrong",Toast.LENGTH_SHORT).show();
                }
            }
        }

    }

    @Override
    public void handleZeroData(BaseModel reqModel) {

    }

    @OnClick({R.id.photo_details_save_btn, R.id.photo_details_favourite})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.photo_details_save_btn:
                saveAndLikePhoto("Save");
                Toast.makeText(this,"Saving Photo...",Toast.LENGTH_SHORT).show();
                break;
            case R.id.photo_details_favourite:
                saveAndLikePhoto("Like");
                Toast.makeText(this,"Saving Photo...",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void photoSelected(ArrayList<Res_Photos.List> arrayList, int position) {

    }
}

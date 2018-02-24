package com.projects.shrungbhatt.photography;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import assets_bank.PhotosBank;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import listeners.Listener_PhotoSelected;
import model.BaseModel;
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

    @Override
    public void handleSuccessData(BaseModel resModel) {

    }

    @Override
    public void handleZeroData(BaseModel reqModel) {

    }

    @OnClick({R.id.photo_details_save_btn, R.id.photo_details_favourite})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.photo_details_save_btn:
                break;
            case R.id.photo_details_favourite:
                break;
        }
    }

    @Override
    public void photoSelected(ArrayList<Res_Photos.List> arrayList, int position) {

    }
}

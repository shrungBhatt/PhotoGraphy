package com.projects.shrungbhatt.photography;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import assets_bank.PhotosBank;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import controller.Controller_AddInquiry;
import model.BaseModel;
import model.Req_AddInquiry;
import model.Res_Photos;
import model.Res_Result;
import utils.Converter;
import utils.MySharedPreferences;

/**
 * Created by jigsaw on 26/2/18.
 */

public class Activity_QuoteInquiry extends BaseActivity implements Validator.ValidationListener{

    private static final String EXTRA_ARRAY = "photo_array";
    private static final String EXTRA_POSITION = "array_position";

    @BindView(R.id.photo_inquiry_image_View)
    ImageView mPhotoInquiryImageView;
    @BindView(R.id.photo_inquiry_photo_name)
    TextView mPhotoInquiryPhotoName;
    @BindView(R.id.photo_inquiry_likes_count)
    TextView mPhotoInquiryLikesCount;

    @NotEmpty
    @BindView(R.id.inquiry_mesasge_edit_text)
    EditText mInquiryMesasgeEditText;
    @BindView(R.id.add_task_fab_button)
    FloatingActionButton mAddTaskFabButton;

    private PhotosBank photosBank;
    private int mArrayPosition;
    private ArrayList<Res_Photos.List> mPhotosList;
    private Validator mValidator;


    public static Intent newIntent(Context context, ArrayList<Res_Photos.List> arrayList,
                                   int position) {
        Intent intent = new Intent(context, Activity_QuoteInquiry.class);
        intent.putExtra(EXTRA_ARRAY, arrayList);
        intent.putExtra(EXTRA_POSITION, position);
        return intent;
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote_inquiry);
        ButterKnife.bind(this);

        photosBank = new PhotosBank(this);

        mValidator = new Validator(this);
        mValidator.setValidationListener(Activity_QuoteInquiry.this);


        mPhotosList = (ArrayList<Res_Photos.List>) getIntent().getSerializableExtra(EXTRA_ARRAY);
        mArrayPosition = getIntent().getIntExtra(EXTRA_POSITION, 0);

        Bitmap bitmap = photosBank.loadDrawable(mPhotosList.get(mArrayPosition).getPhotoUrl());
        mPhotoInquiryImageView.setImageBitmap(bitmap);
        mPhotoInquiryPhotoName.setText(mPhotosList.get(mArrayPosition).getPhotoName());
        mPhotoInquiryLikesCount.setText(Converter.localeConverter(
                Integer.valueOf(mPhotosList.get(mArrayPosition).getPhotoLikes())));

        mAddTaskFabButton.bringToFront();
        mAddTaskFabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mValidator.validate();
            }
        });

    }

    private void addInquiry(){
        Controller_AddInquiry controller_addInquiry = new Controller_AddInquiry();

        Req_AddInquiry req_addInquiry = new Req_AddInquiry();
        req_addInquiry.setInquiryAuthor(MySharedPreferences.getStoredUsername(this));
        req_addInquiry.setPhotoName(mPhotosList.get(mArrayPosition).getPhotoName());
        req_addInquiry.setInquiryMessage(mInquiryMesasgeEditText.getText().toString());
        req_addInquiry.setPhotoUrl(mPhotosList.get(mArrayPosition).getPhotoUrl());
        req_addInquiry.setPhotoDesc(mPhotosList.get(mArrayPosition).getPhotoDescription());
        req_addInquiry.setPhotoTagged(mPhotosList.get(mArrayPosition).getPhotoTagged());
        req_addInquiry.setPhotoLikes(mPhotosList.get(mArrayPosition).getPhotoLikes());
        req_addInquiry.setPhotoCategory(mPhotosList.get(mArrayPosition).getPhotoCategory());
        req_addInquiry.setPhotoAuthor(mPhotosList.get(mArrayPosition).getPhotoAuthor());
        req_addInquiry.setPhotoDate(mPhotosList.get(mArrayPosition).getPhotoDate());
        req_addInquiry.setInquiryDate(String.valueOf(new Date()));

        controller_addInquiry.startFetching(this,req_addInquiry);

    }

    @Override
    public void handleSuccessData(BaseModel resModel) {

        if(resModel != null){
            if(resModel instanceof Res_Result){
                Res_Result res_result = (Res_Result) resModel;
                if (res_result.getResult().
                        equalsIgnoreCase("Insert Successful")) {
                    Toast.makeText(this, "Successful", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
                }


            }
        }

    }

    @Override
    public void handleZeroData(BaseModel reqModel) {

    }

    @OnClick(R.id.add_task_fab_button)
    public void onViewClicked() {

    }

    @Override
    public void onValidationSucceeded() {
        addInquiry();
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {

        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(this);

            // Display error messages ;)
            if (view instanceof EditText) {
                ((EditText) view).setError(message);
            } else {
                Toast.makeText(this, message, Toast.LENGTH_LONG).show();
            }
        }
    }
}

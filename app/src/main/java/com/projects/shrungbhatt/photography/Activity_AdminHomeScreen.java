package com.projects.shrungbhatt.photography;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.util.Base64;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import controller.CallBackListner;
import controller.Controller_AddCategories;
import fragments.Dialog_Add_Category;
import model.BaseModel;
import model.Req_AddCategories;
import model.Res_Result;

/**
 * Created by jigsaw on 25/2/18.
 */

public class Activity_AdminHomeScreen extends BaseActivity implements Validator.ValidationListener {

    private static final int REQUEST_CODE_GALLERY = 101;

    @BindView(R.id.admin_all_photos)
    CardView mAdminAllPhotos;
    @BindView(R.id.admin_inquires)
    CardView mAdminInquires;

    @NotEmpty
    @BindView(R.id.category_name_edtTxt)
    AutoCompleteTextView mCategoryNameEdtTxt;
    @BindView(R.id.add_category_to_server_db)
    Button mAddCategoryToServerDb;
    @BindView(R.id.choose_category_image)
    Button mChooseCategoryImage;


    private String mImage;
    private Validator mValidator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_homescreen);
        ButterKnife.bind(this);

        mValidator = new Validator(this);
        mValidator.setValidationListener(this);
    }

    @Override
    public void handleSuccessData(BaseModel resModel) {
        if (resModel != null) {
            if (resModel instanceof Res_Result) {
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

    @OnClick({R.id.admin_all_photos, R.id.admin_inquires,R.id.add_category_to_server_db, R.id.choose_category_image})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.admin_all_photos:
                startActivity(Activity_AdminScreens.newIntent(this, "All Photos"));
                break;
            case R.id.admin_inquires:
                startActivity(Activity_AdminScreens.newIntent(this, "Inquires"));
                break;
            case R.id.add_category_to_server_db:
                mValidator.validate();
                break;
            case R.id.choose_category_image:
                OpenGallery(REQUEST_CODE_GALLERY);
                break;
        }
    }


    public void OpenGallery(int requestCode) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), requestCode);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            if(requestCode == REQUEST_CODE_GALLERY){
                Uri filePath = data.getData();
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                    setImage(getStringImage(bitmap));
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }

        }
    }

    private void addCategory(String image) {
        Controller_AddCategories controller_addCategories = new Controller_AddCategories();
        Req_AddCategories req_addCategories = new Req_AddCategories();
        req_addCategories.setPhotoCategory(mCategoryNameEdtTxt.getText().toString());
        req_addCategories.setImage(image);
        controller_addCategories.startFetching( this, req_addCategories);

    }

    public String getStringImage(Bitmap bmp){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }

    public String getImage() {
        return mImage;
    }

    public void setImage(String image) {
        mImage = image;
    }

    @Override
    public void onValidationSucceeded() {
        addCategory(getImage());
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

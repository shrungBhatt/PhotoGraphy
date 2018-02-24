package com.projects.shrungbhatt.photography;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import controller.Controller_LogOnUser;
import model.BaseModel;
import model.Req_LogOnUser;
import model.Res_Result;
import utils.MySharedPreferences;

/**
 * Created by jigsaw on 12/2/18.
 */

public class Activity_Login extends BaseActivity implements Validator.ValidationListener {


    private static final int REQUEST_SIGNUP = 1001;
    @NotEmpty
    @BindView(R.id.user_email)
    AutoCompleteTextView userEmail;
    @NotEmpty
    @BindView(R.id.user_password)
    EditText userPassword;
    @BindView(R.id.email_sign_in_button)
    Button emailSignInButton;
    @BindView(R.id.user_sign_up_button)
    Button userSignUpButton;

    public static Boolean mActive;
    public static Activity mActivity;
    Validator mValidator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        mActivity = this;

        //To check whether the user is logged in or not.
        boolean status = MySharedPreferences.getStoredLoginStatus(this);
        if (status) {
            Intent i;
            i = new Intent(this, Activity_HomeScreen.class);

            startActivity(i);
        }

        mValidator = new Validator(this);
        mValidator.setValidationListener(this);
    }

    @OnClick({R.id.email_sign_in_button, R.id.user_sign_up_button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.email_sign_in_button:
                mValidator.validate();
                break;
            case R.id.user_sign_up_button:
                startActivityForResult(new Intent(this, Activity_Signup.class),
                        REQUEST_SIGNUP);
                break;
        }
    }


    @Override
    public void onValidationSucceeded() {
        logonUser();

    }

    private void logonUser() {
        Controller_LogOnUser controller_logOnUser = new Controller_LogOnUser();
        Req_LogOnUser req_logOnUser = new Req_LogOnUser();
        req_logOnUser.setmUserName(userEmail.getText().toString());
        req_logOnUser.setmPassword(userPassword.getText().toString());

        controller_logOnUser.startFetching(this, req_logOnUser);
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

    @Override
    public void handleSuccessData(BaseModel resModel) {
        if (resModel != null) {
            if (resModel instanceof Res_Result) {
                Res_Result res_result = (Res_Result) resModel;
                if (res_result.getResult().equalsIgnoreCase("Success")) {
                    MySharedPreferences.setStoredUsername(this, userEmail.getText().toString());
                    MySharedPreferences.setStoredLoginStatus(this, true);
                    startActivity(new Intent(this, Activity_HomeScreen.class));
                    finish();
                }else{
                    Toast.makeText(this,res_result.getResult(),Toast.LENGTH_SHORT).show();
                }
            }
        }


    }

    @Override
    public void handleZeroData(BaseModel reqModel) {

    }

    @Override
    public void onStart() {
        super.onStart();
        mActive = true;
    }

    @Override
    public void onStop() {
        super.onStop();
        mActive = false;
    }
}

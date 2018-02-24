package com.projects.shrungbhatt.photography;

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
import model.BaseModel;

/**
 * Created by jigsaw on 12/2/18.
 */

public class Activity_Login extends BaseActivity implements Validator.ValidationListener {


    private static final int REQUEST_SIGNUP = 1001;
    @NotEmpty
    @Email
    @BindView(R.id.user_email)
    AutoCompleteTextView userEmail;
    @NotEmpty
    @Password(min = 6, scheme = Password.Scheme.ANY)
    @BindView(R.id.user_password)
    EditText userPassword;
    @BindView(R.id.email_sign_in_button)
    Button emailSignInButton;
    @BindView(R.id.user_sign_up_button)
    Button userSignUpButton;

    Validator mValidator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

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
                startActivityForResult(new Intent(this,Activity_Signup.class),
                        REQUEST_SIGNUP);
                break;
        }
    }

    @Override
    public void onValidationSucceeded() {
        Toast.makeText(this, "Yay! we got it right!", Toast.LENGTH_SHORT).show();

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

    }

    @Override
    public void handleZeroData(BaseModel reqModel) {

    }
}

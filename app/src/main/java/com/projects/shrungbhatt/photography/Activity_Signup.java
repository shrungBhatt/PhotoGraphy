package com.projects.shrungbhatt.photography;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.ConfirmPassword;
import com.mobsandgeeks.saripaar.annotation.Digits;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.Length;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Activity_Signup extends AppCompatActivity implements Validator.ValidationListener {

    @NotEmpty
    @BindView(R.id.signup_user_name_edtTxt)
    AutoCompleteTextView signupUserNameEdtTxt;

    @NotEmpty
    @Email
    @BindView(R.id.signup_user_email_edtTxt)
    AutoCompleteTextView signupUserEmailEdtTxt;

    @NotEmpty
    @Password(min = 6, scheme = Password.Scheme.ANY)
    @BindView(R.id.signup_password_edtTxt)
    AutoCompleteTextView signupPasswordEdtTxt;

    @NotEmpty
    @ConfirmPassword
    @BindView(R.id.signup_retype_password_edtTxt)
    AutoCompleteTextView signupRetypePasswordEdtTxt;

    @NotEmpty
    @Length(max = 10,message = "Enter valid number")
    @BindView(R.id.signup_phone_no_edtTxt)
    AutoCompleteTextView signupPhoneNoEdtTxt;

    @BindView(R.id.signup_select_gender_spinner)
    Spinner signupSelectGenderSpinner;
    @BindView(R.id.signup_dob_button)
    Button signupDobButton;
    @BindView(R.id.signup_button)
    Button signupButton;

    Validator mValidator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);

        mValidator = new Validator(this);
        mValidator.setValidationListener(this);
    }

    @OnClick({R.id.signup_dob_button, R.id.signup_button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.signup_dob_button:
                break;
            case R.id.signup_button:
                mValidator.validate();
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
}

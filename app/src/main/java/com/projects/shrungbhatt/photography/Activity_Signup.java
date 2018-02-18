package com.projects.shrungbhatt.photography;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Activity_Signup extends AppCompatActivity {

    @BindView(R.id.signup_user_name_edtTxt)
    AutoCompleteTextView signupUserNameEdtTxt;
    @BindView(R.id.signup_user_email_edtTxt)
    AutoCompleteTextView signupUserEmailEdtTxt;
    @BindView(R.id.signup_password_edtTxt)
    AutoCompleteTextView signupPasswordEdtTxt;
    @BindView(R.id.signup_retype_password_edtTxt)
    AutoCompleteTextView signupRetypePasswordEdtTxt;
    @BindView(R.id.signup_phone_no_edtTxt)
    AutoCompleteTextView signupPhoneNoEdtTxt;
    @BindView(R.id.signup_select_gender_spinner)
    Spinner signupSelectGenderSpinner;
    @BindView(R.id.signup_dob_button)
    Button signupDobButton;
    @BindView(R.id.signup_button)
    Button signupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.signup_dob_button, R.id.signup_button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.signup_dob_button:
                break;
            case R.id.signup_button:
                break;
        }
    }
}

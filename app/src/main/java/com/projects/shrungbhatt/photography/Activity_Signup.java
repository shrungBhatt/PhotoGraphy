package com.projects.shrungbhatt.photography;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Checked;
import com.mobsandgeeks.saripaar.annotation.ConfirmPassword;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.Length;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import controller.Controller_RegisterUser;
import model.BaseModel;
import model.Req_RegisterUser;
import model.Res_Result;
import utils.Const;

public class Activity_Signup extends BaseActivity implements Validator.ValidationListener,
        AdapterView.OnItemSelectedListener {

    private static final int REQUEST_DATE = 0;
    private static final String DIALOG_DATE = "dialog_date";

    @BindView(R.id.sign_up_as_photographer)
    CheckBox mSignUpAsPhotographer;
    private int mYear, mMonth, mDay;
    Calendar calender;

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
    @Length(max = 10, message = "Enter valid number")
    @BindView(R.id.signup_phone_no_edtTxt)
    AutoCompleteTextView signupPhoneNoEdtTxt;

    @BindView(R.id.signup_select_gender_spinner)
    Spinner signupSelectGenderSpinner;
    @BindView(R.id.signup_dob_button)
    Button signupDobButton;
    @BindView(R.id.signup_button)
    Button signupButton;

    Validator mValidator;
    private String mGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);

        mValidator = new Validator(this);
        mValidator.setValidationListener(this);

        setAdapter(R.array.type_of_gender, signupSelectGenderSpinner);

    }

    @OnClick({R.id.signup_dob_button, R.id.signup_button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.signup_dob_button:
                datePickerDialog();
                break;
            case R.id.signup_button:
                mValidator.validate();
                break;
        }
    }

    private void datePickerDialog() {
        calender = Calendar.getInstance();
        mYear = calender.get(Calendar.YEAR);
        mMonth = calender.get(Calendar.MONTH);
        mDay = calender.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                signupDobButton.setText(formatDate(year, month, dayOfMonth));
            }
        }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    public static String formatDate(int year, int month, int day) {

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(0);
        cal.set(year, month, day);
        Date date = cal.getTime();

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        return sdf.format(date);
    }

    @Override
    public void onValidationSucceeded() {

        if(mSignUpAsPhotographer.isChecked()){
            registerUser(Const.USER_TYPE_PHOTOGRAPHER);
        }else{
            registerUser(Const.USER_TYPE_USER);
        }

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

    private void setAdapter(int id, Spinner spinner) {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                id, R.layout.simple_spinner_layout);
        adapter.setDropDownViewResource(R.layout.spinner_layout);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    private void registerUser(String userType) {
        Controller_RegisterUser controller_registerUser = new Controller_RegisterUser();
        Req_RegisterUser req_registerUser = new Req_RegisterUser();
        req_registerUser.setmUsername(signupUserNameEdtTxt.getText().toString());
        req_registerUser.setmEmailId(signupUserEmailEdtTxt.getText().toString());
        req_registerUser.setmGender(mGender);
        req_registerUser.setUserType(userType);
        req_registerUser.setmPassword(signupPasswordEdtTxt.getText().toString());
        req_registerUser.setmPhoneNo(signupPhoneNoEdtTxt.getText().toString());
        req_registerUser.setmDob(signupDobButton.getText().toString());

        controller_registerUser.startFetching(this, req_registerUser);
    }

    @Override
    public void handleSuccessData(BaseModel resModel) {

        if (resModel != null) {
            if (resModel instanceof Res_Result) {
                Res_Result res_result = (Res_Result) resModel;
                if (res_result.getResult().equalsIgnoreCase("Insert Successful")) {
                    Toast.makeText(this, res_result.getResult(), Toast.LENGTH_SHORT).show();
                    setResult(RESULT_OK);
                    finish();
                } else {
                    Toast.makeText(this, res_result.getResult(), Toast.LENGTH_SHORT).show();
                }
            }
        }

    }

    @Override
    public void handleZeroData(BaseModel reqModel) {

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        mGender = adapterView.getItemAtPosition(i).toString().trim();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

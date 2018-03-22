package fragments;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.view.Window;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.projects.shrungbhatt.photography.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import controller.CallBackListner;
import controller.Controller_AddCategories;
import model.Req_AddCategories;

/**
 * Created by jigsaw on 1/3/18.
 */

public class Dialog_Add_Category extends Dialog implements Validator.ValidationListener {

    @BindView(R.id.close_btn)
    ImageView mCloseBtn;

    @NotEmpty
    @BindView(R.id.category_name_edtTxt)
    AutoCompleteTextView mCategoryNameEdtTxt;

    @BindView(R.id.edt)
    TextInputLayout mEdt;
    @BindView(R.id.add_category_to_server_db)
    Button mAddCategoryToServerDb;
    @BindView(R.id.choose_category_image)
    Button mChooseCategoryImage;
    private Context mContext;
    private Validator mValidator;

    public Dialog_Add_Category(@NonNull Context context) {
        super(context);

        mContext = context;


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_add_category);
        ButterKnife.bind(this);

        mValidator = new Validator(this);
        mValidator.setValidationListener(this);
    }




    @OnClick({R.id.close_btn, R.id.add_category_to_server_db,R.id.choose_category_image})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.close_btn:
                dismiss();
                break;
            case R.id.add_category_to_server_db:
                mValidator.validate();
                break;
            case R.id.choose_category_image:
                break;
        }
    }

    @Override
    public void onValidationSucceeded() {
//        addCategory();
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {


    }


}

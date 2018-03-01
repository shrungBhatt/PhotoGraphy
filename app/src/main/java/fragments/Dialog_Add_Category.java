package fragments;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.view.Window;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;

import com.projects.shrungbhatt.photography.R;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by jigsaw on 1/3/18.
 */

public class Dialog_Add_Category extends Dialog {

    @BindView(R.id.close_btn)
    ImageView mCloseBtn;
    @BindView(R.id.category_name_edtTxt)
    AutoCompleteTextView mCategoryNameEdtTxt;
    @BindView(R.id.edt)
    TextInputLayout mEdt;
    @BindView(R.id.add_category_to_server_db)
    TextView mAddCategoryToServerDb;

    public Dialog_Add_Category(@NonNull Context context, String recipeName) {
        super(context);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_add_category);
    }


    private void addCategory(){

    }

    @OnClick({R.id.close_btn, R.id.category_name_edtTxt, R.id.add_category_to_server_db})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.close_btn:
                dismiss();
                break;
            case R.id.category_name_edtTxt:
                break;
            case R.id.add_category_to_server_db:
                addCategory();
                break;
        }
    }
}

package com.projects.shrungbhatt.photography;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import model.BaseModel;

/**
 * Created by jigsaw on 26/2/18.
 */

public class Activity_QuoteInquiry extends BaseActivity {

    @BindView(R.id.photo_inquiry_image_View)
    ImageView mPhotoInquiryImageView;
    @BindView(R.id.photo_inquiry_photo_name)
    TextView mPhotoInquiryPhotoName;
    @BindView(R.id.photo_inquiry_likes_count)
    TextView mPhotoInquiryLikesCount;
    @BindView(R.id.inquiry_mesasge_edit_text)
    EditText mInquiryMesasgeEditText;
    @BindView(R.id.add_task_fab_button)
    FloatingActionButton mAddTaskFabButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote_inquiry);
        ButterKnife.bind(this);
    }

    @Override
    public void handleSuccessData(BaseModel resModel) {

    }

    @Override
    public void handleZeroData(BaseModel reqModel) {

    }

    @OnClick(R.id.add_task_fab_button)
    public void onViewClicked() {
    }
}

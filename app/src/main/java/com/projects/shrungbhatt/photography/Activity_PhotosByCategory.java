package com.projects.shrungbhatt.photography;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import adapter.Adapter_PhotoView;
import butterknife.BindView;
import butterknife.ButterKnife;
import controller.Controller_FetchPhotoByCategory;
import model.BaseModel;
import model.Req_FetchPhotoByCategory;
import model.Res_Photos;
import utils.ItemDecorationAlbumColumns;


public class Activity_PhotosByCategory extends BaseActivity {

    private static final String EXTRA_CATEGORY = "photo_category";

    @BindView(R.id.favourite_recyclerview)
    RecyclerView categoryRecyclerView;

    private String mCategory;

    public static Intent newIntent(Context context,String category){
        Intent intent = new Intent(context,Activity_PhotosByCategory.class);
        intent.putExtra(EXTRA_CATEGORY,category);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_favourite);
        ButterKnife.bind(this);

        mCategory = getIntent().getStringExtra(EXTRA_CATEGORY);

        categoryRecyclerView.setLayoutManager(new GridLayoutManager(this,3));
        categoryRecyclerView.addItemDecoration(new ItemDecorationAlbumColumns(1,3));

        fetchByCategories(mCategory);

    }

    private void fetchByCategories(String category){
        Controller_FetchPhotoByCategory controller_fetchPhotoByCategory = new
                Controller_FetchPhotoByCategory();
        Req_FetchPhotoByCategory req_fetchPhotoByCategory = new Req_FetchPhotoByCategory();

        req_fetchPhotoByCategory.setmCategory(category);
        controller_fetchPhotoByCategory.startFetching(this,req_fetchPhotoByCategory);

    }

    @Override
    public void handleSuccessData(BaseModel resModel) {
        if(resModel != null){
            if(resModel instanceof Res_Photos){
                Res_Photos res_photos = (Res_Photos) resModel;
                categoryRecyclerView.setAdapter(new Adapter_PhotoView(this,
                        res_photos.getList()));
            }
        }

    }

    @Override
    public void handleZeroData(BaseModel reqModel) {

    }
}

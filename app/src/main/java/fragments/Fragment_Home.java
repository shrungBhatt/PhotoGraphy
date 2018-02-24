package fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.projects.shrungbhatt.photography.Activity_Login;
import com.projects.shrungbhatt.photography.R;

import adapter.Adapter_CategoriesRecyclerView;
import assets_bank.CategoriesBank;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import controller.Controller_FetchPhotoCategories;
import model.BaseModel;
import model.Req_PhotoCategories;
import model.Res_PhotoCategories;
import utils.MySharedPreferences;

/**
 * Created by jigsaw on 18/2/18.
 */

public class Fragment_Home extends BaseFragment {

    @BindView(R.id.home_recycler_view)
    RecyclerView homeRecyclerView;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, v);

        fetchCategories();

        return v;
    }




    private void fetchCategories(){
        Controller_FetchPhotoCategories controller_fetchPhotoCategories = new
                Controller_FetchPhotoCategories();
        Req_PhotoCategories req_photoCategories = new Req_PhotoCategories();
        controller_fetchPhotoCategories.startFetching(this,req_photoCategories);

    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void handleSuccessData(BaseModel resModel) {

        if(resModel != null){
            if(resModel instanceof Res_PhotoCategories){
                Res_PhotoCategories res_photoCategories = (Res_PhotoCategories) resModel;
                homeRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
                homeRecyclerView.setAdapter(new Adapter_CategoriesRecyclerView(getActivity(),
                        res_photoCategories.getList()));
            }
        }

    }

    @Override
    public void handleZeroData(BaseModel reqModel) {

    }



}

package fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.projects.shrungbhatt.photography.R;

import adapter.Adapter_PhotoView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import controller.Controller_PhotosSavedAndFavrt;
import model.BaseModel;
import model.Req_PhotosSavedAndFavrt;
import model.Res_Photos;
import utils.ItemDecorationAlbumColumns;
import utils.MySharedPreferences;

/**
 * Created by jigsaw on 18/2/18.
 */

public class Fragment_Favourite extends BaseFragment {


    @BindView(R.id.favourite_recyclerview)
    RecyclerView favouriteRecyclerview;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_favourite, container, false);


        unbinder = ButterKnife.bind(this, v);

        setUpRecyclerView();

        fetchFavouritePhotos(MySharedPreferences.getStoredUsername(getActivity()));

        return v;
    }

    private void setUpRecyclerView() {
        favouriteRecyclerview.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        favouriteRecyclerview.addItemDecoration(new ItemDecorationAlbumColumns(1, 3));
    }

    private void fetchFavouritePhotos(String userName) {
        Controller_PhotosSavedAndFavrt controller_photosSavedAndFavrt = new Controller_PhotosSavedAndFavrt();
        Req_PhotosSavedAndFavrt req_photosSavedAndFavrt = new Req_PhotosSavedAndFavrt();
        req_photosSavedAndFavrt.setmFragmentCallBack("Favourite");
        req_photosSavedAndFavrt.setmUserName(userName);
        controller_photosSavedAndFavrt.startFetching(this, req_photosSavedAndFavrt);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void handleSuccessData(BaseModel resModel) {

        if (resModel != null) {
            if (resModel instanceof Res_Photos) {
                Res_Photos res_photosSavedAndFavrt = (Res_Photos) resModel;
                favouriteRecyclerview.setAdapter(new
                        Adapter_PhotoView(getActivity(), res_photosSavedAndFavrt.getList()));


            }

        }

    }

    @Override
    public void handleZeroData(BaseModel reqModel) {

    }
}

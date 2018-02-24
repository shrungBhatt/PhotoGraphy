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
import android.widget.TextView;

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

/**
 * Created by jigsaw on 18/2/18.
 */

public class Fragment_Saved extends BaseFragment {


    @BindView(R.id.profile_saved_recycler_view)
    RecyclerView profileSavedRecyclerView;
    @BindView(R.id.no_saved_photos_tv)
    TextView noSavedPhotosTv;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_saved, container, false);
        unbinder = ButterKnife.bind(this, v);

        setUpRecyclerView();

        fetchSavedPhotos("shrung");

        return v;
    }

    private void setUpRecyclerView() {
        profileSavedRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));
        profileSavedRecyclerView.addItemDecoration(new ItemDecorationAlbumColumns(1,3));
    }

    private void fetchSavedPhotos(String userName){
        Controller_PhotosSavedAndFavrt controller_photosSavedAndFavrt = new Controller_PhotosSavedAndFavrt();
        Req_PhotosSavedAndFavrt req_photosSavedAndFavrt = new Req_PhotosSavedAndFavrt();
        req_photosSavedAndFavrt.setmFragmentCallBack("Saved");
        req_photosSavedAndFavrt.setmUserName(userName);
        controller_photosSavedAndFavrt.startFetching(this,req_photosSavedAndFavrt);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void handleSuccessData(BaseModel resModel) {

        if (resModel != null) {
            if(resModel instanceof Res_Photos){
                Res_Photos res_photosSavedAndFavrt = (Res_Photos) resModel;
                profileSavedRecyclerView.setAdapter(new Adapter_PhotoView(getActivity(),res_photosSavedAndFavrt.getList()));


            }

        }

    }

    @Override
    public void handleZeroData(BaseModel reqModel) {

    }
}

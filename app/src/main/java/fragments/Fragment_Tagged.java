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
import controller.Controller_FetchTaggedPhotos;
import model.BaseModel;
import model.Req_PhotosTagged;
import model.Res_Photos;
import utils.ItemDecorationAlbumColumns;

/**
 * Created by jigsaw on 18/2/18.
 */

public class Fragment_Tagged extends BaseFragment {


    @BindView(R.id.profile_tagged_recycler_view)
    RecyclerView profileTaggedRecyclerView;
    @BindView(R.id.no_tagged_photos_tv)
    TextView noTaggedPhotosTv;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tagged, container, false);
        unbinder = ButterKnife.bind(this, v);


        fetchTaggedPhotos();

        return v;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    private void fetchTaggedPhotos(){
        Controller_FetchTaggedPhotos controller_fetchTaggedPhotos = new
                Controller_FetchTaggedPhotos();
        Req_PhotosTagged req_photosTagged = new Req_PhotosTagged();
        req_photosTagged.setmUserName("shrung");
        controller_fetchTaggedPhotos.startFetching(this,req_photosTagged);
    }

    @Override
    public void handleSuccessData(BaseModel resModel) {

        if(resModel != null){
            if(resModel instanceof Res_Photos){
                Res_Photos res_photos = (Res_Photos) resModel;
                profileTaggedRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));
                profileTaggedRecyclerView.addItemDecoration(new ItemDecorationAlbumColumns(1,3));
                profileTaggedRecyclerView.setAdapter(new Adapter_PhotoView(getActivity(),res_photos.getList()));
            }
        }

    }

    @Override
    public void handleZeroData(BaseModel reqModel) {

    }
}

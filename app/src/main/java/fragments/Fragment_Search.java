package fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.projects.shrungbhatt.photography.R;

import adapter.Adapter_PhotoView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import controller.Controller_FetchPhotosByQuery;
import model.BaseModel;
import model.Req_PhotosByQuery;
import model.Res_Photos;
import utils.ItemDecorationAlbumColumns;

/**
 * Created by jigsaw on 18/2/18.
 */

public class Fragment_Search extends BaseFragment {

    @BindView(R.id.search_fragment_searchview)
    SearchView searchFragmentSearchview;
    @BindView(R.id.search_recyclerview)
    RecyclerView searchRecyclerview;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_search, container, false);

        unbinder = ButterKnife.bind(this, v);

        fetchPhotos(",");
        searchFragmentSearchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                fetchPhotos(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String query) {
//                fetchPhotos(query);
                return true;
            }


        });

        return v;
    }


    private void fetchPhotos(String query){
        Controller_FetchPhotosByQuery controller_fetchPhotosByQuery = new
                Controller_FetchPhotosByQuery();
        Req_PhotosByQuery req_photosByQuery = new Req_PhotosByQuery();
        req_photosByQuery.setmQuery(query);
        controller_fetchPhotosByQuery.startFetching(this,req_photosByQuery);

    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void handleSuccessData(BaseModel resModel) {
        if(resModel != null){
            if(resModel instanceof Res_Photos){
                Res_Photos res_photos = (Res_Photos) resModel;
                searchRecyclerview.setLayoutManager(new GridLayoutManager(getActivity(),3));
                searchRecyclerview.addItemDecoration(new ItemDecorationAlbumColumns(1,3));
                searchRecyclerview.setAdapter(new Adapter_PhotoView(getActivity(),
                        res_photos.getList()));
            }
        }

    }

    @Override
    public void handleZeroData(BaseModel reqModel) {

    }
}

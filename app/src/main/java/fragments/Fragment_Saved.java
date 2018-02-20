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
import model.BaseModel;
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

        return v;
    }

    private void setUpRecyclerView() {
        profileSavedRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));
        profileSavedRecyclerView.addItemDecoration(new ItemDecorationAlbumColumns(1,3));
//        profileSavedRecyclerView.setAdapter(new Adapter_PhotoView(getActivity()));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void handleSuccessData(BaseModel resModel) {

    }

    @Override
    public void handleZeroData(BaseModel reqModel) {

    }
}

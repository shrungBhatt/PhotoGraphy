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
import android.widget.SearchView;

import com.projects.shrungbhatt.photography.R;

import adapter.Adapter_PhotoView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import utils.ItemDecorationAlbumColumns;

/**
 * Created by jigsaw on 18/2/18.
 */

public class Fragment_Search extends Fragment {

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

        setUpRecyclerView();
        return v;
    }

    private void setUpRecyclerView(){
        searchRecyclerview.setLayoutManager(new GridLayoutManager(getActivity(),3));
        searchRecyclerview.addItemDecoration(new ItemDecorationAlbumColumns(1,3));
        searchRecyclerview.setAdapter(new Adapter_PhotoView(getActivity()));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

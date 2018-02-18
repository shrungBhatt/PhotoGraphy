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

import adapter.Adapter_CategoriesRecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by jigsaw on 18/2/18.
 */

public class Fragment_Home extends Fragment {

    @BindView(R.id.home_recycler_view)
    RecyclerView homeRecyclerView;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, v);

        setUpRecyclerView();

        return v;
    }


    private void setUpRecyclerView(){
        homeRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        homeRecyclerView.setAdapter(new Adapter_CategoriesRecyclerView(getActivity()));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

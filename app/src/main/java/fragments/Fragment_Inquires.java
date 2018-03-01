package fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.projects.shrungbhatt.photography.R;

import adapter.Adapter_Inquiry;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import controller.Controller_FetchInquires;
import model.BaseModel;
import model.Req_Inquires;
import model.Res_Photos;

/**
 * Created by jigsaw on 25/2/18.
 */

public class Fragment_Inquires extends BaseFragment {


    @BindView(R.id.inquires_recycler_view)
    RecyclerView mInquiresRecyclerView;
    Unbinder unbinder;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_inquires, container, false);
        unbinder = ButterKnife.bind(this, v);

        mInquiresRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        fetchInquires();





        return v;
    }

    private void fetchInquires() {
        Controller_FetchInquires controller_fetchInquires = new Controller_FetchInquires();
        Req_Inquires req_inquires = new Req_Inquires();
        controller_fetchInquires.startFetching(this, req_inquires);
    }

    @Override
    public void handleSuccessData(BaseModel resModel) {

        if (resModel != null) {
            if (resModel instanceof Res_Photos) {
                Res_Photos res_photos = (Res_Photos) resModel;
                mInquiresRecyclerView.setAdapter(new Adapter_Inquiry(getActivity(),
                        res_photos.getList()));
            }
        }

    }

    @Override
    public void handleZeroData(BaseModel reqModel) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

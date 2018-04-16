package fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.projects.shrungbhatt.photography.R;

import adapter.Adapter_Inquiry;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import controller.Controller_FetchInquires;
import controller.Controller_SubmitInquiryReply;
import listeners.Listener_ReplySend;
import model.BaseModel;
import model.Req_Inquires;
import model.Req_SubmitInquiryReply;
import model.Res_Photos;
import model.Res_Result;
import utils.MySharedPreferences;

/**
 * Created by jigsaw on 25/2/18.
 */

public class Fragment_Inquires extends BaseFragment implements Listener_ReplySend{


    @BindView(R.id.inquires_recycler_view)
    RecyclerView mInquiresRecyclerView;
    Unbinder unbinder;
    private Res_Photos mResPhotos;


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
                mResPhotos = res_photos;
                mInquiresRecyclerView.setAdapter(new Adapter_Inquiry(getActivity(),
                        res_photos.getList(),this));
            }else if(resModel instanceof Res_Result){
                Res_Result resResult = (Res_Result) resModel;

                if(resResult.getResult().equalsIgnoreCase("Reply sent")){
                    Toast.makeText(getActivity(),resResult.getResult(),Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getActivity(),"Something went wrong",Toast.LENGTH_SHORT).show();
                }
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

    @Override
    public void sendReply(int position, String reply) {
        submitReply(reply,position);
    }

    private void submitReply(String reply,int position){
        Controller_SubmitInquiryReply controllerSubmitInquiryReply =
                new Controller_SubmitInquiryReply();

        Req_SubmitInquiryReply reqSubmitInquiryReply = new Req_SubmitInquiryReply();
        reqSubmitInquiryReply.setReply(reply);
        reqSubmitInquiryReply.setId(mResPhotos.getList().get(position).getId());
        reqSubmitInquiryReply.setReplyAuthor(MySharedPreferences.getStoredUsername(getActivity()));
        controllerSubmitInquiryReply.startFetching(this,reqSubmitInquiryReply);
    }
}

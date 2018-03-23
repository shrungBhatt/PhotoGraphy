package adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.projects.shrungbhatt.photography.R;

import java.util.ArrayList;

import assets_bank.PhotosBank;
import butterknife.BindView;
import model.Res_Photos;
import utils.Converter;

/**
 * Created by jigsaw on 1/3/18.
 */

public class Adapter_Inquiry extends RecyclerView.Adapter<Adapter_Inquiry.Inquiry_ViewHolder> {


    private Context mContext;
    private ArrayList<Res_Photos.List> mInquiriesList;
    private PhotosBank photosBank;

    public Adapter_Inquiry(Context context, ArrayList<Res_Photos.List> list){
        mContext = context;
        mInquiriesList = list;
        photosBank = new PhotosBank(context);
    }




    @Override
    public Inquiry_ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        return new Inquiry_ViewHolder(inflater,parent);
    }

    @Override
    public void onBindViewHolder(Inquiry_ViewHolder holder, int position) {

        Bitmap bitmap = photosBank.loadDrawable(mInquiriesList.get(position).getPhotoUrl());

        holder.mPhotoInquiryListItemImageView.setImageBitmap(bitmap);
        holder.mListItemInquiryTv.setText(mInquiriesList.get(position).getInquiryMessage());
        holder.mListItemLikesCount.setText(Converter.
                localeConverter(Integer.valueOf(mInquiriesList.get(position).getPhotoLikes())));
        holder.mPhotoNameTv.setText(mInquiriesList.get(position).getPhotoName());
        holder.mInquiryAuthor.setText(mInquiriesList.get(position).getInquiryAuthor());


    }

    @Override
    public int getItemCount() {
        return mInquiriesList.size();
    }

    class Inquiry_ViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.photo_inquiry_list_item_image_view)
        ImageView mPhotoInquiryListItemImageView;
        @BindView(R.id.photo_name_list_item_textView)
        TextView mPhotoNameTv;
        @BindView(R.id.list_item_likes_count)
        TextView mListItemLikesCount;
        @BindView(R.id.list_item_inquiry_tv)
        TextView mListItemInquiryTv;
        TextView mInquiryAuthor;

        Inquiry_ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.inquires_list_item, parent, false));


            mPhotoInquiryListItemImageView = itemView.findViewById(R.id.photo_inquiry_list_item_image_view);

            mPhotoNameTv = itemView.findViewById(R.id.photo_name_list_item_textView);

            mListItemLikesCount = itemView.findViewById(R.id.list_item_likes_count);

            mListItemInquiryTv = itemView.findViewById(R.id.list_item_inquiry_tv);

            mInquiryAuthor= itemView.findViewById(R.id.inquiry_from_list_item_textView);


        }


    }

}

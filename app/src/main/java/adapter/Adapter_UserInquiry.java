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
import java.util.Collections;

import assets_bank.PhotosBank;
import listeners.Listener_ReplySend;
import model.Res_Photos;
import utils.Converter;

/**
 * Created by jigsaw on 1/3/18.
 */

public class Adapter_UserInquiry extends RecyclerView.Adapter<Adapter_UserInquiry.Inquiry_ViewHolder> {


    private Context mContext;
    private ArrayList<Res_Photos.List> mInquiriesList;
    private PhotosBank photosBank;

    public Adapter_UserInquiry(Context context, ArrayList<Res_Photos.List> list){
        mContext = context;
        mInquiriesList = list;
        photosBank = new PhotosBank(context);
        if(mInquiriesList != null) {
            Collections.reverse(mInquiriesList);
        }
    }




    @Override
    public Inquiry_ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        return new Inquiry_ViewHolder(inflater,parent);
    }

    @Override
    public void onBindViewHolder(final Inquiry_ViewHolder holder, final int position) {

        Bitmap bitmap = photosBank.loadDrawable(mInquiriesList.get(position).getPhotoUrl());

        holder.mPhotoInquiryListItemImageView.setImageBitmap(bitmap);
        holder.mListItemLikesCount.setText(Converter.
                localeConverter(Integer.valueOf(mInquiriesList.get(position).getPhotoLikes())));
        holder.mPhotoNameTv.setText(mInquiriesList.get(position).getPhotoName());
        holder.mInquiryReplyAuthor.setText(mInquiriesList.get(position).getReplyAuthor());
        holder.mInquiryReplyMessage.setText(mInquiriesList.get(position).getInquiryReply());


    }

    @Override
    public int getItemCount() {
        return mInquiriesList.size();
    }

    class Inquiry_ViewHolder extends RecyclerView.ViewHolder {


        ImageView mPhotoInquiryListItemImageView;
        TextView mPhotoNameTv;
        TextView mListItemLikesCount;
        TextView mInquiryReplyAuthor;
        TextView mInquiryReplyMessage;


        Inquiry_ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.user_inquires_list_item, parent, false));


            mPhotoInquiryListItemImageView = itemView.findViewById(R.id.photo_inquiry_list_item_image_view);

            mPhotoNameTv = itemView.findViewById(R.id.photo_name_list_item_textView);

            mListItemLikesCount = itemView.findViewById(R.id.list_item_likes_count);

            mInquiryReplyMessage = itemView.findViewById(R.id.inquiry_message_list_item_textView);

            mInquiryReplyAuthor = itemView.findViewById(R.id.inquiry_from_list_item_textView);



        }


    }

}

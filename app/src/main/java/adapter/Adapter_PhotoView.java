package adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.projects.shrungbhatt.photography.Activity_PhotoDetails;
import com.projects.shrungbhatt.photography.R;

import java.util.ArrayList;

import assets_bank.PhotosBank;
import model.Res_Photos;

/**
 * Created by jigsaw on 18/2/18.
 */

public class Adapter_PhotoView extends RecyclerView.Adapter<Adapter_PhotoView.PhotoHolder>{

    private Context mContext;
    private ArrayList<Res_Photos.List> mPhotosList;
    private PhotosBank photosBank;

    public Adapter_PhotoView(Context context,ArrayList<Res_Photos.List> photosList){
        mContext = context;
        mPhotosList = photosList;
        photosBank = new PhotosBank(context);
    }

    @Override
    public PhotoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        return new PhotoHolder(inflater,parent);
    }

    @Override
    public void onBindViewHolder(PhotoHolder holder, final int position) {

        Bitmap bitmap = photosBank.loadDrawable(mPhotosList.get(position).getPhotoUrl());
        holder.mPhoto.setImageBitmap(bitmap);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mContext.startActivity(Activity_PhotoDetails.newIntent(mContext,
                        mPhotosList,position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return mPhotosList.size();
    }

    class PhotoHolder extends RecyclerView.ViewHolder{

        private ImageView mPhoto;

        PhotoHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.list_item_photo,parent,false));

            mPhoto = itemView.findViewById(R.id.list_item_photo_image_view);

        }
    }
}

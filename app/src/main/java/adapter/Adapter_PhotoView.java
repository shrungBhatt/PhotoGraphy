package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.projects.shrungbhatt.photography.R;

/**
 * Created by jigsaw on 18/2/18.
 */

public class Adapter_PhotoView extends RecyclerView.Adapter<Adapter_PhotoView.PhotoHolder>{

    private Context mContext;

    public Adapter_PhotoView(Context context){
        mContext = context;
    }

    @Override
    public PhotoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        return new PhotoHolder(inflater,parent);
    }

    @Override
    public void onBindViewHolder(PhotoHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 15;
    }

    class PhotoHolder extends RecyclerView.ViewHolder{

        private ImageView mPhoto;

        PhotoHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.list_item_photo,parent,false));

            mPhoto = itemView.findViewById(R.id.list_item_photo_image_view);

        }
    }
}

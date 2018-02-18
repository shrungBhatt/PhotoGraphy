package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.projects.shrungbhatt.photography.R;

import butterknife.BindView;

/**
 * Created by jigsaw on 18/2/18.
 */

public class Adapter_CategoriesRecyclerView extends
        RecyclerView.Adapter<Adapter_CategoriesRecyclerView.CategoriesViewHolder> {

    private Context mContext;

    public Adapter_CategoriesRecyclerView(Context context){
        mContext = context;
    }

    @Override
    public CategoriesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        return new CategoriesViewHolder(inflater,parent);
    }

    @Override
    public void onBindViewHolder(CategoriesViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    class CategoriesViewHolder extends RecyclerView.ViewHolder {


        private ImageView listItemCategoryImage;
        private TextView listItemCategoryName;

        CategoriesViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_photo_categories, parent, false));

            listItemCategoryImage = itemView.findViewById(R.id.list_item_category_image);

            listItemCategoryName = itemView.findViewById(R.id.list_item_category_name);

        }


    }

}

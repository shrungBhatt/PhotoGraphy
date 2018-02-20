package assets_bank;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.util.Log;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jigsaw on 20/2/18.
 */

public class CategoriesBank {
    private static final String TAG = "CategoriesBank";
    private static final String CATEGORIES_FOLDER = "categories";
    private AssetManager mAssets;
    private String[] categoriesPhotos;
    private List<String> assetPaths = new ArrayList<>();

    public CategoriesBank(Context context) {
        mAssets = context.getAssets();
        loadCategories();
    }

    private void loadCategories() {

        try {
            categoriesPhotos = mAssets.list(CATEGORIES_FOLDER);
            Log.i(TAG, "Found " + categoriesPhotos.length + " categories");

        } catch (Exception e) {
            e.printStackTrace();
        }
        for(String category : categoriesPhotos){
            String assetPath = CATEGORIES_FOLDER + "/" + category;
            assetPaths.add(assetPath);
        }
    }

    public Bitmap loadDrawable(String name) {

        InputStream stream;
        try {
                stream = mAssets.open(name);
            return BitmapFactory.decodeStream(stream);
        } catch (Exception ex) {

            Log.e("I/O ERROR", "Failed when ...");
            return null;
        }
    }


}

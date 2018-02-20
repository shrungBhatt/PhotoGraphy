package assets_bank;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jigsaw on 20/2/18.
 */

public class PhotosBank {
    private static final String TAG = "PhotosBank";
    private static final String PHOTOS_FOLDER = "photos";
    private AssetManager mAssets;
    private String[] photos;
    private List<String> assetPaths = new ArrayList<>();


    public PhotosBank(Context context){
        mAssets = context.getAssets();
        loadPhotos();
    }

    private void loadPhotos() {
        try {
            photos = mAssets.list(PHOTOS_FOLDER);
            Log.i(TAG, "Found " + photos.length + " photos");

        } catch (Exception e) {
            e.printStackTrace();
        }
        for(String category : photos){
            String assetPath = PHOTOS_FOLDER + "/" + category;
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

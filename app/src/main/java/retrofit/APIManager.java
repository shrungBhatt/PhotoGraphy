package retrofit;


import utils.URLGenerator;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by admin on 28/12/2017.
 */

public interface APIManager {

    @GET(URLGenerator.FETCH_CATEGORIES)
    void getPhotoCategories(Callback<String> callback);

    @GET(URLGenerator.FETCH_PHOTOS)
    void getPhotos(@Query("query") String query,Callback<String> callback);

    @GET(URLGenerator.FETCH_TAGGED_PHOTOS)
    void getTaggedPhotos(@Query("query")String userName,Callback<String> callback);

    @GET(URLGenerator.FETCH_SAVED_PHOTOS)
    void getSavedPhotos(@Query("user_name")String userName,Callback<String> callback);

    @GET(URLGenerator.FETCH_FAVOURITE_PHOTOS)
    void getFavouritePhotos(@Query("user_name")String userName,Callback<String> callback);
}

package retrofit;

import model.BaseModel;
import utils.URLGenerator;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by admin on 28/12/2017.
 */

public interface APIManager {
//    @GET("/")
//    void getLogin(@Body BaseModel model, Callback<String> callback);


    @GET(URLGenerator.FETCH_CATEGORIES)
    void getPhotoCategories(Callback<String> callback);


//    @GET(URLGenerator.CATEGORYMASTER+"{cd}"+"/brands")
//    void getCategoryMaster(@Path("cd") String cd, @Query("active") String isActive, Callback<String> callback);
}

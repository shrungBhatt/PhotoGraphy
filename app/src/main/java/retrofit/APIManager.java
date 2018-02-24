package retrofit;


import com.mobsandgeeks.saripaar.annotation.Url;

import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;
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

    @FormUrlEncoded
    @POST(URLGenerator.SAVE_PHOTOS)
    void savePhoto(@Field("username")String userName,
                    @Field("photo_name")String photoName,
                    @Field("photo_url")String photoUrl,
                    @Field("photo_description")String photoDesc,
                    @Field("photo_tagged")String photoTagged,
                    @Field("photo_likes")String photoLikes,
                    @Field("photo_category")String photoCategory,
                    @Field("photo_author")String photoAuthor,
                    @Field("photo_date")String photoDate,
                    Callback<String> callback);

    @FormUrlEncoded
    @POST(URLGenerator.LIKE_PHOTOS)
    void likePhoto(@Field("username")String userName,
                   @Field("photo_name")String photoName,
                   @Field("photo_url")String photoUrl,
                   @Field("photo_description")String photoDesc,
                   @Field("photo_tagged")String photoTagged,
                   @Field("photo_likes")String photoLikes,
                   @Field("photo_category")String photoCategory,
                   @Field("photo_author")String photoAuthor,
                   @Field("photo_date")String photoDate,
                   Callback<String> callback);

    @GET(URLGenerator.FETCH_BY_CATEGORIES)
    void fetchByCategories(@Query("category")String category,Callback<String> callback);

    @FormUrlEncoded
    @POST(URLGenerator.REGISTER_USER)
    void registerUser(@Field("username")String userName,
                      @Field("email_id")String emailId,
                      @Field("password")String password,
                      @Field("gender")String gender,
                      @Field("phone_no")String phoneNo,
                      @Field("dob")String dob,
                      Callback<String> callback);

    @FormUrlEncoded
    @POST(URLGenerator.LOGIN_IN)
    void logOnUser(@Field("username")String userName,
                   @Field("password")String password,
                   Callback<String> callback);
}

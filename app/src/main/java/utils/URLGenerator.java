package utils;

/**
 * Created by jigsaw on 20/2/18.
 */

public class URLGenerator {

    public static final String BASE_URL = "http://ersnexus.esy.es";


    //Url endpoint to fetch the categories from the server
    public static final String FETCH_CATEGORIES = "/fetch_photos_categories.php";

    //Url endpoint to fetch the photos according to the search query from the server
    public static final String FETCH_PHOTOS = "/fetch_photo_search.php";

    //Url endpoint used to fetch the tagged photos of user from the server.
    public static final String FETCH_TAGGED_PHOTOS = "/fetch_photos_tagged.php";

    //Url endpoint used to fetch the user favourite photos.
    public static final String FETCH_FAVOURITE_PHOTOS = "/fetch_favourite_photo_data.php";

    //Url endpoint used to fetch the user saved photos.
    public static final String FETCH_SAVED_PHOTOS = "/fetch_saved_photos.php";

    //Url endpoint used to save the user selected photos.
    public static final String SAVE_PHOTOS = "/photography_save_photo.php";

    //Url endpoint used to add the liked photos.
    public static final String LIKE_PHOTOS = "/photography_like_photo.php";

    //Url enpoint used to fetch photos by categories.
    public static final String FETCH_BY_CATEGORIES = "/fetch_photo_by_category.php";

    //Url endpoint used to register the user to the db.
    public static final String REGISTER_USER = "/register_photography_user.php";

    //Url endpoint used to log on user.
    public static final String LOGIN_IN = "/photography_user_login.php";

}

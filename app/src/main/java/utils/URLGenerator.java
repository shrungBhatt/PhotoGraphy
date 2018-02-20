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

}

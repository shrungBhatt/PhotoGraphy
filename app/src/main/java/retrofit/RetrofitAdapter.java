package retrofit;

import com.google.gson.GsonBuilder;

import utils.StringDesirializer;
import utils.URLGenerator;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by admin on 28/12/2017.
 */

public class RetrofitAdapter {
    protected APIManager apiManager;

    public APIManager getApiManager() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(String.class, new StringDesirializer());
        if (apiManager == null) {
            apiManager = new RestAdapter.Builder()
                    .setEndpoint(URLGenerator.BASE_URL)
                    .setConverter(new GsonConverter(gsonBuilder.create()))
                    .build()
                    .create(APIManager.class);
        }
        return apiManager;
    }
}

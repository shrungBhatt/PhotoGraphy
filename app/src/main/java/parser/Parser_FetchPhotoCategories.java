package parser;

import com.google.gson.Gson;

import org.json.JSONObject;

import model.BaseModel;
import model.Res_PhotoCategories;

/**
 * Created by jigsaw on 20/2/18.
 */

public class Parser_FetchPhotoCategories extends BaseParser {
    @Override
    public BaseModel doParsing(JSONObject jsonObject) {
        Gson gson = new Gson();
        Res_PhotoCategories res_photoCategories;
        res_photoCategories = gson.fromJson(jsonObject.toString(), Res_PhotoCategories.class);
        return res_photoCategories;
    }
}

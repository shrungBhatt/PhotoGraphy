package parser;

import com.google.gson.Gson;

import org.json.JSONObject;

import model.BaseModel;
import model.Res_Photos;
import model.Res_PhotosSavedAndFavrt;

/**
 * Created by jigsaw on 24/2/18.
 */

public class Parser_PhotosSavedAndFavrt extends BaseParser{


    @Override
    public BaseModel doParsing(JSONObject jsonObject) {
        Gson gson = new Gson();
        Res_Photos res_photos;
        res_photos = gson.fromJson(jsonObject.toString(), Res_Photos.class);
        return res_photos;
    }


}

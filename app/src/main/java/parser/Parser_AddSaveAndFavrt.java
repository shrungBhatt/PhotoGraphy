package parser;

import com.google.gson.Gson;

import org.json.JSONObject;

import model.BaseModel;
import model.Res_AddSaveAndFavrt;


/**
 * Created by jigsaw on 24/2/18.
 */

public class Parser_AddSaveAndFavrt extends BaseParser {
    @Override
    public BaseModel doParsing(JSONObject jsonObject) {
        Gson gson = new Gson();
        Res_AddSaveAndFavrt res_addSaveAndFavrt;
        res_addSaveAndFavrt = gson.fromJson(jsonObject.toString(), Res_AddSaveAndFavrt.class);
        return res_addSaveAndFavrt;
    }
}

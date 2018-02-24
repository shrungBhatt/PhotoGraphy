package parser;

import com.google.gson.Gson;

import org.json.JSONObject;

import model.BaseModel;
import model.Res_Result;


/**
 * Created by jigsaw on 24/2/18.
 */

public class Parser_Result extends BaseParser {
    @Override
    public BaseModel doParsing(JSONObject jsonObject) {
        Gson gson = new Gson();
        Res_Result res_result;
        res_result = gson.fromJson(jsonObject.toString(), Res_Result.class);
        return res_result;
    }
}

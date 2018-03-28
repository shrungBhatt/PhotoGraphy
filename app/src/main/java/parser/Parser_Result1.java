package parser;

import com.google.gson.Gson;

import org.json.JSONObject;

import model.BaseModel;
import model.Res_Result;
import model.Res_Result1;


/**
 * Created by jigsaw on 24/2/18.
 */

public class Parser_Result1 extends BaseParser {
    @Override
    public BaseModel doParsing(JSONObject jsonObject) {
        Gson gson = new Gson();
        Res_Result1 res_result1;
        res_result1 = gson.fromJson(jsonObject.toString(), Res_Result1.class);
        return res_result1;
    }
}

package parser;

import org.json.JSONObject;

import model.BaseModel;

/**
 * Created by admin on 29/12/2017.
 */

public abstract class BaseParser {

    public abstract BaseModel doParsing(JSONObject jsonObject);
}

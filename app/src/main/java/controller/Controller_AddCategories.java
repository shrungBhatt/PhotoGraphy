package controller;

import org.json.JSONObject;

import model.BaseModel;
import model.Req_AddCategories;
import model.Res_Result;
import parser.BaseParser;
import parser.Parser_Result;

/**
 * Created by jigsaw on 1/3/18.
 */

public class Controller_AddCategories extends BaseController {
    @Override
    public void onPopulate(JSONObject objJson, BaseParser baseParser) {
        Parser_Result parserAddSaveAndFavrt = (Parser_Result) baseParser;
        Res_Result res_result = (Res_Result) parserAddSaveAndFavrt.doParsing(objJson);
        callBackListner.handleSuccessData(res_result);

    }


    @Override
    public void startFetching(CallBackListner callBackListner, BaseModel model) {
        super.startFetching(callBackListner, model);

        this.reqModel = model;
        this.baseParser = new Parser_Result();
        Req_AddCategories req_addCategories = (Req_AddCategories) model;
        apiManager.addCategory(req_addCategories.getPhotoCategory(),
                req_addCategories.getPhotoUrl(),callback);

    }
}

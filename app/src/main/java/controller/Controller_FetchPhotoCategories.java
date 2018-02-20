package controller;

import org.json.JSONObject;

import model.BaseModel;
import model.Req_PhotoCategories;
import model.Res_PhotoCategories;
import parser.BaseParser;
import parser.Parser_FetchPhotoCategories;

/**
 * Created by jigsaw on 20/2/18.
 */

public class Controller_FetchPhotoCategories extends BaseController {
    @Override
    public void onPopulate(JSONObject objJson, BaseParser baseParser) {
        Parser_FetchPhotoCategories parser_fetchPhotoCategories = (Parser_FetchPhotoCategories) baseParser;
        Res_PhotoCategories res_photoCategories = (Res_PhotoCategories) parser_fetchPhotoCategories.doParsing(objJson);
        callBackListner.handleSuccessData(res_photoCategories);
    }


    @Override
    public void startFetching(CallBackListner callBackListner, BaseModel model) {
        super.startFetching(callBackListner, model);

        this.reqModel = model;
        this.baseParser = new Parser_FetchPhotoCategories();
//        Req_PhotoCategories req_photoCategories = (Req_PhotoCategories) reqModel;
        apiManager.getPhotoCategories(callback);

    }
}

package controller;

import org.json.JSONObject;

import model.BaseModel;
import model.Req_FetchPhotoByCategory;
import model.Res_Photos;
import parser.BaseParser;
import parser.Parser_FetchPhoto;

/**
 * Created by jigsaw on 25/2/18.
 */

public class Controller_FetchPhotoByCategory extends BaseController {
    @Override
    public void onPopulate(JSONObject objJson, BaseParser baseParser) {
        Parser_FetchPhoto parser_fetchPhoto = (Parser_FetchPhoto) baseParser;
        Res_Photos res_photos = (Res_Photos) parser_fetchPhoto.doParsing(objJson);
        callBackListner.handleSuccessData(res_photos);
    }

    @Override
    public void startFetching(CallBackListner callBackListner, BaseModel model) {
        super.startFetching(callBackListner, model);

        this.reqModel = model;
        this.baseParser = new Parser_FetchPhoto();
        Req_FetchPhotoByCategory req_fetchPhotoByCategory = (Req_FetchPhotoByCategory) reqModel;
        apiManager.fetchByCategories(req_fetchPhotoByCategory.getmCategory(),callback);
    }
}

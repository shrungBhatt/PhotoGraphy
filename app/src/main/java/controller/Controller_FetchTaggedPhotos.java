package controller;

import org.json.JSONObject;

import model.BaseModel;
import model.Req_PhotosByQuery;
import model.Req_PhotosTagged;
import model.Res_Photos;
import parser.BaseParser;
import parser.Parser_FetchPhotoByQuery;

/**
 * Created by jigsaw on 20/2/18.
 */

public class Controller_FetchTaggedPhotos extends BaseController {
    @Override
    public void onPopulate(JSONObject objJson, BaseParser baseParser) {
        Parser_FetchPhotoByQuery parser_fetchPhotoByQuery = (Parser_FetchPhotoByQuery) baseParser;
        Res_Photos res_photos = (Res_Photos) parser_fetchPhotoByQuery.doParsing(objJson);
        callBackListner.handleSuccessData(res_photos);
    }


    @Override
    public void startFetching(CallBackListner callBackListner, BaseModel model) {
        super.startFetching(callBackListner, model);

        this.reqModel = model;
        this.baseParser = new Parser_FetchPhotoByQuery();
        Req_PhotosTagged req_photosTagged = (Req_PhotosTagged) reqModel;
        apiManager.getTaggedPhotos(req_photosTagged.getmUserName(),callback);
    }
}

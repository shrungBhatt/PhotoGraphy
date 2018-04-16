package controller;

import org.json.JSONObject;

import model.BaseModel;
import model.Req_FetchUserInquiries;
import model.Res_Photos;
import parser.BaseParser;
import parser.Parser_FetchPhoto;
import utils.MySharedPreferences;

/**
 * Created by jigsaw on 26/2/18.
 */

public class Controller_FetchUserInquires extends BaseController {
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
        Req_FetchUserInquiries reqFetchUserInquiries = (Req_FetchUserInquiries) model;
        apiManager.fetchUserInquiries(reqFetchUserInquiries.getUsername(),callback);
    }
}

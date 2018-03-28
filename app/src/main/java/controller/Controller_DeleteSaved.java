package controller;

import org.json.JSONObject;

import model.BaseModel;
import model.Req_DeleteSavedAndLiked;
import model.Res_Result;
import model.Res_Result1;
import parser.BaseParser;
import parser.Parser_Result;
import parser.Parser_Result1;

/**
 * Created by jigsaw on 24/2/18.
 */

public class Controller_DeleteSaved extends BaseController{

    @Override
    public void onPopulate(JSONObject objJson, BaseParser baseParser) {
        Parser_Result1 parser_result1 = (Parser_Result1) baseParser;
        Res_Result1 resResult1 =
                (Res_Result1) parser_result1.doParsing(objJson);
        callBackListner.handleSuccessData(resResult1);
    }

    @Override
    public void startFetching(CallBackListner callBackListner, BaseModel model) {
        super.startFetching(callBackListner, model);

        this.reqModel = model;
        this.baseParser = new Parser_Result1();
        Req_DeleteSavedAndLiked deleteSavedAndLiked = (Req_DeleteSavedAndLiked) reqModel;
        apiManager.deleteSavedPhotos(deleteSavedAndLiked.getUsername(),
                deleteSavedAndLiked.getPhotoname(),callback);

    }
}

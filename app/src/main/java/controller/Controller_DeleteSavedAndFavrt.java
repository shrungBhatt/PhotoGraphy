package controller;

import org.json.JSONObject;

import model.BaseModel;
import model.Req_DeleteSavedAndLiked;
import model.Res_Result;
import parser.BaseParser;
import parser.Parser_Result;

/**
 * Created by jigsaw on 24/2/18.
 */

public class Controller_DeleteSavedAndFavrt extends BaseController{

    @Override
    public void onPopulate(JSONObject objJson, BaseParser baseParser) {
        Parser_Result parser_result = (Parser_Result) baseParser;
        Res_Result resResult =
                (Res_Result) parser_result.doParsing(objJson);
        callBackListner.handleSuccessData(resResult);
    }

    @Override
    public void startFetching(CallBackListner callBackListner, BaseModel model) {
        super.startFetching(callBackListner, model);

        this.reqModel = model;
        this.baseParser = new Parser_Result();
        Req_DeleteSavedAndLiked deleteSavedAndLiked = (Req_DeleteSavedAndLiked) reqModel;
        switch (deleteSavedAndLiked.getFragmentCallBack()){

            case "Save":
                apiManager.getSavedPhotos(deleteSavedAndLiked.getId(),callback);
                break;
            case "Like":
                apiManager.deleteLikedPhotos(deleteSavedAndLiked.getUsername(),
                        deleteSavedAndLiked.getPhotoname(),callback);
                break;

        }

    }
}

package controller;

import org.json.JSONObject;

import model.BaseModel;
import model.Req_AddSaveAndFavrt;
import model.Res_Result;
import parser.BaseParser;
import parser.Parser_Result;

/**
 * Created by jigsaw on 24/2/18.
 */

public class Contoller_AddSaveAndFavrt extends BaseController {
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
        Req_AddSaveAndFavrt req_addSaveAndFavrt = (Req_AddSaveAndFavrt) reqModel;
        switch (req_addSaveAndFavrt.getmFragmentCallBack()) {

            case "Save":
                apiManager.savePhoto(req_addSaveAndFavrt.getmUserName(),
                        req_addSaveAndFavrt.getmPhotoName(),
                        req_addSaveAndFavrt.getmPhotoUrl(),
                        req_addSaveAndFavrt.getmPhotoDesc(),
                        req_addSaveAndFavrt.getmPhotoTagged(),
                        req_addSaveAndFavrt.getmPhotoLikes(),
                        req_addSaveAndFavrt.getmPhotoCategory(),
                        req_addSaveAndFavrt.getmPhotoAuthor(),
                        req_addSaveAndFavrt.getmPhotoDate(),
                        callback);
                break;

            case "Like":
                apiManager.likePhoto(req_addSaveAndFavrt.getmUserName(),
                        req_addSaveAndFavrt.getmPhotoName(),
                        req_addSaveAndFavrt.getmPhotoUrl(),
                        req_addSaveAndFavrt.getmPhotoDesc(),
                        req_addSaveAndFavrt.getmPhotoTagged(),
                        req_addSaveAndFavrt.getmPhotoLikes(),
                        req_addSaveAndFavrt.getmPhotoCategory(),
                        req_addSaveAndFavrt.getmPhotoAuthor(),
                        req_addSaveAndFavrt.getmPhotoDate(),
                        callback);
        }

    }
}

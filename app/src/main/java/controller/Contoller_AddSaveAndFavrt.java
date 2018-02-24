package controller;

import org.json.JSONObject;

import model.BaseModel;
import model.Req_AddSaveAndFavrt;
import model.Res_AddSaveAndFavrt;
import parser.BaseParser;
import parser.Parser_AddSaveAndFavrt;

/**
 * Created by jigsaw on 24/2/18.
 */

public class Contoller_AddSaveAndFavrt extends BaseController {
    @Override
    public void onPopulate(JSONObject objJson, BaseParser baseParser) {
        Parser_AddSaveAndFavrt parserAddSaveAndFavrt = (Parser_AddSaveAndFavrt) baseParser;
        Res_AddSaveAndFavrt res_addSaveAndFavrt = (Res_AddSaveAndFavrt) parserAddSaveAndFavrt.doParsing(objJson);
        callBackListner.handleSuccessData(res_addSaveAndFavrt);
    }


    @Override
    public void startFetching(CallBackListner callBackListner, BaseModel model) {
        super.startFetching(callBackListner, model);

        this.reqModel = model;
        this.baseParser = new Parser_AddSaveAndFavrt();
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

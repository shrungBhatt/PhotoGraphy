package controller;

import org.json.JSONObject;

import model.BaseModel;
import model.Req_PhotosSavedAndFavrt;
import model.Res_Photos;
import model.Res_PhotosSavedAndFavrt;
import parser.BaseParser;
import parser.Parser_PhotosSavedAndFavrt;

/**
 * Created by jigsaw on 24/2/18.
 */

public class Controller_PhotosSavedAndFavrt extends BaseController{

    @Override
    public void onPopulate(JSONObject objJson, BaseParser baseParser) {
        Parser_PhotosSavedAndFavrt parser_photosSavedAndFavrt = (Parser_PhotosSavedAndFavrt) baseParser;
        Res_Photos res_photos =
                (Res_Photos) parser_photosSavedAndFavrt.doParsing(objJson);
        callBackListner.handleSuccessData(res_photos);
    }

    @Override
    public void startFetching(CallBackListner callBackListner, BaseModel model) {
        super.startFetching(callBackListner, model);

        this.reqModel = model;
        this.baseParser = new Parser_PhotosSavedAndFavrt();
        Req_PhotosSavedAndFavrt req_photosSavedAndFavrt = (Req_PhotosSavedAndFavrt) reqModel;
        switch (req_photosSavedAndFavrt.getmFragmentCallBack()){

            case "Saved":
                apiManager.getSavedPhotos(req_photosSavedAndFavrt.getmUserName(),callback);
                break;
            case "Favourite":
                apiManager.getFavouritePhotos(req_photosSavedAndFavrt.getmUserName(),callback);
                break;

        }

    }
}

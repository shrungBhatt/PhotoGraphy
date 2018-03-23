package controller;

import org.json.JSONObject;

import model.BaseModel;
import model.Req_RegisterUser;
import model.Res_Result;
import parser.BaseParser;
import parser.Parser_Result;

/**
 * Created by jigsaw on 25/2/18.
 */

public class Controller_RegisterUser extends BaseController {

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
        Req_RegisterUser req_registerUser = (Req_RegisterUser) reqModel;
        apiManager.registerUser(req_registerUser.getmUsername(),
                req_registerUser.getmEmailId(),
                req_registerUser.getmPassword(),
                req_registerUser.getmGender(),
                req_registerUser.getmPhoneNo(),
                req_registerUser.getmDob(),
                req_registerUser.getUserType(),
                callback);
    }
}

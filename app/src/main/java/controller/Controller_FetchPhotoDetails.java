package controller;

import org.json.JSONObject;

import model.BaseModel;
import model.Req_FetchPhotoDetails;
import model.Req_LogOnUser;
import model.Res_Result;
import parser.BaseParser;
import parser.Parser_Result;

/**
 * Created by jigsaw on 25/2/18.
 */

public class Controller_FetchPhotoDetails extends BaseController {
    @Override
    public void onPopulate(JSONObject objJson, BaseParser baseParser) {
        Parser_Result parser_result = (Parser_Result) baseParser;
        Res_Result res_result = (Res_Result) parser_result.doParsing(objJson);
        callBackListner.handleSuccessData(res_result);
    }

    @Override
    public void startFetching(CallBackListner callBackListner, BaseModel model) {
        super.startFetching(callBackListner, model);

        this.reqModel = model;
        this.baseParser = new Parser_Result();
        Req_FetchPhotoDetails reqFetchPhotoDetails = (Req_FetchPhotoDetails) reqModel;
        apiManager.fetchPhotoDetails(reqFetchPhotoDetails.getId(),
                reqFetchPhotoDetails.getUsername(),
                callback);
    }
}

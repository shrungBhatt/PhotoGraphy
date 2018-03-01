package controller;

import org.json.JSONObject;

import model.BaseModel;
import model.Req_AddInquiry;
import model.Res_Result;
import parser.BaseParser;
import parser.Parser_Result;

/**
 * Created by jigsaw on 1/3/18.
 */

public class Controller_AddInquiry extends BaseController {
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
        Req_AddInquiry req_addInquiry = (Req_AddInquiry) model;
        apiManager.addInquiry(req_addInquiry.getInquiryAuthor(),
                req_addInquiry.getPhotoName(),
                req_addInquiry.getPhotoUrl(),
                req_addInquiry.getPhotoDesc(),
                req_addInquiry.getPhotoTagged(),
                req_addInquiry.getPhotoLikes(),
                req_addInquiry.getPhotoCategory(),
                req_addInquiry.getPhotoAuthor(),
                req_addInquiry.getPhotoDate(),
                req_addInquiry.getInquiryMessage(),
                req_addInquiry.getInquiryDate(),
                callback);
    }
}

package controller;

import org.json.JSONObject;

import model.BaseModel;
import model.Req_SubmitInquiryReply;
import model.Res_Photos;
import model.Res_Result;
import parser.BaseParser;
import parser.Parser_FetchPhoto;
import parser.Parser_Result;

/**
 * Created by jigsaw on 26/2/18.
 */

public class Controller_SubmitInquiryReply extends BaseController {
    @Override
    public void onPopulate(JSONObject objJson, BaseParser baseParser) {

        Parser_Result result = (Parser_Result) baseParser;
        Res_Result res_result = (Res_Result) result.doParsing(objJson);
        callBackListner.handleSuccessData(res_result);
    }

    @Override
    public void startFetching(CallBackListner callBackListner, BaseModel model) {
        super.startFetching(callBackListner, model);

        this.reqModel = model;
        this.baseParser = new Parser_Result();
        Req_SubmitInquiryReply reqSubmitInquiryReply = (Req_SubmitInquiryReply) model;
        apiManager.submitInquiryReply(reqSubmitInquiryReply.getReply(),
                reqSubmitInquiryReply.getId(),reqSubmitInquiryReply.getReplyAuthor(),callback);
    }
}

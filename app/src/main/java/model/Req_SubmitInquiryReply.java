package model;

public class Req_SubmitInquiryReply extends BaseModel {

    private String mReply;
    private String mId;


    public String getReply() {
        return mReply;
    }

    public void setReply(String reply) {
        mReply = reply;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }
}

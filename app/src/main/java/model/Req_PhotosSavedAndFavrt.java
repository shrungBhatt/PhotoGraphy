package model;

/**
 * Created by jigsaw on 24/2/18.
 */

public class Req_PhotosSavedAndFavrt extends BaseModel {

    private String mUserName;
    private String mFragmentCallBack;


    public String getmUserName() {
        return mUserName;
    }

    public void setmUserName(String mUserName) {
        this.mUserName = mUserName;
    }

    public String getmFragmentCallBack() {
        return mFragmentCallBack;
    }

    public void setmFragmentCallBack(String mFragmentCallBack) {
        this.mFragmentCallBack = mFragmentCallBack;
    }
}

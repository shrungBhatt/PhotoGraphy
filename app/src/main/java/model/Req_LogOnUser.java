package model;

/**
 * Created by jigsaw on 25/2/18.
 */

public class Req_LogOnUser extends BaseModel {


    private String mUserName;
    private String mPassword;

    public String getmUserName() {
        return mUserName;
    }

    public void setmUserName(String mUserName) {
        this.mUserName = mUserName;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }
}

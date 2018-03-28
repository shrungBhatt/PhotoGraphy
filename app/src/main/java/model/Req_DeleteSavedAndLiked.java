package model;

/**
 * Created by jigsaw on 26/3/18.
 */

public class Req_DeleteSavedAndLiked extends BaseModel {

    private String mId;

    private String mUsername;

    private String mPhotoname;

    private String mFragmentCallBack;

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

    public String getPhotoname() {
        return mPhotoname;
    }

    public void setPhotoname(String photoname) {
        mPhotoname = photoname;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getFragmentCallBack() {
        return mFragmentCallBack;
    }

    public void setFragmentCallBack(String fragmentCallBack) {
        mFragmentCallBack = fragmentCallBack;
    }
}

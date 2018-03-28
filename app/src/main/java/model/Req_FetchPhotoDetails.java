package model;

/**
 * Created by jigsaw on 26/3/18.
 */

public class Req_FetchPhotoDetails extends BaseModel {

    private String mId;
    private String mUsername;
    private String mPhotoname;
    private String mFragmentCallback;

    public String getFragmentCallback() {
        return mFragmentCallback;
    }

    public void setFragmentCallback(String fragmentCallback) {
        mFragmentCallback = fragmentCallback;
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

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }
}

package model;

/**
 * Created by jigsaw on 26/3/18.
 */

public class Req_FetchPhotoDetails extends BaseModel {

    private String mId;
    private String mUsername;

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

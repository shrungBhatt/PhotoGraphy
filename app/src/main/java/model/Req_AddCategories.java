package model;

/**
 * Created by jigsaw on 1/3/18.
 */

public class Req_AddCategories extends BaseModel {

    private String mPhotoCategory;
    private String mPhotoUrl;

    public String getPhotoCategory() {
        return mPhotoCategory;
    }

    public void setPhotoCategory(String photoCategory) {
        mPhotoCategory = photoCategory;
    }

    public String getPhotoUrl() {
        return mPhotoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        mPhotoUrl = photoUrl;
    }
}

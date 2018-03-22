package model;

/**
 * Created by jigsaw on 1/3/18.
 */

public class Req_AddCategories extends BaseModel {

    private String mPhotoCategory;
    private String mImage;

    public String getPhotoCategory() {
        return mPhotoCategory;
    }

    public void setPhotoCategory(String photoCategory) {
        mPhotoCategory = photoCategory;
    }


    public String getImage() {
        return mImage;
    }

    public void setImage(String image) {
        mImage = image;
    }
}

package model;

/**
 * Created by jigsaw on 24/2/18.
 */

public class Req_AddSaveAndFavrt extends BaseModel {

    private String mUserName;
    private String mPhotoName;
    private String mPhotoUrl;
    private String mPhotoDesc;
    private String mPhotoTagged;
    private String mPhotoLikes;
    private String mPhotoCategory;
    private String mPhotoAuthor;
    private String mPhotoDate;
    private String mFragmentCallBack;

    public String getmFragmentCallBack() {
        return mFragmentCallBack;
    }

    public void setmFragmentCallBack(String mFragmentCallBack) {
        this.mFragmentCallBack = mFragmentCallBack;
    }

    public String getmUserName() {
        return mUserName;
    }

    public void setmUserName(String mUserName) {
        this.mUserName = mUserName;
    }

    public String getmPhotoName() {
        return mPhotoName;
    }

    public void setmPhotoName(String mPhotoName) {
        this.mPhotoName = mPhotoName;
    }

    public String getmPhotoUrl() {
        return mPhotoUrl;
    }

    public void setmPhotoUrl(String mPhotoUrl) {
        this.mPhotoUrl = mPhotoUrl;
    }

    public String getmPhotoDesc() {
        return mPhotoDesc;
    }

    public void setmPhotoDesc(String mPhotoDesc) {
        this.mPhotoDesc = mPhotoDesc;
    }

    public String getmPhotoTagged() {
        return mPhotoTagged;
    }

    public void setmPhotoTagged(String mPhotoTagged) {
        this.mPhotoTagged = mPhotoTagged;
    }

    public String getmPhotoLikes() {
        return mPhotoLikes;
    }

    public void setmPhotoLikes(String mPhotoLikes) {
        this.mPhotoLikes = mPhotoLikes;
    }

    public String getmPhotoCategory() {
        return mPhotoCategory;
    }

    public void setmPhotoCategory(String mPhotoCategory) {
        this.mPhotoCategory = mPhotoCategory;
    }

    public String getmPhotoAuthor() {
        return mPhotoAuthor;
    }

    public void setmPhotoAuthor(String mPhotoAuthor) {
        this.mPhotoAuthor = mPhotoAuthor;
    }

    public String getmPhotoDate() {
        return mPhotoDate;
    }

    public void setmPhotoDate(String mPhotoDate) {
        this.mPhotoDate = mPhotoDate;
    }
}

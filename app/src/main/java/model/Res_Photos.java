package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by jigsaw on 20/2/18.
 */

public class Res_Photos extends BaseModel {

    @SerializedName("list")
    @Expose
    private ArrayList<List> list = null;

    public ArrayList<List> getList() {
        return list;
    }

    public void setList(ArrayList<List> list) {
        this.list = list;
    }



    public class List extends BaseModel {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("username")
        @Expose
        private String username;
        @SerializedName("photo_name")
        @Expose
        private String photoName;
        @SerializedName("inquiry_message")
        @Expose
        private String inquiryMessage;
        @SerializedName("photo_url")
        @Expose
        private String photoUrl;
        @SerializedName("photo_tagged")
        @Expose
        private String photoTagged;
        @SerializedName("photo_likes")
        @Expose
        private String photoLikes;
        @SerializedName("photo_category")
        @Expose
        private String photoCategory;
        @SerializedName("photo_author")
        @Expose
        private String photoAuthor;
        @SerializedName("photo_date")
        @Expose
        private String photoDate;
        @SerializedName("photo_description")
        @Expose
        private String photoDescription;
        @SerializedName("inquiry_date")
        @Expose
        private String inquiryDate;
        @SerializedName("inquiry_author")
        @Expose
        private String inquiryAuthor;
        @SerializedName("is_selected")
        private boolean isSelected;

        public boolean isSelected() {
            return isSelected;
        }

        public void setSelected(boolean selected) {
            isSelected = selected;
        }

        public String getInquiryAuthor() {
            return inquiryAuthor;
        }

        public void setInquiryAuthor(String inquiryAuthor) {
            this.inquiryAuthor = inquiryAuthor;
        }

        public String getInquiryDate() {
            return inquiryDate;
        }

        public void setInquiryDate(String inquiryDate) {
            this.inquiryDate = inquiryDate;
        }

        public String getPhotoDescription() {
            return photoDescription;
        }

        public void setPhotoDescription(String photoDescription) {
            this.photoDescription = photoDescription;
        }


        public String getInquiryMessage() {
            return inquiryMessage;
        }

        public void setInquiryMessage(String inquiryMessage) {
            this.inquiryMessage = inquiryMessage;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPhotoName() {
            return photoName;
        }

        public void setPhotoName(String photoName) {
            this.photoName = photoName;
        }

        public String getPhotoUrl() {
            return photoUrl;
        }

        public void setPhotoUrl(String photoUrl) {
            this.photoUrl = photoUrl;
        }

        public String getPhotoTagged() {
            return photoTagged;
        }

        public void setPhotoTagged(String photoTagged) {
            this.photoTagged = photoTagged;
        }

        public String getPhotoLikes() {
            return photoLikes;
        }

        public void setPhotoLikes(String photoLikes) {
            this.photoLikes = photoLikes;
        }

        public String getPhotoCategory() {
            return photoCategory;
        }

        public void setPhotoCategory(String photoCategory) {
            this.photoCategory = photoCategory;
        }

        public String getPhotoAuthor() {
            return photoAuthor;
        }

        public void setPhotoAuthor(String photoAuthor) {
            this.photoAuthor = photoAuthor;
        }

        public String getPhotoDate() {
            return photoDate;
        }

        public void setPhotoDate(String photoDate) {
            this.photoDate = photoDate;
        }

    }
}

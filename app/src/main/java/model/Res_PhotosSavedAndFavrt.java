package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by jigsaw on 24/2/18.
 */

public class Res_PhotosSavedAndFavrt extends BaseModel {

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
        @SerializedName("photo_url")
        @Expose
        private String photoUrl;
        @SerializedName("photo_description")
        @Expose
        private String photoDescription;
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

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
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

        public String getPhotoDescription() {
            return photoDescription;
        }

        public void setPhotoDescription(String photoDescription) {
            this.photoDescription = photoDescription;
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

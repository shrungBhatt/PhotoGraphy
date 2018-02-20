package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by jigsaw on 20/2/18.
 */

public class Res_PhotoCategories extends BaseModel {

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
        @SerializedName("photo_category")
        @Expose
        private String photoCategory;
        @SerializedName("photo_url")
        @Expose
        private String photoUrl;
        @SerializedName("create_date")
        @Expose
        private String createDate;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPhotoCategory() {
            return photoCategory;
        }

        public void setPhotoCategory(String photoCategory) {
            this.photoCategory = photoCategory;
        }

        public String getPhotoUrl() {
            return photoUrl;
        }

        public void setPhotoUrl(String photoUrl) {
            this.photoUrl = photoUrl;
        }

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }


    }
}
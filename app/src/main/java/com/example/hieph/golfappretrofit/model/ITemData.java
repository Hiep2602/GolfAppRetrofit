package com.example.hieph.golfappretrofit.model;

import java.util.List;

/**
 * Created by hieph on 8/20/2018.
 */

public class ITemData {
    private int id;
    private String created_at;
    private String update_at;
    private String image;
    private int par;
    private int hole_count;
    private int follower_count;
    private String name;
    private int rating_count;
    private int avg_rating;
    private int is_following;

    public int getId() {
        return id;
    }

    public ITemData(String created_at, String name, String image) {
        this.created_at = created_at;
        this.update_at = name;
        this.image = image;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(String update_at) {
        this.update_at = update_at;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPar() {
        return par;
    }

    public void setPar(int par) {
        this.par = par;
    }

    public int getHole_count() {
        return hole_count;
    }

    public void setHole_count(int hole_count) {
        this.hole_count = hole_count;
    }

    public int getFollower_count() {
        return follower_count;
    }

    public void setFollower_count(int follower_count) {
        this.follower_count = follower_count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating_count() {
        return rating_count;
    }

    public void setRating_count(int rating_count) {
        this.rating_count = rating_count;
    }

    public int getAvg_rating() {
        return avg_rating;
    }

    public void setAvg_rating(int avg_rating) {
        this.avg_rating = avg_rating;
    }

    public int getIs_following() {
        return is_following;
    }

    public void setIs_following(int is_following) {
        this.is_following = is_following;
    }


    public class DataCourse{
        private List<ITemData> data;

        public List<ITemData> getData() {
            return data;
        }
    }
}
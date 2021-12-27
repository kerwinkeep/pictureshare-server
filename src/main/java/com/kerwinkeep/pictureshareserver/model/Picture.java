package com.kerwinkeep.pictureshareserver.model;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "picture")
public class Picture {

    @Id
    @Column(name = "id")
    int id;

    @Column(name = "user_id")
    int userId;

    @Column(name = "like_num")
    int likeNum;

    @Column(name = "title")
    String title;

    @Column(name = "picture_data")
    String pictureData;

    @Column(name = "create_time", nullable = false)
    Date createDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPictureData() {
        return pictureData;
    }

    public void setPicture(String pictureData) {
        this.pictureData = pictureData;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}

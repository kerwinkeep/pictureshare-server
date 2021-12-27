package com.kerwinkeep.pictureshareserver.vo;

import java.util.Date;

public class PictureVO {

    private long id;

    private long userId;

    private int likeNum;

    private String title;

    private String pictureData;

    private Date createTime;

    private String name;

    public PictureVO() {
    }

    public PictureVO(long id, long userId, int likeNum, String title, String pictureData, Date createTime, String name) {
        this.id = id;
        this.userId = userId;
        this.likeNum = likeNum;
        this.title = title;
        this.pictureData = pictureData;
        this.createTime = createTime;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
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

    public void setPictureData(String pictureData) {
        this.pictureData = pictureData;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

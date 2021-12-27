package com.kerwinkeep.pictureshareserver.controller;

import com.alibaba.fastjson.JSONObject;
import com.kerwinkeep.pictureshareserver.daoi.PictureDao;
import com.kerwinkeep.pictureshareserver.model.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/picture")
public class PictureController {

    @Autowired
    private PictureDao pictureDao;

    @RequestMapping("/getPictures")
    @ResponseBody
    public List<Picture> getPictures(){

        List<Picture> pictureList;
        pictureList = pictureDao.queryPicturesOrOrderByCreateTime();
        return pictureList;
    }

    @RequestMapping("/giveLike")
    @ResponseBody
    public String giveLike(@RequestBody JSONObject jsonObject){

        String id = jsonObject.get("id").toString();
        if(1 == pictureDao.updateLikeNum(Long.parseLong(id))){
            return "Give a like successfully.";
        }
        return "Failed to give a like.";
    }

    @RequestMapping("/getPersonPictures")
    @ResponseBody
    public List<Picture> getPersonPictures(@RequestBody JSONObject jsonObject){

        String userId=jsonObject.get("id").toString();
        List<Picture> pictureList;
        pictureList = pictureDao.queryPersonalPicturesOrOrderByCreateTime(Long.parseLong(userId));
        return  pictureList;
    }

    @PostMapping("/uploadPicture")
    @ResponseBody
    public String uploadPic(@RequestBody JSONObject jsonObject){

        long id = Long.parseLong(jsonObject.get("userId").toString());
        String title = jsonObject.get("title").toString();
        String pictureData = jsonObject.get("pictureData").toString();

        if(1 == pictureDao.insertPicture(id, title, pictureData)){
            return "Upload complete.";
        }
        return "Fail to upload.";
    }

    @RequestMapping("/deletePicture")
    @ResponseBody
    public String deletePicture(@RequestBody JSONObject jsonObject){

        long id = Long.parseLong(jsonObject.get("id").toString());

        if(1 == pictureDao.deletePictureById(id)){
            return "Deleted successfully.";
        }
        return "Fail to delete.";
    }
}

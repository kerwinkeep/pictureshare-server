package com.kerwinkeep.pictureshareserver.controller;

import com.alibaba.fastjson.JSONObject;
import com.kerwinkeep.pictureshareserver.daoi.PictureDao;
import com.kerwinkeep.pictureshareserver.daoi.UserDao;
import com.kerwinkeep.pictureshareserver.model.Picture;
import com.kerwinkeep.pictureshareserver.vo.PictureVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/picture")
public class PictureController {

    @Autowired
    private PictureDao pictureDao;

    @Autowired
    private UserDao userDao;

    @RequestMapping("/getPictures")
    @ResponseBody
    public List<PictureVO> getPictures(){

        List<PictureVO> pictureVOList = new ArrayList<>();
        List<Picture> pictureList = pictureDao.queryPicturesOrderByCreateTime();
        for (Picture picture : pictureList) {
            String name = userDao.findUserById(picture.getUserId()).getName();
            PictureVO pictureVO = new PictureVO(
                    picture.getId(),
                    picture.getUserId(),
                    picture.getLikeNum(),
                    picture.getTitle(),
                    picture.getPictureData(),
                    picture.getCreateDate(),
                    name
            );
            pictureVOList.add(pictureVO);
        }
        return pictureVOList;
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
        pictureList = pictureDao.queryPersonalPicturesOrderByCreateTime(Long.parseLong(userId));
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

package com.kerwinkeep.pictureshareserver.controller;

import com.alibaba.fastjson.JSONObject;
import com.kerwinkeep.pictureshareserver.daoi.PictureDao;
import com.kerwinkeep.pictureshareserver.model.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
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
        if(pictureDao.updateLikeNum(Long.parseLong(id)) == 1){
            return "Give a like successfully.";
        }
        return "Failed to give a like.";
    }
}

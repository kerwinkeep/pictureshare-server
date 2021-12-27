package com.kerwinkeep.pictureshareserver.controller;

import com.kerwinkeep.pictureshareserver.daoi.PictureDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pic")
public class PictureController {

    @Autowired
    private PictureDao pictureDao;

}

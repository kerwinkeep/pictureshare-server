package com.kerwinkeep.pictureshareserver.daoi;

import com.kerwinkeep.pictureshareserver.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface PictureDao extends JpaRepository<Picture, Integer> {

    @Query(value = "select * from picture_share.picture Order By create_time Desc",nativeQuery = true)
    List<Picture> queryPicturesOrOrderByCreateTime();

    @Modifying(clearAutomatically=true)
    @Transactional
    @Query(value = "insert into picture_share.picture(user_id,title,picture_data) value (?1,?2,?3)",nativeQuery = true)
    int insertPicture(long id, String title, String pictureData);

    @Query(value = "select * from picture_share.picture where user_id=?1 Order By create_time Desc",nativeQuery = true)
    List<Picture>  queryPersonalPicturesOrOrderByCreateTime(long userId);

    @Modifying(clearAutomatically=true)
    @Transactional
    @Query(value = "update picture_share.picture set like_num=like_num+1 where id=?1 ",nativeQuery = true)
    int updateLikeNum(long id);

    @Modifying(clearAutomatically=true)
    @Transactional
    @Query(value = "delete from picture_share.picture where  user_id=?1 ",nativeQuery = true)
    int deletePictureByUserId(long userId);

}

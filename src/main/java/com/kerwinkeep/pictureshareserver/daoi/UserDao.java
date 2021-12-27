package com.kerwinkeep.pictureshareserver.daoi;

import com.kerwinkeep.pictureshareserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface UserDao extends JpaRepository<User, Integer> {

    @Modifying(clearAutomatically=true)
    @Transactional
    @Query(value = "insert into picture_share.user(account,password,name) value (?1,?2,?3)",nativeQuery = true)
    int insertUser(String account,String password,String name);

    @Query(value = "select * from picture_share.user where account=?1 and password=?2",nativeQuery = true)
    User verifyLogin(String account,String password);

    @Query(value = "select * from picture_share.user where id=?1",nativeQuery = true)
    User findUserById(long id);


}

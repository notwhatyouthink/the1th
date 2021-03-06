package com.example.mybatis_demo.dao;

import com.example.mybatis_demo.bean.User;
import org.apache.ibatis.annotations.*;
import java.util.List;


@Mapper
public interface UserDao {

    @Select("select * from  user")
   public List<User>getallUser();

    @Select("select * from  user  where  id= #{id}")
    public User getuserbyId(Integer id);


    @Insert("insert into user (name,password, age ,sex) values (#{name},#{password},#{age},#{sex})")
    int addUser(User user);



    @Select("select * from  user  where  name= #{name}")
    public User getuserbyname(String name);


    @Update("update  user set password =#{password}  where  name= #{name}")
    public  int  upDatePassword(@Param("name") String name,
                                @Param("password") String password);

    @Delete("delete from user WHERE id = #{id}")
    int  deleteUser(@Param("id")Integer id);


    @Select("select * from  user limit #{curPage} ,#{pageSize}")
     public List<User>getallUserlimit(@Param("curPage") Integer curPage,@Param("pageSize") Integer pageSize);



    @Select("select * from  user  where  name  like %#{name}% ")
    public List<User>getallUserLike(@Param("name") String name);


     //多条件查询
    @Select("SELECT  *  FROM   USER  WHERE   NAME=#{name} AND  sex=#{sex}")
    List<User>getUserbyNameAndsex(@Param("name") String name, @Param("sex")String sex);



}

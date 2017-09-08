package com.gsq.demo;

import com.gsq.model.User;
import com.gsq.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by guishangquan on 2017/9/8.
 * 分片规则：t_user 表 id 字段模 3
 */
public class PartitionByModTest {

    public static void main(String[] args) {
        SqlSession session = SqlSessionUtils.getSqlSession(true);

        // 删除所有数据
        session.delete("userMapper.delUsers");

        // 插入数据，insert 完之后可以数据具体分片情况
        User user1 = new User(1, "gsq1", "pwd1");
        User user2 = new User(2, "gsq2", "pwd2");
        User user3 = new User(3, "gsq3", "pwd3");
        User user4 = new User(4, "gsq4", "pwd4");
        session.insert("userMapper.addUser", user1);
        session.insert("userMapper.addUser", user2);
        session.insert("userMapper.addUser", user3);
        session.insert("userMapper.addUser", user4);

        // 根据 id 查询数据
        User user5 = (User) session.selectOne("userMapper.getUser", 1);
        System.out.println("user5 = " + user5);
        User user6 = (User) session.selectOne("userMapper.getUser", 2);
        System.out.println("user6 = " + user6);
        User user7 = (User) session.selectOne("userMapper.getUser", 3);
        System.out.println("user7 = " + user7);
        User user8 = (User) session.selectOne("userMapper.getUser", 4);
        System.out.println("user8 = " + user8);

//        // 修改数据
//        user4.setUserName("user5");
//        user4.setPassword("pwd5");
//        session.update("userMapper.modifyUser");

        // 查询所有数据
        List<User> user9 = (List<User>) session.selectList("userMapper.getUsers");
        for (User user : user9) {
            System.out.println("user = " + user);
        }
    }
}

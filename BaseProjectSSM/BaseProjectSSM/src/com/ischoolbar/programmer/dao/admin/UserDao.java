package com.ischoolbar.programmer.dao.admin;

import com.ischoolbar.programmer.entity.admin.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @program: BaseProjectSSM
 * @description User 用户Dao
 * @author: SongJian
 * @create: 2019-02-23 11:00
 **/
@Repository
public interface UserDao {
    public User findByUsername(String username);
    public int add(User user);
    public int edit(User user);
    public int delete(String ids);
    public List<User> findList(Map<String ,Object> querymap);
    public int getTotal(Map<String ,Object> querymap);
    public int editPassword(User user);
}

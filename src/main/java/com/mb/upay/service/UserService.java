package com.mb.upay.service;

import com.mb.upay.model.User;
import java.util.List;

/**
 * Author:lwenm
 * Description:
 * Date:2019/3/5
 * Time:15:43
 **/
public interface UserService {


    /**
     * 添加user
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 分页查找所有user
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<User> findAllUser(int pageNum, int pageSize);

}

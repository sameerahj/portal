package org.dhara.portal.web.springHibernateSample.service;

import org.dhara.portal.web.springHibernateSample.dao.UserDao;
import org.dhara.portal.web.springHibernateSample.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: harsha
 * Date: 7/9/13
 * Time: 1:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserServiceImpl {

    @Autowired(required=true)
    private UserDao userDao;

    @Transactional
    public User createUser(User user) {
        return this.userDao.persistOrMerge(user);
    }

    @Transactional(readOnly=true)
    public User retrieveUser(Long id) {
        return this.userDao.findById(id);
    }

}

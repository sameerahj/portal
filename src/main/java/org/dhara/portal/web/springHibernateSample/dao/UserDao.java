package org.dhara.portal.web.springHibernateSample.dao;

/**
 * Created with IntelliJ IDEA.
 * User: harsha
 * Date: 7/9/13
 * Time: 1:03 PM
 * To change this template use File | Settings | File Templates.
 */

import org.dhara.portal.web.springHibernateSample.entity.User;

public interface UserDao {

    public User findById(Long id);
    public User persistOrMerge(User user);

}
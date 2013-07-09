package org.dhara.portal.web.springHibernateSample.service;

import org.dhara.portal.web.springHibernateSample.entity.User;

/**
 * Created with IntelliJ IDEA.
 * User: harsha
 * Date: 7/9/13
 * Time: 1:06 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UserService {
    public User retrieveUser(Long id);
    public User createUser(User user);
}

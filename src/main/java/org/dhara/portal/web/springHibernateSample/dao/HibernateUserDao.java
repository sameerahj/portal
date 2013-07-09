package org.dhara.portal.web.springHibernateSample.dao;

import org.dhara.portal.web.springHibernateSample.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * User: harsha
 * Date: 7/9/13
 * Time: 1:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class HibernateUserDao implements UserDao {
    @Autowired(required=true)
    private SessionFactory sessionFactory;

    public User findById(Long id) {
        return (User) this.sessionFactory.getCurrentSession().createQuery(
                "from User user where user.id=?").setParameter(0, id)
                .uniqueResult();
    }

    public User persistOrMerge(User user) {
        return (User) this.sessionFactory.getCurrentSession().merge(user);
    }
}

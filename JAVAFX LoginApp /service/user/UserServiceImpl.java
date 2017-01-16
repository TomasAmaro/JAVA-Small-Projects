package org.academiadecodigo.myApp.service.user;

import org.academiadecodigo.myApp.dao.UserDao;
import org.academiadecodigo.myApp.model.User;
import org.academiadecodigo.myApp.persistence.TransactionManager;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by codecadet on 01/12/16.
 */
@Transactional
public class UserServiceImpl implements UserService {

    UserDao userDao;
    TransactionManager transactionManager;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean authenticate(String email, String password) {
        User user = null;
        try {
            user = findByName(email);
            if (user == null) {
                return false;
            }
            return findByName(email).getEmail().equals(email) && findByName(email).getPassword().equals(password);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void addUser(User user) {
            userDao.add(user);
      /*  try {
            transactionManager.beginTransaction();
            transactionManager.commitTransaction();
        } catch (Exception e) {
            transactionManager.rollbackTransaction();
            e.printStackTrace();
        }*/
        //// TODO: 01/12/16 exceptions
    }

    @Override
    public User findByName(String email) {
        User user = null;
            user = userDao.findByName(email);
       /* try {
            transactionManager.beginTransaction();
            transactionManager.commitTransaction();
        } catch (Exception e) {
            transactionManager.rollbackTransaction();
            e.printStackTrace();
        }*/
        return user;
    }

    @Override
    public int count() {
        int count = userDao.count();
/*        transactionManager.beginTransaction();
        transactionManager.commitTransaction();*/
        return count;
    }

    @Override
    public String getServiceName() {
        return userDao.getClass().getName();
    }
}

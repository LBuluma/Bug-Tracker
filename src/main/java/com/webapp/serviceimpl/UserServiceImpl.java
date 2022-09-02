package com.webapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.dao.UserDao;
import com.webapp.model.User;
import com.webapp.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao usrDao;

	@Override
    @Transactional
    public List < User > getUsers() {
        return usrDao.getUsers();
    }

    @Override
    @Transactional
    public void saveUser(User theUser) {
        usrDao.saveUser(theUser);
    }

    @Override
    @Transactional
    public User getUser(int theId) {
        return usrDao.getUser(theId);
    }

//    @Override
//    @Transactional
//    public void deleteUser(int theId) {
//       usrDao.deleteUser(theId);
//    }

	

}

package com.ygep.service.impl.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ygep.mapper.user.UserMapper;
import com.ygep.model.user.User;
import com.ygep.service.user.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	public User selectByKey(int id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public User selectByLoginName(String loginName) {
		// TODO Auto-generated method stub
		
		return userMapper.selectByLoginName(loginName);
	}


}

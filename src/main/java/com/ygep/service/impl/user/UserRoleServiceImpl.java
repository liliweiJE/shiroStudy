package com.ygep.service.impl.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ygep.mapper.user.UserRoleMapper;
import com.ygep.service.user.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService{
	
	@Autowired
	private UserRoleMapper userRoleMapper;

}

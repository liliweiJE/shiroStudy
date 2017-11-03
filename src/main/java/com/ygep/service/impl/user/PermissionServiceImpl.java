package com.ygep.service.impl.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ygep.mapper.user.PermissionMapper;
import com.ygep.service.user.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService{

	@Autowired
	private PermissionMapper PermissionMapper;
}

package com.ygep.service.user;

import com.ygep.model.user.User;

public interface UserService {

	User selectByKey(int i);

	User selectByLoginName(String loginName);


}

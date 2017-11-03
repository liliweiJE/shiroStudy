package com.ygep.service.impl.shiro;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ygep.model.user.User;
import com.ygep.model.user.UserRole;
import com.ygep.service.user.UserService;

@Service
public class MyShiro extends AuthorizingRealm{
	
	@Autowired
	private UserService userService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		// TODO Auto-generated method stub
		//获取登入时输入的用户名
		String loginName 
			= (String)principalCollection.fromRealm(getName()).iterator().next();
		
		//验证用户是否存在
		User user=userService.selectByLoginName(loginName);
		
		if(user!=null){
			//权限信息对象，用来存放所有的角色和权限
			 SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();  
			 //存放所有的角色，如果用角色区分权限就到此结束
			 info.setRoles(user.getRolesName());
			 
			 List<UserRole> userRoles = user.getUserRoles();
				
				for (UserRole userRole : userRoles) {
					info.addStringPermissions(userRole.getRole().getPermissionsName());
				}
				
				return info;
		}
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo
	(AuthenticationToken authenticationToken) throws AuthenticationException {
		// TODO Auto-generated method stub
		//UsernamePasswordToken对象用来存放提交的登录信息 
		UsernamePasswordToken token=
				(UsernamePasswordToken) authenticationToken;
		
		//验证用户是否存在
		User user=userService.selectByLoginName(token.getUsername());
		   if(user!=null){  
	         /*   //若存在，将此用户存放到登录认证info中  
			  Subject subject = SecurityUtils.getSubject();
			    User user2 =(User)subject.getPrincipal();
			  Session session = subject.getSession();
			  session.setAttribute("user", user);*/
	            return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());
	        }  
		return null;
	}

}

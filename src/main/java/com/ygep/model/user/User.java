package com.ygep.model.user;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {
    private Integer id;

    private String username;

    private String password;
    
    private List<UserRole> userRoles;
    
    public List<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

	public Set<String> getRolesName() {
		Set<String> rolesName=null;
		List<UserRole> userRoles = getUserRoles();
		if(null!=userRoles&&userRoles.size()>0){
			rolesName=new HashSet<String>();
			for (UserRole ur : userRoles) {
				rolesName.add(ur.getRole().getRolename());
			}
		}
		return rolesName;
	}
    
}
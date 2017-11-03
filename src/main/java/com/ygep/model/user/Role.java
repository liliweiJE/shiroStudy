package com.ygep.model.user;

import java.util.ArrayList;
import java.util.List;

public class Role {
    private Integer id;

    private String rolename;
    
    private List<Permission> permissions;
    
    public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }
    
    public List<String> getPermissionsName(){  
        List<String> list=null;  
        List<Permission> getPermissions = getPermissions();
        if(null!=permissions&&permissions.size()>0){
        	list=new ArrayList<String>();
        	for (Permission per : getPermissions) {  
                list.add(per.getPermissionname());  
            } 
        }
        return list;  
    }  
}
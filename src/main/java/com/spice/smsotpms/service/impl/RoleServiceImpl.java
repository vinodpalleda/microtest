package com.spice.smsotpms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spice.smsotpms.entity.Role;
import com.spice.smsotpms.repository.RoleRepo;

@Service(value = "roleService")
public class RoleServiceImpl {

    @Autowired
    private RoleRepo roleRepo;

    public Role findByName(String name) {
        Role role = roleRepo.findRoleByName(name);
        return role;
    }
	
	public List<Role> findAll() {
		List<Role> list = new ArrayList<>();
		roleRepo.findAll().iterator().forEachRemaining(list::add);
		return list;
	}
}

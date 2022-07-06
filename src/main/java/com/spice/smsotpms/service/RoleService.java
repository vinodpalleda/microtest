package com.spice.smsotpms.service;

import java.util.List;

import com.spice.smsotpms.entity.Role;

public interface RoleService {
	Role findByName(String name);
    List<Role> findAll();
}

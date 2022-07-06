package com.spice.smsotpms.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spice.smsotpms.entity.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, UUID> {
    Role findRoleByName(String name);
}

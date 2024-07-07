package net.proselyte.springbootdemo.service;

import net.proselyte.springbootdemo.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllUser();

    void save(Role role);

    Role showUserById(Long id);

    Role findById(Long id);

    Role findByRoleName(String roleName);
}
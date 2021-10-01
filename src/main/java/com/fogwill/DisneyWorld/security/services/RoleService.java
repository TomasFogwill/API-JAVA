package com.fogwill.DisneyWorld.security.services;

import java.util.Optional;

import javax.transaction.Transactional;

import com.fogwill.DisneyWorld.security.enums.RoleName;
import com.fogwill.DisneyWorld.security.models.Role;
import com.fogwill.DisneyWorld.security.repositories.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public Optional<Role> getByRoleName(RoleName roleName){
        return roleRepository.findByRoleName(roleName);
    }

    public void save(Role role){
        roleRepository.save(role);
    }
    
    
}

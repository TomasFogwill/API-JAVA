package com.fogwill.DisneyWorld.security.repositories;

import java.util.Optional;

import com.fogwill.DisneyWorld.security.enums.RoleName;
import com.fogwill.DisneyWorld.security.models.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

   Optional<Role> findByRoleName(RoleName roleName);
}

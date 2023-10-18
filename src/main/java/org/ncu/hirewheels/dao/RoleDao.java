package org.ncu.hirewheels.dao;

import org.ncu.hirewheels.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RoleDao extends JpaRepository<Role, Long> {
    List<Role> findByRoleNameIgnoreCase(String roleName);
}
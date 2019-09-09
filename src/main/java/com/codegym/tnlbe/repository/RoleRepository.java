package com.codegym.tnlbe.repository;

import com.codegym.tnlbe.entity.Role;
import com.codegym.tnlbe.entity.RoleName;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}

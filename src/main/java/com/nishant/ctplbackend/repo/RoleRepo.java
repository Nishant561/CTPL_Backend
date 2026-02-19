package com.nishant.ctplbackend.repo;

import com.nishant.ctplbackend.enums.RoleEnums;
import com.nishant.ctplbackend.model.user.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepo extends JpaRepository<Roles , Integer> {

    Optional<Roles> findByRoleName(RoleEnums roleName);


}

package com.nishant.ctplbackend.model.user;

import com.nishant.ctplbackend.base.BaseEntity;
import com.nishant.ctplbackend.enums.RoleEnums;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "role")
public class Roles extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleId;

    @Enumerated(EnumType.STRING)
    private RoleEnums roleName;

    @ManyToMany(mappedBy = "userRole")
    private Set<Users> users = new HashSet<>();




}

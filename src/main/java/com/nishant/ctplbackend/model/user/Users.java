package com.nishant.ctplbackend.model.user;

import com.nishant.ctplbackend.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Users extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String userEmail;

    private String userName;

    private String userPassword;

    private String userRole;

    private String userPhoneNumber;

}

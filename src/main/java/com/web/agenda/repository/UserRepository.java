package com.web.agenda.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.agenda.models.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID>{

}

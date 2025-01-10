package com.teamlink.team_link.repositories;

import com.teamlink.team_link.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID> {
    @Query(value = "SELECT * FROM tb_user WHERE email = :email", nativeQuery = true)
    UserModel findUserByEmail(@Param("email") String email);

    @Query(value = "SELECT * FROM tb_user WHERE name = :name", nativeQuery = true)
    UserModel findUserByName(@Param("name") String name);
}

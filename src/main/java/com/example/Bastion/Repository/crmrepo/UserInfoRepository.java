package com.example.Bastion.Repository.crmrepo;

import com.example.Bastion.entitty.crmentity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepository extends JpaRepository<User,Integer> {
    Optional<User> findByUserName(String userName);
}

package com.wa.repository;


import com.wa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByMobile(String mobile);

    User findByMobile(String mobile);

}

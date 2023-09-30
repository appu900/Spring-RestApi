package com.appu.restapi7.Repository;

import com.appu.restapi7.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {



}

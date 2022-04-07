package com.assignment.two.assignmenttwo.repo;

import com.assignment.two.assignmenttwo.entity.Role;
import com.assignment.two.assignmenttwo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role,Long> {


}

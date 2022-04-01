package com.assignment.two.assignmenttwo.repo;

import com.assignment.two.assignmenttwo.entity.Logger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoggerRepository extends JpaRepository<Logger,Long> {
}

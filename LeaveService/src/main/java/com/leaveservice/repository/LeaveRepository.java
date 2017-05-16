package com.leaveservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leaveservice.model.Leave;

@Repository
public interface LeaveRepository extends JpaRepository<Leave, Long>{

}

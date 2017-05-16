package com.leaveservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leaveservice.model.PeopleLeaves;

public interface PeopleLeaveRepository extends JpaRepository<PeopleLeaves, Long> {

}

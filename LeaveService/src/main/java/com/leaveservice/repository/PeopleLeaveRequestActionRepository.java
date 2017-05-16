package com.leaveservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leaveservice.model.PeopleLeaveRequestAction;

public interface PeopleLeaveRequestActionRepository extends JpaRepository<PeopleLeaveRequestAction, Long> {

}

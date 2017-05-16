package com.projectservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectservice.model.ProjectPeople;

public interface ProjectPeopleRepository extends JpaRepository<ProjectPeople, Long> {

}

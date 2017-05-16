package com.vmware.projects.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vmware.projects.model.People;

@Repository
public interface PeopleRepository extends JpaRepository<People, Long> {

}

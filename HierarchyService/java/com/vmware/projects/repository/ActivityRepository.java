package com.vmware.projects.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vmware.projects.model.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long>{

}

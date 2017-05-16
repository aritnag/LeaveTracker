package com.vmware.projects.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vmware.projects.model.PeopleRoleHierarchy;

@Repository
public interface PeopleRoleHierarchyRepository extends JpaRepository<PeopleRoleHierarchy, Long> {

}

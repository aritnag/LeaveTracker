package com.vmware.projects.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vmware.projects.model.Role;

import com.vmware.projects.repository.RoleRepository;


@Service
public class RoleServiceImpl {

 
	@Autowired
	RoleRepository roleRepository;

	 

	
	@Transactional
	public String saveRole(List<Role> roles) {

		String response = "";

		try {

			roleRepository.save(roles);

			response = "Saved Successfully";

		} catch (Exception e) {

			response = "Failed to save people. Please try again";
			e.printStackTrace();
		}

		return response;
	}

	public List<Role> getAllRoles() {

		List<Role> roles = roleRepository.findAll();

		return roles;
	}

	public Role getRoleById(Long roleId) {

		Role people = null;
		try {

			people = roleRepository.findOne(roleId);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return people;
	}

	
}

package com.vmware.projects.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vmware.projects.model.People;

import com.vmware.projects.repository.PeopleRepository;


@Service
public class UserServiceImpl {

 
	@Autowired
	PeopleRepository peopleRepository;

	 

	
	@Transactional
	public String savePeople(List<People> peoples) {

		String response = "";

		try {

			peopleRepository.save(peoples);

			response = "Saved Successfully";

		} catch (Exception e) {

			response = "Failed to save people. Please try again";
			e.printStackTrace();
		}

		return response;
	}

	public List<People> getAllPeoples() {

		List<People> peoples = peopleRepository.findAll();

		return peoples;
	}

	public People getPeopleById(Long peopleId) {

		People people = null;
		try {

			people = peopleRepository.findOne(peopleId);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return people;
	}

	
}

package com.vmware.projects.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vmware.projects.model.PeopleRoleHierarchy;

import com.vmware.projects.repository.PeopleRoleHierarchyRepository;


@Service
public class PeopleRoleHierarchyService {

 
	@Autowired
	PeopleRoleHierarchyRepository peopleRepository;

	 

	
	@Transactional
	public String savePeople(List<PeopleRoleHierarchy> peoples) {

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

	public List<PeopleRoleHierarchy> getAllPeoples() {

		List<PeopleRoleHierarchy> peoples = peopleRepository.findAll();

		return peoples;
	}

	public PeopleRoleHierarchy getPeopleById(Long peopleId) {

		PeopleRoleHierarchy people = null;
		try {

			List<PeopleRoleHierarchy> peoples = peopleRepository.findAll();
			for(PeopleRoleHierarchy p:peoples)
			{
				if(p.getPeopleId()==peopleId){
					people=p;
					return people;
				}
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return people;
	}
	
	public PeopleRoleHierarchy getPeopleByRoleId(Long roleId) {

		PeopleRoleHierarchy people = null;
		try {

			List<PeopleRoleHierarchy> peoples = peopleRepository.findAll();
			for(PeopleRoleHierarchy p:peoples)
			{
				if(p.getRoleId()==roleId){
					people=p;
					return people;
				}
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return people;
	}

	public List<PeopleRoleHierarchy> getPeopleByReportedPeopleId(Long peopleId) {

		List<PeopleRoleHierarchy> hierarchies = new ArrayList<PeopleRoleHierarchy>();
		try {

			List<PeopleRoleHierarchy> peoples = peopleRepository.findAll();
			for(PeopleRoleHierarchy p:peoples)
			{
				if(p.getPeopleIdReportedTo()==peopleId){
					PeopleRoleHierarchy hierarchy=new PeopleRoleHierarchy();
					hierarchy.setIsActive(p.getIsActive());
					hierarchy.setPeopleId(p.getPeopleId());
					hierarchy.setPeopleRoleHierarchyId(p.getPeopleRoleHierarchyId());
					hierarchy.setRoleId(p.getRoleId());
					hierarchy.setPeopleRoleHierarchyId(p.getPeopleRoleHierarchyId());
					hierarchies.add(hierarchy);
				}
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return hierarchies;
	}
	
}

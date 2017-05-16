package com.vmware.projects.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.vmware.projects.model.PeopleRoleHierarchy;
import com.vmware.projects.service.impl.PeopleRoleHierarchyService;

@Controller
public class HierarchyController {


	@Autowired
	PeopleRoleHierarchyService projectServiceImpl;


	@RequestMapping(value = "/peopleRole", method = RequestMethod.POST)
	@ResponseBody
	public String savePeople(@RequestBody List<PeopleRoleHierarchy> peoples) {

		return projectServiceImpl.savePeople(peoples);
	}

	@RequestMapping(value = "/peopleRole", method = RequestMethod.GET)
	@ResponseBody
	public List<PeopleRoleHierarchy> getAllPeoples() {

		return projectServiceImpl.getAllPeoples();
	}

	@RequestMapping(value = "/peopleRole/peopleId/{peopleId}", method = RequestMethod.GET)
	@ResponseBody
	public PeopleRoleHierarchy getPeople(@PathVariable Long peopleId) {

		return projectServiceImpl.getPeopleById(peopleId);
	}

	@RequestMapping(value = "/peopleRole/roleId/{roleId}", method = RequestMethod.GET)
	@ResponseBody
	public PeopleRoleHierarchy getPeopleByRoleId(@PathVariable Long roleId) {

		return projectServiceImpl.getPeopleByRoleId(roleId);
	}
	
	@RequestMapping(value = "/peopleReportee/{peopleId}", method = RequestMethod.GET)
	@ResponseBody
	public List<PeopleRoleHierarchy> getAllPeoplesReporteeByPeopleId(@PathVariable Long peopleId) {

		return projectServiceImpl.getPeopleByReportedPeopleId(peopleId);
	
	}

}

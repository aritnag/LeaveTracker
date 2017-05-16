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

import com.vmware.projects.model.People;
import com.vmware.projects.service.impl.UserServiceImpl;

@Controller
public class UserController {


	@Autowired
	UserServiceImpl projectServiceImpl;

	@RequestMapping(value = "/project", method = RequestMethod.GET)
	public ModelAndView project(HttpSession session) {
		ModelAndView view = new ModelAndView("projects");
		return view;

	}
	@RequestMapping(value = "/people", method = RequestMethod.POST)
	@ResponseBody
	public String savePeople(@RequestBody List<People> peoples) {

		return projectServiceImpl.savePeople(peoples);
	}

	@RequestMapping(value = "/people", method = RequestMethod.GET)
	@ResponseBody
	public List<People> getAllPeoples() {

		return projectServiceImpl.getAllPeoples();
	}

	@RequestMapping(value = "/people/{peopleId}", method = RequestMethod.GET)
	@ResponseBody
	public People getPeople(@PathVariable Long peopleId) {

		return projectServiceImpl.getPeopleById(peopleId);
	}

	


}

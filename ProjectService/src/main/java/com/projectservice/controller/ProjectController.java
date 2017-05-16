package com.projectservice.controller;

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


import com.projectservice.model.Project;
import com.projectservice.model.ProjectPeople;
import com.projectservice.service.impl.ProjectService;
import com.projectservice.vo.ProjectDetailsVO;
import com.projectservice.vo.ProjectPeopleVO;
import com.projectservice.vo.ProjectVO;

@Controller
public class ProjectController {
	@Autowired
	ProjectService projectserviceimpl;

	 
	@RequestMapping(value = "/projects", method = RequestMethod.POST)
	@ResponseBody
	public String saveProject(@RequestBody List<Project> projects) {

		return projectserviceimpl.saveProject(projects);
	}
	
	@RequestMapping(value = "/projectPeople", method = RequestMethod.POST)
	@ResponseBody
	public String saveProjectPeople(@RequestBody List<ProjectPeople> projects) {

		return projectserviceimpl.saveProjectPeople(projects);
	}

	@RequestMapping(value = "/project/{projectId}", method = RequestMethod.GET)
	@ResponseBody
	public ProjectVO getProject(@PathVariable Long projectId) {

		return projectserviceimpl.getProjectById(projectId);
	}
	
	@RequestMapping(value = "/project/people/{peopleId}", method = RequestMethod.GET)
	@ResponseBody
	public List<ProjectDetailsVO> getProjectByPeopleId(@PathVariable Long peopleId) {

		return projectserviceimpl.getProjectByPeopleId(peopleId);
	}
	
	@RequestMapping(value = "/project/project/{projectId}", method = RequestMethod.GET)
	@ResponseBody
	public List<ProjectDetailsVO> getProjectByProjectId(@PathVariable Long projectId) {

		return projectserviceimpl.getPoepleByProjectId(projectId);
	}

	@RequestMapping(value = "/projects", method = RequestMethod.GET)
	@ResponseBody
	public List<ProjectVO> getAllProjects() {

		return projectserviceimpl.getAllProjects();
	}
	
	@RequestMapping(value = "/projectPeoples", method = RequestMethod.GET)
	@ResponseBody
	public List<ProjectPeopleVO> getAllProjectPeoples() {

		return projectserviceimpl.getAllProjectPeople();
	}
	

}

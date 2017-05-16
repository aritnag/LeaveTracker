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

import com.vmware.projects.model.Activity;
import com.vmware.projects.model.People;
import com.vmware.projects.model.Project;
import com.vmware.projects.model.ProjectCategory;
import com.vmware.projects.service.impl.ProjectServiceImpl;
import com.vmware.projects.vo.CategoryResponseVO;
import com.vmware.projects.vo.CategoryVO;
import com.vmware.projects.vo.ProjectCategoryVO;
import com.vmware.projects.vo.ProjectMemberVO;

@Controller
public class ProjectController {

	@Autowired
	ProjectServiceImpl projectServiceImpl;

	@RequestMapping(value = "/project", method = RequestMethod.GET)
	public ModelAndView project(HttpSession session) {
		ModelAndView view = new ModelAndView("projects");
		return view;

	}

	@RequestMapping(value = "/categories", method = RequestMethod.POST)
	@ResponseBody
	public String saveCategory(@RequestBody List<ProjectCategory> categories) {

		return projectServiceImpl.saveCategory(categories);
	}

	@RequestMapping(value = "/category/{categoryId}", method = RequestMethod.GET)
	@ResponseBody
	public ProjectCategoryVO getCategory(@PathVariable Long categoryId) {

		return projectServiceImpl.getCategoryById(categoryId);
	}

	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	@ResponseBody
	public List<CategoryVO> getAllCategories() {

		return projectServiceImpl.getAllCategories();
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

	@RequestMapping(value = "/category/{categoryId}/project", method = RequestMethod.POST)
	@ResponseBody
	public String saveProject(@PathVariable Long categoryId, @RequestBody List<Project> projects) {

		return projectServiceImpl.saveProject(categoryId, projects);
	}

	@RequestMapping(value = "/project/{projectId}", method = RequestMethod.GET)
	@ResponseBody
	public ProjectMemberVO getProject(@PathVariable Long projectId) {

		return projectServiceImpl.getProjectById(projectId);
	}

	@RequestMapping(value = "/category/{categoryId}/projects", method = RequestMethod.GET)
	@ResponseBody
	public List<Project> getAllProjects(@PathVariable Long categoryId) {

		return projectServiceImpl.getProjects(categoryId);
	}

	@RequestMapping(value = "/project/{projectId}/people/{peopleId}", method = RequestMethod.POST)
	@ResponseBody
	public String saveProjectMember(@PathVariable Long projectId, @PathVariable Long peopleId) {

		return projectServiceImpl.saveProjectMember(projectId, peopleId);
	}

	@RequestMapping(value = "/categories/all", method = RequestMethod.GET)
	@ResponseBody
	public List<CategoryResponseVO> getAllDetails() {

		return projectServiceImpl.getAllDetails();
	}

	@RequestMapping(value = "/activities", method = RequestMethod.POST)
	@ResponseBody
	public String saveActivities(@RequestBody List<Activity> activities) {

		return projectServiceImpl.saveActivities(activities);
	}

	@RequestMapping(value = "/activities", method = RequestMethod.GET)
	@ResponseBody
	public List<Activity> getActivities() {

		return projectServiceImpl.getAllActivities();
	}

}

package com.vmware.projects.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vmware.projects.model.Activity;
import com.vmware.projects.model.People;
import com.vmware.projects.model.Project;
import com.vmware.projects.model.ProjectCategory;
import com.vmware.projects.model.ProjectMember;
import com.vmware.projects.repository.ActivityRepository;
import com.vmware.projects.repository.PeopleRepository;
import com.vmware.projects.repository.ProjectCategoryRepository;
import com.vmware.projects.repository.ProjectMemberRepository;
import com.vmware.projects.repository.ProjectRepository;
import com.vmware.projects.vo.CategoryResponseVO;
import com.vmware.projects.vo.CategoryVO;
import com.vmware.projects.vo.PeopleVO;
import com.vmware.projects.vo.ProjectCategoryVO;
import com.vmware.projects.vo.ProjectMemberVO;
import com.vmware.projects.vo.ProjectResponseVO;
import com.vmware.projects.vo.ProjectVO;

@Service
public class ProjectServiceImpl {

	@Autowired
	ProjectCategoryRepository projectCategoryRepository;

	@Autowired
	PeopleRepository peopleRepository;

	@Autowired
	ProjectRepository projectRepository;

	@Autowired
	ProjectMemberRepository projectMemberRepository;

	@Autowired
	ActivityRepository activityRepository;

	@Transactional
	public String saveCategory(List<ProjectCategory> categories) {

		String response = "";

		try {

			projectCategoryRepository.save(categories);

			response = "Saved Successfully";

		} catch (Exception e) {
			response = "Failed to save category. Please try again";
			e.printStackTrace();
		}

		return response;
	}

	public ProjectCategoryVO getCategoryById(Long categoryId) {

		ProjectCategoryVO projCategory = new ProjectCategoryVO();
		CategoryVO categoryVO = new CategoryVO();
		List<ProjectVO> projects = new ArrayList<ProjectVO>();
		try {

			ProjectCategory category = projectCategoryRepository.findOne(categoryId);

			categoryVO.setCategoryId(category.getCategoryId());
			categoryVO.setName(category.getName());
			categoryVO.setDescription(category.getDescription());

			for (Project project : category.getProjects()) {

				ProjectVO projectVO = new ProjectVO();
				projectVO.setProjectId(project.getProjectId());
				projectVO.setProjectName(project.getProjectName());
				projects.add(projectVO);

			}

			projCategory.setCategory(categoryVO);
			projCategory.setProjects(projects);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return projCategory;
	}

	public List<CategoryVO> getAllCategories() {

		List<ProjectCategory> categories = projectCategoryRepository.findAll();

		List<CategoryVO> projCategories = new ArrayList<CategoryVO>();

		for (ProjectCategory category : categories) {
			CategoryVO categoryVO = new CategoryVO();
			categoryVO.setCategoryId(category.getCategoryId());
			categoryVO.setName(category.getName());
			categoryVO.setDescription(category.getDescription());
			projCategories.add(categoryVO);
		}

		return projCategories;
	}

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

	@Transactional
	public String saveProject(Long categoryId, List<Project> projects) {

		String response = "";

		try {

			ProjectCategory category = new ProjectCategory();
			category.setCategoryId(categoryId);

			for (Project project : projects) {
				project.setProjectCategory(category);
			}

			projectRepository.save(projects);

			response = "Saved Successfully";

		} catch (Exception e) {

			response = "Failed to save Project. Please try again";
			e.printStackTrace();
		}

		return response;
	}

	public List<Project> getProjects(Long categoryId) {

		ProjectCategory category = new ProjectCategory();// (categoryId);
		List<Project> projects = new ArrayList<Project>();

		if (category != null) {
			projects = category.getProjects();
		}

		return projects;
	}

	public ProjectMemberVO getProjectById(Long projectId) {

		ProjectMemberVO memberVO = new ProjectMemberVO();
		ProjectVO projectVO = new ProjectVO();
		List<PeopleVO> peoples = new ArrayList<PeopleVO>();

		Project project = projectRepository.findOne(projectId);

		projectVO.setProjectId(project.getProjectId());
		projectVO.setProjectName(project.getProjectName());
		projectVO.setDescription(project.getDescription());

		for (ProjectMember member : project.getProjectMembers()) {

			PeopleVO peopleVO = new PeopleVO();
			peopleVO.setPeopleId(member.getPeople().getPeopleId());
			peopleVO.setFirstName(member.getPeople().getFirstName());
			peopleVO.setLastName(member.getPeople().getLastName());
			peopleVO.setEmail(member.getPeople().getEmail());
			peoples.add(peopleVO);

		}

		memberVO.setProject(projectVO);
		memberVO.setTeamMembers(peoples);

		return memberVO;

	}

	@Transactional
	public String saveProjectMember(Long projectId, Long peopleId) {

		String response = "";

		try {

			ProjectMember projMember = new ProjectMember(projectId, peopleId);
			projectMemberRepository.save(projMember);

			response = "Saved Successfully";

		} catch (Exception e) {

			response = "Failed to save Project member. Please try again";
			e.printStackTrace();
		}

		return response;
	}

	public List<CategoryResponseVO> getAllDetails() {

		List<ProjectCategory> categories = projectCategoryRepository.findAll();

		List<CategoryResponseVO> finalList = new ArrayList<CategoryResponseVO>();

		for (ProjectCategory category : categories) {

			CategoryResponseVO categoryResp = new CategoryResponseVO();

			categoryResp.setCategoryId(category.getCategoryId());
			categoryResp.setName(category.getName());
			categoryResp.setDescription(category.getDescription());

			List<ProjectResponseVO> projectList = new ArrayList<>();

			for (Project project : category.getProjects()) {

				ProjectResponseVO projectResp = new ProjectResponseVO();
				projectResp.setProjectId(project.getProjectId());
				projectResp.setProjectName(project.getProjectName());
				projectResp.setDescription(project.getDescription());

				List<PeopleVO> peopleList = new ArrayList<PeopleVO>();

				for (ProjectMember member : project.getProjectMembers()) {
					peopleList.add(toPeopleVO(member.getPeople()));
				}

				projectResp.setTeamMembers(peopleList);

				projectList.add(projectResp);

			}

			categoryResp.setProjects(projectList);

			finalList.add(categoryResp);

		}

		return finalList;
	}

	private CategoryVO toCategoryVO(ProjectCategory category) {

		CategoryVO categoryVO = new CategoryVO();
		categoryVO.setCategoryId(category.getCategoryId());
		categoryVO.setName(category.getName());
		categoryVO.setDescription(category.getDescription());

		return categoryVO;
	}

	private ProjectVO toProjectVO(Project project) {

		ProjectVO projectVO = new ProjectVO();
		projectVO.setProjectId(project.getProjectId());
		projectVO.setProjectName(project.getProjectName());
		projectVO.setDescription(project.getDescription());

		return projectVO;
	}

	private PeopleVO toPeopleVO(People people) {

		PeopleVO peopleVO = new PeopleVO();
		peopleVO.setPeopleId(people.getPeopleId());
		peopleVO.setFirstName(people.getFirstName());
		peopleVO.setLastName(people.getLastName());
		peopleVO.setEmail(people.getEmail());

		return peopleVO;
	}

	public String saveActivities(List<Activity> activities) {
		String response = "";

		try {

			activityRepository.save(activities);

			response = "Saved Successfully";

		} catch (Exception e) {

			response = "Failed to save activities. Please try again";
			e.printStackTrace();
		}

		return response;
	}

	public List<Activity> getAllActivities() {
		return activityRepository.findAll();
	}
}

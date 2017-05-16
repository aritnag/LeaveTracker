package com.projectservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.projectservice.model.Project;
import com.projectservice.model.ProjectPeople;
import com.projectservice.repository.ProjectPeopleRepository;
import com.projectservice.repository.ProjectRepository;
import com.projectservice.vo.ProjectDetailsVO;
import com.projectservice.vo.ProjectPeopleVO;
import com.projectservice.vo.ProjectVO;

@Service
public class ProjectService {

	@Autowired
	ProjectRepository projectRepository;
	@Autowired
	ProjectPeopleRepository projectPeopleRepository;
	@javax.transaction.Transactional
	public String saveProject(List<Project> projectDetails) {

		String response = "";

		try {

			projectRepository.save(projectDetails);
            
			response = "Saved Successfully";

		} catch (Exception e) {
			response = "Failed to save category. Please try again";
			e.printStackTrace();
		}

		return response;
	}
	
	@javax.transaction.Transactional
	public String saveProjectPeople(List<ProjectPeople> projectPeopleDetails) {

		String response = "";

		try {

			projectPeopleRepository.save(projectPeopleDetails);
            
			response = "Saved Successfully";

		} catch (Exception e) {
			response = "Failed to save category. Please try again";
			e.printStackTrace();
		}

		return response;
	}
	
	public ProjectVO getProjectById(Long projectId) {
		ProjectVO projectVO=new ProjectVO();
		try {
		   Project project= projectRepository.findOne(projectId);
		   projectVO.setIsActive(project.getIsActive());
		   projectVO.setProjectDetails(project.getProjectDetails());
		   projectVO.setProjectId(project.getProjectId());
		   projectVO.setProjectName(project.getProjectName());
		   

		} catch (Exception e) {

			e.printStackTrace();
		}

		return projectVO;
	}
	
	public ProjectPeopleVO getProjectPeopleById(Long projectPeopleId) {
		ProjectPeopleVO projectPeopleVO=new ProjectPeopleVO();
		try {
		   ProjectPeople projectPeople= projectPeopleRepository.findOne(projectPeopleId);
		   projectPeopleVO.setPeopleId(projectPeople.getPeopleId());
		   projectPeopleVO.setProjectId(projectPeople.getProjectId());
		   projectPeopleVO.setProjectLeadId(projectPeople.getProjectLeadId());
		   projectPeopleVO.setProjectPeopleId(projectPeople.getProjectPeopleId());
		   

		} catch (Exception e) {

			e.printStackTrace();
		}

		return projectPeopleVO;
	}

	public List<ProjectVO> getAllProjects() {

		List<Project> projects = projectRepository.findAll();

		List<ProjectVO> projectPOJOList = new ArrayList<ProjectVO>();

		
		for(Project project : projects)
		{
		 	ProjectVO projectVO=new ProjectVO();
		 	projectVO.setIsActive(project.getIsActive());
			 projectVO.setProjectDetails(project.getProjectDetails());
			   projectVO.setProjectId(project.getProjectId());
			   projectVO.setProjectName(project.getProjectName());
			projectPOJOList.add(projectVO);
			  
		 	
		}

		return projectPOJOList;
	}
	
	public List<ProjectPeopleVO> getAllProjectPeople() {

		List<ProjectPeople> projects = projectPeopleRepository.findAll();

		List<ProjectPeopleVO> projectPOJOList = new ArrayList<ProjectPeopleVO>();

		
		for(ProjectPeople project : projects)
		{
			ProjectPeopleVO projectPeopleVO=new ProjectPeopleVO();
				projectPeopleVO.setPeopleId(project.getPeopleId());
			   projectPeopleVO.setProjectId(project.getProjectId());
			   projectPeopleVO.setProjectLeadId(project.getProjectLeadId());
			   projectPeopleVO.setProjectPeopleId(project.getProjectPeopleId());
			projectPOJOList.add(projectPeopleVO);
			  
		 	
		}

		return projectPOJOList;
	}
	
	public List<ProjectDetailsVO> getProjectByPeopleId(Long peopleId) {

		List<ProjectPeople> projects = projectPeopleRepository.findAll();

		List<ProjectDetailsVO> projectPOJOList = new ArrayList<ProjectDetailsVO>();

		
		for(ProjectPeople project : projects)
		{
			if(peopleId==project.getPeopleId()){
				ProjectDetailsVO projectDetailsVO=new ProjectDetailsVO();
				ProjectVO projectDetails=getProjectById(project.getProjectId());
				projectDetailsVO.setProject(projectDetails);
				ProjectPeopleVO projectPeopleVO=new ProjectPeopleVO();
				projectPeopleVO.setPeopleId(project.getPeopleId());
			   projectPeopleVO.setProjectId(project.getProjectId());
			   projectPeopleVO.setProjectLeadId(project.getProjectLeadId());
			   projectPeopleVO.setProjectPeopleId(project.getProjectPeopleId());
			   projectDetailsVO.setProjectPeople(projectPeopleVO);
			   projectPOJOList.add(projectDetailsVO);	
			}
			
			  
		 	
		}

		return projectPOJOList;
	}
	
	public List<ProjectDetailsVO> getPoepleByProjectId(Long projectId) {

		List<ProjectPeople> projects = projectPeopleRepository.findAll();

		List<ProjectDetailsVO> projectPOJOList = new ArrayList<ProjectDetailsVO>();

		
		for(ProjectPeople project : projects)
		{
			if(projectId==project.getProjectId()){
				ProjectDetailsVO projectDetailsVO=new ProjectDetailsVO();
				ProjectVO projectDetails=getProjectById(project.getProjectId());
				projectDetailsVO.setProject(projectDetails);
				ProjectPeopleVO projectPeopleVO=new ProjectPeopleVO();
				projectPeopleVO.setPeopleId(project.getPeopleId());
			   projectPeopleVO.setProjectId(project.getProjectId());
			   projectPeopleVO.setProjectLeadId(project.getProjectLeadId());
			   projectPeopleVO.setProjectPeopleId(project.getProjectPeopleId());
			   projectDetailsVO.setProjectPeople(projectPeopleVO);
			   projectPOJOList.add(projectDetailsVO);	
			}
			
			  
		 	
		}

		return projectPOJOList;
	}
	
}

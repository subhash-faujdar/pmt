package com.mgmt.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mgmt.entity.Project;
import com.mgmt.exception.ResourceNotFoundException;
import com.mgmt.repository.ProjectRepository;
import com.mgmt.repository.TaskRepository;

@Service
public class ProjectServiceImpl implements ProjectService{
 
	@Autowired
	TaskRepository taskRepository;
	
	@Autowired
	ProjectRepository projectRepository;

	@Override
	public List<Project> getAllProjects(){
		return projectRepository.findAll();
	}
	
	@Override
	public Project createProject(Project project) {
		return projectRepository.save(project);
	}
	

	@Override
	public Project getProjectById(Long id) {
		Project project = projectRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Project does not exist with id :" + id));
		return project;
	}
	
	@Override
	public Project updateProject(Long id, Project projectDetails) {
		Project project = projectRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Project does not exist with id :" + id));
		
		project.setProject_description(projectDetails.getProject_description());
		
		Project updatedProject = projectRepository.save(project);;
		
					
		return updatedProject;
	}
	
	@Override
	public Map<String, Boolean> deleteProject(Long id) {
		Project project = projectRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Project not exist with id :" + id));
				
		projectRepository.delete(project);
		Map<String, Boolean> response = new java.util.HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	
}

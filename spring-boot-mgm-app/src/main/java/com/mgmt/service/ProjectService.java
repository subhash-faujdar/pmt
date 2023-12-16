package com.mgmt.service;

import java.util.List;
import java.util.Map;

import com.mgmt.entity.Project;

public interface ProjectService {
	
	public List<Project> getAllProjects();
	
	public Project createProject(Project project);
	
	public Project getProjectById(Long id);
	
	public Project updateProject(Long id, Project projectDetails);
	
	public Map<String, Boolean> deleteProject(Long id);
	
}

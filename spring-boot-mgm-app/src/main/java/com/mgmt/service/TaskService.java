package com.mgmt.service;

import java.util.List;
import java.util.Map;

import com.mgmt.entity.Project;
import com.mgmt.entity.Task;

public interface TaskService {
	
	public List<Task> getAllTasks();
	
	public List<Project> getAllProjects();
	
	public Task saveTask(Task task);
	
	public Project saveProject(Project project);
	
	public Task getTaskById(Long id);
	
	public Task updateTask(Long id, Task taskDetails);
	
	public Map<String, Boolean> deleteTask(Long id);
	
	public List<Task> getSortedTasks(Integer pageNo, Integer pageSize, String sortBy);
	
}

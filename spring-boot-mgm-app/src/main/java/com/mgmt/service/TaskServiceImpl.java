package com.mgmt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mgmt.entity.Task;
import com.mgmt.exception.ResourceNotFoundException;
import com.mgmt.repository.TaskPagingRepository;
import com.mgmt.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService{
 
	@Autowired
	TaskRepository taskRepository;
	
	@Autowired
	TaskPagingRepository taskPagingRepository;
	
	@Override
	public List<Task> getAllTasks(){
		return taskRepository.findAll();
	}
	
		
	@Override
	public Task saveTask(Task task) {
		return taskRepository.save(task);
	}
	
	@Override
	public Task getTaskById(Long id) {
		Task task = taskRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Task does not exist with id :" + id));
		return task;
	}
	
	@Override
	public Task updateTask(Long id, Task taskDetails) {
		Task task = taskRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Task does not exist with id :" + id));
		
		task.setDate_completed(taskDetails.getDate_completed());
		task.setDate_deadline(taskDetails.getDate_deadline());
		task.setDescription(taskDetails.getDescription());
		task.setPriority(taskDetails.getPriority());
		task.setStatus(taskDetails.getStatus());
		task.setTitle(taskDetails.getTitle());
		Task updatedTask = null;
		
		if(task.getStatus().equalsIgnoreCase("PENDING") || task.getStatus().equalsIgnoreCase("IN-PROGRESS"))
			updatedTask = taskRepository.save(task);
		else
			throw new ResourceNotFoundException("Task cannot be deleted. Task is in progress or pending state :" + id);
			
		return updatedTask;
	}
	
	@Override
	public Map<String, Boolean> deleteTask(Long id) {
		Task task = taskRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Task not exist with id :" + id));
				
		taskRepository.delete(task);
		Map<String, Boolean> response = new java.util.HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	@Override
	public List<Task> getSortedTasks(Integer pageNo, Integer pageSize, String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Task> pagedResult = taskPagingRepository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Task>();
        }
    }
}

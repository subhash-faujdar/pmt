package com.mgmt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mgmt.entity.Project;
import com.mgmt.entity.Task;
import com.mgmt.service.TaskService;


@RestController
@RequestMapping("/pmtapi/v1/")
public class TaskController {
	
		@Autowired
		TaskService taskService;
	
		/**
		 * Get all tasks associated with all projects
		 * @return List of all tasks
		 */
		@GetMapping("/tasks")
		public List<Task> getAllTasks(){
			return taskService.getAllTasks();
		}	
		
		/**
		 * Get all projects
		 * @return List of all projects
		 */
		@GetMapping("/projects")
		public List<Project> getAllProjects(){
			return taskService.getAllProjects();
		}

		/**
		 * Creates new task
		 * @param task
		 * @return
		 */
		@PostMapping("/tasks")
		public Task createTask(@RequestBody Task task) {
			return taskService.saveTask(task);
		}
		
		/**
		 * Creates new project along with the tasks 
		 * @param project
		 * @return
		 */
		@PostMapping("/project")
		public Project createProject(@RequestBody Project project) {
			return taskService.saveProject(project);
		}
		
		/**
		 * Retrieve task details by it's id
		 * @param id
		 * @return
		 */
		@GetMapping("/tasks/{id}")
		public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
			Task task = taskService.getTaskById(id);
			return ResponseEntity.ok(task);
		}
		
		/**
		 * Update existing task
		 * @param id
		 * @param taskDetails
		 * @return
		 */
		@PutMapping("/task/{id}")
		public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task taskDetails){
			Task task = taskService.updateTask(id, taskDetails);
			return ResponseEntity.ok(task);
		}
				
		/**
		 * Delete existing task
		 * @param id
		 * @return
		 */
		@DeleteMapping("/task/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteTask(@PathVariable Long id){
			Map<String, Boolean> response = taskService.deleteTask(id);
			return ResponseEntity.ok(response);
		}
		
		/**
		 * Retrieve tasks as pages and in sorted order
		 * @param pageNo
		 * @param pageSize
		 * @param sortBy
		 * @return
		 */
		@GetMapping("/tasks/page")
	    public ResponseEntity<List<Task>> getAllEmployees(
	                        @RequestParam(defaultValue = "0") Integer pageNo,
	                        @RequestParam(defaultValue = "10") Integer pageSize,
	                        @RequestParam(defaultValue = "id") String sortBy)
	    {
	        List<Task> list = taskService.getSortedTasks(pageNo, pageSize, sortBy);

	        return new ResponseEntity<List<Task>>(list, new HttpHeaders(), HttpStatus.OK);
	    }
	
	
}

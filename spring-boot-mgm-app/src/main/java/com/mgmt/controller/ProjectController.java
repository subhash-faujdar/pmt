package com.mgmt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mgmt.entity.Project;
import com.mgmt.service.ProjectService;

@RestController
@RequestMapping("/pmtapi/v1/")
public class ProjectController {
	
		@Autowired
		ProjectService projectService;
	
		
		/**
		 * Get all projects
		 * @return List of all projects
		 */
		@GetMapping("/projects")
		public List<Project> getAllProjects(){
			return projectService.getAllProjects();
		}

		/**
		 * Creates new prject
		 * @param project
		 * @return
		 */
		@PostMapping("/project")
		public Project createProject(@RequestBody Project project) {
			return projectService.createProject(project);
		}
		
				
		/**
		 * Retrieve project details by it's id
		 * @param id
		 * @return
		 */
		@GetMapping("/projects/{id}")
		public ResponseEntity<Project> getProjectById(@PathVariable Long id) {
			 Project project = projectService.getProjectById(id);
			return ResponseEntity.ok(project);
		}
		
		/**
		 * Update existing project
		 * @param id
		 * @param projectDetails
		 * @return
		 */
		@PutMapping("/project/{id}")
		public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody Project projectDetails){
			 Project project = projectService.updateProject(id, projectDetails);
			return ResponseEntity.ok(project);
		}
				
		/**
		 * Delete existing project
		 * @param id
		 * @return
		 */
		@DeleteMapping("/project/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteProject(@PathVariable Long id){
			Map<String, Boolean> response = projectService.deleteProject(id);
			return ResponseEntity.ok(response);
		}
		
		
	
	
}

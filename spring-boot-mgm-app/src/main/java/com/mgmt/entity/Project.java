package com.mgmt.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="project", schema="testdb")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long project_id;
	
	@Column(nullable = false) 
	private String project_description;
	
	@OneToMany(cascade = CascadeType.ALL)
    private List<Task> tasks;
	
	Project(){}
	
	public Project(long project_id, String project_description) {
		this.project_id = project_id;
		this.project_description = project_description;
	}

	public long getProject_id() {
		return project_id;
	}

	public void setProject_id(long project_id) {
		this.project_id = project_id;
	}

	public String getProject_description() {
		return project_description;
	}

	public void setProject_description(String project_description) {
		this.project_description = project_description;
	}
	
	
}

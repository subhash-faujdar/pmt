package com.mgmt.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="task", schema="testdb")
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
			
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	private String status;
	
	@Column(nullable = false)
	private String priority;
	
	@Column
	private Date date_completed;
	
	@Column(nullable = false)
	private Date date_deadline;
	
	@ManyToOne
    @JoinColumn(name = "project_id")
    Project project;
	
	Task(){}
	
	public Task(long id, String title, String description, String status, 
					String priority, Date date_completed, Date date_deadline, Project project) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.status = status;
		this.priority = priority;
		this.date_completed = date_completed;
		this.date_deadline = date_deadline;
	}

	public long getId() {
		return id;
	}

	public void setId() {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Date getDate_completed() {
		return date_completed;
	}

	public void setDate_completed(Date date_completed) {
		this.date_completed = date_completed;
	}

	public Date getDate_deadline() {
		return date_deadline;
	}

	public void setDate_deadline(Date date_deadline) {
		this.date_deadline = date_deadline;
	}
	
	/*
	 * @OneToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "status_id", referencedColumnName = "id") private Status
	 * status;
	 */
	

		
	
}

package com.mgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mgmt.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{
		
}

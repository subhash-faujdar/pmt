package com.mgmt.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.mgmt.entity.Task;

@Repository
public interface TaskPagingRepository extends PagingAndSortingRepository<Task, Long>{
			
}

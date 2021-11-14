package com.wainhouse.tta.repos;

import com.wainhouse.tta.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import com.wainhouse.tta.domain.Task;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepo extends JpaRepository<Task, Integer> {
}

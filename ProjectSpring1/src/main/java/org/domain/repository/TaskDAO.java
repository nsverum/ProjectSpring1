package org.domain.repository;

import org.domain.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskDAO extends JpaRepository<Task, Long> {
}
